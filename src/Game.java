import java.util.Scanner;

public class Game {
    static boolean gameRunning = true;
    private GameState gameState;
    private Board board;
    private int numRings;
    private Solver solver;

    public Game() {
        this.board = new Board();
        setGameState(new NotPlayingGameState(this));
    }

    // MAIN
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        while (gameRunning) {
            game.handleInput(sc.nextLine());
        }
    }

    public void handleInput(String nextLine) {
        gameState.handleInput(nextLine);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        gameState.gameStateInstructions();
        if (gameState instanceof StartedGameState) {
            printBoard();
        }
    }

    public void quit() {
        gameRunning = false;
    }

    public void setNumRings(int numRings) {
        this.numRings = numRings;
        board.addRings(numRings);
        this.solver = new Solver(board);
    }

    public void quitGame() {
        setGameState(new NotPlayingGameState(this));
        board.removeRings();
    }

    public void moveRing(String moveString) {
        try {
            board.moveRing(moveString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printBoard();
        if (isWon()) {
            setGameState(new WonGameState(this));
        }
    }

    public void printBoard() {
        board.print();
    }

    public boolean isWon() {
        return board.inFinishedPosition();
    }

    public void resetBoard() {
        board = new Board();
        setNumRings(numRings);
        board.print();
    }

    public void clearBoard() {
        board = new Board();
    }

    public void undoLastMove() {
        board.undoLastMove();
        printBoard();
    }

    public void hintMove() {
        board.hintMove(solver.bestNextMove());
        printBoard();
        if (isWon()) {
            setGameState(new WonGameState(this));
        }
    }

    public void completeBoard() {
        while (! isWon()) {
            board.hintMove(solver.bestNextMove());
            printBoard();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
        setGameState(new WonGameState(this));
    }
}
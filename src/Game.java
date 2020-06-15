import java.util.Scanner;

public class Game {
    static boolean gameRunning = true;
    private GameState gameState;
    private Board board;
    private int numRings;

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
    }

    public void quit() {
        gameRunning = false;
    }

    public void setNumRings(int numRings) {
        this.numRings = numRings;
        board.addRings(numRings);
    }

    public void quitGame() {
        setGameState(new NotPlayingGameState(this));
        board.removeRings();
    }

    public void moveRing(String fromStick, String toStick) {
        board.moveRing(fromStick, toStick);
    }

    public void printBoard() {
        board.print();
    }
}

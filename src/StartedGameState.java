public class StartedGameState extends GameState {
    public StartedGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        switch(input) {
            case "H":
                gameStateInstructions();
                break;
            case "Q":
                game.quitGame();
                break;
            case "P":
                game.printBoard();
                break;
            case "L M":
            case "L R":
            case "M L":
            case "M R":
            case "R L":
            case "R M":
                String[] sticks = input.split(" ");
                game.moveRing(sticks[0], sticks[1]);
                game.printBoard();
                break;
            default:
                System.out.println("Invalid input. Type H for help.");
        }
    }

    @Override
    public void gameStateInstructions() {
        System.out.println(("Type 'A B' to move ring from stick A to stick B, where A and B = L,M or R."));
        System.out.println(("Type Q to quit game."));
        System.out.println("Type P to print board.");
    }
}

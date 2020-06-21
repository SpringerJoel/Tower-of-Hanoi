public class StartedGameState extends GameState {
    final private String HELP_STRING = "?";
    final private String QUIT_STRING = "Q";
    final private String PRINT_BOARD_STRING = "P";
    final private String RESET_STRING = "R";
    final private String UNDO_STRING = "U";

    public StartedGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        switch(input) {
            case HELP_STRING:
                gameStateInstructions();
                break;
            case RESET_STRING:
                game.resetBoard();
                break;
            case UNDO_STRING:
                game.undoLastMove();
                break;
            case QUIT_STRING:
                game.quitGame();
                break;
            case PRINT_BOARD_STRING:
                game.printBoard();
                break;
            default:
                if (Move.isValidMoveString(input)) {
                    game.moveRing(input);
                } else {
                    System.out.println(String.format("Invalid input. Type %s for help.", HELP_STRING));
                }
        }
    }

    @Override
    public void gameStateInstructions() {
        System.out.println("Type 'A B' to move ring from stick A to stick B, where A and B = L,M or R.");
        System.out.println("Rings can only be stacked on top of smaller rings.");
        System.out.println("The game is won when all rings are on the right stack.");
        System.out.println(String.format("Type %s to quit game.", QUIT_STRING));
        System.out.println(String.format("Type %s to print board.", PRINT_BOARD_STRING));
        System.out.println(String.format("Type %s to reset board.", RESET_STRING));
        System.out.println(String.format("Type %s to undo last move.", UNDO_STRING));
        System.out.println(String.format("Type %s at any time for help.", HELP_STRING));
    }
}

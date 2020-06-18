public class CreatingGameState extends GameState {
    final private String QUIT_STRING = "Q";

    public CreatingGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        int numRings = 0;
        try {
            numRings = Integer.parseInt(input);
            game.setNumRings(numRings);
            game.setGameState(new StartedGameState(game));
        } catch (NumberFormatException nfe) {
            switch(input) {
                case QUIT_STRING:
                    game.setGameState(new NotPlayingGameState(game));
                    break;
                default:
                    gameStateInstructions();
            }
        }
    }

    @Override
    public void gameStateInstructions() {
        System.out.println("Input number to start a game with that many rings.");
        System.out.println(String.format("Type %s to quit making game.", QUIT_STRING));
    }
}

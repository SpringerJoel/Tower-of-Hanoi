public class CreatingGameState extends GameState {
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
                case "Q":
                    game.setGameState(new NotPlayingGameState(game));
                    break;
                default:
                    gameStateInstructions();
            }
        }
    }

    @Override
    public void gameStateInstructions() {
        System.out.println(("Type number for size of rings on board."));
        System.out.println(("Type Q to quit making game."));
    }
}

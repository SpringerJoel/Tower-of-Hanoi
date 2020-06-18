public class NotPlayingGameState extends GameState {
    final private String NEW_GAME_STRING = "N";
    final private String QUIT_STRING = "Q";

    public NotPlayingGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        switch(input) {
            case NEW_GAME_STRING:
                game.setGameState(new CreatingGameState(game));
                break;
            case QUIT_STRING:
                game.quit();
                break;
            default:
                gameStateInstructions();
        }

    }

    @Override
    public void gameStateInstructions() {
        System.out.println(String.format("Type %s for new game.", NEW_GAME_STRING));
        System.out.println(String.format("Type %s to quit.", QUIT_STRING));
    }
}

public class WonGameState extends GameState {
    final private String QUIT_STRING = "Q";
    final private String NEW_GAME_STRING = "N";

    WonGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        switch(input) {
            case NEW_GAME_STRING:
                game.setGameState(new CreatingGameState(game));
                break;
            case QUIT_STRING:
                this.game.quit();
                break;
            default:
                gameStateInstructions();
        }

    }

    @Override
    public void gameStateInstructions() {
        System.out.println("You've won!");
        System.out.println(String.format("Type %s for new game.", NEW_GAME_STRING));
        System.out.println(String.format("Type %s to quit.", QUIT_STRING));
    }
}

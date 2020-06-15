public class WonGameState extends GameState {
    WonGameState(Game game) {
        super(game);
    }

    @Override
    public void handleInput(String input) {
        switch(input) {
            case "N":
                game.setGameState(new CreatingGameState(game));
                break;
            case "Q":
                this.game.quit();
                break;
            default:
                gameStateInstructions();
        }

    }

    @Override
    public void gameStateInstructions() {
        System.out.println("You've won!");
        System.out.println(("Type N for new game."));
        System.out.println(("Type Q to quit."));
    }
}

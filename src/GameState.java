public abstract class GameState {
    Game game;
    GameState(Game game) {
        this.game = game;
    }

    public abstract void handleInput(String input);

    public abstract void gameStateInstructions();
}

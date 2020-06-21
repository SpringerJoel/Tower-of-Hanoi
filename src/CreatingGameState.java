import GameExceptions.BadInputException;

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
            if (numRings <= 0) {
                throw new BadInputException();
            }
            game.setNumRings(numRings);
            game.setGameState(new StartedGameState(game));
        } catch (NumberFormatException nfe) {
            switch(input) {
                case QUIT_STRING:
                    game.setGameState(new NotPlayingGameState(game));
                    break;
                default:
                    System.out.println(String.format("Invalid input."));
                    gameStateInstructions();
            }
        } catch (BadInputException e){
            System.out.println("Input number must be > 0.");
        }
    }

    @Override
    public void gameStateInstructions() {
        System.out.println("Input number (> 0) to start a game with that many rings.");
        System.out.println("3 is recommended for beginners.");
        System.out.println(String.format("Type %s to quit making game.", QUIT_STRING));
    }
}

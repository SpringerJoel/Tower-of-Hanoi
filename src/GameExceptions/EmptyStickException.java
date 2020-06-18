package GameExceptions;

public class EmptyStickException extends Exception {
    public EmptyStickException() {
        super("No rings to move from this stick.");
    }
}

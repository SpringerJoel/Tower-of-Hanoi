package GameExceptions;

public class EmptyHistoryException extends Exception {
    public EmptyHistoryException() {
        super("Move history is empty.");
    }
}

package GameExceptions;

public class BadInputException extends Exception {
    public BadInputException() {
        super("Input not valid.");
    }
}

package GameExceptions;

public class RingSizeException extends Exception {
    public RingSizeException() {
        super("Can't move larger ring on top of smaller ring.");
    }
}

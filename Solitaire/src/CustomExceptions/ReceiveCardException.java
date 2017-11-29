package CustomExceptions;

public class ReceiveCardException extends Exception {
    public ReceiveCardException(String errorMessage) {
        super(errorMessage);
    }
}

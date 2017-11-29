package Program;

import CustomExceptions.ReceiveCardException;

public interface Receiver<T> {
    public void receive(T cardOrCardsToReceive) throws ReceiveCardException;
}

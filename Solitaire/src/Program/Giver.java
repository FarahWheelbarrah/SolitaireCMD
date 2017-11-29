package Program;

import CustomExceptions.ReceiveCardException;
import CustomExceptions.SuccessfulTurnException;

public interface Giver {
   public void give(Receiver receiver) throws SuccessfulTurnException, ReceiveCardException;
}

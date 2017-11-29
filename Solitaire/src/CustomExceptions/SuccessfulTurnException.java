package CustomExceptions;

import Program.Receiver;
import Program.GoalPile;

public class SuccessfulTurnException extends Exception {
    private Receiver receiver;
    
    public SuccessfulTurnException(Receiver receiver) {
        this.receiver = receiver;
    }
    
    public boolean hasGoalPileAsReceiver() {
        return receiver instanceof GoalPile;
    }
}

package Program;

import CustomExceptions.ReceiveCardException;
import CustomExceptions.SuccessfulTurnException;

public class GoalPile extends Pile implements Giver, Receiver<Card> {
    private String suit;
    
    public GoalPile(int number) {
        super(number);
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    @Override
    public String toString() {
        return "Goal Pile " + NUMBER + printSuit() + ": " + super.toString();
    }
    
    private String printSuit() {
        if (suit != null && !suit.isEmpty())
            return " (" + suit + ")";
        else 
            return "";
    }
    
    private boolean canAddToEmpty(Card card) {
        return cards.isEmpty() && card.hasNumber(1);
    }
    
    private boolean canAddToNonEmpty(Card card) {
        return !cards.isEmpty() && cards.getLast().hasDifference(card.getNumber(), 1) && card.hasSuit(suit);
    }
    
    @Override
    public void give(Receiver receiver) throws SuccessfulTurnException, ReceiveCardException {
        receiver.receive(getTopCard());
        remove();
        throw new SuccessfulTurnException(receiver);
    }
    
    @Override
    public void receive(Card cardToReceive) throws ReceiveCardException {
        if (!canAddToEmpty(cardToReceive) && !canAddToNonEmpty(cardToReceive))
            throw new ReceiveCardException(getErrorMessage(cardToReceive));
        cards.add(cardToReceive);
        if (numOfCards() == 1)
            setSuit(cardToReceive.getSuit());
    }
    
    private void remove() {
        cards.removeLast();
        if (isEmpty())
            setSuit(null);
    }
    
    private String getErrorMessage(Card cardToReceive) {
        String errorMessage = "Cannot move card (" + cardToReceive + "): ";
        String stringBasedOnReceiver = ((numOfCards() > 1) ? " top " : " "); 
        if (isEmpty())
            errorMessage += "Goal Pile " + NUMBER + " is empty - Card must be an Ace to add to this pile";
        else
            errorMessage += "Card must be one value higher than and be the same suit as" + stringBasedOnReceiver + "card in receiving pile (Goal Pile " + NUMBER + " - " + getTopCard() + ")";
        return errorMessage;
    }

    public boolean isComplete() {
        return numOfCards() == 13;
    }
}

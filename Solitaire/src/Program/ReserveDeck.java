package Program;

import CustomExceptions.ReceiveCardException;
import CustomExceptions.SuccessfulTurnException;
import java.util.LinkedList;

public class ReserveDeck extends Pile implements Giver {

    public ReserveDeck(int number) {
        super(number);
    }
    
    @Override 
    public String toString() {
        String deckString = "Reserve Deck: ";
        if (isEmpty()) 
            deckString += "(Empty)";
        else {
            for (int i = numOfCards() - 3; i <= numOfCards() - 1; i++)
                if (i >= 0)
                    deckString += cards.get(i) + " ";
            deckString += "(Cards Remaining: " + numOfCards() + ")";
        }
        return deckString.trim(); 
    }

    @Override
    public void give(Receiver receiver) throws SuccessfulTurnException, ReceiveCardException {
        receiver.receive(getTopCard());
        cards.removeLast();
        throw new SuccessfulTurnException(receiver);
    }
    
    public void receiveCards(LinkedList<Card> cardsToReceive) {
        cards.addAll(cardsToReceive);
    }
    
    public void removeCards() {
        cards.clear();
    }
}

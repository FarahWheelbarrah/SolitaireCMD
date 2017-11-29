package Program;

import java.util.LinkedList;

public abstract class Pile {
    protected LinkedList<Card> cards = new LinkedList<Card>();
    protected final int NUMBER;
    
    public Pile(int number) {
        NUMBER = number;
    }
    
    public LinkedList<Card> getCards() {
        return cards;
    }
    
    @Override 
    public String toString() {
        String pileString = "";
        if (isEmpty())
            pileString += "(Empty)";
        else {
            for (Card card: cards)
                pileString += card + " ";
        }
        return pileString.trim();
    }
    
    public boolean hasNumber(int number) {
        return NUMBER == number;
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }  
    
    public int numOfCards() {
        return cards.size();
    }
    
    public Card getTopCard() {
        return cards.getLast();
    }
    
    public int getNumOfFaceUpCards() {
        int numOfFaceUpCards = 0;
        for (Card card : cards)
             if (card.isFaceUp())
                 numOfFaceUpCards++;
        return numOfFaceUpCards;
    }
    
    public boolean hasMoreThanNFaceUpCards(int number) {
        return getNumOfFaceUpCards() > number;
    }
}

package Program;

public class Card {
    private String suit;
    private int number;
    private String color;
    private boolean faceUp;
  
    public Card(String suit, int number, String color) {
        this.suit = suit;
        this.number = number;
        this.color = color;
    }
    
    private String value() {
        switch (number) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return "" + number;
        }
    }
    
    private String color() {
        if (color.equals("Red"))
            return "R";
        else 
            return "B";
    }
    
    private String suit() {
        switch (suit) {
            case "Hearts": return "H";
            case "Diamonds": return "D";
            case "Spades": return "S";
            case "Clubs": return "C";
        }
        return null;
    }
    
    public boolean hasNumber(int number) {
        return this.number == number;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public int getNumber() {
        return number;
    }
    
    public boolean isFaceUp() {
        return faceUp;
    }
    
    public String getColor() {
        return color;
    }
    
    public boolean hasColor(String color) {
        return this.color.equals(color);
    }
    
    public boolean hasSuit(String suit) {
        return this.suit.equals(suit);
    }
    
    public boolean hasDifference(int number, int difference) {
        return number - this.number == difference;
    }
    
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
    
    @Override
    public String toString() {
        if (faceUp)
            return value() + "-" + suit() + "-" + color();
        else 
            return "FDC"; // FDC: "Face Down Card"
    }
}

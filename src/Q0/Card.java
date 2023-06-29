package Q0;

public class Card {

    private Deck.Suit suit;
    private Deck.Value value;

    public Deck.Suit getSuit() {
        return suit;
    }

    public Deck.Value getValue() {
        return value;
    }

    public void setSuit(Deck.Suit suit) {
        this.suit = suit;
    }

    public void setValue(Deck.Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card { " +
                "suit = " + suit +
                ", value = " + value +
                " } ";
    }
}

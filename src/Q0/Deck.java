package Q0;
import java.util.Random;

public class Deck {

    public enum Suit { SPADES, HEARTS, CLUBS, DIAMONDS};
    public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING };
    static final int NUMTIMES = 50;

    public static void main(String[] args) {
        Card[] deck = new Card[52];

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card c = new Card();
                c.setSuit(Suit.values()[i]);
                c.setValue(Value.values()[j]);
                deck[index] = c;
                index++;
            }
        }

        printDeck(deck);
        System.out.println();
        r = new Random();
        shuffle(deck);
        printDeck(deck);
    }

    public static void printDeck (Card[] deck) {
        for (Card c : deck) {
            System.out.println(c);
        }
    }

    static Random r;
    private static void shuffle (Card[] deck) {
        int num1;
        int num2;
        Card temp;
        for (int i = 0; i < NUMTIMES; i++) {
            num1 = r.nextInt(52);
            num2 = r.nextInt(52);
            temp = deck[num1];
            deck[num1] = deck[num2];
            deck[num2] = temp;
        }
    }
}

package OODesign;

/**
 * Created by tonytan on 8/1/2017.
 *
 * Design the data structures for a generic deck of cards.
 * Explain how you would subclass it to implement particular card games.
 */
public class Card {
    public enum Suit{
        CLUBS(1), SPADES (2), HEARTS (3), DIAMONDS (4);

        int value;
        private Suit(int v){
            value = v;
        }
    };

    int card;
    Suit suit;

    public Card(int card, Suit suit){
        this.card = card;
        this.suit = suit;
    }

    public int getCard() {
        return card;
    }

    public Suit getSuit() {
        return suit;
    }
}

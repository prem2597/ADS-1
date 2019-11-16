import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
/**
 * DeckOfCards is the API to sort all the values of the deck depending on the given order.
 * @author PREM.
 */
public class DeckOfCards {
    /**
     * CardDeck is an API which is used to sort all the cards.
     * @author PREM
     * @reference Geeek for Geeks.
     * @reference Stack OverFlow.
     * @reference Bob sedwick.
     */
    public static class CardDeck {
        /**
         * Here enumerations is used because using enumerator we can represent a group.
         * of named constants. here enumerations is used when we know all possible values
         * at the compile time. Enumeration is represented using enum data type.
         */
        public static enum Face {A, King, Queen, Jack, Ten, Nine,
            Eight, Seven, Six, Five, Four, Three, Two};
        // rank represents the order of the cards.
        // CardDeck rank;
        //     /**
        //      * constructor to the enumerator which represents the rank.
        //      * @param r value of the card.
        //      */
        //     Face (CardDeck r) {
        //         rank = r;
        //     }
        //     /**
        //      * get the rank.
        //      * @return rank value.
        //      */
        //     public CardDeck getRank() {
        //         return rank;
        //     }
        // }
        /**
         * enumerator of suit used to store all values of the cards.
         */
        public static enum Suit {Spades, Hearts, Diamonds, Clubs};
        //     // represent the order of the cards.
        //     int order;
        //     /**
        //      * constructor represents the order of the suits.
        //      * @param o value of the suit.
        //      */
        //     Suit (int o) {
        //         order = o;
        //     }
        //     /**
        //      * get the order of the suit.
        //      * @return order.
        //      */
        //     public int getOrder() {
        //         return order;
        //     }
        // }
        private Face face;
        private Suit suit;
        // face of a card.
        // private final Face face;
        // suit of a card.
        // private final Suit suit;
        /**
         * constructor which is used to represent the face and suit value.
         * @param faceCard card with face.
         * @param suitCard card with suit.
         */
        public CardDeck (Face faceCard, Suit suitCard) {
            this.face = faceCard;
            this.suit = suitCard;
        }
        /**
         * get the face value.
         * @return face value.
         */
        public Face getFace() {
            return face;
        }
        /**
         * get the suit value.
         * @return suit value.
         */
        public Suit getSuit() {
            return suit;
        }
        /**
         * to print the string value.
         */
        public String toString() {
            return suit+" "+face;
        }
    }
    // this List will store all the values of the cards.
    private List<CardDeck> deck = new ArrayList<CardDeck>();
    public DeckOfCards() {
        // CardDeck[] deck = new CardDeck[52];
        // int count = 0;
        for (CardDeck.Suit suit : CardDeck.Suit.values()) {
            for (CardDeck.Face face : CardDeck.Face.values()) {
                // deck[count] = new CardDeck(face.getRank(), suit.getOrder());
                // count++;
                deck.add(new CardDeck(face,suit));
            }
        }
        // list = Arrays.asList(deck);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CardDeck card : deck) {
            sb.append(card + "\n");
        }
        return sb.toString();
    }
    // public void printCards() {
    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.println(list.get(i));
    //     }
    // }
    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        // cards.printCards();
        // cards.toString();
        // cards.DeckOfCards();
        System.out.println(cards);
        
    }
}

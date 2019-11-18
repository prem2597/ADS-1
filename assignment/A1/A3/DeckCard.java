import java.util.*;
import java.util.Scanner;
/**
 * DeckClass are to used to sort the deck.
 * @author PREM
 * Time complexity :
 * Best Case : N.
 * average case : 1/4 N^2.
 * worst case : 1/2 N^2.
 * references : Geeks for Geeks,Stack overflow,Bob sedgweick.
 */
public final class DeckCard {
    /**
     * Card class represents the comparable class of type card.
     * this card class contains the suit and the face.
     */
    public static class Card implements Comparable<Card> {
        /**
         * suit represents the suit of the card.
         */
        private String suit;
        /**
         * face card represents the face of the card.
         */
        private String face;
        // String[] arr;
        // public static String[] removeLastCharacter(String str1) {
        //     String[] result = new String[2];
        //     // String result1 = null;
        //     // String result2 = null;
        //     if ((str1 != null) && (str1.length() > 0)) {
        //         result[0] = str1.substring(0, str1.length() - 2);
        //         result[1] = str1.substring(str1.length()-1, str1.length());
        //     }
        //     return result;
        // }
        /**
         * card is the constructor class.
         * @param faceCard represents the face card
         * @param suitCard represents the suit card
         */
        Card(final String faceCard, final String suitCard) {
            this.face = faceCard;
            this.suit = suitCard;
        }
        /**
         * compareTo will compare two cards based on the parameters.
         * @param obj1 represents the card object to be compared.
         * @return integer value -1 or 0 or 1.
         */
        public int compareTo(final Card obj1) {
            int suit1 = 0;
            int suit2 = 0;
            // int s = 1;
            // int h = 2;
            // int c = 3;
            // int d = 4;
            // this.value = 0;
            // that .value = 0;
            if (this.suit.equals("S")) {
                suit1 = 1;
            } else if (this.suit.equals("H")) {
                suit1 = 2;
            } else if (this.suit.equals("C")) {
                suit1 = 3;
            } else {
                suit1 = 4;
            }
            if (obj1.suit.equals("S")) {
                suit2 = 1;
            } else if (obj1.suit.equals("H")) {
                suit2 = 2;
            } else if (obj1.suit.equals("C")) {
                suit2 = 3;
            } else {
                suit2 = 4;
            }
            if (suit1 > suit2) {
                return 1;
            } else if (suit1 < suit2) {
                return -1;
            } else {
                int face1 = 0;
                int face2 = 0;
                if (this.face.equals("A")) {
                    face1 = 1;
                } else if (this.face.equals("J")) {
                    face1 = 11;
                } else if (this.face.equals("Q")) {
                    face1 = 12;
                } else if (this.face.equals("K")) {
                    face1 = 13;
                }
                if (obj1.face.equals("A")) {
                    face2 = 1;
                } else if (obj1.face.equals("J")) {
                    face2 = 11;
                } else if (obj1.face.equals("Q")) {
                    face2 = 12;
                } else if (obj1.face.equals("K")) {
                    face2 = 13;
                }
                if (face1 == 0) {
                    face1 = Integer.parseInt(this.face);
                }
                if (face2 == 0) {
                    face2 = Integer.parseInt(obj1.face);
                }
                if (face1 > face2) {
                    return 1;
                } else if (face1 < face2) {
                    return -1;
                }

            }
            return 0;
        }
        /**
         * toString print in the form of a string.
         * @return String type.
         */
        public String toString() {
            return suit + " " + face;
        }
    }
    /**
     * constructor for checkstyle.
     */
    private DeckCard() {
    }
    /**
     * applying insertion sort.
     * @param cards card array.
     * @return sorted card array.
     */
    public static Card[] sort(final Card[] cards) {
        int n = cards.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (cards[j - 1].compareTo(cards[j]) == 1) {
                    Card temp = cards[j - 1];
                    cards[j - 1] = cards[j];
                    cards[j] = temp;
                }
            }
        }
        return cards;
    }
    /**
     * main method to read and print the data.
     * @param args arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of cards");
        int n = Integer.parseInt(sc.nextLine());
        Card[] cards = new Card[n];
        int size = 0;
        System.out.println("Enter the card details seperated with spaces");
        String cardData = sc.nextLine();
        String[] arr = cardData.split(" ");
        for (String a : arr) {
            System.out.println(a);
            Card c = new Card(a.substring(0, a.length() - 1),
            a.substring(a.length() - 1, a.length()));
            cards[size++] = c;
        }
        sort(cards);
        System.out.println(Arrays.toString(cards));
        // int n = arr.length;
        // for (int j = 0; j <= n - 1; j++) {
        //     String[] c = removeLastCharacter(arr[j]);
        //     suit[j] = c[0];
        //     face[j] = c[1];
        // }
        // System.out.println("Suits");
        // for (String a : suit) {
        //     System.out.println(a);
        // }
        // System.out.println("Faces");
        // for (String a : face) {
        //     System.out.println(a);
        // }
        sc.close();
    }
}

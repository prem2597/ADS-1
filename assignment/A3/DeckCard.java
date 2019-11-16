import java.util.*;
import java.util.Scanner;
class DeckCard {
    public static class Card implements Comparable<Card> {
        String suit;
        String face;
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
        Card (String faceCard, String suitCard) {
            this.face = faceCard;
            this.suit = suitCard;
        }
        public int compareTo(Card obj1) {
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
                return -1;
            } else if (suit1 < suit2) {
                return 1;
            } else {
                int face1 = 0;
                int face2 = 0;
                if (this.face.equals("A")) {
                    face1 = 1;
                } else if (this.face.equals("J")) {
                    face1 = 11;
                } else if (this.face.equals("Q")) {
                    face1 = 12;
                } else {
                    face1 = 13;
                }
                if (obj1.face.equals("A")) {
                    face2 = 1;
                } else if (obj1.face.equals("J")) {
                    face2 = 11;
                } else if (obj1.face.equals("Q")) {
                    face2 = 12;
                } else {
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
        public String toString() {
            return suit+" "+face;
        }
    }
    public static Card[] sort(final Card[] cards) {
		int n = cards.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (cards[j - 1].compareTo(cards[j]) == -1) {
					Card temp = cards[j - 1];
					cards[j - 1] = cards[j];
					cards[j] = temp;
				} else {
					break;
				}
			}
		}
		return cards;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Card[] cards = new Card[5];
        int size = 0;
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

    }
}

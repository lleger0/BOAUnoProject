import java.util.ArrayList;
import java.util.HashMap;


/******************************************************************************
 *  Compilation:  javac Deck.java
 *  Execution:    java Deck
 *
 *  Deal 52 cards uniformly at random.
 *
 *  % java Deck
 *  Ace of Clubs
 *  8 of Diamonds
 *  5 of Diamonds
 *  ...
 *  8 of Hearts
 *
 ******************************************************************************/
public class Deck {

    // maybe the value in map should be an integer not a string?
    HashMap<String, String> deck = new HashMap<>();
    String[] COLORS = {
            "Red", "Yellow", "Blue", "Green"
    };
    String[] TYPES = {
            "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "Skip", "Reverse", "Draw 2"
    };

//    int n = SUITS.length * RANKS.length;


    public void createDeck() {


        // initialize deck

        // makes two cards of each type for color

        for (int i = 0; i < 2 ; i++) {
            for (String type : TYPES) {
                for (String color: COLORS) {
                    deck.put(color + " " + type, type);
                }
            }
        }

        // each color only has one 0
        for (String color: COLORS) {
            deck.put(color + " " + "0", "0");
        }

        // add 4 wild cards
        int count = 0;
        while (count <4) {
            deck.put("Wild Card - Choose any color" , "any color");
            count++;
        }


        // add 4 black wild cards that have a draw 4
        count = 0;
        while (count <4) {
            deck.put("Wild Card - Choose any color and next person draws 4" , "any color and draw 4");
            count++;
        }

        System.out.println(deck);

// don;t need anymore:
//        for (int i = 0; i < RANKS.length; i++) {
//            for (int j = 0; j < SUITS.length; j++) {
//                deck.add(RANKS[i] + " of " + SUITS[j]);
//            }
//        }
    }




    // shuffle  - need to redo based on a hashmap
//    public void shuffle(){
//        for (int i = 0; i < n; i++) {
//
//            int r = i + (int) (Math.random() * (n-i));
//            String temp = deck.get(r);
//
//            // deck[r] = deck[i];
//            deck.set(r, deck.get(i));
//
//            // deck[i] = temp;
//            deck.set(i, temp);
//        }
//
//
//    }


}




//maybe remove this but idk....
//Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
//Last updated: Fri Oct 20 14:12:12 EDT 2017.

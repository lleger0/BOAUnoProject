import java.util.*;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Integer> playersScoreMap = new HashMap<>();
    static ArrayList<String> playersList = new ArrayList<>();
    static String currentPlayer;
    static int players;

    public static void main(String[] args) {
        //display the rules and objective of the game
        printRules();
        //prompt user for how many players we want and store the players names in a score hash map
        players();
        System.out.println(playersScoreMap);

        // create a deck object
        Deck deck = new Deck();
        // create uno deck using the standard 108 possible cards
        deck.createDeck();
        // suhffle deck and add each card onto a stack
        deck.shuffle();
        // draw card will pop a card off the stack
        String currCardInMiddle = deck.drawCard();

        // create a separate map that stores the hands of each player on line 106 *



        // initialize first player -- maybe can add this as a condition that is
        // inside whoseTurn when we have a method to decide whether it is the first move ever
        currentPlayer = playersList.get(0);
        System.out.println("curr before method call " + currentPlayer);
        System.out.println("curr after method call " + whoseTurn(players, true, false, currentPlayer, playersList));



    }

    /** method to deal x number of cards to player
     *
     */
    public static void dealXCards(int numOfCards) {
        // not sure what return type we want
        // maybe return an array? or store an array
    }

    // ----------------------------------

    /** method to view hand of cards
     *
     */

    public static String viewHand() {
        // not sure what return type we want
        // maybe show user the cards and then have them choose which one they want to play and return that
        String card = "Red 5";
        return card;
    }


    // -----------------------------

    /** method to validate current card played
     *  returns boolean
     */
    public static boolean validateCard(String currCardInMiddle, String cardPlayerWantsToPlay) {
        // have to split the string into two parts and see if either matches the currCardInMiddle

        return false;
    }


    //---------------------------

    /** edit the print rules to be for Uno
     *
     */

    public static void printRules() {
        System.out.println("--------------------\n"+
                "    Black Jack   \n"+
                "--------------------\n");
        System.out.println("Rules: \n Blackjack hands are scored by their point total. The hand with the highest total wins as long as it doesn't exceed 21; a hand with a higher total than 21 is said to bust. Cards 2 through 10 are worth their face value, and face cards (jack, queen, king) are also worth 10. An Ace can be worth one or eleven, you decide. \nEnjoy playing!");



    }



    public static void players(){

        System.out.println("How many players will be playing in this game? 2-7 Players are allowed");
        players = Integer.valueOf(scanner.nextLine());
        //maybe throw an error if an int is not entered

        //for each player, ask for the name and save the names in a map

        for (int i=1; i<=players; i++) {
            System.out.println("What is the name of player " + i + "?");
            String playerName = scanner.nextLine();
            // create an exception if the user does not enter a name
            //if (playerName.isEmpty())
            playersScoreMap.put(playerName, 0);

            playersList.add(playerName);
        }

    }


//    [1, 2, 3, 4]
//    [1, 2, 3, 4]
//     // if reverse
//    [1, 2, 3, 2, 1, 4, 3, 2, 1]
    public static String whoseTurn(int numOfPlayers, boolean reverse, boolean skip, String currPlayer, ArrayList<String> playersList) {
        // change the condition to

        LinkedList<String> turnList = new LinkedList<>();

        if (reverse) {
            int index = numOfPlayers - 1;
            System.out.println(numOfPlayers);
            // create a linked list of the players in reverse order
            while(index>=0) {
                String player = playersList.get(index);
                turnList.add(player);
                index--;
            }
            System.out.println("Turn List after reversing" + turnList);
        }
        else {
            for (String player: playersList) {
                turnList.add(player);
            }
            System.out.println("Turn List with no reversing" + turnList);
        }


        //  j  -> k > l --> m
        //  m -> l ->  k --> j
        Iterator it  = turnList.iterator();
        while (it.hasNext()) {

            if (currPlayer.equals(turnList.getLast())) {
                System.out.println("hey there ");
                currPlayer = turnList.getFirst();
                System.out.println("hey there: " + currPlayer);
                break;
            }
            else if (it.next().equals(currPlayer)) {
                if (skip) {
                    System.out.println("test");
//                    System.out.println("Next: " + it.next());
//                    System.out.println("Next next: " + it.next());
                    it.next();
                    currPlayer = it.next().toString();
                }
                else {
                    currPlayer = it.next().toString();
                    break;
                }
            }
        }


        return currPlayer;
    }




} 

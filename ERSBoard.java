import java.util.*;

/**
 * Write a description of class ERSBoard here.
 * Contains an x number of Player classes and an array list of Card classes
 * Contains a method that determines if a slap is legal or illegal
 * Contains an array that holds the order of slaps
 * @author Brian Yang
 */
public class ERSBoard
{
    private ArrayList<Card> board;
    private ArrayList<Integer> slapOrder;
    private ArrayList<Player> players;
    private Deck deck;
    private ArrayList<Deck> starters;
    
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Constructor for objects of class ERSBoard
     */
    public ERSBoard(int numPlayers)
    {
        board = new ArrayList<Card>();
        slapOrder = new ArrayList<Integer>();
        players = new ArrayList<Player>();
        starters = new ArrayList<Deck>();
        deck = new Deck(String[] ranks, String[] suits, int[] values);
        deck.shuffle();
        for (int x = 0; x < numPlayers; x++) {
            starters.add(new Deck());
        }
        int divisions = 52/numPlayers;
        int leftovers = 52 % numPlayers;
        int place = 0;
        for (int x = 0; x < starters.size(); x++) {
            for (int y = place; y < place + divisions; y++) {
                starters.get(x).add(deck.get(y));
        for (int x = 0; x < numPlayers; x++) {
            players.add(new Player());
        }
    }
}


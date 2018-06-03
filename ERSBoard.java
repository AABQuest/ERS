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

    /**
     * Constructor for objects of class ERSBoard
     */
    public ERSBoard(int numPlayers)
    {
        board = new ArrayList<Card>();
        slapOrder = new ArrayList<Integer>();
        players = new ArrayList<Player>();
        starters = new ArrayList<Deck>();
        deck = new Deck(RANKS, SUITS);
        deck.shuffle();
        for (int x = 0; x < numPlayers; x++) {
            starters.add(new Deck());
        }
        int divisions = 52/numPlayers;
        int leftovers = 52 % numPlayers;
        int place = 0;
        for (int x = 0; x < starters.size(); x++) {
            for (int y = place; y < place + divisions; y++) {
                starters.get(x).addCard(deck.deal());
            }
        }
        for (int x = 0; x < numPlayers; x++) {
            players.add(new Player(starters.get(x),x+1));
        }
          

    }
    public boolean isLegal(Card c1, Card c2, Card c3){
        if(c1.rank().equals(c3.rank()) || c2.rank().equals(c3.rank())){
            return true;
        }
        return false;
    }
    public void resolution(){
        Player first = players.get(slapOrder.get(0));
        if(this.isLegal(board.get(board.size()-3), board.get(board.size()-2), board.get(board.size()-1)){
            for (int i = 0; i < board.size(); i++){
                first.getDeck().addCard(board.get(i));
          }
        }
        else{
            for(int k = 0; k < slapOrder.size() ; k++){
            Player slapPlayerDeck = players.get(slapOrder.get(i)).getDeck()
            board.add(0, slapPlayerDeck.getDeck.deal(slapPlayerDeck.size()-1));
        }
    }
              
}

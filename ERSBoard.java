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

    /**
     * Constructor for objects of class ERSBoard
     */
    public ERSBoard(int numPlayers)
    {
        board = new ArrayList<Card>();
        slapOrder = new ArrayList<Integer>();
        players = new ArrayList<Player>();
        deck = new Deck();
        
        for (int x = 0; x < numPlayers; x++) {
            players.add(new Player());
        }
    }
    public boolean isLegal(Card c1, Card c2, Card c3){
        if(c1.rank().equals(c3.rank()) || c2.rank().equals(c3.rank())){
            return true;
        }
        return false;
    }
    public void resolution(){
        if(this.isLegal(board.get(board.size()-3), board.get(board.size()-2), board.get(board.size()-1)){
           
}


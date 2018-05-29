public class Player
{
    private Deck d;
    private int num;
    
    public Player(Deck d1, int n)
    {
        d = d1;
        num = n;
    }
    
    public int slap()
    {
        return num;
    }
    
    public Deck getDeck()
    {
        return d;
    }
    
    
}

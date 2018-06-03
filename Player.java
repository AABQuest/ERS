public class Player extends JFrame
{
    private static final int WF = JComponent.WHEN_FOCUSED;
    private static final String SLAP = "slap";
    private static final String DEAL_CARD = "deal card";
    
    static JLabel obj1 = new JLabel();
    static JLabel obj2 = new JLabel();
    
    public Player(){
        obj1.getInputMap(WF).put(KeyStroke.getKeyStroke("SLAP"), SLAP);
        
        obj2.getInputMap(WF).put(KeyStroke.getKeyStroke("W"), SLAP);
        
        obj1.getActionMap().put(SLAP, slap());
    
    private Deck d;
    private int num;
    
    public Player(Deck d1, int n)
    {
        d = d1;
        num = n;
    }
    
    public int slap()
    {
        System.out.print(num);
    }
    
    public Deck getDeck()
    {
        return d;
    }
    
    
}

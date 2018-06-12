package aabERS;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	private double x;
	private double y;
    private Deck d;
    private int num;
    
    private BufferedImage player;
    
    public Player(Deck d1, int n, int r, int c, double x, double y, Game game) {
        d = d1;
        num = n;
        this.x = x;
        this.y = y;
        
        SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
        
        player = ss.grabImage(r, c, 128, 128);
    }
    
    
    public void tick() {
    	
    }
    
    public void render(Graphics g) {
    	g.drawImage(player, (int)x, (int)y, null);
    }
    
    
    public int slap()
    {
        return num;
    }
    
    public double getX() {
    	return x;
    }
    
    public double getY() {
    	return y;
    }
    
    public void setX(double x) {
    	this.x = x;
    }
    
    public void setY(double y) {
    	this.y = y;
    }
    
}

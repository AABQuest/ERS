package aabERS;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 680;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Egyptian Ratscrew";
	
	//loop
	private boolean running = false;
	private Thread thread;
	
	//buffering
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	
	private Player p;
	private Player p2;
	private Player p3;
	private Player p4;
	
	public void initialize() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/sprite_sheet.png");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new KeyInput(this));
		
		p = new Player(new Deck(), 1, 1, 1, 560, 900, this);
		p2 = new Player(new Deck(), 2, 1, 2, 100, 450, this);
		p3 = new Player(new Deck(), 3, 2, 2, 720, 100, this);
		p4 = new Player(new Deck(), 4, 2, 1, 1260, 600, this);
	}
	
	private synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		initialize();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			//game loop
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, " + "FPS " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		p.tick();
		p2.tick();
		p3.tick();
		p4.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);	
				
		p.render(g);
		p2.render(g);
		p3.render(g);
		p4.render(g);
		
		/////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_Q) {
			p2.setX(p2.getX() + 500);
		} else if(key == KeyEvent.VK_W) {

		} else if(key == KeyEvent.VK_C) {
			p.setY(p.getY() - 350);
		} else if(key == KeyEvent.VK_V) {

		} else if(key == KeyEvent.VK_M) {
			p3.setY(p3.getY() + 400);
		} else if(key == KeyEvent.VK_COMMA) {
			
		} else if(key == KeyEvent.VK_OPEN_BRACKET) {
			p4.setX(p4.getX() - 450);
		} else if(key == KeyEvent.VK_CLOSE_BRACKET) {
		
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_Q) {
			p2.setX(100);
		} else if(key == KeyEvent.VK_W) {

		} else if(key == KeyEvent.VK_C) {
			p.setY(900);
		} else if(key == KeyEvent.VK_V) {

		} else if(key == KeyEvent.VK_M) {
			p3.setY(100);
		} else if(key == KeyEvent.VK_COMMA) {
			
		} else if(key == KeyEvent.VK_OPEN_BRACKET) {
			p4.setX(1260);
		} else if(key == KeyEvent.VK_CLOSE_BRACKET) {
		
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		game.start();
	}	
	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	
}

import javax.swing.*;
import java.awt.*;

public class ERSSwing {

	public static void ERSSwingRun() {
        //Create and set up the window.
        JFrame frame = new JFrame("Egyptian Ratscrew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());
        
        //Add Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);
        menuBar.setSize(1000, 100);
        menuFile.setSize(500,100);
         
        menuBar.add(menuFile);
         
        // adds menu bar to the frame
        frame.setJMenuBar(menuBar);

        //Display the window.
        frame.pack();
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.getContentPane().setBackground(Color.blue);
	}
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ERSSwingRun();
            }
        });
    }
}

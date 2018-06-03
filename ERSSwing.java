import javax.swing.*;

public class ERSSwing {

	public static void ERSSwingRun() {
        //Create and set up the window.
        JFrame frame = new JFrame("Egyptian Ratscrew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "ERS" label.
        JLabel label = new JLabel("ERS");
        label.setSize(1000, 1000);
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setSize(2500, 2080);
        frame.setVisible(true);
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

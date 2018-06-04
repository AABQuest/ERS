package aabERS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;

public class ERSWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERSWindow frame = new ERSWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ERSWindow() {
		setTitle("ERS");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\eclipse-workspace\\aabERS\\res\\cards.png"));
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 561);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][]", "[][][][][][]"));
		
		Canvas canvas = new Canvas();
		panel.add(canvas, "flowx,cell 1 0 12 5");
		
		Button button = new Button("Play");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ERSBoard board = new ERSBoard(4);
			}
		});
		button.addKeyListener(new KeyAdapter() {
		});
		panel.add(button, "cell 10 2,alignx left");
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

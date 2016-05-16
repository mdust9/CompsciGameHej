import java.awt.EventQueue;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 536, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("DANKY KANG");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 6;
		gbc_lblTitle.gridy = 2;
		frame.getContentPane().add(lblTitle, gbc_lblTitle);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.gridwidth = 2;
		gbc_btnPlay.insets = new Insets(0, 0, 5, 0);
		gbc_btnPlay.gridx = 6;
		gbc_btnPlay.gridy = 4;
		frame.getContentPane().add(btnPlay, gbc_btnPlay);
		
		JButton btnInstructions = new JButton("INSTRUCTIONS");
		btnInstructions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		GridBagConstraints gbc_btnInstructions = new GridBagConstraints();
		gbc_btnInstructions.gridwidth = 2;
		gbc_btnInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_btnInstructions.gridx = 6;
		gbc_btnInstructions.gridy = 6;
		frame.getContentPane().add(btnInstructions, gbc_btnInstructions);
		
		JButton btnCredits = new JButton("CREDITS");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		GridBagConstraints gbc_btnCredits = new GridBagConstraints();
		gbc_btnCredits.gridwidth = 2;
		gbc_btnCredits.gridx = 6;
		gbc_btnCredits.gridy = 8;
		frame.getContentPane().add(btnCredits, gbc_btnCredits);
	}
}

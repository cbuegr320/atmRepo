package sATMPackage;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen1 extends JPanel {
	private JTextField PANTextField;

	/**
	 * Create the panel.
	 */
	public Screen1() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Avenir Next", Font.PLAIN, 35));
		lblWelcome.setBounds(170, 42, 153, 48);
		add(lblWelcome);
		
		JLabel errorLabel = new JLabel("Error: Invalid PAN");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		errorLabel.setBounds(169, 191, 147, 25);
		add(errorLabel);
		
		JLabel lblNewLabel = new JLabel("Please enter your PAN (account number)");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 228, 331, 25);
		add(lblNewLabel);
		
		PANTextField = new JTextField();
		PANTextField.setBounds(152, 265, 200, 33);
		add(PANTextField);
		PANTextField.setColumns(10);
		
		//--------------------------------
		// MARK: - Enter PAN Button Tapped
		//--------------------------------
		JButton enterPANButton = new JButton("ENTER");
		enterPANButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// move to screen 2 or screen 4 depending on if your PAN is correct or not
				
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("2");
				
			}
		});
		enterPANButton.setForeground(new Color(0, 128, 0));
		//enterButton.setBackground(new Color(0, 128, 0));
		enterPANButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		enterPANButton.setBackground(enterButtonColor);
		
		enterPANButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enterPANButton.setBounds(185, 377, 138, 49);
		add(enterPANButton);
	}
}

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

public class Screen3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen3() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your PIN is incorrect.");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(164, 227, 172, 25);
		add(lblNewLabel);
		
		JButton tryAgainButton = new JButton("TRY AGAIN");
		tryAgainButton.setForeground(new Color(0, 128, 128));
		//enterButton.setBackground(new Color(0, 128, 0));
		tryAgainButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		tryAgainButton.setBackground(enterButtonColor);
		
		//--------------------------------
		// MARK: - Try Again Button Tapped
		//--------------------------------
		tryAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// move to screen 2
				// keep track of attempts!
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("2");
			}
		});
		tryAgainButton.setBounds(150, 379, 201, 49);
		add(tryAgainButton);
		
		//---------------------------
		// MARK: - Exit Button Tapped
		//---------------------------
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// move to screen 1
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("1");
			}
		});
		
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		btnExit.setBounds(26, 19, 82, 33);
		add(btnExit);
		
		JLabel lblPleaseTryAgain = new JLabel("Please try again.");
		lblPleaseTryAgain.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblPleaseTryAgain.setBounds(183, 254, 135, 25);
		add(lblPleaseTryAgain);
	}

}

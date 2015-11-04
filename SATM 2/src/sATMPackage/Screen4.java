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

public class Screen4 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen4() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Invalid ATM Card.");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(176, 227, 149, 25);
		add(lblNewLabel);
		Color enterButtonColor = Color.decode("#6365ff");
		
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
		
		JLabel lblItWillBe = new JLabel("It will be retained!");
		lblItWillBe.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblItWillBe.setBounds(176, 258, 149, 25);
		add(lblItWillBe);
	}
}

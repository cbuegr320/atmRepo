package sATMPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Screen15 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen15() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please take your receipt and ATM card.");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 227, 322, 25);
		add(lblNewLabel);
		
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
		
		JLabel lblThankYou = new JLabel("Thank you!");
		lblThankYou.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblThankYou.setBounds(205, 253, 90, 25);
		add(lblThankYou);
	}
}

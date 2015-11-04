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
import javax.swing.JTextField;

public class Screen14 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen14() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your new balance is:");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(166, 227, 169, 25);
		add(lblNewLabel);
		
		//---------------------------
		// MARK: - Exit Button Tapped
		//---------------------------
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						
				// move to screen 15
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("15");
			}
		});
				
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		btnExit.setBounds(26, 19, 82, 33);
		add(btnExit);
		
		JButton tryAgainButton = new JButton("Another Transaction?");
		tryAgainButton.setForeground(new Color(0, 128, 128));
		//enterButton.setBackground(new Color(0, 128, 0));
		tryAgainButton.setFont(new Font("Avenir Next", Font.PLAIN, 24));
		Color enterButtonColor = Color.decode("#6365ff");
		tryAgainButton.setBackground(enterButtonColor);
		
		//--------------------------------
		// MARK: - Try Again Button Tapped
		//--------------------------------
		tryAgainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// move to screen 5
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("5");
			}
		});
		tryAgainButton.setBounds(83, 379, 335, 49);
		add(tryAgainButton);
		
		JLabel balanceLabel = new JLabel("$12,500.23");
		balanceLabel.setForeground(new Color(0, 128, 0));
		balanceLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		balanceLabel.setBounds(205, 264, 90, 25);
		add(balanceLabel);
	}
}

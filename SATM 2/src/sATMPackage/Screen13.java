package sATMPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Screen13 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen13() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please insert deposit into deposit slot");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(96, 227, 309, 25);
		add(lblNewLabel);
		
		JButton tryAgainButton = new JButton("Done");
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
				
				// move to screen 14
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("14");
			}
		});
		tryAgainButton.setBounds(150, 379, 201, 49);
		add(tryAgainButton);
	}
}

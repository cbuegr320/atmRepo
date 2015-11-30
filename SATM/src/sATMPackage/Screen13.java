package sATMPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;

public class Screen13 extends JPanel {
	private JTextField depositTextField;

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
		
		JButton depositButton = new JButton("DEPOSIT");
		depositButton.setForeground(new Color(0, 128, 128));
		//enterButton.setBackground(new Color(0, 128, 0));
		depositButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		depositButton.setBackground(enterButtonColor);
		
		//------------------------------
		// MARK: - Deposit Button Tapped
		//------------------------------
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double depositAmount = Double.parseDouble(depositTextField.getText());
				try {
					ATM.updateDeposit(ATM.getPAN(), depositAmount);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// move to screen 14
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("14");
			}
		});
		depositButton.setBounds(150, 379, 201, 49);
		add(depositButton);
		
		depositTextField = new JTextField();
		depositTextField.setBounds(178, 295, 130, 26);
		add(depositTextField);
		depositTextField.setColumns(10);
	}
}

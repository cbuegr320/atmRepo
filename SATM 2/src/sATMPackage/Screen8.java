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

public class Screen8 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen8() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter a new amount");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(140, 227, 221, 25);
		add(lblNewLabel);
		
		JButton returnToWithdrawButton = new JButton("RETURN TO WITHDRAW");
		returnToWithdrawButton.setForeground(new Color(0, 128, 128));
		//enterButton.setBackground(new Color(0, 128, 0));
		returnToWithdrawButton.setFont(new Font("Avenir Next", Font.PLAIN, 26));
		Color enterButtonColor = Color.decode("#6365ff");
		returnToWithdrawButton.setBackground(enterButtonColor);
		
		//--------------------------------------------
		// MARK: - Enter Withdraw Amount Button Tapped
		//--------------------------------------------
		returnToWithdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// move to screen 7
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("7");
			}
		});
		returnToWithdrawButton.setBounds(80, 379, 340, 44);
		add(returnToWithdrawButton);
		
		//---------------------------------------
		// MARK: - Transaction Menu Button Tapped
		//---------------------------------------
		JButton transactionMenuButton = new JButton("Transaction Menu");
		transactionMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// move to screen 5
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("5");
			}
		});
		
		transactionMenuButton.setForeground(new Color(255, 0, 0));
		transactionMenuButton.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		transactionMenuButton.setBounds(26, 19, 190, 33);
		add(transactionMenuButton);
		
		JLabel lblWithdrawalsMustBe = new JLabel("Insufficient funds!");
		lblWithdrawalsMustBe.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblWithdrawalsMustBe.setBounds(179, 193, 143, 25);
		add(lblWithdrawalsMustBe);
	}
}

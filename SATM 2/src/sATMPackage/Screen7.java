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

public class Screen7 extends JPanel {
	private JTextField enterAmountTextField;

	/**
	 * Create the panel.
	 */
	public Screen7() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter amount");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(195, 227, 111, 25);
		add(lblNewLabel);
		
		enterAmountTextField = new JTextField();
		enterAmountTextField.setBounds(150, 265, 200, 33);
		add(enterAmountTextField);
		enterAmountTextField.setColumns(10);
		
		JButton enterWithdrawAmount = new JButton("WITHDRAW");
		enterWithdrawAmount.setForeground(new Color(0, 128, 128));
		//enterButton.setBackground(new Color(0, 128, 0));
		enterWithdrawAmount.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		enterWithdrawAmount.setBackground(enterButtonColor);
		
		JLabel pleaseInputNumberValueLabel = new JLabel("Please input a number value");
		pleaseInputNumberValueLabel.setVisible(false);
		
		pleaseInputNumberValueLabel.setForeground(new Color(255, 0, 0));
		pleaseInputNumberValueLabel.setFont(new Font("Avenir Next", Font.PLAIN, 15));
		pleaseInputNumberValueLabel.setBounds(151, 326, 199, 21);
		add(pleaseInputNumberValueLabel);
		
		//--------------------------------------------
		// MARK: - Enter Withdraw Amount Button Tapped
		//--------------------------------------------
		enterWithdrawAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				
				// Check if the user input is divisible by 10, then let the user withdraw 
				
				// move to screen 8 if there are insufficient funds
				// move to screen 9 if the input is not divisible by 10
				// move to screen 10 if the system if temporarily unable to process withdrawals
				// move to screen 11 if everything is correct.
				try{
					// checking if user input is divisible by 10
					if((Double.parseDouble(enterAmountTextField.getText()) % 10) == 0){
						satmGui.changeCards("11");
						pleaseInputNumberValueLabel.setVisible(false);
					} 
					else if((Double.parseDouble(enterAmountTextField.getText()) % 10) != 0) {
						satmGui.changeCards("9");
						pleaseInputNumberValueLabel.setVisible(false);
					} else {
						// create other cases for moving to different screens.
					}
				} catch (Exception e1){
					e1.printStackTrace();
					
					pleaseInputNumberValueLabel.setVisible(true);
				}
			}
		});
		enterWithdrawAmount.setBounds(145, 379, 211, 49);
		add(enterWithdrawAmount);
		
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
		
		JLabel lblWithdrawalsMustBe = new JLabel("Withdrawals must be be multiples of $10");
		lblWithdrawalsMustBe.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblWithdrawalsMustBe.setBounds(83, 193, 335, 25);
		add(lblWithdrawalsMustBe);
		
		
	}

}

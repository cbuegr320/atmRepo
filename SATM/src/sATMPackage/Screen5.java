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

import java.sql.*;

public class Screen5 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Screen5() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		//-------------------------------
		// MARK: - Withdraw Button Tapped
		//-------------------------------
		JButton withdrawButton = new JButton("WITHDRAW");
		withdrawButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// move to screen 7
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("7");
			}
		});
		
		withdrawButton.setForeground(new Color(60, 179, 113));
		//enterButton.setBackground(new Color(0, 128, 0));
		withdrawButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		withdrawButton.setBackground(enterButtonColor);
		
		withdrawButton.setBounds(150, 355, 201, 49);
		add(withdrawButton);
		
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
		
		JLabel lblPleaseTryAgain = new JLabel("Select transaction:");
		lblPleaseTryAgain.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblPleaseTryAgain.setBounds(175, 114, 151, 25);
		add(lblPleaseTryAgain);
		
		//------------------------------
		// MARK: - Balance Button Tapped
		//------------------------------
		JButton balanceButton = new JButton("BALANCE");
		balanceButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// move to screen 6
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("6");
				
				
			}
		});
		
		balanceButton.setForeground(new Color(30, 144, 255));
		balanceButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		balanceButton.setBackground(new Color(99, 101, 255));
		balanceButton.setBounds(150, 179, 201, 49);
		add(balanceButton);
		
		//------------------------------
		// MARK: - Deposit Button Tapped
		//------------------------------
		JButton depositButton = new JButton("DEPOSIT");
		depositButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// move to screen 13
				SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
				satmGui.changeCards("13");
			}
		});
		
		depositButton.setForeground(new Color(255, 127, 80));
		depositButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		depositButton.setBackground(new Color(99, 101, 255));
		depositButton.setBounds(150, 265, 201, 49);
		add(depositButton);
	}
}

package sATMPackage;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen6 extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Screen6() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance is");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(209, 227, 83, 25);
		add(lblNewLabel);
		Color enterButtonColor = Color.decode("#6365ff");
		
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
		
		// Add logic to change/update the balanceAmount label
		// ATM.getPrintedBalance()
		JLabel balanceAmountLabel = new JLabel(ATM.getPrintedBalance());
		
		//When panel appears, update balance
		addAncestorListener ( new AncestorListener ()
	    {
	        public void ancestorAdded ( AncestorEvent event )
	        {
	        	balanceAmountLabel.setText(ATM.getPrintedBalance());
	        }

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				balanceAmountLabel.setText(ATM.getPrintedBalance());
			}
	    });
		balanceAmountLabel.setForeground(new Color(0, 128, 0));
		balanceAmountLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		balanceAmountLabel.setBounds(213, 258, 75, 25);
		add(balanceAmountLabel);
	}
}

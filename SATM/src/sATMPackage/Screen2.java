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

public class Screen2 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField PINTextField;

	/**
	 * Create the panel.
	 */
	public Screen2() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter your PIN");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		lblNewLabel.setBounds(163, 227, 175, 25);
		add(lblNewLabel);
		
		PINTextField = new JTextField();
		PINTextField.setBounds(150, 265, 200, 33);
		add(PINTextField);
		PINTextField.setColumns(10);
		
		JButton enterPINButton = new JButton("ENTER");
		enterPINButton.setForeground(new Color(0, 128, 0));
		//enterButton.setBackground(new Color(0, 128, 0));
		enterPINButton.setFont(new Font("Avenir Next", Font.PLAIN, 30));
		Color enterButtonColor = Color.decode("#6365ff");
		enterPINButton.setBackground(enterButtonColor);
		
		//--------------------------------
		// MARK: - Enter PIN Button Tapped
		//--------------------------------
		enterPINButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TEST GUI 
				// move to screen 5 if PIN is correct
				// move to screen 3 if PIN is incorrect
				// move to screen 4 if three attempts have been made
				
				String checkText = PINTextField.getText();
				
				if(checkText.length() == 4){
					
					int temp = Integer.parseInt(PINTextField.getText());
					System.out.println("temp " + temp);
				
					// if PIN is correct...
					if (ATM.isCorrectPIN(temp)) {

						SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
						satmGui.changeCards("5");

						// if PIN is not correct...
					} else {

						SATMGUI satmGui = (SATMGUI) getParent().getParent().getParent().getParent();
						satmGui.changeCards("3");
					}
				} else {
					System.out.println("This pin is not four characters long");
				}
			}
		});
		enterPINButton.setBounds(181, 379, 138, 49);
		add(enterPINButton);
		
		// MARK: - Set TextField to Empty when View Loads
		addAncestorListener ( new AncestorListener ()
		{
			public void ancestorAdded ( AncestorEvent event )
			{
				PINTextField.setText("");
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void ancestorMoved(AncestorEvent event) {

				PINTextField.setText("");
			}
		});
				
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
	}

}

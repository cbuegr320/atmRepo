package ATM;

/* LOG FOR MODIFICATIONS
 * 			WHO			DATE		DETAILS OF CHANGE
 * 		Emanuel Macias	11/2/2015	Added Screen 14 Outline
 * 		Casey/ Ryan		11/2/2015	Added double balance and getBalance()
 */

public class ATM {

	double balance = 0;
	
	public String tenDollarNoteWarning() {
		// Screen 9
		// David Larsen
		return "Machine can only dispense $10 notes.";
	}
	public String transactionComplete() {
		// Screen 15
		// David Larsen
		return "Please take your ATM card.\nThank you.";
	}
	
	public String balanceUpdateText(){
		//Screen 11
		// Manuel Puentes
		
		//Possibly could call or could be called by the update balance function, haven't decided yet
		
		return "Your balance is being updated. Please take cash from dispenser.";
		
	}
	
	public String printReceipt(){
		//Screen 14
		//Emanuel Macias
		
		//Prints Customer Receipt with new balance and asks user 
		//if they want to initiate a new transaction
		
		
		return "Your new balance is being printed. Would you like to make another transaction?";
	}
	
	public double getBalance(){
		// Casey and Ryan
		return balance;
	}
	
}

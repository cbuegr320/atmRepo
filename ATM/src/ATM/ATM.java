package ATM;

/* LOG FOR MODIFICATIONS
 * 			WHO			DATE		DETAILS OF CHANGE
 * 		Emanuel Macias	11/2/2015	Added Screen 14 Outline
 * 		Casey/ Ryan		11/2/2015	Added double balance and getBalance()
 *		Cameron Geiger	11/3/2015	Added verifyAccount and invalidAccountNumber functions
 *		Ryan			11/4/2015 	Added some comments on the getBalance function
 */

public class ATM {

	double balance = 0;
	
	public void verifyAccount(int tryPAN) throws SQLException {
		//Screen 1
		//Cameron Geiger
		
		//Establish connection with database.
		Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
		//Create the vehicle for passing SQL queries.
		Statement statement = databaseConnection.createStatement();
		//A pseudo array for any retrieved results
		ResultSet panResult = statement.executeQuery("SELECT * FROM myatmschema.account");
		
		boolean panFound = false;
		int fetchedPAN;
		
		//While there are still results and the PAN has not been found.
		while(panResult.next() && !panFound) {			
			fetchedPAN = panResult.getInt("PAN");
			if(tryPAN == fetchedPAN) {
				panFound = true;
				Account account = new Account();
			}
		}
		
		if(!panFound) {
			invalidAccountNumber();
		}
	}

	public String invalidAccountNumber() {
		//Screen 4
		//Cameron Geiger
		return "Invalid ATM card or account number.";
	}
	
	public String insufficientFunds() {
		//Screen 8
		//Cameron Geiger
		
	}
	
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
		// TODO: Link this to the SQL server
		return balance;
	}
	
}

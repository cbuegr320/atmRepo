package ATM;

import com.mysql.jdbc.Statement;

/* LOG FOR MODIFICATIONS
 * 			WHO			DATE		DETAILS OF CHANGE
 * 		Emanuel Macias	11/2/2015	Added Screen 14 Outline
 * 		Casey/ Ryan		11/2/2015	Added double balance and getBalance()
 *		Cameron Geiger	11/3/2015	Added verifyAccount and invalidAccountNumber functions
 */

public class ATM {

	int PAN;
	int PIN;
	double atmBalance = 0;
	double userBalance = 0;
	
	
	public void getAccountInfo(int userPAN){
		try {
			// Prepare statement
			// This will select a PAN and find the BALANCE that is associated with
			// that PAN from the database.
			myStatement = myConnection.prepareStatement("SELECT PAN, PIN, BALANCE FROM MyATMSchema.MyATMTable WHERE PAN="+ userPAN);
			myStatement.setInt(1, userPAN);
			// Execute SQL query
			myResultSet = myStatement.executeQuery();
			// Process Result Set
			// "PAN" "PIN" and "BALANCE" are the names of the columns in your database.
			// we assign the variables "thePAN" "thePIN" and "theBalance" to these database columns.
			while (myResultSet.next()) {
				PAN = myResultSet.getInt("PAN");
				PIN = myResultSet.getInt("PIN");
				balance = myResultSet.getInt("BALANCE");
				//System.out.println("Swag PAN: "+ PAN + " PIN: " + PIN + " Balance: " + balance);
			}
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		} 
		finally {
			close (myStatement, myResultSet);
		}
	}
	
	
	
	
	public boolean isCorrectPAN(int tempPAN){
		return PAN == tempPAN;
	} 
		
	
	
	
	public boolean isCorrectPIN(int tempPIN){
		return PIN == tempPIN;
	}

	
	
	
	public String invalidAccountNumber() {
		//Screen 4
		//Cameron Geiger
		return "Invalid ATM card or account number.";
	}
	
	public String insufficientFunds(Account account) {
		//Screen 8
		//Cameron Geiger
		
		//Establish connection with database.
		Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
		//Create the vehicle for passing SQL queries.
		Statement statement = databaseConnection.createStatement();
		//A pseudo array for any retrieved results
		ResultSet balanceResult = statement.executeQuery("SELECT balance FROM myatmschema.account")
		
		return "Insufficient funds. Please enter a new amount."
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
		return balance;
	}
	
}

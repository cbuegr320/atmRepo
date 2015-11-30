package sATMPackage;
import java.sql.*;

public class ATM {
	private static int PAN = 0;
	static int PIN;
	double atmBalance = 0;
	static double userBalance = 0;
	static String printedBalance;
	
	static public boolean getAccountInfo(int userPAN) throws SQLException{
		boolean isCorrectPAN;
		Connection myConnection = null;
		PreparedStatement myStatement = null;
		ResultSet myResultSet = null;
		try {
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost","student","student");
			
			// Prepare statement
			// This will select a PAN and find the BALANCE that is associated with
			// that PAN from the database.
			myStatement = myConnection.prepareStatement("SELECT PAN, PIN, BALANCE FROM MyATMSchema.MyATMTable WHERE PAN="+ userPAN);
			
			// Execute SQL query
			myResultSet = myStatement.executeQuery();
			
			// Process Result Set
			// "PAN" "PIN" and "BALANCE" are the names of the columns in your database.
			// we assign the variables "thePAN" "thePIN" and "theBalance" to these database columns.
			while (myResultSet.next()) {
				setPAN(myResultSet.getInt("PAN"));
				PIN = myResultSet.getInt("PIN");
				System.out.println(PIN);
				userBalance = myResultSet.getDouble("BALANCE");
				printedBalance = Double.toString(userBalance);
			}
		
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		} 
		finally {
			close (myStatement, myResultSet);
		}
		
		 
		if(getPAN() != 0) {
			isCorrectPAN = true;
		}
		else
			isCorrectPAN = false;
		
		return isCorrectPAN;
	}	
	
	
	public static boolean isCorrectPIN(int tempPIN){
		return PIN == tempPIN;
	}

	private static void close(Connection accountConnection, Statement accountStatement, ResultSet accountResultSet) throws SQLException{
		if(accountResultSet != null){
			accountResultSet.close();
		}
		if(accountStatement != null){
			accountStatement.close();
		}
		if(accountConnection != null){
			accountConnection.close();
		}
	}
	
	//Modified helper method for closing connection, statement, and result sets
	//This is also known as a function overload
	private static void close(Statement accountStatement, ResultSet accountResultSet) throws SQLException{
		close(null, accountStatement,accountResultSet);
	}
	
	public static double getUserBalance() {
		return userBalance;
	}
	
	public static String getPrintedBalance() {
		return printedBalance;
	}
	
	public static boolean checkIfSufficientFunds(double withdraw) {
		boolean enoughInAccount;
		if(withdraw > userBalance)
			return enoughInAccount = false;
		else
			return enoughInAccount = true;
	}
	
	
	
	public static void updateWithdraw(int userPAN, double userWithdrawal) throws SQLException{
		// Screen 11
		// Manuel Puentes
		Connection accountConnection = null; //used for the user of the atm
		Statement accountStatement = null;
		ResultSet accountResultSet = null;
		
		Connection atmConnection = null; // used for the atm itself
		Statement atmStatement = null;
		ResultSet atmResultSet = null;
		
		Connection atmGetBalance = null;
		Statement atmBalanceStatement = null;
		ResultSet atmBalanceResult = null;
		
		try{
			//1. Get a connection to database
			accountConnection = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			atmConnection = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			atmGetBalance = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			
			//System.out.println("Database connection successful\n");
			
			//2. Create a statement
			accountStatement = accountConnection.createStatement();
			atmStatement = atmConnection.createStatement();
			atmBalanceStatement = atmGetBalance.createStatement();
			
			//Call helper method to display the ATM user's row information before update
			//System.out.println("Before the update...");
			
			
			
			//***********************************************************************************//
			//***********************************************************************************//
			int ATMUserPAN = userPAN;  
			int AtmId = 1;			
			//***********************************************************************************//
			//***********************************************************************************//
			
			accountStatement.executeUpdate("UPDATE myatmschema.myatmtable " +
									  "SET BALANCE =  BALANCE - " + userWithdrawal + " " +
									  "WHERE PAN = " + ATMUserPAN);
			atmStatement.executeUpdate("UPDATE myatmschema.myatmmachine " +
					  "SET atm_balance = atm_balance -" + userWithdrawal + " " +
					  "WHERE  atm_id = " + AtmId);
			
			userBalance = userBalance - userWithdrawal;
			printedBalance = Double.toString(userBalance);
			
			atmBalanceStatement.executeQuery("");
		
			//3. Execute SQL query
			accountResultSet = accountStatement.executeQuery("SELECT * FROM myatmschema.myatmtable ORDER BY PAN");
			atmResultSet = atmStatement.executeQuery("SELECT * FROM myatmschema.myatmmachine ORDER BY atm_id");
			
		}catch(Exception exc){
			
				exc.printStackTrace();
				
		}finally{
			close(accountConnection, accountStatement, accountResultSet);
			close(atmConnection, atmStatement, atmResultSet);
		}
	}
	
	public static void updateDeposit(int userPAN, double userDeposit) throws SQLException{
		// Screen 11
		// Manuel Puentes
		Connection accountConnection = null; //used for the user of the atm
		Statement accountStatement = null;
		ResultSet accountResultSet = null;
		
		Connection atmConnection = null; // used for the atm itself
		Statement atmStatement = null;
		ResultSet atmResultSet = null;
		
		Connection atmGetBalance = null;
		Statement atmBalanceStatement = null;
		ResultSet atmBalanceResult = null;
		
		try{
			//1. Get a connection to database
			accountConnection = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			atmConnection = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			atmGetBalance = DriverManager.getConnection("jdbc:mysql://localhost", "student","student");
			
			//System.out.println("Database connection successful\n");
			
			//2. Create a statement
			accountStatement = accountConnection.createStatement();
			atmStatement = atmConnection.createStatement();
			atmBalanceStatement = atmGetBalance.createStatement();
			
			//Call helper method to display the ATM user's row information before update
			//System.out.println("Before the update...");
			
			
			
			//***********************************************************************************//
			//***********************************************************************************//
			int ATMUserPAN = userPAN;  
			int AtmId = 1;			
			//***********************************************************************************//
			//***********************************************************************************//
			
			
			accountStatement.executeUpdate("UPDATE myatmschema.myatmtable " +
									  "SET BALANCE =  BALANCE + " + userDeposit + " " +
									  "WHERE PAN = " + ATMUserPAN);
			atmStatement.executeUpdate("UPDATE myatmschema.myatmmachine " +
					  "SET atm_balance = atm_balance +" + userDeposit + " " +
					  "WHERE  atm_id = " + AtmId);
			
			userBalance = userBalance + userDeposit;
			printedBalance = Double.toString(userBalance);
			
			atmBalanceStatement.executeQuery("");
		
			//3. Execute SQL query
			accountResultSet = accountStatement.executeQuery("SELECT * FROM myatmschema.myatmtable ORDER BY PAN");
			atmResultSet = atmStatement.executeQuery("SELECT * FROM myatmschema.myatmmachine ORDER BY atm_id");
			
		}catch(Exception exc){
			
				exc.printStackTrace();
				
		}finally{
			close(accountConnection, accountStatement, accountResultSet);
			close(atmConnection, atmStatement, atmResultSet);
		}
	}


	public static int getPAN() {
		return PAN;
	}


	public static void setPAN(int pAN) {
		PAN = pAN;
	}
}

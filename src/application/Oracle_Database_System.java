package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Oracle_Database_System{


	public boolean Validate_Data_Username(String username)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");	
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT Name FROM admin_table where Name='"+username+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String username1 =" ";
			while(rs.next()){
				username1=rs.getString("Name");
			}
			System.out.println(username1);
			if(username1.equals(username1.valueOf(username)))
			{
				check=true;
				return check;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}

		return check;
	}
	public boolean Validate_Data_cnic(int username)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");	
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT cnic FROM admin_table where cnic="+username;
			ResultSet rs = stmt.executeQuery(sql);
			String username1 =" ";
			while(rs.next()){
				username1=rs.getString("cnic");
			}
			System.out.println(username1);
			if(username1.equals(username1.valueOf(username)))
			{
				check=true;
				return check;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}

		return check;
	}

	public boolean Validate_Data_Password(String password)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");	
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT Password FROM admin_table where Password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			String username1 =" ";
			while(rs.next()){
				username1=rs.getString("Password");
			}
			if(username1.equals(username1.valueOf(password)))
			{
				check=true;
				return check;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}

		return check;
	}

	public void Insert_Values(int cnic,String name,String password)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			String sql="INSERT INTO admin_table(cnic,Name,Password) VALUES (?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,cnic);			
			statement.setString(2,name);			
			statement.setString(3,password);						
			int rowInserted =statement.executeUpdate();
			if(rowInserted > 0)
			{
				System.out.println("A new User is Inserted SucessFully");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}
	public boolean Validate_Voter_Data_cnic(int username)
	{
		boolean check=false;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");	
			System.out.println("Creating statement...");
			Statement stmt = con.createStatement();
			String sql;
			sql = "SELECT cnic FROM Voter where cnic="+username;
			ResultSet rs = stmt.executeQuery(sql);
			String username1 =" ";
			while(rs.next()){
				username1=rs.getString("cnic");
			}
			System.out.println(username1);
			if(username1.equals(username1.valueOf(username)))
			{
				check=true;
				return check;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}

		return check;
	}
	public void Insert_Voter_Values(int cnic,String name,String Party)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			String sql="INSERT INTO Voter(cnic,Name,Party) VALUES (?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,cnic);			
			statement.setString(2,name);			
			statement.setString(3,Party);						
			int rowInserted =statement.executeUpdate();
			if(rowInserted > 0)
			{
				System.out.println("A new User is Inserted SucessFully");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}


	public static ObservableList<Voter> getDataVoter() throws ClassNotFoundException,SQLException{

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			Statement stmt = con.createStatement();
			String sql;
			sql = "Select * from Voter";
			ResultSet rs = stmt.executeQuery(sql);
			ObservableList<Voter> voterList=getVoterObjects(rs);
			return voterList;

		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		return null;
	}
	private static ObservableList<Voter> getVoterObjects(ResultSet rs) {

		try {
			ObservableList<Voter> list =FXCollections.observableArrayList();
			while(rs.next()) {
				Voter obj=new Voter();
				obj.setCnic(rs.getInt("cnic"));
				obj.setName(rs.getString("Name"));
				list.add(obj);
			}
			return list;
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		return null;
	}

	public int  Parties_Votes(String Party_Name)
	{
		int value=0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");	
			System.out.println("Creating statement...");
			PreparedStatement statement =  con.prepareStatement("select count(Party) from Voter where Party='"+Party_Name+"'");
			ResultSet result = statement.executeQuery();
			result.next();
			String sum = result.getString(1);
			value = Integer.parseInt(sum);

		} catch(Exception exc){
			System.out.println(exc.getMessage());
		}
		return value;
	}







	//		public String Account_Type(int getAccountno)
	//		{
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");
	//				System.out.println("Driver successfully loaded");
	//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	//				System.out.println("Connection Established");	
	//				System.out.println("Creating statement...");
	//				Statement stmt = con.createStatement();
	//				String sql;
	//				sql = "SELECT name FROM admin_table where cnic='"+getAccountno+"'";
	//				ResultSet rs = stmt.executeQuery(sql);
	//				while(rs.next()){
	//					String AccountType  = rs.getString("name");
	//					System.out.print(AccountType);
	//					return AccountType;
	//				}
	//				rs.close();
	//				stmt.close();
	//				con.close();
	//			}
	//			catch(ClassNotFoundException e) {
	//				System.out.println("Driver not loaded");
	//			}
	//			catch(SQLException e) {
	//				System.out.println("Connection Failed");
	//			}
	//			return "";
	//		}
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//		public void delete_Values(int getAccountno)
	//		{
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");
	//				System.out.println("Driver successfully loaded");
	//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	//				System.out.println("Connection Established");
	//
	//				String sql="Delete From User_info Where Account_no=?";
	//				PreparedStatement statement=con.prepareStatement(sql);
	//				statement.setInt(1,getAccountno);	
	//				int rowDeleted =statement.executeUpdate();
	//
	//				if(rowDeleted > 0)
	//				{
	//					System.out.println("A new User is Deleted SucessFully");
	//				}
	//			}
	//			catch(ClassNotFoundException e) {
	//				System.out.println("Driver not loaded");
	//			}
	//			catch(SQLException e) {
	//				System.out.println("Connection Failed");
	//			}
	//		}
	//
	//
	//		public int get_Balance(int getAccountno)
	//		{
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");
	//				System.out.println("Driver successfully loaded");
	//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	//				System.out.println("Connection Established");	
	//				System.out.println("Creating statement...");
	//				Statement stmt = con.createStatement();
	//				String sql;
	//				sql = "SELECT Balance FROM User_info where Account_no="+getAccountno;
	//				ResultSet rs = stmt.executeQuery(sql);
	//				while(rs.next()){
	//					int Balance  = rs.getInt("Balance");
	//					return Balance;
	//				}
	//				rs.close();
	//				stmt.close();
	//				con.close();
	//			}
	//			catch(ClassNotFoundException e) {
	//				System.out.println("Driver not loaded");
	//			}
	//			catch(SQLException e) {
	//				System.out.println("Connection Failed");
	//			}
	//			return 0;
	//		}
	//
	//
	//
	//
	//
	//
	//
	//
	//		public String get_details(int getAccountno)
	//		{
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");
	//				System.out.println("Driver successfully loaded");
	//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	//				System.out.println("Connection Established");	
	//				System.out.println("Creating statement...");
	//				Statement stmt = con.createStatement();
	//				String sql;
	//				sql = "SELECT Account_no,FirstName,LastName,Accounttype,Cnic,Pincode,Balance FROM User_info where Account_no="+getAccountno;
	//				ResultSet rs = stmt.executeQuery(sql);
	//				while(rs.next()){
	//					int Account_no  = rs.getInt("Account_no");
	//					String Firstname=rs.getString("FirstName");
	//					String LastName=rs.getString("LastName");
	//					String Accounttype=rs.getString("Accounttype");
	//					String Cnic=rs.getString("Cnic");
	//					int Pincode  = rs.getInt("Pincode");
	//					int Balance  = rs.getInt("Balance");
	//					String FinalString=Account_no+" "+Firstname+" "+LastName+" "+Accounttype+" "+Cnic+" "+Pincode+" "+Balance;
	//					return FinalString;
	//				}
	//				rs.close();
	//				stmt.close();
	//				con.close();
	//			}
	//			catch(ClassNotFoundException e) {
	//				System.out.println("Driver not loaded");
	//			}
	//			catch(SQLException e) {
	//				System.out.println("Connection Failed");
	//			}
	//			return "";
	//		}
	//		public void update_Balance(int getAccountno,int Balance)
	//		{
	//			try {
	//				Class.forName("oracle.jdbc.driver.OracleDriver");
	//				System.out.println("Driver successfully loaded");
	//				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	//				System.out.println("Connection Established");	
	//				System.out.println("Creating statement...");
	//				String sql = "Update User_info SET Balance=? where Account_no=?";
	//				PreparedStatement statement=con.prepareStatement(sql);
	//				statement.setInt(1,Balance);
	//				statement.setInt(2,getAccountno);
	//				int rowUpdated =statement.executeUpdate();
	//				if(rowUpdated > 0)
	//				{
	//					//System.out.println("A new User is Deleted SucessFully");
	//				}
	//				con.close();
	//			}
	//			catch(ClassNotFoundException e) {
	//				System.out.println("Driver not loaded");
	//			}
	//			catch(SQLException e) {
	//				System.out.println("Connection Failed");
	//			}
	//		}



}

package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admin {

	public String Register_Admin(String username,String password,String confirmpassword,String cnic)
	{
		Oracle_Database_System obj1=new Oracle_Database_System();
		String Message="";
		if (obj1.Validate_Data_cnic(Integer.parseInt(cnic))==false)
		{
			if(password.equals(confirmpassword))
			{
				obj1.Insert_Values(Integer.parseInt(cnic),username,password);
				Message="registered";	
			}
			else
			{
				Message="password_missmatch";
			}
		}
		else if (obj1.Validate_Data_cnic(Integer.parseInt(cnic))==true)
		{
			Message="User_already_exist";
		}
		return Message;
	}
	
	public int Signup(String getusername,String password)
	{
		Oracle_Database_System obj1=new Oracle_Database_System();
		int message=0;
		if (obj1.Validate_Data_Username(getusername)==true && obj1.Validate_Data_Password(password)==true)
		{
			message=1;
		}
		if (obj1.Validate_Data_Username(getusername)==false)
		{
			message=2;
		}
		if (obj1.Validate_Data_Password(password)==false)
		{
			message=3;
		}
		return message;
	}
	
}

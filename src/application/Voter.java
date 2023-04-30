package application;

import javafx.beans.property.*;

public class Voter {
	private final IntegerProperty Cnic;
	private final StringProperty Name;
	public Voter()
	{
		this.Cnic=new SimpleIntegerProperty();
		this.Name=new SimpleStringProperty();
	}
	public void setCnic(int Cnic)
	{
		this.Cnic.set(Cnic);
	}
	public void setName(String Name)
	{
		this.Name.set(Name);	
	}
	public IntegerProperty getCnic()
	{
		return Cnic;
	}

	public StringProperty getName()
	{
		return Name;	
	}

	public String Insert_Voter(String cnic,String name,String parties)
	{
		String message="";
		Oracle_Database_System obj1=new Oracle_Database_System();
		if (name.equals(""))
		{
			message="namenull";
			return message;
		}
		if (parties.equals(""))
		{
			message="partiesnull";
			return message;
		}
		if (obj1.Validate_Voter_Data_cnic(Integer.parseInt(cnic))==true)
		{
			message="Voted";
		}
		else
		{
			obj1.Insert_Voter_Values(Integer.parseInt(cnic),name,parties);
		}
		return message;
	}
}

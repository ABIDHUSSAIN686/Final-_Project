package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EVScontroller implements Initializable{
	@FXML
	private Label Time_Display=new Label();
	@FXML
	private Button clickButton;
	@FXML
	private PasswordField Adminpassword;
	@FXML
	private TextField Adminusername;
	@FXML
	private Button Adminloginbutton;
	@FXML
	private Label Adminwrongpassword;
	@FXML
	private Button Login_as_admin;
	@FXML
	private Button loginasvoter;
	@FXML
	private Button SystemAdminBack;
	@FXML
	private Button How_to_cast_vote;
	@FXML
	private Button Cast_Vote;
	@FXML
	private Button signup;
	@FXML
	private TextField Signup_Username;
	@FXML
	private PasswordField Signup_Password;
	@FXML
	private PasswordField Signup_ConfirmPassword;
	@FXML
	private TextField Signup_CNIC;
	@FXML
	private Button Signup_Register;
	@FXML
	private Label Register_Label;
	@FXML
	private Button force_Shutdown;
	@FXML
	private Button Parties_Detail;
	@FXML
	private Button CrossRegisterButton;
	@FXML
	private Button VoterMenuBackButton;
	@FXML
	private Button Howtocastvotebackbutton;
	@FXML
	private Button castvotebackbutton;
	@FXML
	private Button PartiesDetailbackbutton;
	@FXML
	private TextField castvotecnic;
	@FXML
	private TextField castvotename;
	@FXML
	private Button castvotebutton;
	@FXML
	private MenuButton castvoteparties;
	@FXML
	private MenuItem PMLN_Party;
	@FXML
	private MenuItem MQM_Party;
	@FXML
	private MenuItem PTI_Party;
	@FXML
	private MenuItem PPP_Party;
	@FXML
	private MenuItem ANP_Party;
	@FXML
	private MenuItem GDA_Party;
	@FXML
	private Label User_alreadyvoted;
	@FXML
	private Button Modify_Candidate;
	@FXML
	private Button Party_results;
	@FXML
	private Button Add_Candidate;
	@FXML
	private Button Admin_exit_button;
	@FXML
	private Button Voter_Info;
	@FXML
	private Button VoterInfo_exit_button;
	@FXML
	private TableView <Voter>Voter_Info_Table=new TableView<Voter>();
	@FXML
	private TableColumn<Voter, String> Voter_Name_Column=new TableColumn<Voter, String>() ;
	@FXML
	private TableColumn<Voter, Integer> Voter_CNIC_Cloumn=new TableColumn<Voter, Integer>()  ;
	@FXML
	private Button Party_Results_Exit_Button;
	@FXML
	private Button View_Results_Button;
	@FXML
	private PieChart Result_Chart=new PieChart();
	@FXML
	private Button Add_Candidate_Exit_Button;
	@FXML
	private Button Remove_Candidate_Exit_Button;
	final CategoryAxis xAxis=new CategoryAxis();
	final NumberAxis yAxis=new NumberAxis();
	private volatile boolean stop=false;
	@FXML
	private BarChart<String, Number> barChart=new BarChart<String, Number>(xAxis,yAxis);


	private String parties="";
	ObservableList<PieChart.Data> pieData=FXCollections.observableList(new ArrayList<PieChart.Data>());
	ObservableList<Voter> ListM=FXCollections.observableList(new ArrayList<Voter>());
	@FXML
	// In this function as the user click on the proceed button it is send to the login page.
	public void actionOnClickButton(ActionEvent event)
	{
		stop=true;
		try {

			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Login_Page.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void  Time() {
		Thread thread =new Thread(() ->{
			SimpleDateFormat sfd =new SimpleDateFormat("hh:mm:ss");
			while(!stop) {
				try{
					Thread.sleep(1000);
				}catch(Exception e) {
					System.out.print(e);
				}
				final String timenow =sfd.format(new Date());
				Platform.runLater(()->{
					Time_Display.setText(timenow);
				});
			}
		});
		thread.start();
	}


	@FXML
	// This button invoke when the user press on the admin button in the login page.
	public void LoginasAdmin(ActionEvent event)
	{

		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	// If the user doesnot exist and it clicks for signup in adminlogin page.
	public void On_press_Signup(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	//After the user clicked the signup button and now it go to register itself in signup page
	public void On_press_Signup_Register(ActionEvent event) {
		String username=Signup_Username.getText().toString();
		String password=Signup_Password.getText().toString();
		String confirmpassword=Signup_ConfirmPassword.getText().toString();
		String cnic=Signup_CNIC.getText().toString();
		Admin obj1=new Admin();
		String message=obj1.Register_Admin(username, password, confirmpassword, cnic);

		if (message.equals("registered"))
		{
			Register_Label.setText("Congragulation!! you are registered");
		}
		else if (message.equals("password_missmatch"))
		{
			Register_Label.setText("Password does not match!!");
		}
		else if (message.equals("User_already_exist"))
		{
			Register_Label.setText("User Already Exist!!");
		}
	}
	@FXML
	// In this the admin username and password is check if they are correct then the admin is send to the menu page other wise it is not.
	public void AdminloginbuttonFunction(ActionEvent event) {
		String getusername=Adminusername.getText().toString();
		String password=Adminpassword.getText().toString();
		Admin obj1=new Admin();
		int message=obj1.Signup( getusername, password);
		if (message==1)
		{
			Adminwrongpassword.setText("Success!!");
			try {
				Stage stage =new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
				Scene scene = new Scene(root);
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.setTitle("VOTING SYSTEM APPLICATION");
				stage.show();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (message==2)
		{
			Adminwrongpassword.setText("User_name does not Exist!!");
		}
		else if (message==3)
		{
			Adminwrongpassword.setText("Password does not Exist!!");
		}
	}
	@FXML
	void OnpressPartiesDetail(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("PartiesDetail.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	// This button invoke when the user press on the voter button in the login page.
	public void LoginasVoter(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("VoterMenu.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	public void On_press_How_to_cast_vote(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("How_to_Cast_Vote.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void On_press_Cast_Vote(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Cast_Vote.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void Onpresscastvotebutton(ActionEvent event) {
		String cnic=castvotecnic.getText().toString();
		String name=castvotename.getText().toString();
		Voter obj1=new Voter();
		String message=obj1.Insert_Voter(cnic, name, parties);
		if (message.equals("Voted"))
		{
			User_alreadyvoted.setText("You already Voted.");
		}
		else if (message.equals("namenull"))
		{
			User_alreadyvoted.setText("Enter Name Please.");
		}
		else if (message.equals("partiesnull"))
		{
			User_alreadyvoted.setText("Enter Party Please.");
		}
	}
	@FXML
	void OnpressANP_Party(ActionEvent event) {
		parties=ANP_Party.getText().toString();
	}
	@FXML
	void OnpressGDA_Party(ActionEvent event) {
		parties=GDA_Party.getText().toString();
	}
	@FXML
	void OnpressMQM_Party(ActionEvent event) {
		parties=MQM_Party.getText().toString();
	}
	@FXML
	void OnpressPMLN_Party(ActionEvent event) {
		parties=PMLN_Party.getText().toString();
	}
	@FXML
	void OnpressPPP_Party(ActionEvent event) {
		parties=PPP_Party.getText().toString();
	}
	@FXML
	void OnpressPTI_Party(ActionEvent event) {
		parties=PTI_Party.getText().toString();
	}
	void Admin_Menu(ActionEvent event)
	{
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void On_press_Party_results(ActionEvent event) {
		try {
			System.out.print("PieChart "+pieData);
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Party_Results.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void OnpressView_Results_Button(ActionEvent event) {

	}
	@FXML
	void On_press_Voter_Info(ActionEvent event) throws ClassNotFoundException, SQLException {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Voter_Info.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@FXML
	void OnpressAdd_Candidate(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Add_Candidate.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void OnpressModify_Candidate(ActionEvent event) {
		try {
			Stage stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Modify_Candidate.fxml"));
			Scene scene = new Scene(root);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Time();
		// TODO Auto-generated method stub
		Oracle_Database_System obj2=new Oracle_Database_System();
		int PPP=0,PMLN=0,MQM=0,PTI=0,GDA=0,ANP=0;
		PPP=obj2.Parties_Votes("PPP");
		PMLN=obj2.Parties_Votes("PMLN");
		MQM=obj2.Parties_Votes("MQM");
		PTI=obj2.Parties_Votes("PTI");
		GDA=obj2.Parties_Votes("GDA");
		ANP=obj2.Parties_Votes("ANP");
		double total=PPP+PMLN+MQM+PTI+GDA+ANP;
		pieData =FXCollections.observableArrayList(
				new PieChart.Data("PMLN", (PMLN/total)*100),
				new PieChart.Data("PPP", (PPP/total)*100),
				new PieChart.Data("PTI", (PTI/total)*100),
				new PieChart.Data("MQM", (MQM/total)*100),
				new PieChart.Data("GDA", (GDA/total)*100),
				new PieChart.Data("ANP", (ANP/total)*100)
				);
		Result_Chart.setData(pieData);
		Series<String, Number> series1=new XYChart.Series<>();
		int sum=PPP+PMLN+MQM+PTI+GDA+ANP;
		series1.setName("Parties Votes & Total Vote Casted="+sum);
		series1.getData().add(new XYChart.Data<>("PMLN", PMLN));
		series1.getData().add(new XYChart.Data<>("PPP", PPP));
		series1.getData().add(new XYChart.Data<>("PTI", PTI));
		series1.getData().add(new XYChart.Data<>("MQM", MQM));
		series1.getData().add(new XYChart.Data<>("GDA", GDA));
		series1.getData().add(new XYChart.Data<>("ANP", ANP));
		series1.getData().add(new XYChart.Data<>("PMLN", PMLN));
		barChart.getData().add(series1);
		try {
			ListM=Oracle_Database_System.getDataVoter();
			populateTable(ListM);
			Voter_CNIC_Cloumn.setCellValueFactory(cellData->cellData.getValue().getCnic().asObject());
			Voter_Name_Column.setCellValueFactory(cellData->cellData.getValue().getName());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void populateTable(ObservableList<Voter> listM2) {
		// TODO Auto-generated method stub
		Voter_Info_Table.setItems(listM2);
	}
	@FXML
	void OnpressVoterMenuBackButton(ActionEvent event) {
		stop=true;
		actionOnClickButton(event);	
	}
	@FXML
	void OnpressHowtocastvotebackbutton(ActionEvent event) {
		LoginasVoter(event);
	}
	@FXML
	void Onpresscastvotebackbutton(ActionEvent event) {
		LoginasVoter(event);
	}
	@FXML
	void OnpressPartiesDetailbackbutton(ActionEvent event) {
		LoginasVoter(event);
	}
	@FXML
	void On_press_Admin_exit_button(ActionEvent event) {
		stop=true;
		LoginasAdmin(event);
	}
	@FXML
	void OnpressParty_Results_Exit_Button(ActionEvent event) {
		Admin_Menu(event);
	}
	@FXML
	void OnpressVoterInfo_exit_button(ActionEvent event) {
		Admin_Menu(event);
	}
	@FXML
	//When click back on the admin_login page, go to the main login page
	public void OnpressSystemAdminBack(ActionEvent event) {	
		actionOnClickButton(event);
	}
	@FXML
	//When click back on the admin_login page, go to the main login page
	public void OnpressCrossRegisterButtonAction(ActionEvent event) {	
		LoginasAdmin(event);
	}
	@FXML
	// When user click on the cross in the Login page
	public void On_press_cross(ActionEvent event) {
		int response=JOptionPane.showConfirmDialog(null, "Do you want to Exit","CONFIRMATION",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (response==JOptionPane.YES_OPTION)
		{
			Platform.exit();
			System.exit(0);	
		}
	}
	@FXML
	void OnpressAdd_Candidate_Exit_Button(ActionEvent event) {
		Admin_Menu(event);
	}
	@FXML
	void OnpressRemove_Candidate_Exit_Button(ActionEvent event) {
		Admin_Menu(event);
	}
}
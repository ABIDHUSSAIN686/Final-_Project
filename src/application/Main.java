 package application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		EVS obj1=new EVS();
		obj1.Proceed_Page(stage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

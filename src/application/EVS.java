package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EVS {
	void Proceed_Page(Stage stage)
	{
		try {
			stage =new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Proceed.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("VOTING SYSTEM APPLICATION");
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

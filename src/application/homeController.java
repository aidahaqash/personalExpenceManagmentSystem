package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class homeController 
{     public int userid =0 ;

	
	@FXML
    public void start1 (ActionEvent event ) throws IOException{
		  Node node = (Node) event.getSource();
		  Stage stage = (Stage) node.getScene().getWindow();
		  userid = (int) stage.getUserData();
		//Node node = (Node) event.getSource();
	//	Stage stage = (Stage) node.getScene().getWindow();
	     stage.close();
	     System.out.println(userid);
	     try 
	     {
	    	       Parent scene2parent=FXMLLoader.load(getClass().getResource("addCategory.fxml"));
	       	       stage.setUserData(userid);
	       	       Scene scene = new Scene(scene2parent);
	               stage.setScene(scene);
	       	       stage.show();
	     } 
	     catch (IOException e)
	     {
	    	    System.err.println(String.format("Error: %s", e.getMessage()));
	     }
	     
	     }
}
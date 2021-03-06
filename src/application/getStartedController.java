package application;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class getStartedController implements Initializable{
	@FXML
	private Button getStarted;
	
	 private static final String IDLE_BUTTON_STYLE = "-fx-background-color:  #ED254E; -fx-background-radius: 25px; -fx-opacity: 0.7;";
	    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-background-radius: 25px; -fx-opacity: 0.7;";
    @FXML
    public void start (ActionEvent event ) throws IOException{
        Parent scene2parent=FXMLLoader.load(getClass().getResource("logOrReg.fxml"));
        Scene scene2=new Scene(scene2parent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
        
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 getStarted.setStyle(IDLE_BUTTON_STYLE);
	       getStarted.setOnMouseEntered(e -> getStarted.setStyle(HOVERED_BUTTON_STYLE));
	       getStarted.setOnMouseExited(e -> getStarted.setStyle(IDLE_BUTTON_STYLE));
	      
		
	}
  
}

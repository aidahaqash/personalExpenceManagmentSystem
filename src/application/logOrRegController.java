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

public class logOrRegController implements Initializable{
	@FXML
    private Button login;

    @FXML
    private Button signup;
	
	 private static final String IDLE_BUTTON_STYLE = "-fx-background-color:  #ED254E; -fx-background-radius: 25px; -fx-opacity: 0.7;";
	    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-background-radius: 25px; -fx-opacity: 0.7;";
    @FXML
    public void log (ActionEvent event ) throws IOException{
        Parent scene3parent=FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene3=new Scene(scene3parent);
        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
        
      
        
    }
@FXML
public void sign (ActionEvent event ) throws IOException{
    Parent scene3parent=FXMLLoader.load(getClass().getResource("signUp.fxml"));
    Scene scene3=new Scene(scene3parent);
    Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(scene3);
    window.show();
    
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 login.setStyle(IDLE_BUTTON_STYLE);
	       login.setOnMouseEntered(e -> login.setStyle(HOVERED_BUTTON_STYLE));
	       login.setOnMouseExited(e -> login.setStyle(IDLE_BUTTON_STYLE));
	       signup.setStyle(IDLE_BUTTON_STYLE);
	       signup.setOnMouseEntered(e -> signup.setStyle(HOVERED_BUTTON_STYLE));
	       signup.setOnMouseExited(e -> signup.setStyle(IDLE_BUTTON_STYLE));
	      
		
	}
  
}

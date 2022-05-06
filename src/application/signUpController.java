package application;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class signUpController   implements Initializable {
	 @FXML
	    private Button back;

	    @FXML
	    private Label conL;

	    @FXML
	    private PasswordField confirmP;

	    @FXML
	    private Label emL;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField fullName;

	    @FXML
	    private Label namL;

	    @FXML
	    private Label pasL;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Button signUp;
	    private static final String IDLE_BUTTON_STYLE = "-fx-background-color:  #ED254E; -fx-background-radius: 25px; -fx-opacity: 0.7;";
	    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-background-radius: 25px; -fx-opacity: 0.7;";
	    
	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("logOrReg.fxml"));
		        Scene scene2=new Scene(scene2parent);
		        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		        window.setScene(scene2);
		        window.show();

	    }
	    @FXML
    public void getData(ActionEvent actionEvent) throws IOException {
    	
    	  namL.setText(null);
    		 emL.setText(null);
    		  pasL.setText(null);
    		 conL.setText(null);
    		 if(testInputs()==true) {
    			  Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
    		        Scene scene2=new Scene(scene2parent);
    		        Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    		        window.setScene(scene2);
    		        window.show();	 
    		 };
    		 
    		 
    
       
    }
    public boolean testInputs(){
    	int f=0;

 

	
        // Confirm mandatory fields are filled out
        if (fullName.getText().isEmpty()) {
           namL.setText("PLEASE ENTER YOUR FULLNAME");
           f=1;
        		   }
       
        if (email.getText().isEmpty()) {
        	emL.setText("PLEASE ENTER YOUR EMAIL");
        	f=1;
        }
        if (password.getText().isEmpty()) {
        	pasL.setText("PLEASE ENTER PASSWORD");
        	f=1;
        }
        if (confirmP.getText().isEmpty()) {
        	conL.setText("PLEASE CONFIRM PASSWORD");
        	f=1;
        }
        if(!(password.getText().isEmpty())&& !(confirmP.getText().trim().isEmpty())) {
        	if (!(password.getText().equals(confirmP.getText()))) { 
        	conL.setText("PASSWORDS DIDN'T MATCH");
        	f=1;
        	confirmP.setText(null);
        	password.setText(null);
        }}
        
        if(!(password.getText().isEmpty())) {
        if(password.getText().length()<8) {
        
        	pasL.setText("PASSWORD MUST BE 8 OR MORE CHARACTERS");
        	
        	f=1;
        	confirmP.setText(null);
        	password.setText(null);
        	}
        
        }
        if(!(email.getText().isEmpty())) {
            if(valEmail(email.getText())==false) {
            
            	emL.setText("EMAIL DOES NOT EXIST");
            	
            	f=1;
            	email.setText(null);
            	
            	}
            
            }
   
    
    if(f==0) {
    	
    writeToDatabase(fullName.getText(), email.getText(), password.getText());
    return true;


    }
    return false;
    }
    
    public static boolean valEmail(String input) {
    	String emailRegex= "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    	Pattern emailPat=Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
    	Matcher matcher=emailPat.matcher(input);
    	return matcher.find();
    } 

    
    public static void writeToDatabase(String userName, String userEmail, String userPassword) {

        String url = "jdbc:postgresql://localhost:5432/Expensify";
        String user1 = "postgres";
    
        
        String password = "123456";

        String name = userName;
        String email= userEmail;
        String pass = userPassword;
             
        // query
        String query = "INSERT INTO sign(name, email, password) VALUES(?, ?,?)";
       
        try (Connection con = DriverManager.getConnection(url, user1, password);
             PreparedStatement pst = con.prepareStatement(query)) {
        	
     
       
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
           
            pst.executeUpdate();
            System.out.println("Sucessfully created.");
            
            
    
            
            

        }

        catch (SQLException ex) {

            Logger lgr = Logger.getLogger(signUpController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }
    
   
    @Override
   	public void initialize(URL arg0, ResourceBundle arg1) {
       	back.setStyle(IDLE_BUTTON_STYLE);
       	back.setOnMouseEntered(e ->back.setStyle(HOVERED_BUTTON_STYLE));
       	back.setOnMouseExited(e -> back.setStyle(IDLE_BUTTON_STYLE));
       	signUp.setStyle(IDLE_BUTTON_STYLE);
       	signUp.setOnMouseEntered(e ->signUp.setStyle(HOVERED_BUTTON_STYLE));
       	signUp.setOnMouseExited(e ->signUp.setStyle(IDLE_BUTTON_STYLE));}

}

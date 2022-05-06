package application;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.stage.Stage;


public class loginController  implements Initializable {

	  @FXML
	    private Button back;

	    @FXML
	    private Label emLa;

	    @FXML
	    private TextField email;

	    @FXML
	    private Button login;

	    @FXML
	    private Label pasLa;
	 

	    @FXML
	    private PasswordField password;
	    
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
    public void login(ActionEvent actionEvent) throws IOException {
    	
    
    		 emLa.setText(null);
    		  pasLa.setText(null);
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

        if (email.getText().isEmpty()) {
        	emLa.setText("PLEASE ENTER YOUR EMAIL");
        	f=1;
        }
        if (password.getText().isEmpty()) {
        	pasLa.setText("PLEASE ENTER YOUR PASSWORD");
        	f=1;
        }
        if(!(email.getText().isEmpty())) {
        	if(emailExist(email.getText())==false) {
        		emLa.setText("THIS EMAIL DOESN'T HAVE AN ACCOUNT");
            	f=1;
        	}
        }
        if(emailExist(email.getText())==true) {
        if(!(password.getText().isEmpty())) {
        	if(passCheck(email.getText(),password.getText())==false) {
        		pasLa.setText("WRONG PASSWORD");
        		f=1;
        	}
        }}
        if(f==0) {
        	
            return true;}
        
return false;
    }
    public boolean emailExist(String em){
    	  String url = "jdbc:postgresql://localhost:5432/Expensify";
          String user1 = "postgres";
          String password = "123456";
          boolean f=true;
         

         try {
        	 Connection con=DriverManager.getConnection(url,user1,password);
        	 Statement stmt=con.createStatement();
        	 String query = "SELECT * FROM sign WHERE email ='" +em+"'";
        	 ResultSet rs =stmt.executeQuery(query);
        	 
        	 if(rs.next()) {
        		 f=true;
        
         	
         	 }
         	 else {
         		 f=false;
        
         	 } 
         }
          catch(Exception e){
        	System.out.println("ERROR: "+e.getMessage())  ;
          }
         return f;

    }
    public boolean passCheck(String email,String pass){
    	
    	String url = "jdbc:postgresql://localhost:5432/Expensify";
        String user1 = "postgres";
        String password = "123456";
        boolean f=true;
       

       try {
      	 Connection con=DriverManager.getConnection(url,user1,password);
      	 Statement stmt=con.createStatement();
      	String query = "Select * from sign Where email='" + email + "' and password='"+pass+"'";
      	 ResultSet rs =stmt.executeQuery(query);
      	 
      	 if(rs.next()) {
      		 f=true;
      		 
       	
       	 }
       	 else {
       		 f=false;
       		
       	 } 
       }
        catch(Exception e){
      	System.out.println("ERROR: "+e.getMessage())  ;
        }
       return f;
    }

  
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	back.setStyle(IDLE_BUTTON_STYLE);
    	back.setOnMouseEntered(e ->back.setStyle(HOVERED_BUTTON_STYLE));
    	back.setOnMouseExited(e -> back.setStyle(IDLE_BUTTON_STYLE));
    	login.setStyle(IDLE_BUTTON_STYLE);
    	login.setOnMouseEntered(e ->login.setStyle(HOVERED_BUTTON_STYLE));
    	login.setOnMouseExited(e ->login.setStyle(IDLE_BUTTON_STYLE));
       	

}
}

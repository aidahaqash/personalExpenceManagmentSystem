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
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class addIncomeCategoryController {

	@FXML
	  private Button addcat;
	@FXML
	 private Label namew;
	@FXML
	 private TextField catnam;
	public int userid;
	@FXML
	public void addcate(ActionEvent actionEvent) throws IOException {
		   Node node = (Node) actionEvent.getSource();
	     	 Stage stage = (Stage) node.getScene().getWindow();
	     	 int catId = (int) stage.getUserData();
		  namew.setText(null);
		  testInput(catId);
		  Parent scene2parent=FXMLLoader.load(getClass().getResource("incomes.fxml"));
	      Scene scene2=new Scene(scene2parent);
	      Stage window =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
	      window.setScene(scene2);
	      window.show();

  }
	
    public void testInput(int c){
    	int f=0;
 

	
        // Confirm mandatory fields are filled out
        if (catnam.getText().trim().isEmpty()) {
        	namew.setText("PLEASE ENTER CATEGORY NAME");
           f=1;
        		   }
        if(f==0) {
            writecat(c);
            
            }
    }
    
  

        
	
    @FXML
    public void writecat (int d) {
    	
    	   String url = "jdbc:postgresql://localhost:5432/Expensify";
           String user1 = "postgres";
       
           
           String password = "123456";

           String name = catnam.getText();
      
     	 System.out.print(d);
     int usersid=d;
     int incid=1;
                
           // query
           String query = "INSERT INTO incomescategories (userid,incomeid,incomecategoryname) VALUES(?,?,?)";
          
           try (Connection con = DriverManager.getConnection(url, user1, password);
                PreparedStatement pst = con.prepareStatement(query)) {
           	
        
        	   pst.setInt(1,usersid);
               pst.setInt(2, incid);
               pst.setString(3, name);
             
            
               pst.executeUpdate();
               namew.setText("Sucessfully created.");
            
          
               

           } catch (SQLException ex) {

               Logger lgr = Logger.getLogger(signUpController.class.getName());
               lgr.log(Level.SEVERE, ex.getMessage(), ex);
           }
    	
    	
    	
    }

       
    

    	
    
	
	
}

package application;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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


public class addCategoryController
{
	public  int catId ;
	public int userId;


	    @FXML
	    private TextField Category_Name_text;

	    @FXML
	    private TextField Budget_text;
	    
	    @FXML
	    private TextField COLOR_text;
	    
	    @FXML
	    private TextField LOGO_text ;
	    
	    
	   
 @FXML
 public void addCAT (ActionEvent event ) throws IOException
 {
	 
	  Node node = (Node) event.getSource();
	  Stage stage = (Stage) node.getScene().getWindow();
	  userId = (int) stage.getUserData();
	  //__________________________________________________________________________
	  String url = "jdbc:postgresql://localhost:5432/Expensify";
	     String user1 = "postgres";
	     String password = "123456";
	     
      String sql1 ="select MAX(categoryid) from expensescategories " ;

	     try (Connection con = DriverManager.getConnection(url, user1, password);
	    		 PreparedStatement pst = con.prepareStatement(sql1))	 {
	    	 ResultSet rs1 = pst.executeQuery();
	    	 if(rs1.next())
	    	 {
	    		 catId = rs1.getInt(1) +1;
	    	 }
	    	 
	    	 con.close();
	     }
	     catch (SQLException ex) {

	         Logger lgr = Logger.getLogger(signUpController.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
	     }
	  
	  //________________________________________________________________
	  
	  if(Category_Name_text.getText().trim().isEmpty() || COLOR_text.getText().trim().isEmpty()|| LOGO_text.getText().trim().isEmpty() || Budget_text.getText().trim().isEmpty())
	  {
		  JOptionPane.showMessageDialog(null, "Please make sure that all fields are filled in\n");
	  }
	  else
	  {
     String query = "INSERT INTO expensescategories(categoryID, userID, categoryName , categoryColor,categoryLogo,categoryBudget) VALUES(?,?,?,?,?,?)";
    
     try (Connection con = DriverManager.getConnection(url, user1, password);
          PreparedStatement pst = con.prepareStatement(query)) 
     {
    
         pst.setInt(1, catId);
         pst.setInt(2, userId);
         pst.setString(3,Category_Name_text.getText());
         pst.setString(4, COLOR_text.getText());
         pst.setString(5, LOGO_text.getText());
         pst.setInt(6,Integer.parseInt(Budget_text.getText()));

        
         pst.executeUpdate();
         

     } catch (SQLException ex) {

		  JOptionPane.showMessageDialog(null, "Please check your data");

        // Logger lgr = Logger.getLogger(signUpController.class.getName());
         //lgr.log(Level.SEVERE, ex.getMessage(), ex);
     }
	 
	 
     Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
    

	  }
 }
 	
}
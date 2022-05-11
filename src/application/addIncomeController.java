package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class addIncomeController implements Initializable
 {
	@FXML
	private Label valuelab;
	
	int userid;
	
	@FXML
	  private ComboBox<Product> sources;
	
	@FXML
	 private Label value;
	@FXML
	 private TextField incval;
	

	@FXML
	  private Button addincome;
	
	 public void addinc1(ActionEvent event ) throws IOException{
		  String url = "jdbc:postgresql://localhost:5432/Expensify";
          String user1 = "postgres";
      
          
          String password = "123456";
         // System.out.println("fdlsdf   "+sources.getValue().getCode());
     int incomecategoryid=sources.getValue().getCode();
     
    int usersid=loginController.id;
   int incomevalue=Integer.parseInt(incval.getText());
               
          // query
          String query = "INSERT INTO public.\"incomes \" ( userid, incomecategoryid, incomevalue)VALUES ( ?, ?, ?);";
         
          try (Connection con = DriverManager.getConnection(url, user1, password);
               PreparedStatement pst = con.prepareStatement(query)) {
          	
       
       	   pst.setInt(1,usersid);
              pst.setInt(2, incomecategoryid);
              pst.setInt(3, incomevalue);
            
           
              pst.executeUpdate();
             valuelab.setText("DONE");
              System.out.println("Sucessfully created.");
              Parent scene2parent=FXMLLoader.load(getClass().getResource("incomes.fxml"));
    	      Scene scene2=new Scene(scene2parent);
    	      Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	      window.setScene(scene2);
    	      window.show();
              

          } catch (SQLException ex) {

              Logger lgr = Logger.getLogger(signUpController.class.getName());
              lgr.log(Level.SEVERE, ex.getMessage(), ex);
          }
   	

   
		 
		 
	 }
	 
	 
	 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 Platform.runLater(() -> {

			 List<Product> list = new ArrayList();
			 
				//	 Stage stage =(Stage) sources.getScene().getWindow();

				     	   
				     	 //int catId = (int) stage.getUserData();
					 
				
					   String url = "jdbc:postgresql://localhost:5432/Expensify";
			           String user1 = "postgres";
			       
			           
			           String password = "123456";

			     
			  
			  //   int usersid=13;
			     int incid=1;
			                
			           // query
			           String query = "SELECT incomecategoryid, incomecategoryname FROM public.incomescategories where  userid=?";
			          
			          
			           try (Connection con = DriverManager.getConnection(url, user1, password);
			                PreparedStatement pst = con.prepareStatement(query)) {
			        	  
			        
			        	   pst.setInt(1,userid);
			        	   
			           
			             
			            
			        	   ResultSet rs= pst.executeQuery();
		            	   Product pd;
			        	   while(rs.next()) {
			            	   pd=new Product();
			            	   pd.setCode(rs.getInt("incomecategoryid"));
			            	   pd.setName(rs.getString("incomecategoryname"));
			            	   list.add(pd);
			            	   
			               }
			           
			             
			               

			           } catch (SQLException ex) {

			               Logger lgr = Logger.getLogger(signUpController.class.getName());
			               lgr.log(Level.SEVERE, ex.getMessage(), ex);
			           }

			          
					 
					
				       // ObservableList obList = FXCollections.observableList(list);
			           ObservableList<Product> data =
			                   FXCollections.observableArrayList(list);
sources.setConverter(new ProductConverter());
				        sources.getItems().clear();
				    //    sources.setItems(data);
				        sources.getItems().addAll(list);


			    });

	
		
	}
	 public void setuserid(int userid) {
		 this.userid=userid;
		 
		 
	 }
	

		    
}

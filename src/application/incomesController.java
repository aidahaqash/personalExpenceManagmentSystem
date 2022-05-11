package application;


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

import javax.swing.*;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class incomesController implements Initializable{


    @FXML
    private Button addc;

    @FXML
    private Button addi;

    @FXML
    private Button dashboard;

    @FXML
    private Button expenses;

    @FXML
    private Button incomes;

    @FXML
    private PieChart pie;

    @FXML
    private Button reports;

 
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color:   #548939;  -fx-opacity: 0.7;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-opacity: 0.7;";
    private static final String IDLE_BUTTON_STYLE1 = "-fx-background-color:   #ED254E;  -fx-opacity: 0.7;";

   

    @FXML
    void dash(ActionEvent event) throws IOException {
    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
         Scene scene2=new Scene(scene2parent);
         Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene2);
         window.show();
         
    }

    @FXML
    void exp(ActionEvent event) throws IOException {
    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("expenses.fxml"));
         Scene scene2=new Scene(scene2parent);
         Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene2);
         window.show();
         
    }


    @FXML
    void inc(ActionEvent event) throws IOException {
    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("incomes.fxml"));
         Scene scene2=new Scene(scene2parent);
         Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene2);
         window.show();
         
    }



    @FXML
    void rep(ActionEvent event) throws IOException {
    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("reports.fxml"));
         Scene scene2=new Scene(scene2parent);
         Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(scene2);
         window.show();
         
    }




    int id =loginController.id ;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    dashboard.setStyle(IDLE_BUTTON_STYLE);
			dashboard.setOnMouseEntered(e ->	dashboard.setStyle(HOVERED_BUTTON_STYLE));
			dashboard.setOnMouseExited(e -> 	dashboard.setStyle(IDLE_BUTTON_STYLE));
	    	expenses.setStyle(IDLE_BUTTON_STYLE);
	    	expenses.setOnMouseEntered(e ->expenses.setStyle(HOVERED_BUTTON_STYLE));
	    	expenses.setOnMouseExited(e ->expenses.setStyle(IDLE_BUTTON_STYLE));
	    	
	    	incomes.setStyle(IDLE_BUTTON_STYLE);
	    	incomes.setOnMouseEntered(e ->incomes.setStyle(HOVERED_BUTTON_STYLE));
	    	incomes.setOnMouseExited(e ->incomes.setStyle(IDLE_BUTTON_STYLE));
	    	
	    	reports.setStyle(IDLE_BUTTON_STYLE);
	    	reports.setOnMouseEntered(e ->reports.setStyle(HOVERED_BUTTON_STYLE));
	    	reports.setOnMouseExited(e ->reports.setStyle(IDLE_BUTTON_STYLE));
		List<PieChart.Data>  list=new ArrayList<>();
		
		
		//getting form database with setting user id
		  String url = "jdbc:postgresql://localhost:5432/Expensify";
          String user1 = "postgres";
      
          
          String password = "123456";

          String query = "SELECT \n"
          		+ "(select incomecategoryname from  public.incomescategories cat where cat.incomecategoryid=inc.incomecategoryid) as incomeCat,\n"
          		+ "sum (incomevalue) as total\n"
          		+ "FROM public.\"incomes \" as inc\n"
          		+ "where inc.userid=?\n"
          		+ "group by incomecategoryid";
         // System.out.println("im here 6556"+this.userId);
         
          try (Connection con = DriverManager.getConnection(url, user1, password);
               PreparedStatement pst = con.prepareStatement(query)) {
       	  
       
       	   pst.setInt(1,id);
		
		//after executing the query while rs.next
		
		//filling the list 
		ResultSet rs= pst.executeQuery();
		PieChart.Data pd;
  	   while(rs.next()) {
      	   pd=new PieChart.Data(rs.getString("incomeCat"),rs.getInt("total"));
      	   list.add(pd);
      	  
         }
     
		
		
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						list
    		//	new PieChart.Data("FreeLancing",22)
    			);
    	pie.setData(pieChartData);
    	pie.setStartAngle(90);
	}
          catch (SQLException ex) {

              Logger lgr = Logger.getLogger(signUpController.class.getName());
              lgr.log(Level.SEVERE, ex.getMessage(), ex);
          }
	}
	 @FXML
	    public void addca (ActionEvent event ) throws IOException{
		 Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
		     stage.close();
	        Parent scene3parent=FXMLLoader.load(getClass().getResource("addIncomeCategory.fxml"));
	        stage.setUserData(id);
	        Scene scene3=new Scene(scene3parent);
	        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(scene3);
	        window.show();
	        
	      
	        
	    }
	 
	 @FXML
	 public void addin(ActionEvent event ) throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("addIncome.fxml"));
	     //   Parent root = loader.load(); 
	   
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
		     stage.close();
		    Parent root= loader.load(); 
		    addIncomeController controller = loader.getController();
		  //  System.out.println("im here name "+id);
            controller.setuserid(id);
		 
		    stage.setUserData(id);
		    Scene scene5=new Scene(root);
		    Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		    window.setScene(scene5);
		    window.show();
		 
		    
	 }
	 
	 
		    
	
	
}

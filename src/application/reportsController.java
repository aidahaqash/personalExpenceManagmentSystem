package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class reportsController implements Initializable{

	public int incomes1,expense1,incomes2;
	public int profets1,losses1;
	public int userId;
	public String catt;
	 public int decc;
	 public PieChart.Data pd;
 	 public List<PieChart.Data>  list=new ArrayList<>();
 	public PieChart.Data pdd;
	 public List<PieChart.Data>  list1=new ArrayList<>();
 	public String s;
 	public int i;
 	public String iv[];
 	public String iv1[];
 	public int iv2[];
 	private static final String IDLE_BUTTON_STYLE = "-fx-background-color:   #548939;  -fx-opacity: 0.7;";
 	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-opacity: 0.7;";
 	private static final String IDLE_BUTTON_STYLE1 = "-fx-background-color:   #ED254E;  -fx-opacity: 0.7;";

    @FXML
    private DatePicker dPicker;

    @FXML
    private Button dashboard;

    @FXML
    private PieChart expensePie;

    @FXML
    private Button expenses;

    @FXML
    private PieChart incomePie;

    @FXML
    private Button incomes;

    @FXML
    private Label llosses;

    @FXML
    private Label lprofets;

    @FXML
    private Button reports;

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

public int userid;
   
    @FXML
    public void search(ActionEvent event) throws IOException {
   
    	userId=userid;
    	LocalDate mydate=dPicker.getValue();
    	int d=mydate.getDayOfMonth();
    	int m=mydate.getMonthValue();
    	System.out.println(mydate.toString());
    	
    	 Node node = (Node) event.getSource();
   	  Stage stage = (Stage) node.getScene().getWindow();
   	
   	  //userId = (int) stage.getUserData();
   	  //__________________________________________________________________________
   	  String url = "jdbc:postgresql://localhost:5432/Expensify";
   	     String user1 = "postgres";
   	     String password = "123456";
    	
   	  
   	  String sql1 ="select * from expenses" ;
   	

	     try (Connection con = DriverManager.getConnection(url, user1, password);
	    		 PreparedStatement pst = con.prepareStatement(sql1))	 {
	    	 ResultSet rs1 = pst.executeQuery();
	    	int vsum=0;
	    	int sum=0;
	    	

	    	int incomeess=0;
	    	
	    	while(rs1.next()) {
	    		if(userId==Integer.parseInt(rs1.getString(2))) {
	    			String value=rs1.getString(5);
		    		 vsum=Integer.parseInt(value);
		    		 sum+=vsum;
	    		}
	    		
	    		
	    	 }
	    	expense1=sum;
	    	
		//	profets=incomeess-sum;
	    	
	    	
	    //	 System.out.println(profets);
	    //	 System.out.println(losses);
	   // 	 llosses.setText(String.valueOf(losses));
	   // 	 lprofets.setText(String.valueOf(profets));
	    	 con.close();
	     }
	     catch (SQLException ex) {

	         Logger lgr = Logger.getLogger(signUpController.class.getName());
	         lgr.log(Level.SEVERE, ex.getMessage(), ex);
	     }
	     
	     String sql2 ="select * from incomes where userid="+userId ;
	    	
	  	   try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql2))	 {
		    	 ResultSet rs2 = pst.executeQuery();
		    	
		    	int incsum=0;
		    	
		    	while(rs2.next()) {
		    		
		    			
			    		 incsum+=rs2.getInt(4);
		    		
		    		
		    		
		    	 }
		    	
		    
		    	incomes1=incsum;
		    	// System.out.println(incsum);
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
	  	   
	  	   
	  	   /////////////////////////////
	  	   
	  	 String sql3 ="select * from expensescategories where userid="+userId ;
	    	
	  	   try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql3))	 {
		    	 ResultSet rs3 = pst.executeQuery();
		    	int vvsum=0;
		    	int incsum=0;
		    	
		    	while(rs3.next()) {
		    		
		    			
			    		 incsum+=rs3.getInt(7);
		    		
		    		
		    		
		    	 }
		    	
		    
		    	incomes2=incsum;
		    
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
	  	   
	  	   
	  	   
	     profets1=incomes1-expense1;
	     losses1=expense1;
	     System.out.println(profets1);
	     System.out.println(losses1);
	     llosses.setText(String.valueOf(losses1)+"$");
		 lprofets.setText(String.valueOf(incomes2)+"$");
	     
		 String sql4 ="select * from expensescategories where userid="+userId ;
	    	
	  	   try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql4))	 {
		    	 ResultSet rs4 = pst.executeQuery();
		    	String cat="";
		    	int dec=0;
		    	
		    	 while(rs4.next()) {
		    	
		    		cat=rs4.getString(3);
		    			dec=rs4.getInt(6)-rs4.getInt(7);
		    			catt="";
				    	decc=0;
		    			catt=cat;
				    	decc=dec;
				    	System.out.print(catt);
				    	System.out.print(decc);
				 
		    		 pd=new PieChart.Data(catt,decc);
		        	   list.add(pd);
				 		    		
		    	 }
		    	 
		    	 ObservableList<PieChart.Data> pieChartData = 
		 				FXCollections.observableArrayList(list);
		    	 expensePie.setData(pieChartData);
		    	 expensePie.setStartAngle(90);
		   	
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
	  	   
	  	   /////////////
	  	   
	  	 String sql5 ="select * from incomescategories where userid="+userId ;
	    	
	  	   try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql5))	 {
		    	 ResultSet rs5 = pst.executeQuery();
		    	 String iv1 ="" ;
		    	
		    	 while(rs5.next()) {
		    		 
		    		 iv1 += rs5.getString(4) + ',';
		    		
		    		
		    	
		    			
		    		
				 		    		
		    	 }
		    	 
		    	 iv= iv1.split(",");
		    	 System.out.println("\n");
		    	// for(int i=0;i<iv.length;i++) {
		    //	 System.out.println(iv[i]);
		    //	 }
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
	  	   
	  	 String sql6="select * from test where userid="+userId ;
	    	
	  	   try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql6))	 {
		    	 ResultSet rs6 = pst.executeQuery();
		    	 String iv11 ="" ;
		    	
		    	 while(rs6.next()) {
		    		 
		    		 iv11 += rs6.getString(4) + ',';
		    		
		    		
		    	
		    			
		    		
				 		    		
		    	 }
		    	 
		    	 iv1= iv11.split(",");
		    	 System.out.println("\n");
		    	 
		    	 int size=iv1.length;
		    	iv2=new int[size];
		    	for(int i=0; i<size; i++) {
		            iv2[i] = Integer.parseInt(iv1[i]);
		            System.out.println(iv2[i]);
		         }
		    	
		    	 for(int i=0;i<iv.length;i++) {
		    		 System.out.println(iv[i]);
		    	 System.out.println(iv1[i]);
		    	
		    	 
		    	 
		    	 pdd=new PieChart.Data(iv[i],iv2[i]);
	        	   list1.add(pdd);
		    	 
		    	 }
		    	 
		    	 ObservableList<PieChart.Data> pieChartData = 
			 				FXCollections.observableArrayList(list1);
			    	 incomePie.setData(pieChartData);
			    	 incomePie.setStartAngle(90); 
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
 
    }
    
    
   
  
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
userid=loginController.id;
    	
    	
	}
	
}

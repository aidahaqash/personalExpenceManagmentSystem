package application;

import javafx.fxml.Initializable;
import java.sql.Statement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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



public class addExpenseController implements Initializable
{

	@FXML
    private TextField Ex_Name;

    @FXML
    private TextField ExpenseValue;

    @FXML
    private Label expB;

    @FXML
    private ImageView expL;

    @FXML
    private Label expLa;

    @FXML
    private TextField up_budget;
    @FXML
    private Button back;
    
@FXML
private Label err;
public float remain ;
public float newremain;
	public int catid;
	public int userId;
	public String cat_id;
	public String Cat_name;
	public String Cat_budget;
	public float Expense_value =0;
	public int exid=0;
	private Date d;
	
	 @FXML
	    void back(ActionEvent event) throws IOException {
	    	  Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
		        Scene scene2=new Scene(scene2parent);
		        Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		        window.setScene(scene2);
		        window.show();

	    }
	 public void setdata (ActionEvent event ) throws IOException
	 {
	
		  String url = "jdbc:postgresql://localhost:5432/Expensify";
		     String user1 = "postgres";
		     String password = "123456";
		     
	      String sql1 ="select * from expenses where userid="+userId+" and expensecategoryid ="+ cat_id ;
	      

		     try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con.prepareStatement(sql1))	 {
		    	 ResultSet rs1 = pst.executeQuery();
		    	 Expense_value =0;
		    	 while(rs1.next())
		    	 {
		    		 Expense_value += rs1.getInt(5);
		    	 }
		    	 
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
		  
		     if( (Expense_value +Float.parseFloat(ExpenseValue.getText())) > Float.parseFloat(Cat_budget))
		     {
		    	 err.setText("All Expenses in this category equal :"+ (Expense_value +Float.parseFloat(ExpenseValue.getText())) + "so grate than Category Budget :"+Cat_budget +"\n Please Enter less number :(");
		    	 
		     }
		     else
		     {
		      newremain=remain-Float.parseFloat(ExpenseValue.getText());
		      System.out.println(newremain);
		      System.out.println(remain);
		      System.out.println(ExpenseValue.getText());
		     String Co = "update expensescategories set remainbudget = "+newremain+ " where categoryid =" +Integer.parseInt(cat_id)  ;
		     try (Connection con1 = DriverManager.getConnection(url, user1, password);
		             PreparedStatement pst = con1.prepareStatement(Co)) 
		        {
		       
		            pst.executeUpdate();
		            

		        } catch (SQLException ex) {

		   	
		        
		        }
		     Expense_value+=Float.parseFloat(ExpenseValue.getText()); 
		   
	      String sql11 ="select MAX(expenseid) from expenses" ;

		     try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst1 = con.prepareStatement(sql11))	 {
		    	 ResultSet rs11 = pst1.executeQuery();
		    	 if(rs11.next())
		    	 {
		    		 exid = rs11.getInt(1)+1;
		    	 }
		    	 
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }
		        
		    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	              LocalDateTime now = LocalDateTime.now();  
	              String DA []= now.toString().split("-");
	              String dayy[] = DA[2].split("T");
	              String Now_Date =DA[0]+"-"+DA[1]+"-"+dayy[0];
	              System.out.print(Now_Date);
		                     //Database Connection
		       
		     String query = "INSERT INTO expenses(expenseid, userid, expensecategoryid , expensename,expensevalue,expensedate) VALUES(?,?,?,?,?,?)";

		     try (Connection con = DriverManager.getConnection(url, user1, password);
		             PreparedStatement pst = con.prepareStatement(query)) 
		        {
		       
		            pst.setInt(1, exid);
		            pst.setInt(2, userId);
		            pst.setInt(3,Integer.parseInt(cat_id));
		            pst.setString(4, Ex_Name.getText());
		            pst.setInt(5,Integer.parseInt(ExpenseValue.getText()));
		           
				Date D = new Date(Integer.parseInt(DA[0]),Integer.parseInt(DA[1]),Integer.parseInt(dayy[0]));
		            pst.setDate(6,D);

		           
		            pst.executeUpdate();
		            

		        } catch (SQLException ex) {

		   		  

		        }
		     //________________________open home page___________________________________________
		     
		     Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
		     Scene scene2=new Scene(scene2parent);
		     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		     window.setScene(scene2);
		     window.show();
		     
		     }
	 }
	 
	 
	 public void update (ActionEvent event ) throws IOException
	 {
		
		  String url = "jdbc:postgresql://localhost:5432/Expensify";
		     String user1 = "postgres";
		     String password = "123456";
		     int rem=0;
		  String sql11 ="select * from expensescategories where categoryid ="+cat_id ;
		     try (Connection con = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst1 = con.prepareStatement(sql11))	 {
		    	 ResultSet rs11 = pst1.executeQuery();
		    	 if(rs11.next())
		    	 {
		    		rem = rs11.getInt(7); 
		    	 }
		    	 
		    	 con.close();
		     }
		     catch (SQLException ex) {

		         Logger lgr = Logger.getLogger(signUpController.class.getName());
		         lgr.log(Level.SEVERE, ex.getMessage(), ex);
		     }		  
			  int V = Integer.parseInt(Cat_budget) - rem;

		if(Integer.parseInt( up_budget.getText())-V<0)
		{
			 err.setText("New value of Budget is smaller than expenses :(");
	   		  
		}
		else
		{
			
	        String Co = "update expensescategories set categorybudget = '"+up_budget.getText()+ "' where categoryid =" +Integer.parseInt(cat_id)  ;
	        
	        try (Connection con = DriverManager.getConnection(url, user1, password);
	             PreparedStatement pst = con.prepareStatement(Co)) 
	        {
	       
	            pst.executeUpdate();
	            

	        } catch (SQLException ex) {

	   		  

	        }
	        Parent scene2parent=FXMLLoader.load(getClass().getResource("home.fxml"));
		     Scene scene2=new Scene(scene2parent);
		     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		     window.setScene(scene2);
		     window.show();
		}
	 }

public void set() {
	
String url = "jdbc:postgresql://localhost:5432/Expensify";
	
    String user1 = "postgres";
    String password = "123456";

	try{
	Connection con=DriverManager.getConnection(url,user1,password);
	
 	Statement stmt=con.createStatement();
 	String query = "SELECT * FROM  expensescategories WHERE categoryid='"+catid+"'";

 	ResultSet rs =stmt.executeQuery(query);
 
 	if(rs.next()) {
 	cat_id=rs.getString(1);	
 	Cat_name=rs.getString(3);
 	userId=loginController.id;
 	Cat_budget=rs.getString(6);
 	Image image = new Image(rs.getString(5));
		expL.setImage(image);
		expLa.setText(rs.getString(3));
	
		expB.setText(rs.getString(7)+"$"+" left from "+rs.getString(6)+"$");
		remain=rs.getFloat(7);

 	}
	 
con.close();
	}
	catch(Exception e) {
		System.out.println("ERROR: "+e.getMessage())  ;
	}
	
	
	
}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		catid=homeController.catid;
		set();
		
	}

}
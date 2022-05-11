package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;


public class homeController implements Initializable 
{     public int userid;
public static int catid;


@FXML
private Label welcome;
@FXML
private Button add;

@FXML
private Button btn1;

@FXML
private Button btn2;

@FXML
private Button btn3;

@FXML
private Button btn4;

@FXML
private Button btn5;

@FXML
private Button btn6;

@FXML
private Button dashboard;

@FXML
private Button expenses;

@FXML
private Button incomes;

@FXML
private Label lb1;

@FXML
private Label lb2;

@FXML
private Label lb3;

@FXML
private Label lb4;

@FXML
private Label lb5;

@FXML
private Label lb6;

@FXML
private ImageView logo1;

@FXML
private ImageView logo2;

@FXML
private ImageView logo3;

@FXML
private ImageView logo4;

@FXML
private ImageView logo5;

@FXML
private ImageView logo6;

@FXML
private Button logout;

@FXML
public Button reports;
public Button[] btns =new Button[10];
public Label[] lbs =new Label[10];
public ImageView[] imgs =new ImageView[10];
public String Name[];// this array is store all categorys name
public String Cat_color[];// this array is store all categorys color
public String Cat_logo[];// this array is store all categorys logo
public String Cat_budget[];// this array is store all categorys budget
public String Cat_id[];// this array is store all categorys Id
public String Cat_remain[];

private static final String IDLE_BUTTON_STYLE = "-fx-background-color:   #548939;  -fx-opacity: 0.7;";
private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: pink; -fx-opacity: 0.7;";
private static final String IDLE_BUTTON_STYLE1 = "-fx-background-color:   #ED254E;  -fx-opacity: 0.7;";
@FXML
void btn1action(ActionEvent event) throws IOException {
this.catid=Integer.parseInt(Cat_id[0]);
Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
Scene scene2=new Scene(scene2parent);
Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
window.setScene(scene2);
window.show();
}

@FXML
void btn2action(ActionEvent event) throws IOException {
	this.catid=Integer.parseInt(Cat_id[1]);
	 Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
}

@FXML
void btn3action(ActionEvent event) throws IOException {
	this.catid=Integer.parseInt(Cat_id[2]);
	 Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
}

@FXML
void btn4action(ActionEvent event) throws IOException {
	this.catid=Integer.parseInt(Cat_id[3]);
	 Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
}

@FXML
void btn5action(ActionEvent event) throws IOException {
	this.catid=Integer.parseInt(Cat_id[4]);
	 Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
}

@FXML
void btn6action(ActionEvent event) throws IOException {
	this.catid=Integer.parseInt(Cat_id[5]);
	 Parent scene2parent=FXMLLoader.load(getClass().getResource("addExpense.fxml"));
     Scene scene2=new Scene(scene2parent);
     Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
     window.setScene(scene2);
     window.show();
}
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
void logout(ActionEvent event) throws IOException {
	userid=0;
	  Parent scene2parent=FXMLLoader.load(getClass().getResource("getStarted.fxml"));
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


@FXML
public void addCat(ActionEvent event ) throws IOException
{   
	
	Node node = (Node) event.getSource();
	Stage stage = (Stage) node.getScene().getWindow();
    stage.close();
     try 
     {
    	       Parent scene2parent=FXMLLoader.load(getClass().getResource("addCategory.fxml"));
       	       stage.setUserData(userid);
       	       Scene scene = new Scene(scene2parent);
               stage.setScene(scene);
       	       stage.show();
     } 
     catch (IOException e)
     {
    	    System.err.println(String.format("Error: %s", e.getMessage()));
     }
     
     }

	@FXML
    public void start1 (ActionEvent event ) throws IOException{
		  
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
	     stage.close();

	     try 
	     {     Parent scene2parent=FXMLLoader.load(getClass().getResource("addCategory.fxml"));
	       	       stage.setUserData(userid);
	       	       Scene scene = new Scene(scene2parent);
	               stage.setScene(scene);
	       	       stage.show();
	     } 
	     catch (IOException e)
	     {
	    	    System.err.println(String.format("Error: %s", e.getMessage()));
	     }
	     
	     }


public void welcome1() {
		String url = "jdbc:postgresql://localhost:5432/Expensify";
		
	    String user1 = "postgres";
	    String password = "123456";
	    int user=userid;
	    
	    welcome.setText("welcome aida");
		try{
		Connection con=DriverManager.getConnection(url,user1,password);
		
	 	Statement stmt=con.createStatement();
	 	String query = "SELECT name FROM  sign WHERE uid='"+user+"'";
	 	ResultSet rs =stmt.executeQuery(query);
	 	if(rs.next()) {
	 		welcome.setText("Welcome "+rs.getString(1));
	 	}

		}
		catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage())  ;
		}

		
	}
public void rem() {
	
	
	String url = "jdbc:postgresql://localhost:5432/Expensify";
	
    String user1 = "postgres";
    String password = "123456";
	 int remainbudget[] = new int [Cat_id.length];
	    for(int j=0;j<Cat_id.length;j++)
	    {
	   	 int sum =0;
	   	 String sql ="select * from expenses where userid ="+userid +"and expensecategoryid ="+Cat_id[j];

		     try (Connection con1 = DriverManager.getConnection(url, user1, password);
		    		 PreparedStatement pst = con1.prepareStatement(sql))	 {
		    	 
		    	 ResultSet rs1 = pst.executeQuery();
		    	 while(rs1.next())
		    	 {
		    		 sum+= rs1.getInt(5);
		    	 }
		    	 remainbudget[j] = Integer.parseInt(Cat_budget[j])-sum;
		     con1.close();
	    }
	    catch (SQLException ex) {

	   
	    }	
		    
	   	 
	    }
	   
	    //_________________________store remainbudget____________________________
	    
	    for(int i=0;i<remainbudget.length;i++)
	    {
	   	 
		        String Co = "update expensescategories set remainbudget = '"+remainbudget[i]+ "' where categoryid =" +Integer.parseInt(Cat_id[i])  ;
		        
		        try (Connection con1 = DriverManager.getConnection(url, user1, password);
		             PreparedStatement pst = con1.prepareStatement(Co)) 
		        {
		       
		            pst.executeUpdate();
		            

		        } catch (SQLException ex) {

		   	
		        
		        }
	    }
	
}

	public void set () {
		
		String url = "jdbc:postgresql://localhost:5432/Expensify";
	
    String user1 = "postgres";
    String password = "123456";
    int user=userid;
    String Name1 ="" ;
	 String Cat_color1 ="" ;
	 String Cat_logo1 ="" ;
	 String Cat_budget1 ="" ;
	 String Cat_id1 ="" ;
	 String Cat_remain1="";
	
	try{
	Connection con=DriverManager.getConnection(url,user1,password);
	
 	Statement stmt=con.createStatement();
 	String query = "SELECT * FROM  expensescategories WHERE userid='"+user+"'";

 	ResultSet rs =stmt.executeQuery(query);
 
 	while(rs.next()) {
 		
		 Name1 += rs.getString(3) + ',';
		 Cat_color1 += rs.getString(4) + ',';
		 Cat_logo1 += rs.getString(5) + ',';
			Cat_id1 += rs.getString(1) + ',';
	 		 Cat_budget1 += rs.getString(6) + ',';
		 Cat_remain1+= rs.getString(7) + ',';
 	}

 	 
	 Name = Name1.split(",");
	 Cat_color = Cat_color1.split(",");
	 Cat_logo = Cat_logo1.split(",");
	 Cat_id = Cat_id1.split(",");
 	 Cat_budget = Cat_budget1.split(",");
	 Cat_remain = Cat_remain1.split(",");
	
	 if(Cat_id.length!=0){
		 for(int i=0;i<Cat_id.length;i++)
	
   	 {
	    	 btns[i].setText("       "+Name[i]);

	  	
	  		btns[i].setStyle("-fx-background-color:"+Cat_color[i]);

	  		lbs[i].setText(Cat_remain[i]+"$"+" of "+Cat_budget[i]+"$");
	  		Image image = new Image(Cat_logo[i]);
	  		imgs[i].setImage(image);
	  		
   		
  
   		
   	
   	 }
	 }
con.close();
	}
	catch(Exception e) {
		System.out.println("ERROR: "+e.getMessage())  ;
	}
	
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btns[0]=btn1;
	    btns[1]=btn2;
	    btns[2]=btn3;
	    btns[3]=btn4;
	    btns[4]=btn5;
	    btns[5]=btn6;
	    lbs[0]=lb1;
	    lbs[1]=lb2;
	    lbs[2]=lb3;
	    lbs[3]=lb4;
	    lbs[4]=lb5;
	    lbs[5]=lb6;
	    imgs[0]=logo1;
	    imgs[1]=logo2;
	    imgs[2]=logo3;
	    imgs[3]=logo4;
	    imgs[4]=logo5;
	    imgs[5]=logo6;
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
    	
    	logout.setStyle(IDLE_BUTTON_STYLE1);
    	logout.setOnMouseEntered(e ->logout.setStyle(HOVERED_BUTTON_STYLE));
    	logout.setOnMouseExited(e ->logout.setStyle(IDLE_BUTTON_STYLE1));
    	add.setStyle(IDLE_BUTTON_STYLE);
    	add.setOnMouseEntered(e ->add.setStyle(HOVERED_BUTTON_STYLE));
    	add.setOnMouseExited(e ->add.setStyle(IDLE_BUTTON_STYLE));
    	userid=loginController.id;

    	set();
    	welcome1();

    
    
    	
     		
     		 
      	
      	
     	
     	
     	
 
		
	}
}
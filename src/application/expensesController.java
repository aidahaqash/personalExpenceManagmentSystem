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
public class expensesController {

    @FXML
    private Button dashboard;

    @FXML
    private Button expenses;

    @FXML
    private Button incomes;

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

}

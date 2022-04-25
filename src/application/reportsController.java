package application;


import java.net.URL;
import java.util.ResourceBundle;


import javax.swing.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class reportsController implements Initializable{

   
    @FXML
    private PieChart expensePie;

    @FXML
    private PieChart incomePie;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
    			new PieChart.Data("Bills",22),
    			new PieChart.Data("Education",30),
    			new PieChart.Data("Resturants",15),
    			new PieChart.Data("Groceries",10));
    	incomePie.setData(pieChartData);
    	incomePie.setStartAngle(90);
		ObservableList<PieChart.Data> pieChartData2 = 
				FXCollections.observableArrayList(
    			new PieChart.Data("FreeLancing",22),
    			new PieChart.Data("University",30),
    			new PieChart.Data("Company",15),
    			new PieChart.Data("Business",10));
    	expensePie.setData(pieChartData2);
    	expensePie.setStartAngle(90);
    	
    	
	}
	
}

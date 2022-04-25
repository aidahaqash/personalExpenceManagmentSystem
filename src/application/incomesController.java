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

public class incomesController implements Initializable{

    @FXML
    private PieChart pie;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
    			new PieChart.Data("FreeLancing",22),
    			new PieChart.Data("University",30),
    			new PieChart.Data("Company",15),
    			new PieChart.Data("Business",10));
    	pie.setData(pieChartData);
    	pie.setStartAngle(90);
	}
	
}

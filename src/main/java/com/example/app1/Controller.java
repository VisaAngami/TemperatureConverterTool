package com.example.app1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField userInputField;

	@FXML
	public Button convertButton;

	private static final String C_T_F_TEXT ="Celsius to Fahrenheit";
	private static final String F_T_C_TEXT ="Fahrenheit to Celsius";

	private boolean isC_TO_F=true;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		choiceBox.getItems().add(C_T_F_TEXT);
		choiceBox.getItems().add(F_T_C_TEXT);

		choiceBox.setValue(C_T_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> System.out.println(t1));

		convertButton.setOnAction(actionEvent -> {
			convert();

		});

	}

	private void convert() {

		String input=userInputField.getText(); //23   ==> "23"

		float enterTemperature=0.0f;

		try{
			enterTemperature= Float.parseFloat(input);
		}
		catch (Exception e){

			warnUser();
			return;
		}

		float newTemperature=0.0f;

		if (isC_TO_F) {  // if user select cel to feh
			newTemperature=(enterTemperature *9/5) +32;
		}
		else{
			newTemperature=(enterTemperature -32) * 9/5;

		}
		display(newTemperature);
	}

	private void warnUser() {

		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter Valid Temperature");
		alert.show();
	}

	private void display(float newTemperature) {
		String unit= isC_TO_F? "F":"C";

		System.out.println("The New Temperature is: " +newTemperature + unit);

		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The New Temperature is: " +newTemperature + unit);
		alert.show();
	}
}

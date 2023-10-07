package com.example.temperatureconverter;

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
    public ChoiceBox<String> choiceBox ;

    @FXML
    public TextField userInput ;

    @FXML
    public Button convertBtn ;

    private static final String C_to_F = "Celsius To Fahrenheit" ;
    private static final String F_to_C = "Fahrenheit To Celsius" ;

    private boolean isC_to_F = true ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        choiceBox.getItems().add(C_to_F);
        choiceBox.getItems().add(F_to_C);
        choiceBox.setValue(C_to_F);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(C_to_F ) ){
                isC_to_F = true;
            } else {
                isC_to_F=false;
            }
        });


           convertBtn.setOnAction(actionEvent ->
                   {
                      convert();
                   });
    }

    private void convert() {
      String input =  userInput.getText();

      float enterValue = 0.0f;
        try{
           enterValue = Float.parseFloat(input);
      } catch (Exception exception) {
          warner();
          return;
      }

      float newTemp = 0.00f;

      if (isC_to_F){
          newTemp = (enterValue * 9/5) + 32 ;
      } else {
          newTemp = (enterValue -32 )*5/9 ;
      }

      display(newTemp);

    }

    private void warner() {
        Alert alert = new Alert(Alert.AlertType.ERROR) ;
        alert.setTitle("ERROR OCCURRED");
        alert.setHeaderText("INVALID TEMPERATURE ");
        alert.setContentText("PLEASE ENTER THE VALID TEMPERATURE");
        alert.show();
    }

    private void display( float newTemp) {
       String unit = isC_to_F? "F" : "C" ;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("RESULT");
        alert.setHeaderText(isC_to_F? "The given celsius temp in fahrenheit" :"The given Fahrenheit temp in celsius" );
        alert.setContentText("THE NEW TEMPERATURE IS: " + newTemp + unit ) ;

        System.out.println(newTemp);
        alert.show();
    }
}

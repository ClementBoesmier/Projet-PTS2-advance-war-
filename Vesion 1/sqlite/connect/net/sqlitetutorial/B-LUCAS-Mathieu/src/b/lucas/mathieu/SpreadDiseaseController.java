package b.lucas.mathieu;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class SpreadDiseaseController implements Initializable {
   private int itsDate;
   private Timer itsTimer;
   private boolean itsTriggerTime;
   private Disease itsDisease;
   
   @FXML
   private AnchorPane AnchorPane1;
   
   @FXML 
   private AnchorPane AnchorPane2;
   
   @FXML
   private Label lTransmissionRate;
   
   @FXML
   private Label lDaysWithSymptoms;
    
   @FXML
   private Label lDaysInIncubation;
   
   @FXML
   private Slider sTransmissionRate;
   
   @FXML
   private Slider sDaysInIncubation;
   
   @FXML
   private Slider sDaysWithSymptoms;
   
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    Rectangle rectangles[][] = new Rectangle[54][54]; 
    for (int i = 0; i < 52; i++){
        for (int j = 0; j < 52; j++){
            rectangles[i][j] = new Rectangle(6*i+50+i, 6, 6, 6);
            rectangles[i][j].setStroke(Color.GREY);
            rectangles[i][j].setFill(Color.WHITE);
            AnchorPane2.getChildren().add(rectangles[i][j]);
        }
    }
    AnchorPane1.getChildren().add(AnchorPane2);
    lTransmissionRate.textProperty().bind(Bindings.format("%.2f",sTransmissionRate.valueProperty()));
    lDaysWithSymptoms.textProperty().bind(Bindings.format("%.2f",sDaysWithSymptoms.valueProperty()));
    lDaysInIncubation.textProperty().bind(Bindings.format("%.2f",sDaysInIncubation.valueProperty()));//To change body of generated methods, choose Tools | Templates.
    }
    
}


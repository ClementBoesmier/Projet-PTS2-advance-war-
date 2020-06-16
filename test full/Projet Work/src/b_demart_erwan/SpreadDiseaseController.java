package b_demart_erwan;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class SpreadDiseaseController implements Initializable {
    public AnchorPane apAnchor;
    public Label lDaysWithSymptoms;
    public Slider sDaysWithSymptoms;
    public Label lDaysInIncubation;
    public Slider sDaysInIncubation;
    public Label lTransmitionRate;
    public Slider sTransmitionRate;
    private int itsDate;
    private Timer itsTimer = new Timer();
    private boolean itsTriggerTime;
    private Disease itsDisease;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itsDisease = new Disease();
        itsTimer = new Timer();
        itsTriggerTime = false;
        itsDate = 0;

        //changement des valeur du slider
        sTransmitionRate.setMax(1);

        //Bind des variable de Disiease
        itsDisease.getDaysInIncubation().bindBidirectional(sDaysInIncubation.valueProperty());
        itsDisease.getDaysWithSymptoms().bindBidirectional(sDaysWithSymptoms.valueProperty());
        itsDisease.getTransmissionRate().bindBidirectional(sTransmitionRate.valueProperty());

        //Bind au label d'affichage
        lDaysInIncubation.textProperty().bind(itsDisease.getDaysInIncubation().asString());
        lDaysWithSymptoms.textProperty().bind(itsDisease.getDaysWithSymptoms().asString());
        lTransmitionRate.textProperty().bind(itsDisease.getTransmissionRate().asString());

        for (int x = 0; x < 54; x++) {
            for (int y = 0; y < 54; y++) {
                Rectangle anAvatar= new Rectangle();
                anAvatar.resize(6,6);
                anAvatar.setX(x+8+100);
                anAvatar.setY(y+8+150);
                itsDisease.setAvatar(y,x,anAvatar);
                apAnchor.getChildren().add(anAvatar);
            }
        }
        itsDisease.draw();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(itsTriggerTime == true)
                {
                    itsDisease.update(itsDate);
                    itsDisease.draw();
                    itsDate++;
                }
            }
        };
        itsTimer.schedule(task,500,500);

    }

    public void start(ActionEvent actionEvent) {
        itsTriggerTime = true;
    }

    public void stop(ActionEvent actionEvent) {
        itsTriggerTime = false;
    }

    public void stepByStep(ActionEvent actionEvent) {
        itsDisease.update(itsDate);
        itsDisease.draw();
        itsDate++;
    }
}

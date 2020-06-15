/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2017;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 *
 * @author louis
 */
public class SpreadDiseaseController implements Initializable {

    ArrayList<Skier> Skiers = new ArrayList<>();
    Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private TextField tfName;

    @FXML
    private Label rName;

    @FXML
    private Button btnAdd;

    @FXML
    private RadioButton rbHomme;

    @FXML
    private RadioButton rbFemme;

    @FXML
    private ComboBox cCategory;

    @FXML
    private Spinner sHours;

    @FXML
    private Spinner sMin;

    @FXML
    private Spinner sSec;

    @FXML
    //Create an add a skier to the skier's list
    private void btnAddAction(ActionEvent event) {
        Skier skier1;
        if (rbHomme.isSelected()) {
            skier1 = new Skier(tfName.getText(),
                    cCategory.getValue().toString(), rbHomme.getText(),
                    (int) sHours.getValue(), (int) sMin.getValue(),
                    (int) sSec.getValue());
        } else {
            skier1 = new Skier(tfName.getText(),
                    cCategory.getValue().toString(), rbFemme.getText(),
                    (int) sHours.getValue(), (int) sMin.getValue(),
                    (int) sSec.getValue());
        }
        Skiers.add(skier1);
        alert.setTitle("Skiers");
        alert.setHeaderText("Skier added :");
        alert.setContentText(skier1.toString());
        alert.showAndWait();
    }

    @FXML
    //Display all the skiers added
    private void btnAllAddedAction(ActionEvent event) {
        alert.setTitle("Skiers");
        alert.setHeaderText("Skier added :");
        alert.setContentText(Skiers.toString());
        alert.showAndWait();

    }

    @FXML
    //Display the skier with the best time
    private void btnFirstAction(ActionEvent event) throws ParseException {
        Skier minSkier = new Skier("MinSkier", "Senior", "Homme", 24, 59, 59);
        Date minTime = minSkier.getItsTime();
        //browse the skier's list to find the smallest time
        for (int i = 0; i < Skiers.size(); i++) {
            if (Skiers.get(i).getItsTime().compareTo(minTime) < 0) {
                minTime = Skiers.get(i).getItsTime();
            }
        }
        //browse the skier's list to associate
        //the smallest time to it's skier
        for (int i = 0; i < Skiers.size(); i++) {
            if (minTime.equals(Skiers.get(i).getItsTime())) {
                alert.setTitle("First Skier");
                alert.setHeaderText("First Skier :");
                alert.setContentText(Skiers.get(i).toString());
                alert.showAndWait();
            }
        }

    }

    @FXML
    private void btnUnder3Action(ActionEvent event) throws ParseException {
        Skier maxSkier = new Skier("MinSkier", "Senior", "Homme", 3, 0, 0);
        Date maxTime = maxSkier.getItsTime();
        ArrayList<Skier> SkiersUnder3 = new ArrayList<>();

        //browse the skier's list to find all times under 3 hours
        // and add them into the SkiersUnder3 list
        for (int i = 0; i < Skiers.size(); i++) {
            if (Skiers.get(i).getItsTime().compareTo(maxTime) < 0) {
                SkiersUnder3.add(Skiers.get(i));
            }
        }
        for (Skier Skier : Skiers) {
        }
        alert.setTitle("Skier under 3 hours");
        alert.setHeaderText("Skier under 3 hours");
        alert.setContentText(SkiersUnder3.toString());
        alert.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Initalize all category for the comboBox
        cCategory.getItems().addAll(
                "Veteran",
                "Senior",
                "Junior"
        );

    }

}

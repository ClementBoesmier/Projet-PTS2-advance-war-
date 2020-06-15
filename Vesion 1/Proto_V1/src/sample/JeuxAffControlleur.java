package sample;

import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuxAffControlleur implements Initializable {


    public Pane pan;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Maps map = new Maps("test");
        pan.getChildren().add(map.getTableauxAff());
    }
}

package sample;

import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class JeuxAffControlleur implements Initializable {


    private Game game;
    public AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Maps map = new Maps("France");
        GridPane test = map.getTableauxAff();
        game = new Game(map);
        pane.getChildren().add(test);
        test.setLayoutX(0);
        test.setLayoutY(0);
    }

    public void endTurn(ActionEvent actionEvent) {
        game.endTurn();
    }
}

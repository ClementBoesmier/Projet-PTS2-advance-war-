package sample;

import ClasseAdvencedWars.Game;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.TeamID;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class JeuxAffControlleur implements Initializable {


    @FXML
    public Label blueIncome;
    @FXML
    public Label bluePO;
    @FXML
    public Label redIncome;
    @FXML
    public Label redPO;
    @FXML
    public Label teamPlayNow;
    @FXML
    public Button butRouge;
    @FXML
    public Button butBleux;
    @FXML
    public Label nbToursAff;
   
    private Game game;

    @FXML
    public AnchorPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //Création de la carte
        Maps map = new Maps("France");
        GridPane affMap = map.getTableauxAff();
        game = new Game(map);
        pane.getChildren().add(0,affMap);
        affMap.setLayoutX(0);
        affMap.setLayoutY(0);

        //Bind des variable a l'interface
        nbToursAff.textProperty().bind(game.getNbTurnPropeties().asString());
        //Bleu
        bluePO.textProperty().bind(game.gettBlue().getArgentAffProperty().asString());
        blueIncome.textProperty().bind(game.gettBlue().getIncomAffProperty().asString());
        //Rouge
        redPO.textProperty().bind(game.gettRed().getArgentAffProperty().asString());
        redIncome.textProperty().bind(game.gettRed().getIncomAffProperty().asString());

        //Gestion Background
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/ressource/background.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));

        turnAffGest();
    }

    @FXML
    public void endTurn(ActionEvent actionEvent) {
        game.endTurn();
        turnAffGest();
    }

    private void turnAffGest()
    {
        if(Game.tTurn.getTeamID() == TeamID.BLUE)
        {
            teamPlayNow.setText("Bleux");
            teamPlayNow.setTextFill(Color.BLUE);
            butRouge.setVisible(false);
            butBleux.setVisible(true);
        }else
        {
            teamPlayNow.setText("Rouge");
            teamPlayNow.setTextFill(Color.RED);
            butRouge.setVisible(true);
            butBleux.setVisible(false);
        }
    }
}

package b_demart_erwan;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class MaineMenuControlleur implements Initializable {


    public static StringProperty redTeamName,blueTeamName;
    public TextField textBoxRed;
    public TextField textBoxBlue;
    public Button startButton;
    public Label redNameAff;
    public Label blueNameAff;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initialisation des propetie
        redTeamName = new SimpleStringProperty("red");
        blueTeamName = new SimpleStringProperty("blue");
        //Bind des propertie
        textBoxRed.textProperty().bindBidirectional(redTeamName);
        textBoxBlue.textProperty().bindBidirectional(blueTeamName);
        redNameAff.textProperty().bind(redTeamName);
        blueNameAff.textProperty().bind(blueTeamName);
    }

    public void lancerJeux(ActionEvent actionEvent) throws IOException {
        startButton.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("jeuxAff.fxml"));
        Scene game = new Scene(root);
        Stage gameStage = new Stage();
        gameStage.setScene(game);
        gameStage.show();
    }

    public void exitGame(ActionEvent actionEvent)
    {
        System.exit(0);
    }
}

package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public GridPane grille;
    public AnchorPane affPan;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Image herbre = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\neeko50.jpg");
        //Image apres = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\neekoChange50.jpg");
        String map = "0000000000" +
                "0211111110" +
                "0111111110" +
                "0113111110" +
                "0111111110" +
                "0111111110" +
                "0311111110" +
                "0111113110" +
                "0111111120" +
                "0000000000";
        Map carte = new Map(map,10);
        carte.generer();
        affPan.getChildren().add(carte.getAffMap());
    }
}

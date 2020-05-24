package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public GridPane grille;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int index=0;
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
        Image apres = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\cadre.png");
        Image herbre = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\herbre.jpg");
        Image ocean = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\oceanr.jpg");
        Image batiment = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\base.png");
        Image imgVille = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\ville.png");
        Base base = new Base(batiment);
        Base ville = new Base(imgVille);
        grille.setPadding(new Insets(0,0,0,0));
        int pointeur = 0;
        for (int i = 0; i < 10; i ++)
        {
            for (int u = 0; u < 10;u++)
            {
                switch (map.charAt(index))
                {
                    case '0':
                        grille.add(new Case(index,ocean, apres),u,i);
                        break;
                    case '1':
                        grille.add(new Case(index,herbre, apres),u,i);
                        break;
                    case '2':
                        grille.add(new Case(index,herbre, apres,base),u,i);
                        break;
                    case '3':
                        grille.add(new Case(index,herbre, apres,ville),u,i);
                        break;
                }
                index++;
            }
        }
    }
}

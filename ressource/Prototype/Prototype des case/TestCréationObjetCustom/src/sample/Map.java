package sample;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Map extends GridPane {
    private String map;

    public Map(String map)
    {
        int index=0;
        this.map = map;
        Image apres = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\cadre.png");
        Image herbre = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\herbre.jpg");
        Image ocean = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\oceanr.jpg");
        Image batiment = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\base.png");
        Image imgVille = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\ville.png");
        Base base = new Base(batiment);
        Base ville = new Base(imgVille);
        super.setPadding(new Insets(0,0,0,0));
        super.setManaged(true);
        int pointeur = 0;
        for (int i = 0; i < 10; i ++)
        {
            for (int u = 0; u < 10;u++)
            {
                switch (map.charAt(index))
                {
                    case '0':
                        super.add(new Case(index,ocean, apres),u,i);
                        break;
                    case '1':
                        super.add(new Case(index,herbre, apres),u,i);
                        break;
                    case '2':
                        super.add(new Case(index,herbre, apres,base),u,i);
                        break;
                    case '3':
                        super.add(new Case(index,herbre, apres,ville),u,i);
                        break;
                }
                index++;
            }
        }
    }


}

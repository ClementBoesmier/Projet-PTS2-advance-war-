package sample;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Map {
    private String Stringmap;
    private Case[][] map;
    private GridPane affMap;

    public Map(String Stringmap, int size)
    {
        this.Stringmap = Stringmap;
        map = new Case[size][size];
        affMap = new GridPane();
    }

    public void generer()
    {
        int index=0;
        Image apres = new Image("file:C:\\Users\\yugog\\Pictures\\waifu\\cadre.png");
        Image herbre = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\Plains.png");
        Image ocean = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\sea.png");
        Image batiment = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\UsineNeutre.png");
        Image imgVille = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\VilleNeutreV1.png");
        Base base = new Base(batiment);
        Base ville = new Base(imgVille);
        affMap.setPadding(new Insets(0,0,0,0));
        affMap.setManaged(true);
        int pointeur = 0;
        for (int i = 0; i < 10; i ++)
        {
            for (int u = 0; u < 10;u++)
            {
                switch (Stringmap.charAt(index))
                {
                    case '0':
                        affMap.add(new Case(index,ocean, apres),u,i);
                        break;
                    case '1':
                        affMap.add(new Case(index,herbre, apres),u,i);
                        break;
                    case '2':
                        affMap.add(new Case(index,herbre, apres,base),u,i);
                        break;
                    case '3':
                        affMap.add(new Case(index,herbre, apres,ville),u,i);
                        break;
                }
                index++;
            }
        }
    }

    public void getCase(int x, int y)
    {

    }

    public GridPane getAffMap() {
        return affMap;
    }
}

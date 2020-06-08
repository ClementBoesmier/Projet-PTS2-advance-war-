package sample.carte;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Menu;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class Map {
    private Case[][] cases;
    private GridPane tableauxAff;
    private String map;
    private int size;
    private ArrayList<Batiment> batiments;

    public Map(String map, int size)
    {
        this.map = map;
        this.size = size;
        cases = new Case[size][size];
        tableauxAff = new GridPane();
        batiments = new ArrayList<>();
        setEvent();
    }

    private void setEvent()
    {
        Delta dragDelta = new Delta();
        tableauxAff.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                if(mouseEvent.getButton() == MouseButton.PRIMARY)
                {
                    dragDelta.x = tableauxAff.getLayoutX() - mouseEvent.getSceneX();
                    dragDelta.y = tableauxAff.getLayoutY() - mouseEvent.getSceneY();
                    tableauxAff.setCursor(Cursor.MOVE);
                }
            }
        });
        tableauxAff.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                tableauxAff.setCursor(Cursor.HAND);
            }
        });
        tableauxAff.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton() == MouseButton.PRIMARY)
                {
                    tableauxAff.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                    tableauxAff.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
                }

            }
        });
        tableauxAff.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                tableauxAff.setCursor(Cursor.HAND);
            }
        });

        tableauxAff.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                if(event.getDeltaY() > 0)
                {
                    for(int x = 0; x < size; x ++)
                    {
                        for (int y = 0; y < size; y++) {
                            cases[x][y].zoom();
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutX()/2);
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutY()/2);
                        }
                    }
                }else
                {
                    for(int x = 0; x < size; x ++)
                    {
                        for (int y = 0; y < size; y++) {
                            cases[x][y].dezoom();
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutX()*2);
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutY()*2);
                        }
                    }
                }

            }
        });
    }

    public void generate()
    {
        int index = 0;
        for(int x = 0; x < size; x ++)
        {
            for (int y = 0; y < size; y++) {
                cases[x][y] = generateCase(index);
                tableauxAff.add(cases[x][y], y, x);
                index++;
            }
        }
    }

    private Case generateCase(int index)
    {
        switch (map.charAt(index))
        {
            case '0':
                return new Case(BibliotequeImage.ocean);
            case '1':
                return new Case(BibliotequeImage.plaine);
            case '2':
                Batiment batiment = new Batiment(BibliotequeImage.ville,BibliotequeImage.ville,BibliotequeImage.ville);
                batiments.add(batiment);
                return new Case(BibliotequeImage.plaine, batiment);
            case '3':
                Units units = new Units(BibliotequeImage.redBazooka,BibliotequeImage.blueBazooka, true);
                return new Case(BibliotequeImage.plaine, units);
            case '4':
                Units uniter = new Units(BibliotequeImage.redBazooka,BibliotequeImage.blueBazooka, false);
                return new Case(BibliotequeImage.plaine, uniter);
            case '5':
                Batiment batiment2 = new Batiment(BibliotequeImage.ville,BibliotequeImage.ville,BibliotequeImage.ville);
                batiments.add(batiment2);
                Units uniter2 = new Units(BibliotequeImage.redBazooka,BibliotequeImage.blueBazooka, false);
                return new Case(BibliotequeImage.plaine, batiment2,uniter2);
        }
        return new Case(BibliotequeImage.plaine);
    }

    public GridPane getTableauxAff() {
        return tableauxAff;
    }
}

class Delta { double x, y; }
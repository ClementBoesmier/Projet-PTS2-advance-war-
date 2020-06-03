package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Case extends Canvas {

    private int nombreCase;
    private GraphicsContext aff;
    private Image avant, apres;
    private Batiment batiment;


    public Case(int nombreCase, Image image, Image apres)
    {
        super(32,32);
        super.setScaleX(2);
        super.setScaleY(2);
        super.setHeight(64);
        super.setWidth(64);

        ContextMenu menu = new ContextMenu();

        MenuItem connard = new MenuItem("test");
        connard.setOnAction(event -> System.out.println("test"));
        menu.getItems().add(new MenuItem("test"));

        super.setOnContextMenuRequested(event -> menu.show(Case.super.getParent(), event.getScreenX(), event.getScreenY()));
        menu.setAutoHide(true);


        this.avant = image; this.apres = apres;
        aff = this.getGraphicsContext2D();
        this.nombreCase = nombreCase;
        aff.drawImage(avant, 0, 0);
        this.setOnMouseExited(event -> System.out.println("La souris est plus la : "+nombreCase));

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aff.drawImage(apres,0,0);
                System.out.println("Il est sur : "+nombreCase);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aff.drawImage(avant,0,0);
                System.out.println("Il est plus sur : "+nombreCase);
            }
        });


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Image affi = new Image("http://51.77.215.147/image/kawaii/tsuyu2.jpg");
                //aff.drawImage(affi,0,0);
                System.out.println("Il a cliquer sur : "+nombreCase);
            }
        });
    }

    public Case(int nombreCase, Image image, Image apres, Batiment batiment)
    {
        super(32,32);
        super.setScaleX(2);
        super.setScaleY(2);
        super.setHeight(64);
        super.setWidth(64);

        ContextMenu menu = new ContextMenu();

        MenuItem connard = new MenuItem("test");
        connard.setOnAction(event -> System.out.println("test"));
        menu.getItems().add(new MenuItem("test"));

        super.setOnContextMenuRequested(event -> menu.show(Case.super.getParent(), event.getScreenX(), event.getScreenY()));
        menu.setAutoHide(true);



        this.avant = image; this.apres = apres;
        aff = this.getGraphicsContext2D();
        this.nombreCase = nombreCase;
        aff.drawImage(avant, 0, 0);
        aff.drawImage(batiment.getImage(),0,0);
        this.setOnMouseExited(event -> System.out.println("La souris est plus la : "+nombreCase));

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aff.drawImage(apres,0,0);
                System.out.println("Il est sur : "+nombreCase);
            }
        });

        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                aff.drawImage(avant,0,0);
                aff.drawImage(batiment.getImage(),0,0);
                System.out.println("Il est plus sur : "+nombreCase);
            }
        });


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //Image affi = new Image("http://51.77.215.147/image/kawaii/tsuyu2.jpg");
                //aff.drawImage(affi,0,0);
                System.out.println("Il a cliquer sur : "+nombreCase);
            }
        });
    }



}

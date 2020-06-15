package sample.carte;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

public class Case extends Canvas {
    private Units uniter;
    private Batiment building;
    private Image terrain;
    private GraphicsContext affichage;
    private static final Image contours = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\contourV1.png");
    private static double largeur=32, hauteur=32;
    private int zoom;
    private ContextMenu menu;

    public Case(Image terrain, Batiment building, Units uniter) {
        super(largeur, hauteur);
        this.uniter = uniter;
        this.building = building;
        this.terrain = terrain;
        init();
    }

    public Case(Image terrain, Batiment building) {
        super(largeur, hauteur);
        this.building = building;
        this.terrain = terrain;
        init();
    }

    public Case(Image terrain, Units units) {
        super(largeur, hauteur);
        this.uniter = units;
        this.terrain = terrain;
        init();
    }

    public Case(Image terrain) {
        super(largeur, hauteur);
        this.terrain = terrain;
        init();
    }


    public void init()
    {
        zoom = 2;
        affichage = this.getGraphicsContext2D();
        menu = new ContextMenu();

        this.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                affichage.drawImage(contours,0,0);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                refreshAff();
            }
        });
        this.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                ContextMenu menu = new ContextMenu();
                System.out.println("je marche");
                if(building != null)
                {
                    //Menu batimentMen = building.getMenu();
                    MenuItem batiment = new MenuItem("batiment");
                    menu.getItems().add(batiment);
                }
                if(uniter != null)
                {
                    //Menu Uniter = building.getMenu();
                    MenuItem uniter = new MenuItem("uniter");
                    menu.getItems().add(uniter);
                }
                menu.setAutoHide(true);
                menu.show(Case.super.getParent(), event.getScreenX(), event.getScreenY());
            }
        });
        refreshAff();
        setScale();
        tooltypeAff();
    }

    private void tooltypeAff()
    {
        String text = "";
        if(terrain == BibliotequeImage.plaine)
        {
            text+="plaine"+'\n';
        }else
        {
            text+="ocean"+'\n';
        }
        tooltypeRefresh(text);
    }

    private void tooltypeRefresh()
    {
        String text = "";
        if(uniter != null)
        {
            text+="uniter"+'\n';
        }
        if(building != null)
        {
            text+="batiment"+'\n';
        }
        Tooltip.install(this, new Tooltip(text));
    }

    private void tooltypeRefresh(String text)
    {
        if(uniter != null)
        {
            text+="uniter"+'\n';
        }
        if(building != null)
        {
            text+="batiment"+'\n';
        }
        Tooltip.install(this, new Tooltip(text));
    }


    public void zoom()
    {
        zoom++;
        setScale();
    }

    public void dezoom()
    {
        zoom--;
        setScale();
    }




    private void setScale()
    {
        if(zoom <= 0)
        {
            zoom = 1;
        }else if(zoom >= 5)
        {
            zoom = 4;
        }
        super.setScaleX(zoom);
        super.setScaleY(zoom);
        super.setHeight(hauteur*zoom);
        super.setWidth(hauteur*zoom);
    }

    public void refreshAff()
    {
        affichage.drawImage(terrain,0,0);
        if(building != null)
        {
            affichage.drawImage(building.getImage(),0,0);
        }
        if(uniter != null)
        {
            affichage.drawImage(uniter.getImage(),0,0);
        }
    }
}

package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Exception.MoveException;
import ClasseAdvencedWars.Location;
import ClasseAdvencedWars.Maps;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.RocketLauncher;
import ClasseAdvencedWars.units.Tank;
import ClasseAdvencedWars.units.Units;
import ClasseAdvencedWars.Exception.FriendException;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.BibliotequeImage;

/**
 * 
 */
public abstract class Case {

    //Affichage
    private Image terrain;
    private GraphicsContext affichage;
    private static final Image contours = BibliotequeImage.contour;
    private static double largeur=32, hauteur=32;
    private int zoom;
    private ContextMenu menu;

    private Units unit = null;
    private Maps map;
    private Location location;
    
    private final Building building;

    private boolean lock;

    private Canvas affCanvas;
    
    /**
     * Default constructor
     */
    public Case(Building building) {
        this.building = building;
        init();
    }
    public Case(){
        this.building = null;
        init();
    }

    public Case(Building building, Image terrain) {
        this.building = building;
        this.terrain = terrain;
        init();
    }
    public Case(Image terrain){
        this.building = null;
        this.terrain = terrain;
        init();
    }

    /**
     * @return
     */
    public Units getUnit() {
        return this.unit;
    }

    public void setUnit(Units unit) throws FriendException {
        if(unit == null){
            this.unit = null;
        }else if(this.unit == null){
            this.unit = unit;
            if(this.getBuilding()!=null && this.getBuilding().getOwner()!=unit.getOwner()){
                this.getBuilding().setOnCapture(true);
            }
        }else if(this.unit.getOwner()== unit.getOwner()){
            throw new FriendException("error : ally unit allredy in the case");
        }else{
            this.unit = this.fight(unit);
        }
        refreshAff();
        tooltypeRefresh();
    }
    
    /**
     * @return
     */
    public Building getBuilding() {
        return this.building;
    }
    
    private Units fight(Units attack){
        Units sortie = null;
        if(attack.getClass().equals(this.unit.getClass())){
            sortie = null;
        }
        else if(attack instanceof Tank){
            if(this.unit instanceof Infantry){
                sortie = attack;
                if(this.getBuilding()!=null && this.getBuilding().getOwner()!=attack.getOwner()){
                this.getBuilding().setOnCapture(true);
            }
            }
            else{
                sortie = this.unit;
            }
        }
        else if(attack instanceof RocketLauncher){
            if(this.unit instanceof Tank){
                sortie = attack;
                if(this.getBuilding()!=null && this.getBuilding().getOwner()!=attack.getOwner()){
                this.getBuilding().setOnCapture(true);
            }
            }
            else{
                sortie = this.unit;
            }
        }
        else if(attack instanceof Infantry){
            if(this.unit instanceof RocketLauncher){
                sortie = attack;
                if(this.getBuilding()!=null && this.getBuilding().getOwner()!=attack.getOwner()){
                this.getBuilding().setOnCapture(true);
            }
            }
            else{
                sortie = this.unit;
            }
        }
        return sortie;
    }

    public abstract boolean getWalkable(Units aThis);

    public void setMap(Maps map) {
        this.map = map;
    }

    public Maps getMap() {
        return map;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    //Gestion affichage :

    public void init()
    {
        affCanvas = new Canvas();
        zoom = 2;
        affichage = affCanvas.getGraphicsContext2D();
        menu = new ContextMenu();
        lock = false;

        affCanvas.setOnMouseEntered((event)-> {
            affichage.drawImage(contours,0,0);
        });

        affCanvas.setOnMouseClicked((event -> {
            lock = true;
            map.setSelectedCase(this);
        }));


        affCanvas.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(!lock)
                {
                    refreshAff();
                }
            }
        });


        affCanvas.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                ContextMenu menu = new ContextMenu();
                if(building != null)
                {
                    //Menu batimentMen = building.getMenu();
                    MenuItem batiment = building.getAction();
                    menu.getItems().add(batiment);
                }
                if(unit != null)
                {
                    //Menu Uniter = building.getMenu();
                    MenuItem uniter = unit.getAction();
                    menu.getItems().add(uniter);
                }
                menu.setAutoHide(true);
                menu.getItems().add(new MenuItem("quitter"));
                menu.show(affCanvas.getParent(), event.getScreenX(), event.getScreenY());
            }
        });

        affCanvas.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("marche");
            }
        });


        setScale();
        tooltypeAff();
        refreshAff();
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
        if(unit != null)
        {
            text+="uniter"+'\n';
        }
        if(building != null)
        {
            text+="batiment"+'\n';
        }
        Tooltip.install(affCanvas, new Tooltip(text));
    }

    private void tooltypeRefresh(String text)
    {
        if(unit != null)
        {
            text+="uniter"+'\n';
        }
        if(building != null)
        {
            text+="batiment"+'\n';
        }
        Tooltip.install(affCanvas, new Tooltip(text));
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
        affCanvas.setScaleX(zoom);
        affCanvas.setScaleY(zoom);
        affCanvas.setHeight(hauteur*zoom);
        affCanvas.setWidth(hauteur*zoom);
    }

    public void refreshAff()
    {
        affichage.drawImage(terrain,0,0);
        if(building != null)
        {
            affichage.drawImage(building.getImage(),0,0);
        }
        if(unit != null)
        {
            affichage.drawImage(unit.getImage(),0,0);
        }
        if(this.lock)
        {
            affichage.drawImage(contours,0,0);
        }
        tooltypeAff();
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
        refreshAff();
    }

    public Canvas getAffCanvas() {
        return affCanvas;
    }
}
package ClasseAdvencedWars.Case;

import ClasseAdvencedWars.Case.Building.Building;
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
import javafx.scene.input.MouseEvent;
import sample.BibliotequeImage;

/**
 * 
 */
public abstract class Case extends Canvas {

    //Affichage
    private Image terrain;
    private GraphicsContext affichage;
    private static final Image contours = new Image("file:E:\\Developpement\\git\\Projet-PTS2-advance-war-\\ressource\\GraphismeV1\\contourV1.png");
    private static double largeur=32, hauteur=32;
    private int zoom;
    private ContextMenu menu;

    private Units unit = null;
    private Maps map;
    private Location location;
    
    private final Building building;
    
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
                if(unit != null)
                {
                    //Menu Uniter = building.getMenu();
                    MenuItem uniter = unit.getAction();
                    menu.getItems().add(uniter);
                }
                menu.setAutoHide(true);
                menu.show(Case.super.getParent(), event.getScreenX(), event.getScreenY());
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
        Tooltip.install(this, new Tooltip(text));
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
        if(unit != null)
        {
            affichage.drawImage(unit.getImage(),0,0);
        }
        tooltypeAff();
    }



}
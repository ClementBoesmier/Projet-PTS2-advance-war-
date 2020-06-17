package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.MoveException;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.Units;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import sample.BibliotequeImage;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * 
 */
public class Maps {

    private GridPane tableauxAff;

    /**
     * 
     */
    
    private Case[][] map;
    /**
     * 
     */
    private  int WIDTH;

    /**
     * 
     */
    private int HEIGHT;

    private Team rTeam, bTeam;

    private Case selectedCase ;


    
    /**
     * Default constructor
     */
    public Maps(int width,int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    //Constructeur finit
    public Maps(String mapName, Team rTeam,Team bTeam){
        tableauxAff = new GridPane();
        this.rTeam = rTeam;
        this.bTeam = bTeam;
        this.selectedCase = null;
        generate(mapName);
    }

    public void generate(String mapName)
    {
        boolean firstBaseGeneration = true;
        try (Connection con = this.connect();
             Statement stmt = con.createStatement();
             Statement stmt1 = con.createStatement();
             Statement stmt2 = con.createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(PositionX) FROM PlayGround WHERE mapID = '" + mapName + "'");
             ResultSet res1 = stmt1.executeQuery("SELECT MAX(PositionY) FROM PlayGround WHERE mapID = '" + mapName + "'");
             ResultSet res2 = stmt2.executeQuery("SELECT Name FROM Player");
             PreparedStatement pstmt = con.prepareStatement("SELECT Type, Building FROM PlayGround WHERE PositionX=? And PositionY=? AND mapID = '" + mapName + "'")){

            this.HEIGHT = res.getInt("MAX(PositionX)");
            this.WIDTH = res1.getInt("MAX(PositionY)");
            map = new Case[this.HEIGHT+1][this.WIDTH+1];

            for(int i=0; i<this.HEIGHT+1;i++){
                pstmt.setInt(1, i);
                for(int j = 0; j<this.WIDTH+1;j++){
                    pstmt.setInt(2,j);
                    if(pstmt.executeQuery().getString("Type").equals(new String("Plain"))){
                        //System.out.println(pstmt.executeQuery().getString("Type"));
                        //System.out.println(pstmt.executeQuery().getString("Building"));
                        if(pstmt.executeQuery().getString("Building")==null){
                            this.map[j][i]= new Plain();
                        }
                        else if(pstmt.executeQuery().getString("Building").equals(new String("Base"))){
                            //System.out.println("Base");
                            Base base = new Base(bTeam);
                            if(firstBaseGeneration == true)
                            {
                                base = new Base(rTeam);
                                firstBaseGeneration = false;
                            }else
                            {
                                base = new Base(bTeam);
                            }
                            map[j][i]= new Plain(base);
                            base.setMyCase(map[j][i]);
                        }

                        else if(pstmt.executeQuery().getString("Building").equals(new String("Town"))){
                           // System.out.println("Town");
                            Town town = new Town();
                            map[j][i]= new Plain(town);
                            town.setMyCase(map[j][i]);
                        }

                    }
                    if(pstmt.executeQuery().getString("Type").equals(new String("Ocean"))){
                        //System.out.println("Ocean");
                        map[j][i] = new Ocean();
                    }

                }
            }

            //AFF
            for(int x = 0; x < map.length; x++)
            {
                for (int y = 0; y < map.length; y++) {
                    if(map[x][y] == null)
                    {
                        System.out.println("X: "+x+" Y: "+y);
                    }else
                    {
                        tableauxAff.add(map[x][y].getAffCanvas(),y,x);
                        map[x][y].setMap(this);
                        map[x][y].setLocation(new Location(x,y));
                    }

                }
            }
            setEvent();
            System.out.println("Generation de la carte finit");
        }
        catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param x 
     * @param y 
     * @return
     */
    public Case getCase(int x, int y) {
        return map[x][y];
    }

    /**
     * @return
     */
    public HashMap<Location, Case> getBuilding() {
        HashMap<Location, Case> sortie = new HashMap<>();
        for(int i = 0; i < this.WIDTH+1; i++){
            for(int j = 0; j < this.HEIGHT+1; j++){
                if(map[i][j].getBuilding() != null){
                    sortie.put(new Location(i,j), map[i][j]);
                }
            }
        }
        return sortie;
    }
    
    public HashMap<Location, Case> getUnits(){
                HashMap<Location, Case> sortie = new HashMap<>();
        for(int i = 0; i < this.WIDTH+1; i++){
            for(int j = 0; j < this.HEIGHT+1; j++){
                if(map[i][j].getUnit() != null){
                    sortie.put(new Location(i,j), map[i][j]);
                }
            }
        }
        return sortie;
    }

    
    public Location GetLocal(Units unit){
        Location sortie = null;
        for(int i = 0; i < this.WIDTH+1; i++){
            for(int j = 0; j < this.HEIGHT+1; j++){
                if(this.map[i][j] != null){
                    if(this.map[i][j].getUnit() == unit){
                        sortie = new Location(i,j);
                    }
                }
            }
        }
        return sortie;
    }
    
    public Location GetLocal(Building build){
        Location sortie = null;
        for(int i = 0; i < this.WIDTH; i++){
            for(int j = 0; j < this.HEIGHT; j++){
                if(this.map[i][j] != null){
                    if(this.map[i][j].getBuilding() == build){
                        sortie = new Location(i,j);
                    }
                }
            }
        }
        return sortie;
    }
    
    
    
    private static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            File dbfile=new File("");
            String url = "jdbc:sqlite:/media/clement/USBa-cClement/cour 2019-2020/PTS2/test full/Projet Work/src/ressource/DB/Carte1DB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }

    //Aff

    private void setEvent()
    {
        tableauxAff.setHgap(0);
        tableauxAff.setVgap(0);
        tableauxAff.setPadding(new Insets(0,0,0,0));

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
                    for(int x = 0; x < map.length; x ++)
                    {
                        for (int y = 0; y < map.length; y++) {
                            map[x][y].zoom();
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutX()/2);
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutY()/2);
                        }
                    }
                }else
                {
                    for(int x = 0; x < map.length; x ++)
                    {
                        for (int y = 0; y < map.length; y++) {
                            map[x][y].dezoom();
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutX()*2);
                            //tableauxAff.setLayoutX(tableauxAff.getLayoutY()*2);
                        }
                    }
                }

            }
        });

        //Event non fonctionnelle
        tableauxAff.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event){
                System.out.println("marche");
                if(selectedCase != null || selectedCase.getUnit() != null)
                {
                    Units unit = selectedCase.getUnit();
                    switch (event.getCode())
                    {
                        case UP:
                            try {
                                unit.moveSelector("up");
                            } catch (MoveException e) {
                                e.printStackTrace();
                            } catch (FriendException e) {
                                e.printStackTrace();
                            }
                            break;
                        case LEFT:
                            try {
                                unit.moveSelector("left");
                            } catch (MoveException e) {
                                e.printStackTrace();
                            } catch (FriendException e) {
                                e.printStackTrace();
                            }
                            break;
                        case RIGHT:
                            try {
                                unit.moveSelector("right");
                            } catch (MoveException e) {
                                e.printStackTrace();
                            } catch (FriendException e) {
                                e.printStackTrace();
                            }
                            break;

                        case DOWN:
                            try {
                                unit.moveSelector("back");
                            } catch (MoveException e) {
                                e.printStackTrace();
                            } catch (FriendException e) {
                                e.printStackTrace();
                            }
                            break;
                    }
                }
            }
        });
    }

    public GridPane getTableauxAff() {
        return tableauxAff;
    }

    public Case getSelectedCase() {
        return selectedCase;
    }


    public void setSelectedCase(Case selectedCase) {
        if(this.selectedCase != null)
        {
            if(this.selectedCase.getUnit() != null)
            {
                if(this.selectedCase.getUnit().getOwner() == Game.tTurn)
                {
                    try {
                        this.selectedCase.getUnit().moveStep(selectedCase.getLocation().getX() - this.selectedCase.getLocation().getX(), selectedCase.getLocation().getY()-this.selectedCase.getLocation().getY(),this);
                    } catch (FriendException e) {
                        e.printStackTrace();
                    } catch (MoveException e) {
                        e.printStackTrace();
                    }
                    this.selectedCase.setLock(false);
                    selectedCase.setLock(false);
                    this.selectedCase = null;
                }else
                {
                    selectedCase.setLock(false);
                    this.selectedCase.setLock(false);
                    this.selectedCase = null;
                }
            }else
            {
                this.selectedCase.setLock(false);
                this.selectedCase = selectedCase;
            }
        }else
        {
            this.selectedCase = selectedCase;
            this.selectedCase.setLock(true);
        }
    }
}

class Delta { double x, y; }
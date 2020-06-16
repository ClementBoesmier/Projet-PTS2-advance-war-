package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Building;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.units.Infantry;
import ClasseAdvencedWars.units.Units;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.GridPane;
import sample.BibliotequeImage;

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

    
    /**
     * Default constructor
     */
    public Maps(int width,int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }
    //CONSTRUCTEUR DE TEST TEMPORAIRE
    public Maps(int width, int height, Case temp[][]){
        this.HEIGHT = height;
        this.WIDTH = width;
        this.map = temp;
    }
    
    //Constructeur fini ( passage par mapID ) à faire
    public Maps(String mapName){
        tableauxAff = new GridPane();
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
                            this.map[i][j]= new Plain();
                        }
                        else if(pstmt.executeQuery().getString("Building").equals(new String("Base"))){
                            //System.out.println("Base");
                            Base base = new Base(Game.tBlue);
                            map[i][j]= new Plain(base);
                            base.setMyCase(map[i][j]);
                           }
                        
                        else if(pstmt.executeQuery().getString("Building").equals(new String("Town"))){
                            //System.out.println("Town");
                            Town town = new Town();
                            map[i][j]= new Plain(town);
                            town.setMyCase(map[i][j]);
                        }
                        
                    }
                    if(pstmt.executeQuery().getString("Type").equals(new String("Ocean"))){
                        map[i][j] = new Ocean();
                    }
                    
                }
            }

            //AFF
            for(int x = 0; x < map.length; x++)
            {
                for (int y = 0; y < map.length; y++) {
                    tableauxAff.add(map[x][y],y,x);
                    map[x][y].setMap(this);
                    map[x][y].setLocation(new Location(x,y));

                    if(x == 2 && y == 2)
                    {
                        map[x][y].setUnit(new Infantry(Game.tBlue, map[x][y]));
                    }
                }
            }
            setEvent();
            if(tableauxAff == null)
            {
                System.out.println("test");
            }
        }   
        catch(SQLException | FriendException e ){
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
        for(int i = 0; i < this.WIDTH; i++){
            for(int j = 0; j < this.HEIGHT; j++){
                if(map[i][j].getBuilding() != null){
                    sortie.put(new Location(i,j), map[i][j]);
                }
            }
        }
        return sortie;
    }
    
    public HashMap<Location, Case> getUnits(){
                HashMap<Location, Case> sortie = new HashMap<>();
        for(int i = 0; i < this.WIDTH; i++){
            for(int j = 0; j < this.HEIGHT; j++){
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
            String url = "jdbc:sqlite:/media/clement/USBa-cClement/cour 2019-2020/PTS2/Vesion 1/sqlite/db/AdvanceWarsDB.db";
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
    }

    public GridPane getTableauxAff() {
        return tableauxAff;
    }
    
}

class Delta { double x, y; }
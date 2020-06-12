package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Building.Base;
import ClasseAdvencedWars.Case.Building.Town;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Case.Ocean;
import ClasseAdvencedWars.Case.Plain;
import ClasseAdvencedWars.units.Units;
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
    public Maps(){  
        try (Connection con = this.connect();
            Statement stmt = con.createStatement();    
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(PositionX) FROM PlayGround");
            ResultSet res1 = stmt1.executeQuery("SELECT MAX(PositionY) FROM PlayGround");
            ResultSet res2 = stmt2.executeQuery("SELECT Name FROM Player");
            PreparedStatement pstmt = con.prepareStatement("SELECT Type, Building FROM PlayGround WHERE PositionX=? And PositionY=?")){
            
            this.HEIGHT = res.getInt("MAX(PositionX)");
            this.WIDTH = res1.getInt("MAX(PositionY)");
            map = new Case[this.HEIGHT+1][this.WIDTH+1];
            
            for(int i=0; i<this.HEIGHT+1;i++){
                pstmt.setInt(1, i);
                for(int j = 0; j<this.WIDTH+1;j++){
                    pstmt.setInt(2,j);
                    if(pstmt.executeQuery().getString("Type").equals(new String("Plain"))){
                        System.out.println(pstmt.executeQuery().getString("Type"));
                        System.out.println(pstmt.executeQuery().getString("Building"));
                        if(pstmt.executeQuery().getString("Building")==null){
                            this.map[i][j]= new Plain();
                        }
                        else if(pstmt.executeQuery().getString("Building").equals(new String("Base"))){
                            System.out.println("Base");
                            map[i][j]= new Plain(new Base(new Team(res2.getString("Name"))));
                           }
                        
                        else if(pstmt.executeQuery().getString("Building").equals(new String("Town"))){
                            System.out.println("Town");
                            this.map[i][j]= new Plain(new Town());
                        }
                        
                    }
                    if(pstmt.executeQuery().getString("Type").equals(new String("Ocean"))){
                        map[i][j] = new Ocean();
                    }
                    
                }
            }
            
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

    
    public Location GetLocalUnit(Units unit){
        Location sortie = null;
        for(int i = 0; i < this.WIDTH; i++){
            for(int j = 0; j < this.HEIGHT; j++){
                if(this.map[i][j] != null){
                    if(this.map[i][j].getUnit() == unit){
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
            String url = "jdbc:sqlite:C:/sqlite/db/AdvanceWarsDB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
    
}
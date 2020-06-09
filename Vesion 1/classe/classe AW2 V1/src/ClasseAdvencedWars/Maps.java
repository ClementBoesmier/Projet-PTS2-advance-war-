package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.units.Units;
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
    private final int WIDTH;

    /**
     * 
     */
    private final int HEIGHT;

    
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
    /** Constructeur quasi fini
    public Maps(String mapName){
        String blabla;
        String izi ;
        try (Connection con = this.connect();
            Statement stmt = con.createStatement();    
            Statement stmt1 = con.createStatement();
            Statement stmt2 = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(PositionX) FROM " + mapName);
            ResultSet res1 = stmt1.executeQuery("SELECT MAX(PositionY) FROM " + mapName);
            ResultSet res2 = stmt2.executeQuery("SELECT Name FROM Player");
            PreparedStatement pstmt = con.prepareStatement("SELECT Type, Building FROM PlayGround WHERE PositionX=? And PositionY=?")){
            
            this.HEIGHT = res.getInt("MAX(PositionX)");
            this.WIDTH = res1.getInt("MAX(PositionY)") ;
            
            
            for(int i=0; i<this.HEIGHT+1;i++){
                pstmt.setInt(1, i);
                for(int j = 0; j<this.WIDTH+1;j++){
                    pstmt.setInt(2,j);
                    blabla = pstmt.executeQuery().getString("Type");
                    izi = pstmt.executeQuery().getString("Building");
                    System.out.println(blabla);
                    System.out.println(izi);
                    while(res.next()){
                    if(blabla=="Plain"){
                        if(izi=="NULL"){
                            this.map[i][j]= new Plain();
                        }
                        if(izi=="Base"){
                            this.map[i][j]= new Plain(new Base(new Team(res2.getString("Player"))));
                        }
                        if(izi=="Town"){
                            this.map[i][j]= new Plain(new Town());
                        }
                     
                    }
                    if(blabla=="Ocean"){
                        this.map[i][j] = new Ocean();
                    }
                }}
            }
            
        }   
        catch(SQLException e ){
            System.out.println(e.getMessage());
        }
    }
    */

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
    
    public Location GetLocalUnit(Units unit){
        Location sortie = null;
        for(int i = 0; i < this.WIDTH; i++){
            for(int j = 0; j < this.HEIGHT; j++){
                if(map[i][j].getUnit() == unit){
                    sortie = new Location(i,j);
                }
            }
        }
        return sortie;
    }
    /**
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
    */
}
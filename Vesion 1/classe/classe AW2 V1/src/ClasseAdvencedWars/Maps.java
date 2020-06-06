package ClasseAdvencedWars;


import ClasseAdvencedWars.Case.Case;
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
        // TODO implement here
        return null;
    }

}
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



    /**
     * @param x 
     * @param y 
     * @return
     */
    public Case getCase(int x, int y) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public HashMap<Location, Case> getBuilding() {
        // TODO implement here
        return null;
    }

}
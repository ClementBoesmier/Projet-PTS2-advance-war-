package ClasseAdvencedWars.units;



/**
 * 
 */
public abstract class Units extends Tank {

    /**
     * Default constructor
     */
    public Units() {
    }

    /**
     * 
     */
    private final int VISION;

    /**
     * 
     */
    private final int MAXTRAVEL;

    /**
     * 
     */
    private int movePoint;

    /**
     * 
     */
    private final int COST;

    private final Team OWNER;

    /**
     * @param x 
     * @param y 
     * @return
     */
    public void move(int x, int y) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Team getOwner() {
        // TODO implement here
        return null;
    }

}
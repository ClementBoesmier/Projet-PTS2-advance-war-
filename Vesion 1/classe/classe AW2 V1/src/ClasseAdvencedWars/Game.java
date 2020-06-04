package ClasseAdvencedWars;

/**
 * 
 */
public class Game {
    /**
     * 
     */
    private int nbTurn;
    
    /**
     * 
     */
    private final Maps MAPS;
    
    /**
     * 
     */
    private final Team tBlue;
    
    /**
     * 
     */
    private final Team tRed;
    
    /**
     * Default constructor
     */
    public Game(Maps maps, Team teamB, Team teamR) {
        this.MAPS = maps;
        this.tBlue = teamB;
        this.tRed = teamR;
    }


    /**
     * @return
     */
    public int getTurn() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public void endTurn() {
        // TODO implement here
    }

}
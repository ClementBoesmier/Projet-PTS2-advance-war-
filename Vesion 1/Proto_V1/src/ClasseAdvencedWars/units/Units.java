package ClasseAdvencedWars.units;

import ClasseAdvencedWars.*;
import ClasseAdvencedWars.Case.Case;
import ClasseAdvencedWars.Exception.FriendException;
import ClasseAdvencedWars.Exception.MoveException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;


/**
 * 
 */
public abstract class Units{
    //affichage
    private Image redFac,blueFac;
    private Case aCase;
    
    /**
     * 
     */
    protected int movePoint;

    private final Team OWNER;
    
    
    /**
     * Default constructor
     * @param owner
     */
    public Units(Team owner, Case aCase, Image redFac, Image blueFac) {
        this.OWNER = owner;
        this.aCase = aCase;
        this.redFac = redFac;
        this.blueFac = blueFac;
    }
    /**
     * 
     * @param x
     * @param y
     * @param map
     * @throws Exception.MoveException
     * @throws Exception.FriendException
     */
    public void moveStep(int x, int y, Maps map) throws MoveException, FriendException{
        int localY = 0;
        int localX = 0;
        Location localPos;
        if(this.movePoint <= 0){
            throw new MoveException("no more MP");
        }else if((x != 0 && y != 0) || (x < -1 || x > 1) || (y < -1 || y > 1)){
            throw new MoveException("Illegale Step move");
        }else{
        localPos = map.GetLocal(this);
        localX = localPos.getX();
        localY = localPos.getY();
        }
        if(map.getCase(localX+x, localY+y) == null){
            throw new MoveException("hors map");
        }else if(!map.getCase(localX+x, localY+y).getWalkable(this)){
            throw new MoveException("area not walkable");
        }else{
            map.getCase(localX+x, localY+y).setUnit(this);
            map.getCase(localX, localY).setUnit(null);
            this.movePoint-=1;
        }
    }

    /**
     * @return
     */
    public Team getOwner() {
        return this.OWNER;
    }
    
    /**
     *
     */
    public abstract void onEndTurn();


    public Image getImage()
    {
        if(getOwner().getTeamID() == TeamID.BLUE)
        {
            return blueFac;
        }else
            {
                return redFac;
            }
    }


    public Menu getAction()
    {
        if(getOwner() != Game.tTurn)
        {
            return new Menu("Pas ton tour !!!!");
        }else if(movePoint == 0)
        {
            return new Menu("Plus de Déplacement");
        }
        Menu menu = new Menu("Uniter ("+movePoint+"MP)");
        MenuItem moveUP = new MenuItem("Haut");
        moveUP.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    moveSelector("up");
                } catch (MoveException e) {
                    e.printStackTrace();
                } catch (FriendException e) {
                    e.printStackTrace();
                }
            }
        });
        MenuItem moveBACK = new MenuItem("Bas");
        moveBACK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    moveSelector("back");
                } catch (MoveException e) {
                    e.printStackTrace();
                } catch (FriendException e) {
                    e.printStackTrace();
                }
            }
        });
        MenuItem moveLEFT = new MenuItem("Gauche");
        moveLEFT.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                moveSelector("left");
            } catch (MoveException e) {
                e.printStackTrace();
            } catch (FriendException e) {
                e.printStackTrace();
            }
        }
    });
        MenuItem moveRIGHT = new MenuItem("Droite");
        moveRIGHT.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            try {
                moveSelector("right");
            } catch (MoveException e) {
                e.printStackTrace();
            } catch (FriendException e) {
                e.printStackTrace();
            }
        }
    });
        menu.getItems().add(moveUP);
        menu.getItems().add(moveLEFT);
        menu.getItems().add(moveRIGHT);
        menu.getItems().add(moveBACK);
        return menu;
    }

    private void moveSelector(String entrer) throws MoveException, FriendException {
        switch (entrer)
        {
            case "up":
                moveStep(-1,0,aCase.getMap());
                break;
            case "back":
                moveStep(1,0,aCase.getMap());
                break;
            case "left":
                moveStep(0,-1,aCase.getMap());
                break;
            case "right":
                moveStep(0,1,aCase.getMap());
                break;
        }
    }

    public int getCost() {
        return 0;
    }
}
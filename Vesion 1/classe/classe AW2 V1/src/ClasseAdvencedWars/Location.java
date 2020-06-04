/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseAdvencedWars;

/**
 *
 * @author clement
 */
public class Location {
    
    private int X;
    private int Y;
    
    public Location(int x, int y){
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    
}

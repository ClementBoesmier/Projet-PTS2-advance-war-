/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.pkg1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mathi
 */
public class Paddle {
    private double itsX;
    private double itsY;
    private double itsWidth;
    private double itsHeight;
    private double itsSpeed;
    private Rectangle itsPaddle;
    
    public double getItsX() {
        return itsX;
    }

    public double getItsWidth() {
        return itsWidth;
    }

    public double getItsSpeed() {
        return itsSpeed;
    }

    public void setItsSpeed(double itsSpeed) {
        this.itsSpeed = itsSpeed;
    }
    public void draw(){
        this.calculatePosition();
        this.itsPaddle.setLayoutX(itsX);
        this.itsPaddle.setLayoutY(itsY);
        this.itsPaddle.setWidth(this.itsWidth);
        this.itsPaddle.setHeight(this.itsHeight);
        this.itsPaddle.setFill(Color.BLUE);
    }

    private void calculatePosition() {
        this.itsX +=this.itsSpeed;
    }
    
}

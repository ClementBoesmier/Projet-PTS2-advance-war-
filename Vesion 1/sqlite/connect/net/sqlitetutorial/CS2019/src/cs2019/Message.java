/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2019;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author mathi
 */
public class Message {
    private ObservableList<String> sesPhrases;
    private int sonChoixDeCouleur;
    
    public Message(){
        this.sesPhrases= FXCollections.observableArrayList();
        this.sonChoixDeCouleur = 0;
        
    }
    public String choisirPhrase(){
        int max = sesPhrases.size();
        int min = 0;
        int range = max - min + 1;
        int index = (int) (Math.random() * range) + min;
        System.out.println(index);
        String theResult = "";
        try {
            theResult = sesPhrases.get(index);
        } catch (IndexOutOfBoundsException e) {
        }

        return theResult;
    }
    public double choisirX(){
        int max = 70; 
        int min = 30; 
        int range = max - min + 1;
        return (Math.random() * range) + min; 
    }
    public double choisirY(){
        int max =400; 
        int min = 40; 
        int range = max - min + 1;
        return (Math.random() * range) + min; 
    }
    public Paint choisirCouleur(){
        this.sonChoixDeCouleur++;
        if(this.sonChoixDeCouleur>4){
            this.sonChoixDeCouleur=0;
        }
        Paint res = Color.WHITE;
        switch(this.sonChoixDeCouleur){
            case 0 : res=Color.BLUE;
                              break;
            case 1 : res=Color.RED;
                              break;
            case 2 : res=Color.GREEN;
                              break;
            case 3 : res=Color.YELLOW;
                              break;
            case 4 : res=Color.CHOCOLATE;
                              break;                  
        }
        return res;
    }
}

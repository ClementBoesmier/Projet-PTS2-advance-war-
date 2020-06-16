/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseAdvencedWars.Exception;

import javafx.scene.control.Alert;

/**
 *
 * @author clement
 */
public class MoveException extends Exception{

    public MoveException() {
    }

    public MoveException(String string) {
        super(string);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Déplacement");
        alert.setContentText("Cette unité ne peut pas marcher sur cette case");
        alert.show();
    }
    
}

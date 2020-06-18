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
public class SpawnException extends Exception{

    public SpawnException() {
    }

    public SpawnException(String string) {
        super(string);
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Uniter");
        alert.setContentText(string);
        alert.show();
    }
    
}
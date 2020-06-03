/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypepts;

import java.time.LocalDate;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ordinateur
 */
public class joueur 
{
    private SimpleStringProperty pseudo = new SimpleStringProperty();
    
    
    public joueur ()
    {
        this.pseudo=new SimpleStringProperty();
    }

    public SimpleStringProperty getPseudo() 
    {
        return this.pseudo;
    }

    public void setPseudo(SimpleStringProperty pseudo) 
    {
        this.pseudo = pseudo;
    }
    
}

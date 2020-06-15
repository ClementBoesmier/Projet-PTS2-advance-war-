package sample.carte;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;

public class Units {
    private Image redFac,blueFac;
    private boolean faction;
    private Menu menu;
    private Case aCase;

    public Units(Image redFac, Image blueFac, boolean faction) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.faction = faction;
    }

    public Image getImage()
    {
        if(faction == true)
        {
            return redFac;
        }else
        {
            return blueFac;
        }
    }

    public void setaCase(Case aCase)
    {
        this.aCase = aCase;
    }
}

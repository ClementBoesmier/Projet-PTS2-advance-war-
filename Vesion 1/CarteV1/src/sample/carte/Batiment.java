package sample.carte;

import javafx.scene.control.Menu;
import javafx.scene.image.Image;

public class Batiment {
    private Image redFac,blueFac, neutral;
    private boolean faction;
    private Menu menu;

    public Batiment(Image redFac, Image blueFac, Image neutral) {
        this.redFac = redFac;
        this.blueFac = blueFac;
        this.neutral = neutral;
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

    public Menu getMenu() {
        return menu;
    }
}

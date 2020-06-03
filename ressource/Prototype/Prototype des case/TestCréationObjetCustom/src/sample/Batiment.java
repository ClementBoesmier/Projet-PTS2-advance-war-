package sample;

import javafx.scene.image.Image;

public abstract class Batiment {
    private Image aAff;

    public Batiment(Image aAff)
    {
        this.aAff = aAff;
    }

    public Image getImage() {
        return aAff;
    }
}

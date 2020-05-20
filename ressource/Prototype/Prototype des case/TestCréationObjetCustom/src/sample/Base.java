package sample;

import javafx.scene.image.Image;

public class Base implements Batiment {
    private Image aAff;

    public Base(Image aAff)
    {
        this.aAff = aAff;
    }

    @Override
    public Image getImage() {
        return aAff;
    }
}

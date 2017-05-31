package jpu2016.dogfight.model;

import java.awt.*;

/**
 * Sky Model (arrière plan du jeu)
 * @author Mandel Vaubourg
 * @version 1.0
 */
public abstract class Sky implements IArea{

    private Dimension dimension;
    private Image image;
    /**
     * @param dimension défini les dimensions du ciel
     * */
    public Sky(Dimension dimension){

        this.dimension = dimension;

    }
    @Override
    public Dimension getDimention(){
        return this.dimension;
    }
    @Override
    public Image getImage(){

        return this.image;
    }


}

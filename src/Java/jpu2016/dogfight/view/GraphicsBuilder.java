package jpu2016.dogfight.view;

import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.gameframe.IGraphicsBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public abstract class GraphicsBuilder implements IGraphicsBuilder{
    private BufferedImage emptySky;
    private IDogfightModel dogfightModel;

    public GraphicsBuilder (IDogfightModel dogfightModel){
        this.dogfightModel = dogfightModel;
    }

    public void setDogfightModel(IDogfightModel dogfightModel) {
        this.dogfightModel = dogfightModel;
    }
    public IDogfightModel getDogfightModel() {
        return dogfightModel;
    }

    public void setEmptySky(BufferedImage emptySky) {
        this.emptySky = emptySky;
    }
    public BufferedImage getEmptySky() {
        return emptySky;
    }

    public void applyModelToGraphic(Graphics graphics, ImageObserver observer){}

    private void buildEmptySky(){}

    private void drawMobile(IMobile mobile, Graphics graphics, ImageObserver observer){}

    public int getGlobalWidth(){
        return this.dogfightModel.getArea().getDimention().getWidth();
    }
    public int getGlobalHeight(){
        return this.dogfightModel.getArea().getDimention().getHeight();
    }



}

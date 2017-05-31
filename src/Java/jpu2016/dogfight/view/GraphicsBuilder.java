package jpu2016.dogfight.view;

import jpu2016.gameframe.IGraphicsBuilder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class GraphicsBuilder extends IGraphicsBuilder {
    private BufferedImage emptySky;
    private IDogfightModel dogfightModel;

    public GraphicsBuilder (IDogfightModel dogfightModel){}

    public void applyModelToGraphic(Graphics graphics, ImageObserver observer){}

    private void buildEmptySky(){}

    private void drawMobile(IMobile mobile, Graphics graphics, ImageObserver observer){}

    public int getGlobalWidth(){
        return 0;
    }
    public int getGlobalHeight(){
        return 0;
    }

}

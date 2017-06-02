package jpu2016.dogfight.view;

import javafx.scene.transform.Scale;
import jpu2016.dogfight.model.IArea;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.dogfight.model.IMobile;
import jpu2016.gameframe.IGraphicsBuilder;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class GraphicsBuilder implements IGraphicsBuilder{
    private BufferedImage emptySky;
    private IDogfightModel dogfightModel;

    public GraphicsBuilder (IDogfightModel dogfightModel){
        this.dogfightModel = dogfightModel;
        this.buildEmptySky();
    }

    public IDogfightModel getDogfightModel() {
        return dogfightModel;
    }

    public BufferedImage getEmptySky() {
        return emptySky;
    }

    public void applyModelToGraphic(Graphics graphics, ImageObserver observer){
        IArea area = this.dogfightModel.getArea();

        Graphics emptySkyGraphic = this.emptySky.getGraphics();
        emptySkyGraphic.drawImage(area.getImage(), 0, 0, area.getDimention().getWidth(), area.getDimention().getHeight(), null);

        graphics.drawImage(area.getImage(), 0, 0, area.getDimention().getWidth(), area.getDimention().getHeight(), observer);

        ArrayList<IMobile> mobiles = this.dogfightModel.getMobiles();

        for(IMobile mobile: mobiles ){
            this.drawMobile(mobile, graphics, observer);
        }
    }

    private void buildEmptySky(){
        IArea area = this.dogfightModel.getArea();
        this.emptySky = new BufferedImage(area.getDimention().getWidth(), area.getDimention().getHeight(), Transparency.TRANSLUCENT);
    }

    public int getGlobalWidth(){
        return this.dogfightModel.getArea().getDimention().getWidth();
    }
    public int getGlobalHeight(){
        return this.dogfightModel.getArea().getDimention().getHeight();
    }

    private void drawMobile(final IMobile mobile, final Graphics graphics, final ImageObserver observer) {
        BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);
        final Graphics graphicsMobile = imageMobile.getGraphics();

        double rotationRequired;

        switch (mobile.getDirection()){
            case UP:
                rotationRequired = Math.toRadians(-90);
                break;
            case DOWN:
                rotationRequired = Math.toRadians(90);
                break;
            case LEFT:
                rotationRequired = Math.toRadians(180);
                break;
            case RIGHT:
                rotationRequired = Math.toRadians(0);
                break;
            default:
                rotationRequired = Math.toRadians(0);
        }

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, mobile.getWidth()/2, mobile.getHeight()/2);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer);

        imageMobile = op.filter(imageMobile, null);

        graphics.drawImage(imageMobile, mobile.getPosition().x, mobile.getPosition().y, observer);

        final boolean isHorizontalOut = (mobile.getPosition().getX() + mobile.getWidth()) > this.dogfightModel.getArea().getDimention().getWidth();
        final boolean isVerticalOut = (mobile.getPosition().getY() + mobile.getHeight()) > this.dogfightModel.getArea().getDimention().getHeight();

        if (isHorizontalOut){
            final BufferedImage imageMobileH = imageMobile.getSubimage(this.dogfightModel.getArea().getDimention().getHeight()- mobile.getPosition().x, 0, (mobile.getWidth() - this.dogfightModel.getArea().getDimention().getWidth()) + mobile.getPosition().x, mobile.getHeight());
               graphics.drawImage(imageMobileH, 0, mobile.getPosition().y, observer);
        }
        if (isVerticalOut){
            final BufferedImage imageMobileV = imageMobile.getSubimage(0, this.dogfightModel.getArea().getDimention().getHeight() - mobile.getPosition().y, mobile.getWidth(),(mobile.getHeight() - this.dogfightModel.getArea().getDimention().getHeight()) + mobile.getPosition().y);
            graphics.drawImage(imageMobileV, mobile.getPosition().x, 0, observer);
        }
        if (isHorizontalOut && isVerticalOut) {
           final BufferedImage imageMobileHV = imageMobile.getSubimage(this.dogfightModel.getArea().getDimention().getWidth() - mobile.getPosition().x, this.dogfightModel.getArea().getDimention().getHeight() - mobile.getPosition().y, (mobile.getWidth() - this.dogfightModel.getArea().getDimention().getWidth()) + mobile.getPosition().x, (mobile.getHeight() - this.dogfightModel.getArea().getDimention().getHeight()) + mobile.getPosition().y);
           graphics.drawImage(imageMobileHV, 0, 0, observer);
        }
    }

}

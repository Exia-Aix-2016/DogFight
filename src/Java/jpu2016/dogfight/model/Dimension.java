package jpu2016.dogfight.model;

/**
 * Created by Mandel on 31/05/2017.
 */
public class Dimension {

    private int width;
    private int height;


    public Dimension(final int width, final int height){

        this.height = height;
        this.width = width;

    }
    public Dimension(Dimension dimension){

        this.width = dimension.getWidth();
        this.height = dimension.getHeight();
    }
    //Assesseur
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    //Mutateur
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}

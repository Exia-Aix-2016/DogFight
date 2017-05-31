package jpu2016.dogfight.model;

/**
 * Dimension objet
 * @author Mandel Vaubourg
 * @version 1.0
 */
public class Dimension {

    /**
     * Largeur
     * */
    private int width;
    /**
     * Hauteur
     * */
    private int height;


    /**
     * @param height Hauteur
     * @param width Largeur
     * */
    public Dimension(final int width, final int height){

        this.height = height;
        this.width = width;

    }
    /**
     * @param dimension Objet Dimension
     * @see Dimension
     * */
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

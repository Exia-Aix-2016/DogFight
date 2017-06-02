package jpu2016.dogfight.model;

/**
 * Created by Mandel on 31/05/2017.
 */
public class Position {

    /**
     * Position en x
     * */
    private double x;
    /**
     * Position en y
     * */
    private double y;

    /**
     * Position max en x
     * */
    private double maxX;
    /**
     * Position max en y
     * */
    private double maxY;


    public Position(final double x, final double y, final double maxX, final double maxY){
        this.setMaxX(maxX);
        this.setMaxY(maxY);
        this.setX(x);
        this.setY(y);
    }
    //Mutateur
    public void setX(double x) {
        if (x < 0){
            this.x = this.getMaxX() + x;
        } else {
            this.x = x % this.getMaxX();
        }
    }

    public void setY(double y) {
        this.y = y % this.getMaxY();
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    //Assesseur
    public double getMaxX() {
        return maxX;
    }
    public double getMaxY() {
        return maxY;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}

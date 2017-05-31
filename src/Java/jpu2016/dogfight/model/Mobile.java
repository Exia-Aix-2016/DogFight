package jpu2016.dogfight.model;

import java.awt.*;

/**
 * Mobile class
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public abstract class Mobile implements IMobile {

    private int speed;
    private Image Fimage;

    private Direction direction;
    private Dimension dimension;
    private Position position;
    private String filenameIMG;

    Mobile(Direction direction, Position position, Dimension dimension, int speed, final String image){

        this.direction = direction;
        this.position = position;
        this.dimension = dimension;
        this.speed = speed;
        this.filenameIMG = image;

    }

    public void moveUP(){
        this.direction = Direction.UP;
    }
    public void moveDOWN(){
        this.direction = Direction.DOWN;
    }
    public void moveRIGHT(){
        this.direction = Direction.RIGHT;
    }
    public void moveLEFT(){
        this.direction = Direction.LEFT;
    }
    @Override
    public void move() {

    }
    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setDirection(Direction direction) {

    }

    @Override
    public Point getPosition() {
        Point point = new Point();
        point.setLocation(this.position.getX(), this.position.getY());
        return point;
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public int getWidth() {
        return this.getDimension().getWidth();
    }

    @Override
    public int getHeight() {
        return this.getDimension().getHeight();
    }

    @Override
    public int getSpeed() {
        return this.speed;
    }

    @Override
    public Image getImage() {
        return this.Fimage;
    }


    /**
     * A IMPLEMENTER
     * */
    @Deprecated
    @Override
    public void placeInArea(IArea area) {

    }

    @Override
    public abstract boolean isPlayer(int player);

    /**
     * A IMPLEMENTER
     * */
    @Deprecated
    @Override
    public void setDogfightModel(DogfightModel dogfightModel) {

        this.position.setMaxY(dogfightModel.getPosition().getMaxY());
        this.position.setMaxX(dogfightModel.getPosition().getMaxX());
        dogfightModel.addMobile(this);

    }
    @Override
    public abstract boolean hit();

    @Override
    public abstract boolean isWeapon();

    /**
     * ??? a IMPLEMENTER
     * */
    @Deprecated
    public Color getColor(){
        return new Color(0000);
    }
}

package jpu2016.dogfight.model;

import java.awt.*;

/**
 * Created by Mandel on 31/05/2017.
 */
public class Mobile implements IMobile {

    private int speed;
    private Image image;

    private Direction direction;
    private Dimension dimension;
    private Position position;

    Mobile(Direction direction, Position position, Dimension dimension, int speed, final String image){

        this.direction = direction;
        this.position = position;
        this.dimension = dimension;
        this.speed = speed;

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
        return null;
    }

    @Override
    public Dimension getDimension() {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public Image getImage() {
        return null;
    }



    @Override
    public void placeInArea(IArea area) {

    }

    @Override
    public boolean isPlayer(int player) {
        return false;
    }

    @Override
    public void setDogfightModel(DogfightModel dogfightModel) {

    }

    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }

    public Color getColor(){
        return null;
    }
}

package jpu2016.dogfight.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Mobile class
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public abstract class Mobile implements IMobile {

    private int speed;
    private Image Fimage;

    protected Direction direction;
    protected Dimension dimension;
    protected Position position;
    private String filenameIMG;
    protected DogfightModel dogfightModel;
    protected boolean hit = false;

    Mobile(Direction direction, Position position, Dimension dimension, int speed, final String image){
        this.direction = direction;
        this.position = position;
        this.dimension = dimension;
        this.speed = speed;
        this.filenameIMG = image;

        //Chargement de l'image
        try{
            this.loadImage();
        }catch (Exception e){
            System.out.println(e);
        }


    }

    private void loadImage() throws IOException{
        InputStream in = getClass().getResourceAsStream(filenameIMG);
        this.setImage(ImageIO.read(in));
    }
    public void setImage(Image image){
        this.Fimage = image;

    }
    //MOUVEMENT
    /**
     * Avancer en haut
     * */
    public void moveUP(){
        this.direction = Direction.UP;
        this.move();
    }
    /**
     * Avancer en bas
     * */
    public void moveDOWN(){
        this.direction = Direction.DOWN;
        this.move();
    }

    /**
     * Avancer vers la droite
     * */
    public void moveRIGHT(){
        this.direction = Direction.RIGHT;
        this.move();
    }

    /**
     * Avancer vers la gauche
     * */
    public void moveLEFT(){
        this.direction = Direction.LEFT;
        this.move();
    }

    /**
     * Permet de faire avancer l'objet Mobile dans la direction
     * */
    @Override
    public void move() {
        double y = this.getPosition().getY();
        double x = this.getPosition().getX();

        switch (this.direction){
            case UP:
                this.getPositions().setY(y - this.getSpeed());
                break;

            case DOWN:
                this.getPositions().setY(y + this.getSpeed());
                break;
            case RIGHT:
                this.getPositions().setX(x + this.getSpeed());
                break;
            case LEFT:
                this.getPositions().setX(x - this.getSpeed());
                break;
        }
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Il est préfèrable d'utiliser les méthode move#()
     * */
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;

    }

    @Override
    public Point getPosition() {
        Point point = new Point();
        point.setLocation(this.position.getX(), this.position.getY());
        return point;
    }

    @Override
    public Position getPositions(){
        return this.position;
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

    @Override
    public void setDogfightModel(DogfightModel dogfightModel) {
        this.dogfightModel = dogfightModel;

        this.position.setMaxY(dogfightModel.getPosition().getMaxY());
        this.position.setMaxX(dogfightModel.getPosition().getMaxX());
        dogfightModel.addMobile(this);

    }
    @Override
    public void hit(){
        this.hit = true;
    }

    @Override
    public boolean isHit() {
        return hit;
    }

    @Override
    public boolean isWeapon(){
        return false;
    }

    public Color getColor(){
        return new Color(0000);
    }
}

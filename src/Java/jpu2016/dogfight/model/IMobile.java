package jpu2016.dogfight.model;

import java.awt.*;

/**
 * Created by Mandel on 31/05/2017.
 */
public interface IMobile {

    /**
     * @return Direction
     * */
    Direction getDirection();
    /**
     * @param direction Set la direction
     * */
    void setDirection(Direction direction);

    /**
     * @return Position
     * */
    Point getPosition();

    /**
     * @return Dimension
     * */
    Dimension getDimension();

    /**
     * @return width
     * */
    int getWidth();
    /**
     * @return Height
     * */
    int getHeight();
    /**
     * @return speed
     * */
    int getSpeed();
    /**
     * @return image
     * */
    Image getImage();

    /**
     * Permet de move l'objet
     * */
    void move();
    /**
     * Placement dans l'arène
     * */
    void placeInArea(IArea area);
    /**
     * Savoir si l'objet est un joueur
     * */
    boolean isPlayer(final int player);
    /**
     * @param dogfightModel Ajout du module dogFight
     * */
    void setDogfightModel(DogfightModel dogfightModel);

    boolean hit();

    boolean isWeapon();





}

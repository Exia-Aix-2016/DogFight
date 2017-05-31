package jpu2016.dogfight.model;

import java.awt.*;

/**
 * Created by Mandel on 31/05/2017.
 */
public interface IMobile {

    Direction getDirection();

    void setDirection(Direction direction);

    Point getPosition();

    Dimension getDimension();

    int getWidth();

    int getHeight();

    int getSpeed();

    Image getImage();

    void move();

    void placeInArea(IArea area);

    boolean isPlayer(final int player);

    void setDogfightModel(DogfightModel dogfightModel);

    boolean hit();

    boolean isWeapon();





}

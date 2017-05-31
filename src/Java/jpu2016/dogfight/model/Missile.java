package jpu2016.dogfight.model;

/**
 * Missile model
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public class Missile extends Mobile {

    private static final int SPEED = 4;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 10;
    private static String image = "missile.png";
    private static int MAX_DISTANCE_TRAVELED = 1400;
    private int distance_traveled = 0;

    /**
     * Missile construct
     * @param dimension Set dimension
     * @param direction Set Direction
     * */
    Missile(Direction direction, Dimension dimension){
        super(direction, null, dimension, SPEED, image);
    }

    public static int getWidthWithADirection(Direction direction){
        return 0;
    }

    public static int getHeightWithADirection(Direction direction){
        return 0;
    }

    @Override
    public void move(){

    }
    public boolean hit(){
        return true;
    }
    @Override
    public boolean isWeapon() {
        return true;
    }
}

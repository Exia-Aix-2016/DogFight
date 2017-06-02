package jpu2016.dogfight.model;

/**
 * Missile model
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public class Missile extends Mobile {

    private static final int SPEED = 10;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 10;
    private static String image = "missile.png";
    private static int MAX_DISTANCE_TRAVELED = 1400;
    private int distance_traveled = 0;

    /**
     * @see Mobile
     * */
    @Deprecated
    public Missile(Direction direction, Dimension dimension){
        super(direction, null, dimension, SPEED, image);
    }
    /**
     * @see Mobile
     * */
    public Missile(Direction direction, Position position){
        super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, image);
    }
    public static int getWidthWithADirection(Direction direction){
        return 0;
    }

    public static int getHeightWithADirection(Direction direction){
        return 0;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getWIDTH() {
        return WIDTH;
    }
    @Override
    public void move(){
        super.move();
        this.distance_traveled += SPEED;
        if(this.distance_traveled == MAX_DISTANCE_TRAVELED){
            this.hit();
        }


    }

    @Override
    public boolean isWeapon() {
        return true;
    }

    @Override
    public boolean isPlayer(int player) {
        return false;
    }
}

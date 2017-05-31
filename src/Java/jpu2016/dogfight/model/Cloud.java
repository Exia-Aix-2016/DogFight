package jpu2016.dogfight.model;

/**
 * Représente les nuages
 * @author Mandel Vaubourg
 * @version 1.0
 */
public class Cloud extends Mobile{

    private static final int SPEED = 1;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 150;
    private static String image = "cloud.png";

    Cloud(Direction direction, Dimension dimension){
        super(direction, null, dimension, SPEED, image);
    }
    Cloud(Direction direction){
        super(direction, null, new Dimension(WIDTH, HEIGHT), SPEED, image);
    }
    @Override
    public boolean hit() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
    @Override
    public boolean isPlayer(int player) {
        return false;
    }
}

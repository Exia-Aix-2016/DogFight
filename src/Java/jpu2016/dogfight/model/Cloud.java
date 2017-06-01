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

    /**
     * @see Mobile
     * */
    public Cloud(Direction direction, Position position){
        super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, image);
    }
    @Override
    public boolean isPlayer(int player) {
        return false;
    }
}

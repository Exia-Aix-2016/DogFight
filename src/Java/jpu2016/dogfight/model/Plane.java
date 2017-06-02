package jpu2016.dogfight.model;

/**
 * Plane model
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public class Plane extends Mobile {

    private static final int SPEED = 5;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;
    private int player;


    public Plane(final int player, Direction direction, Position position, final String nameImage){
        super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED, nameImage);
        this.player = player;
    }

    public boolean isPlayer(final int player){
        return this.player == player;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
}

package jpu2016.dogfight.model;

/**
 * Plane model
 * @author Mandel Vaubourg
 * @version 1.0
 * */
public class Plane extends Mobile {

    private static final int SPEED = 2;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 30;
    private static final String IMAGE = "plane.png";
    private int player;


    public Plane(final int player, Direction direction, Position position, final String image){
        super(direction, position, new Dimension(WIDTH, HEIGHT), SPEED,  IMAGE);

    }

    public boolean isPlayer(final int player){
        return this.player == player;
    }

    @Override
    public boolean hit() {
        this.dogfightModel.removeMobile(this);
        return true;
    }



    @Override
    public boolean isWeapon() {
        return false;
    }
}

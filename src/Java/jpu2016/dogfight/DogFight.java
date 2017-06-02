package jpu2016.dogfight;

import jpu2016.dogfight.controller.DogfightController;
import jpu2016.dogfight.model.*;
import jpu2016.dogfight.view.DogfightView;

public class DogFight {
    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    public static int PLAYER1 = 1;
    public static int PLAYER2 = 2;

    public static void main(String[] args){
        final DogfightModel dogfightModel = new DogfightModel();
        dogfightModel.buildArea(new Dimension(WIDTH, HEIGHT));

        final DogfightController dogfightController = new DogfightController(dogfightModel);
        final DogfightView dogfightView = new DogfightView(dogfightController, dogfightModel , dogfightModel);
        
        dogfightController.setViewSystem(dogfightView);

        dogfightModel.addMobile(new Cloud(Direction.RIGHT, new Position(5, 5,WIDTH,HEIGHT)));
        dogfightModel.addMobile(new Cloud(Direction.LEFT, new Position(40, 150,WIDTH,HEIGHT)));
        dogfightModel.addMobile(new Cloud(Direction.RIGHT, new Position(100, 400,WIDTH,HEIGHT)));

        dogfightModel.addMobile(new Plane(PLAYER1, Direction.RIGHT, new Position(0, 200,WIDTH,HEIGHT),  "plane1.png"));
        dogfightModel.addMobile(new Plane(PLAYER2, Direction.RIGHT, new Position(HEIGHT, 200,WIDTH,HEIGHT),  "plane2.png"));

        dogfightController.play();
    }
}

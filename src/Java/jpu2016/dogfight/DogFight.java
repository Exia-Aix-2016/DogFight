package jpu2016.dogfight;

import jpu2016.dogfight.controller.DogfightController;
import jpu2016.dogfight.model.*;
import jpu2016.dogfight.view.DogfightView;

public class DogFight {
    public static void main(String[] args){
        final DogfightModel dogfightModel = new DogfightModel();
        dogfightModel.buildArea(new Dimension(800, 800));

        final DogfightController dogfightController = new DogfightController(dogfightModel);
        final DogfightView dogfightView = new DogfightView(dogfightController, dogfightModel , dogfightModel);
        
        dogfightController.setViewSystem(dogfightView);

        dogfightModel.addMobile(new Cloud(Direction.RIGHT, new Position(5, 5,5,5)));
        dogfightController.play();
    }
}

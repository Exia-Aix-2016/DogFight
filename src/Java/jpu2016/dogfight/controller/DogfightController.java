package jpu2016.dogfight.controller;

import jpu2016.dogfight.model.*;
import jpu2016.dogfight.view.IViewSystem;

import java.util.ArrayList;
import java.util.Optional;

public class DogfightController implements IOrderPerformer {
    private static int TIME_SLEEP = 30;
    private IViewSystem viewSystem;
    private IDogfightModel dogfightModel;

    public DogfightController(IDogfightModel dogfightModel){
        this.dogfightModel = dogfightModel;
    }

    @Override
    public void orderPerform(UserOrder userOrder){
        IMobile mobile = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer());

        switch (userOrder.getOrder()){
            case UP:
                mobile.setDirection(Direction.UP);
                break;
            case RIGHT:
                mobile.setDirection(Direction.RIGHT);
                break;
            case DOWN:
                mobile.setDirection(Direction.DOWN);
                break;
            case LEFT:
                mobile.setDirection(Direction.LEFT);
                break;
            case SHOOT:
                this.lauchMissile(userOrder.getPlayer());
                break;
            case NOP:
                break;
        }
    }

    public void play(){

    }

    public void setViewSystem(IViewSystem viewSystem){
        this.viewSystem = viewSystem;
    }

    private void lauchMissile(int player){
        IMobile plane = this.dogfightModel.getMobileByPlayer(player);
        Direction direction = plane.getDirection();
        Position position = plane.getPositions();

        IMobile missile = new Missile(direction, position);
        this.dogfightModel.addMobile(missile);
    }

    private Optional<Plane> isWeaponOnMobile(Missile missile){

        ArrayList<IMobile> mobiles = this.dogfightModel.getMobiles();

        for (IMobile mobile: mobiles){
            if (mobile instanceof Plane){
                return Optional.of((Plane) mobile);
            }
        }

        return Optional.empty();
    }

    private void manageCollision(Missile missile, Plane plane){
        missile.hit();
        plane.hit();
    }

    private void gameLoop(){

    }
}

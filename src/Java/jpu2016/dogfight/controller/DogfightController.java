package jpu2016.dogfight.controller;

import jpu2016.dogfight.model.*;
import jpu2016.dogfight.view.IViewSystem;

import java.awt.*;
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

                int mX1 = missile.getPosition().x;
                int mX2 = mX1 + missile.getWidth();
                int mY1 = missile.getPosition().y;
                int mY2 = mY1 + missile.getHeight();
                Rectangle m = new Rectangle(mX1, mY1, mX2, mY2);

                int pX1 = mobile.getPosition().x;
                int pX2 = pX1 + mobile.getWidth();
                int pY1 = mobile.getPosition().y;
                int pY2 = pY1 + mobile.getHeight();
                Rectangle p = new Rectangle(pX1, pY1, pX2, pY2);

                if (m.intersects(p)){
                    return Optional.of((Plane) mobile);
                }
            }
        }

        return Optional.empty();
    }

    private void manageCollision(Missile missile, Plane plane){
        missile.hit();
        plane.hit();
    }

    private void gameLoop(){
        while (true){
            ArrayList<IMobile> mobiles = this.dogfightModel.getMobiles();
            for (IMobile mobile: mobiles){
                mobile.move();
                if (mobile instanceof Missile){
                    Optional<Plane> hit = isWeaponOnMobile((Missile) mobile);
                    if (hit.isPresent()){
                        this.manageCollision((Missile) mobile, hit.get());
                        break;
                    }
                }
            }
        }
    }
}

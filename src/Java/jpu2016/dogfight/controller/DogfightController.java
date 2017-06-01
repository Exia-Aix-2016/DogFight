package jpu2016.dogfight.controller;

import jpu2016.dogfight.model.*;
import jpu2016.dogfight.view.IViewSystem;

import java.util.ArrayList;

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
        this.gameLoop();
        this.viewSystem.displayMessage("Game Over");
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

    private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
        if (((weapon.getPosition().getX() / weapon.getWidth()) >= (mobile.getPosition().getX() / weapon.getWidth())) && ((weapon.getPosition().getX() / weapon.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth()) / weapon.getWidth()))) {
            if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight()))     && ((weapon.getPosition().getY() / weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / weapon.getHeight()))) {
                return true;
            }
        }  return false;
    }

    private void manageCollision(IMobile missile, IMobile plane){
        missile.hit();
        plane.hit();
    }

    private void gameLoop(){
        while (true){
            ArrayList<IMobile> mobiles = this.dogfightModel.getMobiles();
            ArrayList<IMobile> missiles = new ArrayList<>();
            ArrayList<IMobile> planes = new ArrayList<>();

            for (IMobile mobile: mobiles){
                mobile.move();
                if (mobile instanceof Missile){
                    missiles.add(mobile);
                } else if (mobile instanceof Plane){
                    planes.add(mobile);
                }
            }

            for (IMobile plane: planes){
                for (IMobile missile: missiles){
                    if (this.isWeaponOnMobile(plane, missile)){
                        this.manageCollision(missile, plane);
                        break;
                    }
                }
            }

            try {
                Thread.sleep(this.TIME_SLEEP);
            } catch (Exception e){
                System.err.println(e);
            }
        }
    }
}

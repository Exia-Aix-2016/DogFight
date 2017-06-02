package jpu2016.dogfight.controller;

import jpu2016.dogfight.model.*;
import jpu2016.dogfight.sound.Sound;
import jpu2016.dogfight.view.IViewSystem;

import java.util.ArrayList;
import java.util.Iterator;

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
        Position position = new Position(plane.getPositions());

        switch (direction){
            case RIGHT:
                position.setX(position.getX() + plane.getDimension().getWidth());
                position.setY(position.getY() + (plane.getDimension().getHeight()/2) - (Missile.getHEIGHT()/2));
                break;
            case LEFT:
                position.setY(position.getY() + (plane.getDimension().getHeight()/2) - (Missile.getHEIGHT()/2));
                break;
            case UP:
                position.setY(position.getY() - Missile.getHEIGHT());
                position.setX(position.getX() + (plane.getDimension().getWidth()/2) - (Missile.getWIDTH()/2));
                break;
            case DOWN:
                position.setY(position.getY() + plane.getDimension().getHeight());
                position.setX(position.getX() + (plane.getDimension().getWidth()/2) - (Missile.getWIDTH()/2));
                break;
        }

        IMobile missile = new Missile(direction, position);
        this.dogfightModel.addMobile(missile);
        Sound sound = new Sound();
        sound.playSound("missile");
    }

    private boolean isWeaponOnMobile(final IMobile mobile, final IMobile weapon) {
        if (((weapon.getPosition().getX() / weapon.getWidth()) >= (mobile.getPosition().getX() / weapon.getWidth())) && ((weapon.getPosition().getX() / weapon.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth()) / weapon.getWidth()))) {
            if (((weapon.getPosition().getY() / weapon.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight()))     && ((weapon.getPosition().getY() / weapon.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / weapon.getHeight()))) {
                return true;
            }
        }

        return false;
    }

    private void manageCollision(IMobile missile, IMobile plane){
        missile.hit();
        plane.hit();
    }

    private void gameLoop(){
        boolean gameLoop = true;
        while (gameLoop){
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

            for(Iterator<IMobile> plane = planes.iterator(); plane.hasNext();){
                IMobile avion = plane.next();
                if(avion != null){
                    for(Iterator<IMobile> rocket = missiles.iterator(); rocket.hasNext();){
                        IMobile missile = rocket.next();
                        if(this.isWeaponOnMobile(avion, missile)){
                            this.manageCollision(missile, avion);
                        }
                    }
                }
            }

            for(Iterator<IMobile> iterator = mobiles.iterator(); iterator.hasNext();){
                IMobile mobile = iterator.next();
                if(mobile.isHit()){
                   iterator.remove();
                }
            }

            this.dogfightModel.setMobilesHavesMoved();

            try {
                Thread.sleep(this.TIME_SLEEP);
            } catch (Exception e){
                System.err.println(e);
            }
            if(planes.size() == 0) {
                gameLoop = false;

            }
        }
    }
}

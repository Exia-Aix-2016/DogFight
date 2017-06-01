package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.Order;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

import java.awt.event.KeyEvent;

public  class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer;


    public EventPerformer(IOrderPerformer oderPerformer){
        this.orderPerformer = oderPerformer;
    }

        public void eventPerformer(KeyEvent KeyCode){

    }

    @Deprecated
    private UserOrder keyCodeToUserOrder (int keyCode){
        Order order;

        switch (keyCode){
            case KeyEvent.VK_UP:
                order = Order.UP;
                break;
            case KeyEvent.VK_DOWN:
                order = Order.DOWN;
                break;
            case KeyEvent.VK_LEFT:
                order = Order.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                order = Order.RIGHT;
                break;
            default:
                order = Order.NOP;
        }
        return new UserOrder(1, order);
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {

    }

}

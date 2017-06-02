package jpu2016.dogfight.view;

import com.sun.org.apache.xpath.internal.operations.Or;
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

    private UserOrder keyCodeToUserOrder (int keyCode){
        Order order;
        int player = 1;


        switch (keyCode){
            case KeyEvent.VK_UP:
                order = Order.UP;

                break;
            case KeyEvent.VK_Z:
                order = Order.UP;
                player = 2;
                break;
            case KeyEvent.VK_DOWN:
                order = Order.DOWN;
                break;
            case KeyEvent.VK_S:
                order = Order.DOWN;
                player = 2;
                break;
            case KeyEvent.VK_LEFT:
                order = Order.LEFT;
                break;
            case KeyEvent.VK_Q:
                order = Order.LEFT;
                player = 2;
                break;

            case KeyEvent.VK_RIGHT:
                order = Order.RIGHT;
                break;
            case KeyEvent.VK_D:
                order = Order.RIGHT;
                player = 2;
                break;

            case KeyEvent.VK_SPACE:
                order = Order.SHOOT;
                break;
            case KeyEvent.VK_A:
                order = Order.SHOOT;
                player = 2;
                break;

            default:
                order = Order.NOP;
        }
        return new UserOrder(player, order);
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {
        UserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
        this.orderPerformer.orderPerform(userOrder);
    }

}

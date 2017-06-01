package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.Order;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

import java.awt.event.KeyEvent;

public abstract class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer;


    public EventPerformer(IOrderPerformer oderPerformer){
        this.orderPerformer = oderPerformer;
    }

        public void eventPerformer(KeyEvent KeyCode){

    }

    @Deprecated
    private UserOrder keyCodeToUserOrder (int keyCode){
        switch (keyCode){
            case 72:

                break;
        }

        return new UserOrder();
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {

    }

}

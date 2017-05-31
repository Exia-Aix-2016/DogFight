package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

import java.awt.event.KeyEvent;

public abstract class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer;

    public EventPerformer(){}

    public EventPerformer(IOrderPerformer oderPerformer){}

    public void setOrderPerformer(IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

    public IOrderPerformer getOrderPerformer() {
        return orderPerformer;
    }

    public void eventPerformer(KeyEvent KeyCode){}



    @Deprecated
    private UserOrder keyCodeToUserOrder (int keyCode){
        return null;
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {

    }

}

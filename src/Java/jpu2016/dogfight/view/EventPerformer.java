package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

import java.awt.event.KeyEvent;

public abstract class EventPerformer implements IEventPerformer {
    private IOrderPerformer orderPerformer;

    public EventPerformer(IOrderPerformer oderPerformer){}

    public void eventPerformer(KeyEvent KeyCode){}


    /**
     * A IMPLEMENTER
     * */
    @Deprecated
    private UserOrder keyCodeToUserOrder (int keyCode){
        return null;
    }

    @Override
    public void eventPerform(KeyEvent keyCode) {

    }

}

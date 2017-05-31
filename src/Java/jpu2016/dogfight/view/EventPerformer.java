package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.controller.UserOrder;
import jpu2016.gameframe.IEventPerformer;

import java.awt.event.KeyEvent;

public class EventPerformer extends IEventPerformer {
    private IOrderPerformer orderPerformer;

    public EventPerformer(IOrderPerformer oderPerformer){}

    public void eventPerformer(KeyEvent KeyCode){}

    private UserOrder keyCodeToUserOrder (int keyCode){}

    @Override
    public void eventPerform(KeyEvent keyCode) {

    }

}

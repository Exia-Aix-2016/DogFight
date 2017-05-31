package jpu2016.gameframe;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class GameFrame extends JFrame implements IEventPerformer, KeyListener {

    public GameFrame(String title, IEventPerformer performer, IGraphicsBuilder graphicBuilder, Observable observable){

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent){

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }


    @Override
    public void eventPerform(KeyEvent keyCode) {

    }
}

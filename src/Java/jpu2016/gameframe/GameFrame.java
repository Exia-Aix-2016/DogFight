package jpu2016.gameframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class GameFrame extends JFrame implements KeyListener {
    private IEventPerformer eventPerformer;

    public GameFrame(String title, IEventPerformer performer, IGraphicsBuilder graphicBuilder, Observable observable){
        this.eventPerformer = performer;
        this.setSize(new Dimension(graphicBuilder.getGlobalWidth(), graphicBuilder.getGlobalHeight()));
        this.setTitle(title);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        this.eventPerformer.eventPerform(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

package jpu2016.gameframe;

import jpu2016.dogfight.model.IMobile;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GamePanel extends JPanel implements Observer {
    private Observable observable;
    private IGraphicsBuilder graphicsBuilder;

    public GamePanel(IGraphicsBuilder graphicBuilder){
        this.graphicsBuilder = graphicBuilder;
    }

    @Override
    public void update(Observable observable, Object arg) {
        this.observable = observable;
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);

        IMobile mobile = (IMobile) this.observable;
        this.graphicsBuilder = graphicsBuilder;
    }

}

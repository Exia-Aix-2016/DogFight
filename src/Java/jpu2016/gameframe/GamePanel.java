package jpu2016.gameframe;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GamePanel extends JPanel implements Observer {
    private Observable observable;
    private IGraphicsBuilder graphicsBuilder;

    GamePanel(IGraphicsBuilder graphicBuilder){
        this.graphicsBuilder = graphicBuilder;
    }

    @Override
    public void update(Observable observable, Object arg) {
        this.observable = observable;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
        this.graphicsBuilder.applyModelToGraphic(graphic,this);
    }

}

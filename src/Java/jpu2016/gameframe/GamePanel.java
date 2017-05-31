package jpu2016.gameframe;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GamePanel extends JPanel implements Observer {
    public GamePanel(IGraphicsBuilder graphicBuilder){

    }

    @Override
    public void update(Observable observable, Object arg) {

    }

    @Override
    protected void paintComponent(Graphics graphic) {
        super.paintComponent(graphic);
    }
}

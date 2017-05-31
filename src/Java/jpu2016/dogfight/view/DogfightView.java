package jpu2016.dogfight.view;

import jpu2016.dogfight.controller.IOrderPerformer;
import jpu2016.dogfight.model.IDogfightModel;
import jpu2016.gameframe.GameFrame;

import java.util.Observable;

public class DogfightView implements Runnable, IViewSystem {
    private EventPerformer eventPerformer;
    private GraphicsBuilder graphicsBuilder;
    private GameFrame gameFrame;

    public DogfightView(IOrderPerformer orderPerformer, IDogfightModel dogfightModel, Observable observable){
        
    }

    public void setEventPerformer(EventPerformer eventPerformer) {
        this.eventPerformer = eventPerformer;
    }

    public EventPerformer getEventPerformer() {
        return eventPerformer;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGraphicsBuilder(GraphicsBuilder graphicsBuilder) {
        this.graphicsBuilder = graphicsBuilder;
    }

    public GraphicsBuilder getGraphicsBuilder() {
        return graphicsBuilder;
    }

    @Override
    public void run() {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void closeAll() {

    }
}

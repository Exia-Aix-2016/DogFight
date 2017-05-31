package jpu2016.dogfight.view;

import jpu2016.gameframe.GameFrame;

public class DogfightView implements Runnable, IViewSystem {
    private EventPerformer eventPerformer;
    private GraphicsBuilder graphicsBuilder;
    private GameFrame gameFrame;

    public DogfightView(EventPerformer eventPerformer, GraphicsBuilder graphicsBuilder, GameFrame gameFrame){
        this.eventPerformer = eventPerformer;
        this.graphicsBuilder = graphicsBuilder;
        this.gameFrame = gameFrame;
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

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
        this.eventPerformer = new EventPerformer(orderPerformer);
        this.graphicsBuilder = new GraphicsBuilder(dogfightModel);

        this.gameFrame = new GameFrame("DogFight", this.eventPerformer, this.graphicsBuilder, observable);
    }

    public EventPerformer getEventPerformer() {
        return eventPerformer;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public GraphicsBuilder getGraphicsBuilder() {
        return graphicsBuilder;
    }

    @Override
    public void run() {
        this.graphicsBuilder.applyModelToGraphic(this.gameFrame.getGraphics(), this.gameFrame);
        this.gameFrame.setVisible(true);
    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void closeAll() {

    }
}

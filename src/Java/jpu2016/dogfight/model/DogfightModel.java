package jpu2016.dogfight.model;

import java.util.ArrayList;
import java.util.Observable;

public class DogfightModel extends Observable implements IDogfightModel{

    ArrayList<IMobile> mobiles;
    IArea area;
    Position position;

    public DogfightModel(Position position){
        this.position = position;
        this.mobiles = new ArrayList<>();


    }
    @Override
    public IArea getArea(){
        return this.area;
    }

    @Override
    public void buildArea(Dimension dimension){
       //this.area = new IArea(dimension);
    }

    @Override
    public void addMobile(IMobile mobile){
        this.mobiles.add(mobile);
    }

    @Override
    public void removeMobile(IMobile mobile){

        for(int i = 0; i < this.mobiles.size(); i++){
            if(this.mobiles.get(i) == mobile){
                this.mobiles.remove(i);
                break;
            }
        }
    }

    @Override
    public ArrayList<IMobile> getMobiles(){
        return this.mobiles;

    }

    @Override
    public IMobile getMobileByPlayer(final int player){
        if(this.mobiles.get(player).isPlayer(player)){
            return this.mobiles.get(player);
        }

        return this.mobiles.get(player);

    }

    @Override
    public void setMobilesHavesMoved(){

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

package jpu2016.dogfight.model;

import java.util.ArrayList;

public class DogfightModel implements IDogfightModel {

    ArrayList<IMobile> mobiles;
    IArea area;

    /**
     * Pas encore implémenté
     *
     * */
    @Deprecated
    public DogfightModel(){


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
        return this.mobiles.get(player);

    }

    @Override
    public void setMobilesHavesMoved(){

    }
}

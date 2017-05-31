package jpu2016.dogfight.model;

import java.util.ArrayList;

/**
 * @author Mandel Vaubourg
 * @version 1.0
 * interface
 */
public interface IDogfightModel {

    /**
     * @return IArea retourne l'arène
     * */
    IArea getArea();
    /**
     * Permet de construire l'arène
     * @param dimension Dimension de l'arène
     * */
    void buildArea(Dimension dimension);
    /**
     * Permet de rajouter un élément mobile
     * @param mobile Element à rajouter
     * */
    void addMobile(IMobile mobile);
    /**
     * Permet de supprimer un mobile
     * @param mobile Element à supprimer
     * */
    void removeMobile(IMobile mobile);
    /**
     * @return les mobiles
     * */
    ArrayList<IMobile> getMobiles();
    /**
     * @return Le mobile correspondant au joueur
     * */
    IMobile getMobileByPlayer(final int player);

    void setMobilesHavesMoved();



}

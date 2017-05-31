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

    /**
     * @return Position du DogfightModel
     * */
    Position getPosition();

    /**
     * @param position Set la position du dogfightModel
     * */
    void setPosition(Position position);

    /**
     * @param y Set la position en y
     * @param x Set la position en x
     * */
    void setPosition(final double x, final double y);

    /**
     * @param y Set la position en y
     * @param x Set la position en x
     * @param maxX Set la position max en x
     * @param maxY Set la position max en y
     * */
    void setPosition(final double x, final double y, final double maxX, final double maxY);



}

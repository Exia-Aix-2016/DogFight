package jpu2016.dogfight.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Executable;

/**
 * Sky Model (arrière plan du jeu)
 * @author Mandel Vaubourg
 * @version 1.0
 */
public class Sky implements IArea{

    private Dimension dimension;
    private Image image;
    private static String imageName = "sky.png";
    /**
     * @param dimension défini les dimensions du ciel
     * */
    public Sky(Dimension dimension){

        this.dimension = dimension;

        //Chargement de l'image
        try{
            this.loadImage();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Dimension getDimention(){
        return this.dimension;
    }
    @Override
    public Image getImage(){

        return this.image;
    }
    private void loadImage() throws IOException {
        InputStream in = getClass().getResourceAsStream(imageName);
        this.setImage(ImageIO.read(in));
    }
    public void setImage(Image image){
        this.image = image;

    }
}

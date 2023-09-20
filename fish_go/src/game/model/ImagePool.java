package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Data
public class ImagePool {
    public static BufferedImage backgroundImage;
    public static BufferedImage fishImage;
    public static BufferedImage stickComponentImage;
    public static BufferedImage starfishLargeImage;
    public static BufferedImage starfishSmallImage;

    static {
        try {
            BufferedImage backgroundOriginal = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/sea.png"));
            backgroundImage = resize(backgroundOriginal, 750, 500);

            fishImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/fish.png"));
            stickComponentImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/stickComponent.png"));
            starfishLargeImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/starfishLarge.png"));
            starfishSmallImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/starfishSmall.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static BufferedImage resize(BufferedImage bi, int targetWidth, int targetHeight) {
        BufferedImage newImg = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        newImg.getGraphics().drawImage(bi.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH), 0, 0, null);
        return newImg;
    }
}

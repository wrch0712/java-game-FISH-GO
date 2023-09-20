package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Data
public class StarfishLarge {
    private BufferedImage starfishLarge = ImagePool.starfishLargeImage;
    private int x = 750 - starfishLarge.getWidth();
    private int y;
    private final int speed = 2;

    public StarfishLarge(Stick stick) {
        generateStarfishLarge(stick);
    }


    public void generateStarfishLarge(Stick stick) {
        Random random = new Random();
        y = random.nextInt(500 - starfishLarge.getHeight() - 30) + 20;
        Rectangle stickRec = new Rectangle(stick.getX(), stick.getY(), stick.getStickComponent().getWidth(), stick.getLength());
        Rectangle starfishLargeRec = new Rectangle(x - 10, y - 10, starfishLarge.getWidth() + 20, starfishLarge.getHeight() + 20);
        if (starfishLargeRec.intersects(stickRec)) {
            generateStarfishLarge(stick);
        }
    }

    public void drawStarfishLarge(Graphics g) {
        g.drawImage(starfishLarge, x, y, null);
        x -= speed;
    }

}

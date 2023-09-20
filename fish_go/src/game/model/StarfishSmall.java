package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Data
public class StarfishSmall {
    private BufferedImage starfishSmall = ImagePool.starfishSmallImage;
    private int x = 750 - starfishSmall.getWidth();
    private int y;
    private final int speed = 2;

    public StarfishSmall(Stick stick) {
        generateStarfishSmall(stick);
    }


    public void generateStarfishSmall(Stick stick) {
        Random random = new Random();
        y = random.nextInt(500 - starfishSmall.getHeight() - 30) + 20;
        Rectangle stickRec = new Rectangle(stick.getX(), stick.getY(), stick.getStickComponent().getWidth(), stick.getLength());
        Rectangle starfishSmallRec = new Rectangle(x - 10, y - 10, starfishSmall.getWidth() + 20, starfishSmall.getHeight() + 20);
        if (starfishSmallRec.intersects(stickRec)) {
            generateStarfishSmall(stick);
        }
    }

    public void drawStarfishSmall(Graphics g) {
        g.drawImage(starfishSmall, x, y, null);
        x -= speed;
    }
}

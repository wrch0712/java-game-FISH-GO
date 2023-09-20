package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;

@Data
public class Fish {
    private BufferedImage fish = ImagePool.fishImage;
    private int x = 200;
    private int y = 200;
    private int speed = 1;
    private int life = 3;
    private int score = 0;


    public void up() {
        if (y <= 30) {
            //y = 500 - fish.getHeight();
            y = 480;
        }
        y -= 25;
    }

    public void down() {
        if (y >= 500 - fish.getHeight()) {
            y = 10;
        }
        y += 25;
    }

    public void speedup(){
        if (speed < 3){
            speed += 1;
        }
    }

    public void speeddown(){
        if (speed > 0){
            speed -= 1;
        }
    }

    public void drawFish(Graphics g) {
        g.drawImage(fish, x, y, null);
        x += speed;
        if (x + fish.getWidth() > 750) {
            x = 5;
        }
    }
}

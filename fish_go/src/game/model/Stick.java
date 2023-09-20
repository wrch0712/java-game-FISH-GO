package edu.uchicago.gerber._08final.myGame_fishGo.model;

import lombok.Data;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Data
public class Stick {
    private BufferedImage stickComponent = ImagePool.stickComponentImage;
    private int x = 750 - stickComponent.getWidth();
    private int y;
    private int length;
    private final int speed = 2;

    public Stick() {
        generateStick();
    }

    public Stick(int x) {
        this.x = x;
        generateStick();
    }

    private void generateStick() {
        Random random = new Random();
        length = random.nextInt(200) + 100;
        y = random.nextInt(500-length);
    }

    public void drawStick(Graphics g) {
        int count = length / stickComponent.getHeight();
        for (int i = 0; i < count; i++) {
            g.drawImage(stickComponent, x, y + i * stickComponent.getHeight(), null);
        }
        x -= speed;
    }
}

package edu.uchicago.gerber._08final.myGame_fishGo.view;

import edu.uchicago.gerber._08final.myGame_fishGo.controller.GameLayer;
import edu.uchicago.gerber._08final.myGame_fishGo.model.Fish;
import edu.uchicago.gerber._08final.myGame_fishGo.model.ImagePool;
import edu.uchicago.gerber._08final.myGame_fishGo.model.Timer;

import java.awt.*;

/*
DrawUtil provide several methods that draw graph on the frame
 */

public class DrawUtil {

    public static void drawGame(Graphics g, Fish fish, GameLayer layer, Timer timer){
        fish.drawFish(g);
        try {
            layer.draw(g, fish);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //draw life on the frame
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Life: " + fish.getLife(), 30, 60);

        //draw score on the frame
        g.drawString("Score: " + fish.getScore(), 330, 60);

        //draw time on the frame
        timer.computeTime();
        g.drawString("Time: " + timer.getTime() + " seconds", 570, 60);
    }

    public static void drawStartInstruction(Graphics g){
        g.setColor(new Color(70, 180, 200));
        g.fillRect(0,0,750, 500);
        g.drawImage(ImagePool.fishImage, 100, 80, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Hi! I'm little fish MinMin. Welcome to FishGO!", 170, 110);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawString("I live in the beautiful sea", 110, 150);
        g.setColor(Color.ORANGE);
        g.drawString("There are many sticks in the sea", 110, 185);
        g.drawString("If I hit the stick, I will die", 110, 210);
        g.drawString("I have 3 lives", 110, 235);
        g.drawString("I love starfishes", 110, 270);
        g.drawString("If I eat a small yellow starfish, you will gain 1 point", 110, 295);
        g.drawString("If I eat a large red starfish, you will gain 2 points", 110, 320);
        g.setColor(Color.red);
        g.drawString("Please press ↑ to move up and ↓ to move down", 110, 355);
        g.drawString("Please press → to speed up and ← to speed down", 110, 380);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("READY? PRESS 'SPACE' TO START THE GAME", 105, 430);
    }

    public static void drawEndInstruction(Graphics g, Fish fish, Timer timer){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("GAME OVER", 220, 150);

        //g.setColor(new Color(180, 20, 230));
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 35));
        g.drawString("SCORE: " + fish.getScore(), 290, 240);
        g.drawString("TIME: " + timer.getTime() + " seconds", 230, 290);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 26));
        g.drawString("PRESS 'SPACE' TO RESTART THE GAME", 135, 380);
    }
}

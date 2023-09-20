package edu.uchicago.gerber._08final.myGame_fishGo.controller;

import edu.uchicago.gerber._08final.myGame_fishGo.model.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
GameLayer class combines fish, sticks, starfishes together
it generates sticks and starfishes randomly
and also detect crashes between fishes and sticks, fishes and starfishes
 */

public class GameLayer {
    private List<Stick> sticks = new ArrayList<>();
    private List<StarfishLarge> starfishLarges = new ArrayList<>();
    private List<StarfishSmall> starfishSmalls = new ArrayList<>();

    public void draw(Graphics g, Fish fish) throws Exception {
        for (int i = 0; i < sticks.size(); i++) {
            Stick stick = sticks.get(i);
            if (stick.getX() > 0) {
                stick.drawStick(g);
            } else {
                sticks.remove(i);
                i--;
            }
        }
        for (int i = 0; i < starfishLarges.size(); i++) {
            StarfishLarge starfishLarge = starfishLarges.get(i);
            if (starfishLarge.getX() > 0) {
                starfishLarge.drawStarfishLarge(g);
            } else {
                starfishLarges.remove(i);
                i--;
            }
        }
        for (int i = 0; i < starfishSmalls.size(); i++) {
            StarfishSmall starfishSmall = starfishSmalls.get(i);
            if (starfishSmall.getX() > 0) {
                starfishSmall.drawStarfishSmall(g);
            } else {
                starfishSmalls.remove(i);
                i--;
            }
        }

        fishStickCollide(fish);
        fishStarfishLargeCollide(fish);
        fishStarfishSmallCollide(fish);

        if (sticks.size() == 0) {
            Stick s = new Stick();
            sticks.add(s);
            starfishLarges.add(new StarfishLarge(s));
            starfishLarges.add(new StarfishLarge(s));
            starfishSmalls.add(new StarfishSmall(s));
            starfishSmalls.add(new StarfishSmall(s));
            starfishSmalls.add(new StarfishSmall(s));
        } else {
            if (sticks.get(sticks.size() - 1).getX() < 500) {
                sticks.add(new Stick());
            }
            if (starfishLarges.size() > 0 && starfishLarges.get(starfishLarges.size() - 1).getX() < 550) {
                starfishLarges.add(new StarfishLarge(sticks.get(sticks.size() - 1)));
            }
            if (starfishSmalls.size() > 0 && starfishSmalls.get(starfishSmalls.size() - 1).getX() < 650) {
                starfishSmalls.add(new StarfishSmall(sticks.get(sticks.size() - 1)));
            }
        }
    }

    public void fishStickCollide(Fish fish) throws Exception {
        for (int i = 0; i < sticks.size(); i++) {
            Stick stick= sticks.get(i);
            Rectangle stickRec = new Rectangle(stick.getX(), stick.getY(), stick.getStickComponent().getWidth(), stick.getLength());
            Rectangle fishRec = new Rectangle(fish.getX(), fish.getY(), fish.getFish().getWidth(), fish.getFish().getHeight());
            if (fishRec.intersects(stickRec)) {
                new SoundPool(SoundPool.crashPath).start();
                fish.setLife(fish.getLife() - 1);
                sticks.remove(i);
            }
        }
    }

    public void fishStarfishLargeCollide(Fish fish) throws Exception {
        for (int i = 0; i < starfishLarges.size(); i++) {
            StarfishLarge starfish= starfishLarges.get(i);
            Rectangle starfishLargeRec = new Rectangle(starfish.getX(), starfish.getY(), starfish.getStarfishLarge().getWidth(), starfish.getStarfishLarge().getHeight());
            Rectangle fishRec = new Rectangle(fish.getX(), fish.getY(), fish.getFish().getWidth(), fish.getFish().getHeight());
            if (fishRec.intersects(starfishLargeRec)) {
                new SoundPool(SoundPool.scorePath).start();
                fish.setScore(fish.getScore() + 2);
                starfishLarges.remove(i);
            }
        }
    }

    public void fishStarfishSmallCollide(Fish fish) throws Exception {
        for (int i = 0; i < starfishSmalls.size(); i++) {
            StarfishSmall starfishSmall= starfishSmalls.get(i);
            Rectangle starfishSmallRec = new Rectangle(starfishSmall.getX(), starfishSmall.getY(), starfishSmall.getStarfishSmall().getWidth(), starfishSmall.getStarfishSmall().getHeight());
            Rectangle fishRec = new Rectangle(fish.getX(), fish.getY(), fish.getFish().getWidth(), fish.getFish().getHeight());
            if (fishRec.intersects(starfishSmallRec)) {
                new SoundPool(SoundPool.scorePath).start();
                fish.setScore(fish.getScore() + 1);
                starfishSmalls.remove(i);
            }
        }
    }
}

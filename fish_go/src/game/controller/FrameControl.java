package edu.uchicago.gerber._08final.myGame_fishGo.controller;

import edu.uchicago.gerber._08final.myGame_fishGo.model.*;
import edu.uchicago.gerber._08final.myGame_fishGo.model.Timer;
import edu.uchicago.gerber._08final.myGame_fishGo.view.DrawUtil;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;

/*
FrameControl draw the basic frame (with help of methods in DrawUtil in View)
and add KeyListener to control the game
 */

public class FrameControl extends JFrame implements KeyListener, Runnable {

    private Fish fish = new Fish();
    private GameLayer layer = new GameLayer();
    private Thread thread = new Thread(this);
    private Timer timer = new Timer();
    private boolean gameBegin = false;


    public FrameControl() {
        this.setSize(750, 500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Fish_Go");
        timer.begin();

        repaint();
        thread.start();
    }


    @Override
    public void paint(Graphics g) {
        //draw background
        if (!gameBegin) {
            // instruction before the game
            DrawUtil.drawStartInstruction(g);
        } else {
            g.drawImage(ImagePool.backgroundImage, 0, 0, this);
            if (fish.getLife() > 0) {
                // draw the game
                DrawUtil.drawGame(g, fish, layer, timer);
            } else {
                // game over
                DrawUtil.drawEndInstruction(g, fish, timer);
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameBegin && e.getKeyCode() == KeyEvent.VK_SPACE) {
            try {
                new SoundPool(SoundPool.startPath).start();
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            gameBegin = true;
        } else if (fish.getLife() == 0 && e.getKeyCode() == KeyEvent.VK_SPACE) {
            try {
                restart();
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            fish.up();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            fish.down();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            fish.speedup();
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            fish.speeddown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void restart() throws LineUnavailableException {
        try {
            new SoundPool(SoundPool.startPath).start();
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        fish = new Fish();
        layer = new GameLayer();
        timer = new Timer();
        timer.begin();
    }
}

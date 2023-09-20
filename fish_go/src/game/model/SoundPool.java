package edu.uchicago.gerber._08final.myGame_fishGo.model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundPool extends Thread{
    public static final String crashPath = System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/crash.wav";
    public static final String scorePath = System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/getScore.wav";
    public static final String startPath = System.getProperty("user.dir") + "/src/main/resources/fishGo_resource/start.wav";
    AudioClip ac;

    public SoundPool(String path) throws MalformedURLException {
        URL url = new File(path).toURI().toURL();
        ac = Applet.newAudioClip(url);
    }

    public void startSound(){
        ac.play();
    }


    @Override
    public void run(){
        startSound();
    }


}

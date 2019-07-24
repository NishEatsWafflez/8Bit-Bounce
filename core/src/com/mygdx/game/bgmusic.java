package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class bgmusic {
    Music bitmusic;

    //constructor
    public bgmusic () {
        bitmusic = Gdx.audio.newMusic(Gdx.files.internal("8bitmusic.mp3"));
    }

    //music play method
    public void play() {
        bitmusic.setLooping(true);
        bitmusic.play();
    }

    //music stop method
    public void stop(){
        bitmusic.stop();
    }

    public void pause(){
        bitmusic.pause();
    }

}

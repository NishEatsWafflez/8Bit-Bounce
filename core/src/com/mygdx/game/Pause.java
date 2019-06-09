package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Pause{
    Texture pauseScreen;
    Boolean gamePause;
    int x;
    int y;
    int width;
    int height;
    int x2;
    int y2;
    int width2;
    int height2;
    Texture pauseText;
    int pauseCounter;
    int xvel;
    int yvel;


    //constructor
    public Pause(/*int width, int height, int x, int y, int xvel, int yvel, Texture texture,*/ SpriteBatch batch) {

        x = 250;
        y = 400;
        width = 500;
        height = 200;
        pauseScreen = new Texture(Gdx.files.internal("purple.png"));
        pauseText = new Texture(Gdx.files.internal("pauseText.png"));
        x2 = 250;
        y2 = 250;
        width2 = 500;
        height2 = 400;
        gamePause = false;
        pauseCounter = 0;
    }


    public void render() {

    }


    //enables and disables pause screen
    public void setPause () {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)){
            System.out.println("yeet");
            //pauseCounter++;
            if (!gamePause){
                gamePause = true;
            } else {
                gamePause = false;
            }

        }
       // System.out.println(gamePause);
    }
}

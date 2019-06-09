package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class background {
    Texture blueImage;
    public int  width;
    public int  height;
    public static long x;
    public static long y;
    double xvel;


    //constructor
    public background (long x, int y, int width, int height, Texture blueImage){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.blueImage = blueImage;
        //blueImage = new Texture("clouds4.png");
        xvel = -2.5;
        //x = 0;
        //y = 0;
        //width = 1200;
        //height = 1000;
    }

    //method for movement
    public void update () {
        this.x += xvel;
    }

    //render background
    public void render(long x, long y, SpriteBatch batch){
        batch.draw(blueImage, this.x, y, width, height);
    }
}

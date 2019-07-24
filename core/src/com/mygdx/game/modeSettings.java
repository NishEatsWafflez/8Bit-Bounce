package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class modeSettings {
    int x;
    int y;
    int width;
    int height;
    Texture texture;
    SpriteBatch batch;
    public modeSettings(int x, int y, int width, int height, Texture texture, SpriteBatch batch){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.batch = batch;
    }
    public void render(){
        batch.draw(texture, x, y, width, height);
    }
}

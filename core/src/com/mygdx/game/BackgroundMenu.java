package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundMenu {
    Texture texture;
    int x;
    int y;
    int width;
    int height;
    SpriteBatch batch;
    public BackgroundMenu (int x, int y, int width, int height, Texture texture, SpriteBatch batch){
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.batch = batch;
    }
    public void render(){
        batch.draw(texture, 300, 375, 300, 240);
    }
}

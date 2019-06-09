package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.Random;


//extends abstract collision class
public class Blocks extends blockEntity {
    static int blocknumber = 4;
    public Texture block;

    //constructor
    public Blocks(/*int width, int height,*/ int x, int y,/* int xvel, int yvel, */Texture texture, SpriteBatch batch) {
        super(210, 80, x, y, -16, 0, new Texture("art (1).png"), batch);
    }

    //moves blocks at set speed
    public void update() {
        xvel = -9;
        this.x += xvel;
    }


    @Override
    public void handleCollision(blockEntity e) {

    }

    //draws blocks
    @Override
    public void render() {
        batch.draw(texture, x, y, width, height);
    }
}


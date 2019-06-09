package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class blockEntity {

    public Texture texture;    //Texture

    public SpriteBatch batch;  //Draw Textures

    public int width;
    public int height;

    public int x;
    public int y;
    public int xvel;
    public int yvel;
    public static ArrayList<blockEntity> blockentities = new ArrayList<blockEntity>();

    //collision class template
    //constructor
    public blockEntity (int width, int height, int x, int y, int xvel, int yvel, Texture texture, SpriteBatch batch) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xvel = xvel;
        this.yvel = yvel;
        this.batch = batch;
        this.texture = texture;
    }

    //defines collision
    public boolean isCollide (blockEntity e) {
        if (x < e.x + e.width &&
                x + width > e.x &&
                y <= e.y + e.height &&
                y> e.y + e.height-30) {
            return true;
        } else {
            return  false;
        }
    }

    //methods for handling collision and rendering
    public abstract void handleCollision(blockEntity e);
    public abstract void render();

}

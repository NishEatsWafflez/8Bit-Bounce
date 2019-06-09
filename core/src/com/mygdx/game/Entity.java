package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Entity {
    public Texture texture;    //Texture

    public SpriteBatch batch;  //Draw Textures

    public int width;
    public int height;

    public int x;
    public int y;
    public int xvel;
    public int yvel;
    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    public Entity (int width, int height, int x, int y, int xvel, int yvel, Texture texture, SpriteBatch batch) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xvel = xvel;
        this.yvel = yvel;
        this.batch = batch;
        this.texture = texture;
    }
    public boolean isCollide (Entity e) {
        if (x < e.x + e.width &&
        x + width > e.x &&
        y < e.y + e.height &&
         height +y > e.y) {
            return true;
        } else {
            return  false;
        }
    }
    public abstract void handleCollision(Entity e);
    public abstract void render();
}

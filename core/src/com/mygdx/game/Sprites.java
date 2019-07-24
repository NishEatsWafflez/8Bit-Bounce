package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.swing.text.StyledEditorKit;

public class Sprites extends blockEntity {
    public Texture guyImage;
    int q;
    Boolean touchState;
    Boolean pointState;
    public int points;
    int jumpCount;
    Boolean readytoBegin;


    //constructor for sprite
    public Sprites(int width, int height, /* int x, int y, int xvel, int yvel,*/ Texture texture, SpriteBatch batch) {
        super(width, height, 40, 700, 0, 16, texture, batch);
        //this.guyImage = guyImage;
        touchState = false;
        pointState = false;
        points = 0;
        jumpCount = 1;
        readytoBegin = false;
    }

    //states what will happen if collision occurs
    //if falls on block from top, stop gravity and teleport to top of box, adds point
    @Override
   public void handleCollision(blockEntity e) {
        if (yvel <= 0) {
            if (!pointState) {
                if (readytoBegin) {
                    points++;
//                    System.out.println(points);
                }
            }
            pointState = true;
            touchState = true;
            jumpCount = 0;
            y = e.y + e.height;
            yvel = 0;
        } else {
            touchState = false;
            pointState = false;
        }
    }

    //movement method: space increases velocity
    public void update() {
        if (y <= 0) {
            yvel = 0;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (jumpCount == 0) {
                if (yvel==0) {
                    if (MainMenuScreen.easy) {
                        yvel = 25;
                    }
                    if (MainMenuScreen.medium){
                        yvel = 23;
                    }
                    if (MainMenuScreen.hard){
                        yvel = 22;
                    }
                    jumpCount++;
                }
            }
        }
        if (!touchState) {
            if (yvel > -12) {
                yvel--;
            }
        } /*else {
            yvel = 0;
        }*/
        if (y <= 0) {
            System.out.println("oof");
        }
        y += yvel;
    }


    //draws sprite
    @Override
    public void render() {
        batch.draw(texture, x, y, width, height);


    }
}

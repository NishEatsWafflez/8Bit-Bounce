package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.graphics.Color;


import java.awt.*;

public class MenuHUD {
    public Stage stage;
    private Viewport viewport;
    Label settingsLabel;
    Label startLabel;
    private BitmapFont font1;
    public Boolean nextScreen;
    public Boolean settings;
    int counter = 0;
   // public  static Boolean cloudsOn;

    public MenuHUD (SpriteBatch sb){

       // cloudsOn = true;
        viewport = new FitViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, new OrthographicCamera());
        stage = new Stage (viewport, sb);

        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));
        settingsLabel = new Label("SETTINGS", new Label.LabelStyle(font1, Color.WHITE));
        startLabel = new Label("START", new Label.LabelStyle(font1, Color.WHITE));

        settingsLabel.setFontScale(1.5f);
        startLabel.setFontScale(1.5f);

        Table displayTable = new Table();
        displayTable.center();
        displayTable.setFillParent(true);

        displayTable.add(startLabel);
        displayTable.row();
        displayTable.add(settingsLabel).padTop(120);

        stage.addActor(displayTable);

        nextScreen = false;
        settings = false;

    }

    public void update(){


        if (Gdx.input.getX()> 435 && Gdx.input.getX() < 565 && (BitBounce.V_HEIGHT-Gdx.input.getY())> 550 && (BitBounce.V_HEIGHT-Gdx.input.getY())< 650){
            startLabel.setFontScale(2.5f);

            if (Gdx.input.isTouched()){
                nextScreen = true;
            }
        } else{
            startLabel.setFontScale(1.5f);
        }
        if (Gdx.input.getX()> 420 && Gdx.input.getX()< 580 && (BitBounce.V_HEIGHT-Gdx.input.getY())> 350 && (BitBounce.V_HEIGHT-Gdx.input.getY())<450){
            settingsLabel.setFontScale(2.5f);

            if (Gdx.input.isTouched()){
                settings = true;
                MainMenuScreen.screen1 = true;
                MainMenuScreen.screen2 = false;
            }
        } else {
            settingsLabel.setFontScale(1.5f);
        }

    }
}

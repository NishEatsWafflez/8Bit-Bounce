package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class creditsHUD {
    public Stage stage;
    private Viewport viewport;
    Label creditsLabel;
    Label plugLabel;
    Label titleBG;
    private BitmapFont font1;
    public Boolean nextScreen;
    public Boolean settings;
    public static Boolean cloudsOn;


    public creditsHUD (SpriteBatch sb1){
        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));
        creditsLabel = new Label("Special Thanks to Therese Rico for creating the Ralph graphics.", new Label.LabelStyle(font1, Color.WHITE));
//        creditsLabel.setPosition(0, 100);
//        creditsLabel.setWidth(200);
//        creditsLabel.setHeight(50);
        creditsLabel.setWrap(true);
//        creditsLabel.pack();
//        creditsLabel.setWidth(5);
//        creditsLabel.setHeight(creditsLabel.getPrefHeight());




        plugLabel = new Label("Find her at twitch.tv/tea_rese or on twitter.com/tea_rese", new Label.LabelStyle(font1, Color.WHITE));
        plugLabel.setWrap(true);
        titleBG = new Label("Credits", new Label.LabelStyle(font1, Color.WHITE));


        viewport = new FitViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb1);

        creditsLabel.setFontScale(1.5f);
        plugLabel.setFontScale(1.5f);
        titleBG.setFontScale(2.75f);

        Table displayTable1 = new Table();
        displayTable1.center();
        displayTable1.setFillParent(true);

        displayTable1.add(titleBG);
        displayTable1.row();
        displayTable1.add(creditsLabel).width(375).padBottom(20);
        displayTable1.row();
        displayTable1.add(plugLabel).padBottom(50).width(375);
//        displayTable1.row();
//        displayTable1.add(forestLabel).padTop(10).padRight(20);
//        displayTable1.row();
//        displayTable1.add(titleMute);
//        displayTable1.row();
//        displayTable1.add(mute).padBottom(70).padRight(190);


        stage.addActor(displayTable1);


    }


}

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

public class bgHUD {
    public Stage stage;
    private Viewport viewport;
    Label cloudsLabel;
    Label forestLabel;
    Label titleBG;
    Label titleMute;
    Label mute;
    private BitmapFont font1;
    public Boolean nextScreen;
    public Boolean settings;
    public static Boolean cloudsOn;


    public bgHUD (SpriteBatch sb1){
        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));
        cloudsLabel = new Label("Clouds Theme", new Label.LabelStyle(font1, Color.WHITE));
        forestLabel = new Label("Forest Theme", new Label.LabelStyle(font1, Color.WHITE));
        titleBG = new Label("Background", new Label.LabelStyle(font1, Color.WHITE));
        titleMute = new Label("Sound", new Label.LabelStyle(font1, Color.WHITE));
        mute = new Label("Mute", new Label.LabelStyle(font1, Color.WHITE));


        viewport = new FitViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb1);

        cloudsLabel.setFontScale(2f);
        forestLabel.setFontScale(2f);
        titleBG.setFontScale(2.75f);
        titleMute.setFontScale(2.75f);
        mute.setFontScale(2f);

        Table displayTable1 = new Table();
        displayTable1.center();
        displayTable1.setFillParent(true);

        displayTable1.add(titleBG);
        displayTable1.row();
        displayTable1.add(cloudsLabel).padRight(30).padBottom(30);
        displayTable1.row();
        displayTable1.add(forestLabel).padTop(10).padRight(20);
        displayTable1.row();
        displayTable1.add(titleMute);
        displayTable1.row();
        displayTable1.add(mute).padBottom(70).padRight(190);


        stage.addActor(displayTable1);


    }


}

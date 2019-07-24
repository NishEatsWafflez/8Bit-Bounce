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
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import sun.security.util.Password;

public class HUD {
    public Stage settingStage;
    public Stage closeStage;
    public Stage stage;
    private Viewport viewport;
    public Integer score;
    Label scoreLabel;
    Label marioLabel;
    private BitmapFont font1;
    Label settingLabel;
    Label closeLabel;


    //constructor
    public HUD (SpriteBatch sb) {
        score = 0;
        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage (viewport, sb);
        settingStage = new Stage (viewport,sb);
        closeStage = new Stage (viewport,sb);

        Table close = new Table();
        close.setFillParent(true);
        Table settings = new Table();
        settings.setFillParent(true);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        String scoro = "potato"+score;
        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));

        scoreLabel = new Label(scoro, new Label.LabelStyle(font1, Color.WHITE));
        marioLabel = new Label("HIGH SCORE:" + PlayScreen.prefs.getInteger("highScore"), new Label.LabelStyle(font1, Color.WHITE));
        settingLabel = new Label("Settings", new Label.LabelStyle(font1, Color.WHITE));
        closeLabel = new Label("CLOSE", new Label.LabelStyle(font1, Color.GRAY));

        closeLabel.setFontScale(2f);
        settingLabel.setFontScale(2f);
        close.add(closeLabel).padLeft(395).padTop(435);
        closeStage.addActor(close);
        settings.top();
        settings.right();
        settings.add(settingLabel).padTop(10).padRight(20);
        settingStage.addActor(settings);


        scoreLabel.setFontScale(2.5f);
        marioLabel.setFontScale(2.5f);

        table.add(marioLabel).expandX().padTop(10);
        //table.add(worldLabel).expandX().padTop(10);
       // table.add(timeLabel).expandX().padTop(10);
        //table.row();
        table.add(scoreLabel).expandX().padTop(10).padRight(70);
        //table.add(levelLabel).expandX();
        //table.add(countdownLabel).expandX();

        stage.addActor(table);
    }

    //updates score labels and high score label
    public void update(String s){
        scoreLabel.setText(s);
    }
    public void hsupdate (String s){
        marioLabel.setText(s);
    }
    public void dispose(){
        stage.dispose();
        font1.dispose();
    }
}

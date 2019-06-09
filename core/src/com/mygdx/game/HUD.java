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

public class HUD {
    public Stage stage;
    private Viewport viewport;
    public Integer score;
    Label scoreLabel;
    Label marioLabel;
    private BitmapFont font1;


    //constructor
    public HUD (SpriteBatch sb) {
        score = 0;
        viewport = new FitViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, new OrthographicCamera());
        stage = new Stage (viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);
        String scorelmao = "potato"+score;
        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));

        scoreLabel = new Label(scorelmao, new Label.LabelStyle(font1, Color.WHITE));
        marioLabel = new Label("HIGH SCORE:" + PlayScreen.prefs.getInteger("highScore"), new Label.LabelStyle(font1, Color.WHITE));



        scoreLabel.setFontScale(2.5f);
        marioLabel.setFontScale(2.5f);

        table.add(marioLabel).expandX().padTop(10);
        //table.add(worldLabel).expandX().padTop(10);
       // table.add(timeLabel).expandX().padTop(10);
        //table.row();
        table.add(scoreLabel).expandX().padTop(10);
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
}

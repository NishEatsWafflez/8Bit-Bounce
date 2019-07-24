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


public class bg2HUD {
    public Stage stage;
    private Viewport viewport;
    Label hardLabel;
    Label medLabel;
    Label easyLabel;
    Label difficulty;
    private BitmapFont font1;

    public bg2HUD(SpriteBatch sb1){

        viewport = new FitViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, sb1);


        font1 = new BitmapFont(Gdx.files.internal("font1.fnt"));
        hardLabel = new Label("Hard", new Label.LabelStyle(font1, Color.WHITE));
        medLabel = new Label("Medium", new Label.LabelStyle(font1, Color.WHITE));
        easyLabel = new Label("Easy", new Label.LabelStyle(font1, Color.WHITE));
        difficulty = new Label("Difficulty", new Label.LabelStyle(font1, Color.WHITE));

        medLabel.setFontScale(2f);
        hardLabel.setFontScale(2f);
        easyLabel.setFontScale(2f);
        difficulty.setFontScale(2.5f);

        Table displayTable2 = new Table();
        displayTable2.center();
        displayTable2.setFillParent(true);

        displayTable2.add(difficulty);
        displayTable2.row();
        displayTable2.add(easyLabel).padBottom(40).padRight(180);
        displayTable2.row();
        displayTable2.add(medLabel).padBottom(40).padRight(138);
        displayTable2.row();
        displayTable2.add(hardLabel).padBottom(125).padRight(180);

        stage.addActor(displayTable2);

    }
}

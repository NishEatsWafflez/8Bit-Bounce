package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class passwordClass implements Screen {
    SpriteBatch batch;
    final BitBounce game;
    passwordInput password1;
    Texture whatever;
    OrthographicCamera camera;
    BitmapFont font;
    Sprites sprites1;
    String stringy;
    TextField textUsername;
    public Boolean answerGiven;
    private int dounter;

    //constructor
    public passwordClass(final BitBounce game) {
        password1 = new passwordInput();
        this.game = game;
        whatever = new Texture(Gdx.files.internal("purple.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 1000);
        batch = new SpriteBatch();
        font = new BitmapFont();
        sprites1 = new Sprites(0, 0, whatever, batch);
        stringy = "waluigi";
        answerGiven = false;
        dounter = 0;

    }

    //render method to make textbox and lead to next screen
    public void render(float delta){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.draw(whatever, 0, 0, 1000, 1000);

        //used to output text box only once
        dounter++;
        if (dounter ==1) {
            password1.render();
        }
        System.out.println(password1.awesomeLevel);
        password1.input(password1.text);


        if (password1.awesomeLevel == true){
            game.setScreen(new PlayScreen(game));
        }
        if (password1.gameStart){
            game.setScreen(new PlayScreen(game));
        }


        game.batch.end();
    }
    public void show(){}

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

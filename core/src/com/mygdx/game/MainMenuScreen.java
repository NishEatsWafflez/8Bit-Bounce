package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class MainMenuScreen implements Screen{
    final BitBounce game;
    public static Boolean diffChange = false;
    Boolean settingsON;
    static Texture close;
    MenuHUD hud;
    public static Texture red;
    static bgHUD Hud2;
    static bg2HUD setHUD;
    public static Boolean screen1 = true;
    public static Boolean screen2 = false;
    public static Boolean screen3 = false;
    public static Boolean easy =false;
    public static Boolean medium = true;
    public static Boolean hard = false;
    public static Boolean cloudsOn = true;
    public static Boolean muteOn;
    static Texture emptybox;
    static Texture filledBox = new Texture(Gdx.files.internal("filledbox.png"));
    static Texture notForward = new Texture(Gdx.files.internal("nFOR.png"));
    static Texture notBack = new Texture(Gdx.files.internal("nBACK.png"));
    static Texture forwardArrow = new Texture(Gdx.files.internal("Forward.png"));
    static Texture backwardArrow = new Texture(Gdx.files.internal("backward.png"));
    Texture titleImage = new Texture(Gdx.files.internal("BitBounce.png"));
    Texture purpleImage = new Texture(Gdx.files.internal("purple1.png"));
    public static int pageNumber = 1;

    public MainMenuScreen (final BitBounce game){
        this.game = game;
        settingsON = false;
        close = new Texture(Gdx.files.internal("Close.png"));
        hud = new MenuHUD(game.batch);
        Hud2 = new bgHUD(game.batch);
        setHUD = new bg2HUD(game.batch);
        red = new Texture(Gdx.files.internal("redBlock.png"));

        emptybox = new Texture(Gdx.files.internal("EmptyBox.png"));
        cloudsOn = true;
        muteOn = false;
    }

//    @Override
    public void show() {

    }

//    @Override
    public void render(float delta) {
//        if (hud.counter %2 == 0) {
//            for (int i = 0; i < 600000000; i++) {
//                hud.startLabel.setColor(Color.CLEAR);
//                //System.out.println("no");
//            }
//            hud.counter++;
//        } else if (hud.counter % 2 == 1){
//            for (int i = 0; i < 600000000; i ++) {
//                hud.startLabel.setColor(Color.WHITE);
//                //  System.out.println("yes");
//            }
//            hud.counter ++;
//        }
//        if (timer >=1){
//            nextScreen = true;
//        } else {
//            nextScreen = false;
//        }
        game.batch.begin();
        Gdx.gl.glClearColor(.6f, .01f, 2, .2f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.draw(purpleImage, 0, 0, 1000, 1000);
        game.batch.draw(titleImage, 206, 650, 588, 324);
        if (!hud.settings) {
            if (Gdx.input.isTouched()){
                if (Gdx.input.getX() > 425 && Gdx.input.getX() < 575 && (BitBounce.V_HEIGHT-Gdx.input.getY()) >500 && (BitBounce.V_HEIGHT- Gdx.input.getY()) < 535) {
                    hud.settings = true;
                    screen1 = true;
                    screen2 = false;
                }
            }
        }else {
            if (Gdx.input.isTouched()){
                if (Gdx.input.getX() > 650 && Gdx.input.getX() < 750 && (BitBounce.V_HEIGHT-Gdx.input.getY())>265 && (BitBounce.V_HEIGHT-Gdx.input.getY()) < 300){
                    hud.settings = false;
                }
            }
        }

        if (hud.settings) {
            game.batch.draw(close, 600, 265, 150, 35);
            game.batch.draw(red, 300, 325, 400, 400);
            if (screen1) {
                game.batch.draw(notBack,250, 500, 30, 50);
                game.batch.draw(forwardArrow, 720, 500, 30, 50);
                if (cloudsOn) {
                    game.batch.draw(emptybox, 310, 495, 40, 40);
                    game.batch.draw(filledBox, 310, 590, 40, 40);
                }
                if (!cloudsOn) {
                    game.batch.draw(filledBox, 310, 495, 40, 40);
                    game.batch.draw(emptybox, 310, 590, 40, 40);
                }
                if (Gdx.input.justTouched()){
                    if (Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT -Gdx.input.getY())>590 && (BitBounce.V_HEIGHT-Gdx.input.getY())<630){
                        cloudsOn = true;
                    }
                    if (Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT-Gdx.input.getY()>495) && (BitBounce.V_HEIGHT-Gdx.input.getY()<535)){
                        cloudsOn = false;
                    }
                }
                if (muteOn){
                    game.batch.draw(filledBox,310,365,40,40);
                }
                else {
                    game.batch.draw(emptybox,310,365,40,40);
                }
                if(Gdx.input.justTouched()){
                    if(Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT-Gdx.input.getY()>360) && (BitBounce.V_HEIGHT-Gdx.input.getY()<400)){
                        if (muteOn){
                            muteOn = false;
                        } else{
                            muteOn = true;
                        }
                    }
                }
                if (Gdx.input.justTouched()) {
                    if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 770 && Gdx.input.getX() > 720) {
                        screen1 = false;
                        screen2 = true;
                        screen3 = false;
                    }
                }
            }



            if (screen2){
                game.batch.draw(notForward, 720, 500, 30, 50 );
                game.batch.draw(backwardArrow, 250, 500, 30, 50);
                if (medium){
                    game.batch.draw(filledBox, 310, 505, 40, 40);
                    game.batch.draw(emptybox,310, 602, 40, 40);
                    game.batch.draw(emptybox,310,410,40,40);
                } else if (easy){
                    game.batch.draw(emptybox, 310, 505, 40, 40);
                    game.batch.draw(filledBox,310, 602, 40, 40);
                    game.batch.draw(emptybox,310, 410, 40, 40);
                } else if (hard){
                    game.batch.draw(emptybox, 310, 505, 40, 40);
                    game.batch.draw(emptybox, 310, 602, 40, 40);
                    game.batch.draw(filledBox, 310, 410, 40, 40);
                }
                if (Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT - Gdx.input.getY()>410) && (BitBounce.V_HEIGHT-Gdx.input.getY()<450)){
                    if (Gdx.input.justTouched()){
                        medium = false;
                        easy = false;
                        hard = true;
                    }
                } else if (Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT - Gdx.input.getY()>602) && (BitBounce.V_HEIGHT-Gdx.input.getY()<642)){
                    if (Gdx.input.justTouched()){
                        medium = false;
                        easy = true;
                        hard = false;
                    }
                } else if (Gdx.input.getX()>310 && Gdx.input.getX()<700 && (BitBounce.V_HEIGHT - Gdx.input.getY()>505) && (BitBounce.V_HEIGHT-Gdx.input.getY()<545)){
                    if (Gdx.input.justTouched()){
                        medium = true;
                        easy = false;
                        hard = false;
                    }
                }
                if (Gdx.input.justTouched()) {
                    if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 300 && Gdx.input.getX() > 250) {
                        screen1 = true;
                        screen2 = false;
                        screen3 = false;
                    }
                }
            }

        }


        if (! hud.settings) {
            //game.batch.draw(settings, 425, 500, 150, 35);
        }
        game.batch.end();
        if (!hud.settings) {
            hud.stage.draw();
        }
        if (hud.settings){
            if (screen1){
                Hud2.stage.draw();
            }
            if (screen2){
                setHUD.stage.draw();
            }
        }
        if (!hud.settings) {
                hud.update();

        }

        if (hud.nextScreen) {
            game.setScreen(new PlayScreen(game));
        }

    }

//    @Override
    public void resize(int width, int height) {

    }

//    @Override
    public void pause() {

    }

//    @Override
    public void resume() {

    }
    public static void update  (int pageNumber){
        if (PlayScreen.settingsOn) {
            if (Gdx.input.justTouched()) {
                if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 770 && Gdx.input.getX() > 720) {
                    pageNumber = 2;
                }
            }
            if (Gdx.input.justTouched()) {
                if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 300 && Gdx.input.getX() > 250) {
                    pageNumber = 1;
                }
            }
        }
    }
    public static void page2(int pageNumber){

    }
    public static void yeet(final BitBounce game, bgHUD Hud2, bg2HUD setHUD, int pageNumber, Boolean diffChange){
        if (PlayScreen.settingsOn) {

            game.batch.begin();
            //game.batch.draw(close, 600, 265, 150, 35);
            game.batch.draw(red, 300, 325, 400, 400);
            if (pageNumber == 1) {
//                game.batch.draw(notBack, 250, 500, 30, 50);
                game.batch.draw(notForward, 720, 500, 30, 50);
                if (cloudsOn) {
                    game.batch.draw(emptybox, 310, 495, 40, 40);
                    game.batch.draw(filledBox, 310, 590, 40, 40);
                }
                if (!cloudsOn) {
                    game.batch.draw(filledBox, 310, 495, 40, 40);
                    game.batch.draw(emptybox, 310, 590, 40, 40);
                }
                if (Gdx.input.justTouched()) {
                    if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY()) > 590 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 630) {
                        cloudsOn = true;
                    }
                    if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY() > 495) && (BitBounce.V_HEIGHT - Gdx.input.getY() < 535)) {
                        cloudsOn = false;
                    }
                }



            }


            if (pageNumber == 2) {
//                game.batch.draw(notForward, 720, 500, 30, 50);
                game.batch.draw(notBack, 250, 500, 30, 50);
                if (medium) {
                    game.batch.draw(filledBox, 310, 505, 40, 40);
                    game.batch.draw(emptybox, 310, 602, 40, 40);
                    game.batch.draw(emptybox, 310, 410, 40, 40);
                } else if (easy) {
                    game.batch.draw(emptybox, 310, 505, 40, 40);
                    game.batch.draw(filledBox, 310, 602, 40, 40);
                    game.batch.draw(emptybox, 310, 410, 40, 40);
                } else if (hard) {
                    game.batch.draw(emptybox, 310, 505, 40, 40);
                    game.batch.draw(emptybox, 310, 602, 40, 40);
                    game.batch.draw(filledBox, 310, 410, 40, 40);
                }


            }
            game.batch.end();
            if (pageNumber == 1) {
                Hud2.stage.draw();
            }
            if (pageNumber == 2) {
                setHUD.stage.draw();
            }
        }


    }

//    @Override
    public void hide() {

    }

//    @Override
    public void dispose() {
        close.dispose();
        emptybox.dispose();
        filledBox.dispose();
        notForward.dispose();
        notBack.dispose();
        forwardArrow.dispose();
        backwardArrow.dispose();

    }
}

package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Color;


import java.awt.*;

public class PlayScreen implements Screen {
    public static Boolean settingsOn = false;
    final BitBounce game;
    OrthographicCamera camera;
    Viewport port;
    private HUD hud;
    Texture blockImage;
    Rectangle model;
    boolean keypress;
    static int i;
    int a;
    public int yvel;
    Texture blueImage1;
    Rectangle blue;
    long lastSpawn;
    Sprites sprites;
    public int xvel;
    int d;
    private Blocks[] blocks;
    private static int BLOCK_SPACING = MathUtils.random(450,500);
    //MathUtils.random(200,300);
    private static final int BLOCK_COUNT = 7;
    private static int HEIGHT_SPACING = 280;
    background bg1;
    background bg2;
    double xvel1;
    public Boolean readyToStart;
    int points;
    private int[] blockx;
    private int[] blocky;
    Boolean dead;
    Texture deathImage;
    Texture instructionsImage;
    bgmusic music;
    int highScore = 0;
    int Bounter = 1;
    Texture deathTextImage;
    //Music bgmusic;
    int characterNumber;
    Texture marioImage;
    Texture sprite2Image;
    Texture kaoopa;
    int counter = 1;
    Music bgmusic1;
    Pause pause1;
    passwordInput password1;
    static Preferences prefs = Gdx.app.getPreferences("My preferences");
    passwordClass password2;
    int dounter;
    Texture backgroundw;
    Texture blockImage1;
    Texture blocksW;
    Texture shrek;
    Texture peppa;
    Boolean peppaOn;
    Boolean deathOn;
    Texture rayman;
    Boolean rayon;
    Boolean tabOn;
    Texture Banjo;
    Texture forestbg;
    Texture backgroundR;
    MenuHUD menuhud;
    Texture ralphyboy;
    int settingCounter = 0;



    MainMenuScreen menu;

    //constructor
    public PlayScreen(final BitBounce game) {
//        if (MainMenuScreen.easy){
//            HEIGHT_SPACING = 200;
//        }
//        if (MainMenuScreen.medium){
//            HEIGHT_SPACING = 280;
//        }
//        if (MainMenuScreen.hard){
//            HEIGHT_SPACING = 300;
//        }
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, BitBounce.V_WIDTH, BitBounce.V_HEIGHT);
        port = new ExtendViewport(BitBounce.V_WIDTH, BitBounce.V_HEIGHT, camera);
        camera.update();
        hud = new HUD(game.batch);
        //blocks = new Array<Rectangle>();
        blockImage = new Texture(Gdx.files.internal("gameblock.png"));
        blocksW = new Texture(Gdx.files.internal("waluigiBlock.png"));
        model = new Rectangle();
        keypress = false;
        model.x = 0;
        model.y = 0;
        model.height = 120;
        model.width = 60;
        blueImage1 = new Texture(Gdx.files.internal("clouds4.png"));
        forestbg = new Texture(Gdx.files.internal("forests.png"));
        blue = new Rectangle();
        blue.x = 0;
        blue.y = 0;
        blue.width = 2262;
        blue.height = 1000;
        marioImage = new Texture(Gdx.files.internal("Steve.png"));
        sprite2Image = new Texture(Gdx.files.internal("Waluigi.png"));
        sprites = new Sprites(120, 210, marioImage, game.batch);
        kaoopa = new Texture(Gdx.files.internal("kaoopa.png"));
        pause1 = new Pause(game.batch);
        password1 = new passwordInput();
//        Gdx.input.getTextInput(, "What is the Password", "idk bro", "");
        password2 = new passwordClass(game);
        dounter = 0;
        backgroundw = new Texture(Gdx.files.internal("art (2).png"));
        backgroundR = new Texture(Gdx.files.internal("fixitfelixbg.png"));
        blockImage1 = new Texture(Gdx.files.internal("art (1).png"));
        shrek = new Texture(Gdx.files.internal("shrek.png"));
        peppa = new Texture(Gdx.files.internal("peppa.png"));
        ralphyboy = new Texture(Gdx.files.internal("ralphy.png"));
        rayman = new Texture(Gdx.files.internal("rayman.png"));
        Banjo = new Texture(Gdx.files.internal("Banjo.png"));
        peppaOn = false;
        deathOn = false;
        rayon = false;
        tabOn = false;
        menuhud = new MenuHUD(game.batch);


        xvel1 = -2.5;
        readyToStart = true;
        points = 0;
        music = new bgmusic();
        deathTextImage = new Texture(Gdx.files.internal("deathText.png"));
        characterNumber = 1;

        deathImage = new Texture(Gdx.files.internal("deathScreen.png"));
        sprites.points = hud.score;

        //make an array for the original positions of the blocks:
        blockx = new int[7];
        blockx[0] = 0;
        blockx[1] = 500;
        blockx[2] = 1000;
        blockx[3] = 1500;
        blockx[4] = 2000;
        blockx[5] = 2500;
        blockx[6] = 3000;
        //sprites.x = blocks[0].x;

        blocky = new int[7];
        blocky[0] = 200;
        blocky[1] = 400;
        blocky[2] = 600;
        blocky[3] = 800;
        blocky[4] = 600;
        blocky[5] = 400;
        blocky[6] = 200;


        bg1 = new background(0-2262+1200, 0, 2262, 1000, blueImage1);
        bg2 = new background(bg1.x + 2262, 0, 2262, 1000, blueImage1);


        blocks = new Blocks[7];
        xvel = 0;

        dead = false;


        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new Blocks(blockx[i], blocky[i], blockImage1, game.batch);
        }
        //blocks[0].x = 20;
        //blocks[0].y = 70;

        //used to log high scores and log it into preferences:
        instructionsImage = new Texture(Gdx.files.internal("Instructions.png"));
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }

    }

//    public void move(float delta) {
//        //if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) block.x += 200*Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
//            if (!keypress) {
//                model.y += 70;
//            }
//            keypress = true;
//        } else {
//            keypress = false;
//        }
//    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);








        //Renders a text box
        dounter++;
        if (dounter == 1) {
            password1.render();
        }
//        if (!MainMenuScreen.muteOn){
//            if (dead) {
//                music.stop();
//            } else if (pause1.gamePause){
//                music.pause();
//            } else {
//                music.play();
//            }
//        } else if (MainMenuScreen.muteOn){
//            music.stop();
//        }
//        if (!dead){
//            if (!MainMenuScreen.muteOn){
//                music.play();
//            }
//        } else {
//            music.stop();
//        }
//
//        if (!MainMenuScreen.muteOn){
//            if (pause1.gamePause){
//                music.pause();
//            } else if (!dead){
//                music.play();
//            } else {
//                music.stop();
//            }
//        }
//        if (pause1.gamePause){
//            music.pause();
//        } else if (!dead){
//            if (!MainMenuScreen.muteOn){
//                music.play();
//            }
//        } else {
//            music.stop();
//        }

        password1.input(password1.text);

        //Allows for different character models with right password or if "right" button is pushed
        if (!pause1.gamePause) {
            //if (password2.answerGiven) {
                if (password1.awesomeLevel) {
                    hud.scoreLabel.setColor(Color.GRAY);
                    hud.settingLabel.setColor(Color.GRAY);
                    hud.marioLabel.setColor(Color.GRAY);
                    sprites.texture = sprite2Image;
                    // bgmusic1 = Gdx.audio.newMusic(Gdx.files.internal("8bitmusic.mp3"));
                    sprites.width = 120;
                    sprites.height = 235;
                    bg1.texture = backgroundw;
                    bg2.texture = backgroundw;
                    bg1.width = 1809;
                    bg2.width = 1809;
                    for (int i = 0; i < blocks.length; i++) {
                        blocks[i].texture = blocksW;
                    }

                }
                if (password1.ralphLevel) {
                    hud.scoreLabel.setColor(Color.GRAY);
                    hud.settingLabel.setColor(Color.GRAY);
                    hud.marioLabel.setColor(Color.GRAY);
                    sprites.texture = ralphyboy;
                // bgmusic1 = Gdx.audio.newMusic(Gdx.files.internal("8bitmusic.mp3"));
                    sprites.width = 195;
                    sprites.height = 235;
                    bg1.texture = backgroundR;
                    bg2.texture = backgroundR;
                    bg1.width = 1809;
                    bg2.width = 1809;
                    for (int i = 0; i < blocks.length; i++) {
                        blocks[i].texture = blockImage1;
                    }

                }
                if (Bounter % 3 == 1) {
                    if (!password1.awesomeLevel && !password1.ralphLevel) {
                        if (!peppaOn) {
                            if (!deathOn) {
                                if (!tabOn) {
                                    sprites.texture = marioImage;
                                    //  bgmusic1 = Gdx.audio.newMusic(Gdx.files.internal("8bitmusic.mp3"));
                                    sprites.width = 120;
                                    sprites.height = 227;
                                }
                            }
                        }
                    }
                }
                if (Bounter % 3 == 0) {
                    if (!password1.awesomeLevel && !password1.ralphLevel) {
                        if (!peppaOn) {
                            if (!deathOn) {
                                if (!tabOn) {
                                    //if (Bounter % 2 == 0) {
                                    sprites.texture = kaoopa;
                                    sprites.width = 170;
                                    sprites.height = 200;
                                }
                            }
                        }
                    }
                }

                if (Bounter % 3 == 2) {
                    if (!password1.awesomeLevel && !password1.ralphLevel) {
                        if (!peppaOn) {
                            if (!deathOn) {
                                if (!tabOn) {
                                    sprites.texture = shrek;
                                    sprites.width = 160;
                                    sprites.height = 225;
                                }
                            }
                        }
                    }
                }
            //}
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                Bounter++;
            }
            // }
        }
        if (!password1.awesomeLevel && !password1.ralphLevel) {
            if (MainMenuScreen.cloudsOn) {
                bg1.texture = blueImage1;
                bg2.texture = blueImage1;
                hud.closeLabel.setColor(Color.GRAY);
            } else {
                bg1.texture = forestbg;
                bg2.texture = forestbg;
                hud.closeLabel.setColor(Color.WHITE);

            }
        }
        if (peppaOn) {
            sprites.texture = peppa;
            sprites.height = 225;
            sprites.width = 175;
        }
        if (Gdx.input.getX() > 0 && Gdx.input.getX() < 100 && (BitBounce.V_HEIGHT - Gdx.input.getY()) > 900 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 1000) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
                if (!password1.awesomeLevel && !password1.ralphLevel) {
                    if (!deathOn) {
                        if (!peppaOn) {
                            if (!tabOn) {
                                sprites.texture = Banjo;
                                sprites.width = 200;
                                sprites.height = 225;
                                tabOn = true;
                            } else {
                                tabOn = false;
                            }
                        }
                    }
                }
            }
        }

        //creates backgrounds
        game.batch.draw(instructionsImage, 250, 300, 500, 400);
      game.batch.draw(bg1.texture, bg1.x + bg1.width, bg2.y, bg2.width, bg2.height);
        bg1.render(bg1.x, bg1.y, game.batch);

        //creates blocks with set values
        for (int i = 0; i <= blocks.length - 1; i++) {
            blocks[i].render();
        }

        //makes moving backgrounds and ready to start boolean
        if (!dead) {
            if (!pause1.gamePause){
                if (sprites.readytoBegin) {
                bg1.update();

                //}
                //if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                bg2.update();
                }
            }
            //  bg3.update();
            //}
                if (!dead) {
                    if (!pause1.gamePause) {
                        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                            if (!settingsOn) {
                                if (readyToStart) {
                                    counter++;
                                    if (counter == 2) {
                                        sprites.readytoBegin = true;
                                    }
                                }
                            }
                        }
                    }
                }


            //background respawn:
            if (bg2.x <= -bg2.width) {
                bg2.x = bg1.x + bg1.width;
            }
            if (bg1.x <= -bg1.width) {
                bg1.x = bg2.x + bg2.width;
            }

            //sprite and  block movement methods
            if (pause1.gamePause == false) {
                sprites.update();
                for (int i = 0; i < blocks.length; i++) {
                    if (sprites.readytoBegin) {
                        blocks[i].update();
                    }
                }
            }


            //block respawning code:
            if (blocks[0].x < -blocks[0].width) {
                blocks[0].x = blocks[6].x + BLOCK_SPACING;
                if (blocks[6].y <= BitBounce.V_HEIGHT - blocks[6].height - sprites.height - 20) {
                    blocks[0].y = MathUtils.random(0, blocks[6].y + HEIGHT_SPACING);
                } else if (blocks[6].y <= 0) {
                    blocks[0].y += 320;
                } else {
                    blocks[0].y += -60;
                }
            }

            for (i = 0; i < blocks.length; i++) {
                if (i>0){
                    if (blocks[i].x < -blocks[i].width) {
                        blocks[i].x = blocks[i-1].x + BLOCK_SPACING;
                        if (blocks[i-1].y < BitBounce.V_HEIGHT - blocks[i-1].height - sprites.height - 20) {
                           blocks[i].y = MathUtils.random(0, blocks[i-1].y + HEIGHT_SPACING);
                            //blocks[i].y = blocks[i-1].y += 300;
                        } else if (blocks[i-1].y <= 0) {
                            blocks[i].y += 320;
                        } else {
                            blocks[i-1].y += -120;
                        }
                    }
                }
            }


            update();

            //creates sprite
            sprites.render();
        }

        //establishes what happens if player dies
        if (sprites.y <= 0) {
            dead = true;
            music.stop();
            counter = 0;
        }
        if (dead){
            music.stop();
        }
        if (dead) {
            if (!pause1.gamePause){
            readyToStart = false;
            if (!settingsOn) {
                if (password1.awesomeLevel) {
                    game.batch.draw(pause1.pauseScreen, 250, 400, 500, 200);
                } else {
                    game.batch.draw(deathImage, 250, 400, 500, 200);
                }
                game.batch.draw(deathTextImage, 250, 250, 500, 400);
            }
            try {
                highScore = prefs.getInteger("highScore");
            } catch (Exception e){
                System.out.println("nothing");
            }
            if (sprites.points > highScore) {
                    highScore = sprites.points;
                    prefs.putInteger("highScore", highScore);
                    prefs.flush();
                    highScore = prefs.getInteger("highScore");
                    hud.hsupdate("HIGH SCORE: " +  prefs.getInteger("highScore"));
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                counter = 1;
                reset();
                dead = false;
            }

            }
        }

        //pause screen
        if (pause1.gamePause == true){
            if (!MainMenuScreen.muteOn){
                music.pause();
            }
            if (!settingsOn) {
                game.batch.draw(pause1.pauseScreen, pause1.x, pause1.y, pause1.width, pause1.height);
                game.batch.draw(pause1.pauseText, pause1.x2, pause1.y2, pause1.width2, pause1.height2);
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                if (!password1.awesomeLevel && !password1.ralphLevel) {
                    if (!deathOn) {
                        if (!tabOn) {
                            if (!peppaOn) {
                                peppaOn = true;

                            } else {
                                peppaOn = false;
                                if (deathOn) {
                                    sprites.texture = rayman;
                                    sprites.width = 200;
                                } else if (tabOn) {
                                    sprites.texture = sprite2Image;
                                } else{
                                    if (Bounter%3 == 1){
                                        sprites.texture = marioImage;
                                        sprites.width = 120;
                                        sprites.height = 227;
                                    } else if (Bounter%3 == 0){
                                        sprites.texture = kaoopa;
                                        sprites.width = 170;
                                        sprites.height = 200;
                                    } else {
                                        sprites.texture = shrek;
                                        sprites.width = 160;
                                        sprites.height = 225;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (dead){
            if (Gdx.input.isKeyJustPressed(Input.Keys.F)){
                if (!password1.awesomeLevel && !password1.ralphLevel) {
                    //if (peppaOn == false) {
                    if (!peppaOn) {
                        if (!tabOn) {
                            if (!deathOn) {
                                rayon = true;
                                deathOn = true;
                                sprites.texture = rayman;
                                sprites.width = 200;
                            } else if (tabOn) {
                                sprites.texture = sprite2Image;
                                deathOn = false;
                            } else {
                                deathOn = false;
                            }
                        }
                    }
                }
            }
        }


        //creates score counter from hud class
        keypress = true;
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        if (!settingsOn){
        } else{
            if (pause1.gamePause) {
                game.batch.draw(MainMenuScreen.red, 300, 325, 400, 400);
            }
        }
        game.batch.end();
        if (pause1.gamePause || dead || counter == 1) {
                if (settingsOn) {
                    hud.closeStage.draw();
                    if (Gdx.input.justTouched()) {
                        if (BitBounce.V_HEIGHT-Gdx.input.getY()>265 && BitBounce.V_HEIGHT-Gdx.input.getY()<305 && Gdx.input.getX()>650 && Gdx.input.getX() <750)
                        settingsOn = false;
                        if (MainMenuScreen.diffChange) {
                            reset();
                            counter = 1;
                            pause1.gamePause = false;
                        }
                    }
                } else if (!settingsOn) {
                    hud.settingStage.draw();
                    if (Gdx.input.justTouched()){
                        if ((BitBounce.V_HEIGHT-Gdx.input.getY())>940 && (BitBounce.V_HEIGHT-Gdx.input.getY()<1000) && Gdx.input.getX()>810 && Gdx.input.getX()<1000) {
                            //System.out.println("no");
                            MainMenuScreen.diffChange = false;
                            settingsOn = true;
                            MainMenuScreen.pageNumber = 1;
                        }
                    }



                }
        }
        if (dead){
            music.stop();
        } else if (!sprites.readytoBegin){
            music.stop();
        } else {
            if (!MainMenuScreen.muteOn) {
                if (!pause1.gamePause) {
                    music.play();
                } else {
                    music.pause();
                }
            }
        }

        if (settingsOn){
            if (pause1.gamePause || dead || counter == 1){
                MainMenuScreen.yeet(game, MainMenuScreen.Hud2, MainMenuScreen.setHUD, MainMenuScreen.pageNumber, MainMenuScreen.diffChange);
                if (Gdx.input.justTouched()) {
                    if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 770 && Gdx.input.getX() > 720) {
                        MainMenuScreen.pageNumber = 2;
                    }
                }
                if (Gdx.input.justTouched()) {
                    if ((BitBounce.V_HEIGHT - Gdx.input.getY()) > 500 && (BitBounce.V_HEIGHT - Gdx.input.getY()) < 550 && Gdx.input.getX() < 300 && Gdx.input.getX() > 250) {
                        MainMenuScreen.pageNumber = 1;
                    }
                }
                game.batch.begin();
                if (MainMenuScreen.pageNumber == 1){
                    if (MainMenuScreen.muteOn) {
                        game.batch.draw(MainMenuScreen.filledBox, 310, 365, 40, 40);
                    } else {
                        game.batch.draw(MainMenuScreen.emptybox, 310, 365, 40, 40);
                    }
                    if (Gdx.input.justTouched()) {
                        if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY() > 360) && (BitBounce.V_HEIGHT - Gdx.input.getY() < 400)) {
                            if (MainMenuScreen.muteOn) {
                                MainMenuScreen.muteOn = false;
                            } else {
                                MainMenuScreen.muteOn = true;
                            }
                        }
                    }
                }
                game.batch.end();
                if (MainMenuScreen.pageNumber == 2) {
                    if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY() > 410) && (BitBounce.V_HEIGHT - Gdx.input.getY() < 450)) {
                        if (Gdx.input.justTouched()) {
                            MainMenuScreen.medium = false;
                            MainMenuScreen.easy = false;
                            MainMenuScreen.hard = true;
                            MainMenuScreen.diffChange = true;

                        }
                    } else if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY() > 602) && (BitBounce.V_HEIGHT - Gdx.input.getY() < 642)) {
                        if (Gdx.input.justTouched()) {
                            MainMenuScreen.medium = false;
                            MainMenuScreen.easy = true;
                            MainMenuScreen.hard = false;
                            MainMenuScreen.diffChange = true;
                        }
                    } else if (Gdx.input.getX() > 310 && Gdx.input.getX() < 700 && (BitBounce.V_HEIGHT - Gdx.input.getY() > 505) && (BitBounce.V_HEIGHT - Gdx.input.getY() < 545)) {
                        if (Gdx.input.justTouched()) {
                            MainMenuScreen.medium = true;
                            MainMenuScreen.easy = false;
                            MainMenuScreen.hard = false;
                            MainMenuScreen.diffChange = true;
                        }
                    }
                }


            }
        }


        hud.stage.draw();
        pause1.setPause();
    }

    @Override
    public void resize(int width, int height) {
//        width = BitBounce.V_WIDTH;
//        height = BitBounce.V_HEIGHT;
//        port.update(width,height);
//        hud.stage.getViewport().update(width, height, true);
//        BitBounce.
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
        game.batch.dispose();
        blueImage1.dispose();
        backgroundw.dispose();
        marioImage.dispose();
        sprite2Image.dispose();
        kaoopa.dispose();
        blocksW.dispose();
        blockImage.dispose();
        deathTextImage.dispose();
        deathImage.dispose();
        pause1.pauseScreen.dispose();
        pause1.pauseText.dispose();
        shrek.dispose();
        forestbg.dispose();
        peppa.dispose();
        rayman.dispose();
        Banjo.dispose();
        hud.settingStage.dispose();
        hud.closeStage.dispose();
        hud.stage.dispose();
        menuhud.stage.dispose();



    }

    public void update() {

        //collision methods for mario and block
        if (sprites.isCollide(blocks[0]) || sprites.isCollide(blocks[1]) || sprites.isCollide(blocks[2]) || sprites.isCollide(blocks[3])||
                sprites.isCollide(blocks[4]) || sprites.isCollide(blocks[5]) || sprites.isCollide(blocks[6])) {
                    //blocks[i].handleCollision(sprites);
                   for (int i = 0; i<blocks.length; i++) {
                       if (sprites.isCollide(blocks[i])) {
                           sprites.handleCollision(blocks[i]);
                       }
                   }
        } else {
            sprites.touchState = false;
            sprites.pointState = false;
        }

        //score update
        hud.score = sprites.points;
        hud.update(" " + sprites.points);




    }
    public void reset (){

        //reset method if character dies
        sprites.readytoBegin = false;
        //readyToStart = false;
        blockx[0] = 0;
        blockx[1] = 500;
        blockx[2] = 1000;
        blockx[3] = 1500;
        blockx[4] = 2000;
        blockx[5] = 2500;
        blockx[6] = 3000;

        blocky[0] = 200;
        blocky[1] = 400;
        blocky[2] = 600;
        blocky[3] = 800;
        blocky[4] = 600;
        blocky[5] = 400;
        blocky[6] = 200;

        for (i=0; i<blocks.length; i++) {
            blocks[i].x = blockx[i];
            blocks[i].y = blocky[i];
        }
        bg1.x = 0+1200;

        sprites.points = 0;

        sprites.x = 40;
        sprites.y = 700;

        readyToStart = true;
    }


}

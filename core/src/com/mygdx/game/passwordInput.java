package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import javafx.stage.Screen;

public class passwordInput implements Input.TextInputListener {
    String text;
    String trying;
    static public Boolean awesomeLevel;
    static public Boolean ralphLevel;
    public Boolean gameStart = false;

    //creates input listener
    Input.TextInputListener textListener = new Input.TextInputListener() {

        @Override
        public void input(String text) {
            //System.out.println(text);
            if (text.contains("waluigi") || text.contains("Waluigi")){
                //System.out.println("yeet");
                awesomeLevel = true;
                gameStart = true;
                //System.out.println(awesomeLevel);
            }else if (text.contains("ralph") || text.contains("Ralph")){
                //System.out.println("yeet");
                ralphLevel = true;
                gameStart = true;
                //System.out.println(awesomeLevel);
            } else if (text == null){
                awesomeLevel = false;
                gameStart = false;
            } else{
                gameStart = true;
            }
            //System.out.println(awesomeLevel);
        }

        @Override
        public void canceled() {
            System.out.println("cancelled");
        }
    };


    public passwordInput() {
        awesomeLevel = false;
        ralphLevel = false;
    }

    //makes text box
    public void render(){
        Gdx.input.getTextInput(textListener, "Waah?", " ", "to access a Secret Character");
        Gdx.app.log("Who is the Key to Life", text);
    }
    public void getTextInput (Input.TextInputListener textListener){

    }
    @Override
    public void input(String text) {
        this.text = text;

    }

    @Override
    public void canceled() {
        text = "canceled";

    }
}

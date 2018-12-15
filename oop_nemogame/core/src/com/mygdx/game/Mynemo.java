package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Mynemo extends Game {
	SpriteBatch batch;
	private Stage stage;
	private MainClass ohm;
	
	
	@Override
	public void create () {
		ohm = new MainClass();
		batch = new SpriteBatch();
		stage = new Stage(new ScreenViewport());
	    Gdx.input.setInputProcessor(stage);
	    Skin mySkin = new Skin(Gdx.files.internal("glassy/skin/glassy-ui.json"));
	    
	    Label header = new Label("Nemo Game", mySkin);
	    header.setSize(100,200);
	    header.setPosition(400, 350);
	    header.setAlignment(Align.center);
	    stage.addActor(header);
	    ohm.create();
	    
	    //play button
	    Button playbn = new TextButton("PLAY" ,mySkin,"small");
	    playbn.setSize(100,50);
        playbn.setPosition(400,320);
        playbn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        		
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        //high score button
        
        Button scorebn = new TextButton("score" ,mySkin,"small");
        scorebn.setSize(100, 50);
        scorebn.setPosition(400 , 220);
        scorebn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            	
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        
        
	    //exit button
	    Button exitbn = new TextButton("Exit" ,mySkin,"small");
	    exitbn.setSize(100, 50);
        exitbn.setPosition(400, 120);
        exitbn.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                System.exit(0);
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        stage.addActor(playbn);
        stage.addActor(scorebn);
        stage.addActor(exitbn);
	    
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1);
		batch.begin();
		ohm.render();
		batch.end();		

	}
	
	
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import GameManager.GameStateManager;

public class main_nemo extends ApplicationAdapter {
	
	GameStateManager gsm;
	
	@Override
	public void create () {
		
		gsm = new GameStateManager();
		gsm.setState(GameStateManager.PLAY);
		
	}

	@Override
	public void render () {
		
		
		gsm.render();
		
	}
	
	@Override
	public void dispose () {
		
		gsm.dispose();
		
	}
}

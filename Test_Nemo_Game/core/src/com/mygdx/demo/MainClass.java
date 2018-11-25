package com.mygdx.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	
	public static final int WIDTH = 840;
	public static final int HEIGHT= 600;
	
	SpriteBatch batch;
	Texture img;
	
	float x = 0;
	float y = 400;
	
	//ประกาศตัวแปร font
	//BitmapFont font;
	
	//ฟังก์ชั่นนี้จะทำตอนเริ่มโปรแกรม
	@Override
	public void create () {
		batch = new SpriteBatch();
		//set รูปภาพ
		img = new Texture(Gdx.files.internal("1.jpg"));
		
		//สร้างฟอนด์ + กำหนดสีฟอนต์//
		//font = new BitmapFont();
		//font.setColor(Color.WHITE);
	
	}

	//ฟังก์ชั่นคือ จะทำตลอดเวลาตั้งแต่เปิดโปรแกรม
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		//set text และ set ตำแหน่ง
		//font.draw(batch, "Hello World", 300, 300);
		
		//สั่งให้batch ทำการวาดภาพที่ตำแหน่ง (ตำแปรรูป, ตำแหน่งแกน x, ตำแหน่งแกน y, width, height)
		batch.draw(img, x, y, 100, 100);
		batch.end();
		
		
		//ทำให้รูปภาพขยับ
//		y -= 200 * Gdx.graphics.getDeltaTime();
//		x += 100 * Gdx.graphics.getDeltaTime();
//		
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x += 500 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x -= 500 * Gdx.graphics.getDeltaTime();
		}
		//อันนี้คือเวลากดปุม ตัวอย่างคือ space bar
		//if (Gdx.input.isKeyPressed(Keys.SPACE)) {
		//	}
		
		//อันนี้คือเวลากดคลิ๊กจะ + แกน y เพิ่มเข้าไป
//		if (Gdx.input.isTouched()) {
//            y += 500 * Gdx.graphics.getDeltaTime();
//        }
		//อันนี้คือเวลา x มันหลุดขอบ ก็ให้มันมาเริ่มที่ 0 ใหม่
		if (x > 750) {
			x = 750;
		}
		if (x < 0) {
			x = 0;
		}
//		if (y < 0 || x > WIDTH || y >600) {
//            x = 0;
//            y = HEIGHT / 2;
//        }
	}
	//ฟังก์ชั่นนี้จะทำงานตอนปิดโปรแกรม
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

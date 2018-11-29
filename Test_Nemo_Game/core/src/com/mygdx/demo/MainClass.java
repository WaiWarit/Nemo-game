package com.mygdx.demo;

import com.badlogic.gdx.ApplicationAdapter;
import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainClass extends ApplicationAdapter {
	//set ค่าไว้เพื่อที่จะเอาไว้เช็คไม่ให้ทะลุขอบ
	public static final int WIDTH = 840;
	public static final int HEIGHT= 600;
	
	Random rand = new Random (); //อันนี้เอาไว้randomค่าตัวเลข
	
	SpriteBatch batch;
	
	Texture img, img2, img3, img4; //รูป
	
	float x1 = 0; // ค่า x ของเรือ
	float y1 = 400; // ค่า y ของเรือ
	
	float x2 = 0; // ค่า x ของปลาตัวแรก
	float y2 = 400; // ค่า y ของปลาตัวแรก
	
	float x3 = 0; // ค่า x ของปลาตัวสอง
	float y3 = 400; // ค่า y ของปลาตัวสอง
	
	float x4 = 0; // ค่า x ของปลาตัวสาม
	float y4 = 400; // ค่า y ของปลาตัวสาม

	
	//ประกาศตัวแปร font
	//BitmapFont font;
	
	//ฟังก์ชั่นนี้จะทำตอนเริ่มโปรแกรม
	@Override
	public void create () {
		// random เพื่อที่จะให้ปลาเริ่มตำแหน่งสุ่ม
		x2 = rand.nextInt(840);
		y2 = rand.nextInt(300);
		x3 = rand.nextInt(840);
		y3 = rand.nextInt(300);
		x4 = rand.nextInt(840);
		y4 = rand.nextInt(300);
		
		
		batch = new SpriteBatch();
		//set รูปภาพ
		img = new Texture(Gdx.files.internal("1.jpg"));
		img2 = new Texture(Gdx.files.internal("2.png"));
		img3 = new Texture(Gdx.files.internal("3.png"));
		img4 = new Texture(Gdx.files.internal("4.png"));
		
		//สร้างฟอนด์ + กำหนดสีฟอนต์//
		//font = new BitmapFont();
		//font.setColor(Color.WHITE);
	
	}

	//ฟังก์ชั่นนี้คือ จะทำตลอดเวลาตั้งแต่เปิดโปรแกรม
	@Override
	public void render () {
		
		
		Gdx.gl.glClearColor(0, 1, 0, 1);//อันนี้ทำให้พื้นหลังเป็นสีเขียว
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		//set text และ set ตำแหน่ง
		//font.draw(batch, "Hello World", 300, 300);
		
		//สั่งให้batch ทำการวาดภาพที่ตำแหน่ง (ตำแปรรูป, ตำแหน่งแกน x, ตำแหน่งแกน y, width, height)
		batch.draw(img, x1, y1, 100, 100);//อันนี้คือสร้างเรือ
		
		batch.draw(img2, x2, y2, 100, 100);//อันนี้คือปลาตัวแรก
		batch.draw(img3, x3, y3, 100, 100);//ตัวสอง
		batch.draw(img4, x4, y4, 100, 100);//ตัวสาม
		batch.end();
		//อันนี้ทำให้ปลาขยับ ลองปรับเลขข้างหน้าดู
		x2 += 300 * Gdx.graphics.getDeltaTime();
		x3 += 300 * Gdx.graphics.getDeltaTime();
		x4 += 300 * Gdx.graphics.getDeltaTime();
		//ทำให้รูปภาพขยับ
//		y -= 200 * Gdx.graphics.getDeltaTime();
//		x += 100 * Gdx.graphics.getDeltaTime();
//		
		//อันนี้คือดักว่าถ้ากดลูกศรซ้ายจะทำไร ขวาทำไร
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x1 += 500 * Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x1 -= 500 * Gdx.graphics.getDeltaTime();
		}
		
		//อันนี้คือเวลากดปุม ตัวอย่างคือ space bar
		//if (Gdx.input.isKeyPressed(Keys.SPACE)) {
		//	}
		
		//อันนี้คือเวลากดคลิ๊กจะ + แกน y เพิ่มเข้าไป
//		if (Gdx.input.isTouched()) {
//            y += 500 * Gdx.graphics.getDeltaTime();
//        }
		
		//อันนี้คือเวลา x มันหลุดขอบ ก็ให้มันมาเริ่มที่ 750 ใหม่
		if (x1 > 750) {
			x1 = 750;
		}
		if (x2 > 850) {
			x2 = -100;
		}
		if (x3 > 850) {
			x3 = -100;
		}
		if (x4 > 850) {
			x4 = -100;
		}
		//อันนี้คือเวลา x มันหลุดขอบ ก็ให้มันมาเริ่มที่ 0 ใหม่
		if (x1 < 0) {
			x1 = 0;
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

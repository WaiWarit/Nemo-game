package Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BigFish {
	Texture fish;
	Sprite test;
	boolean check = true;
	
	int x, y; // เอาค่า x กับ y มากำหนด position ของปลา
	int a= 10;
	
	public BigFish(float x2, float y2) {
		fish = new Texture(Gdx.files.internal("sqiud.png"));
		test = new Sprite(fish);
		test.setPosition(x2, y2);
		test.setSize(100, 100); // setขนาด

	}
	
	public BigFish() {
		fish = new Texture(Gdx.files.internal("sqiud.png"));
		test = new Sprite(fish);
		test.setPosition(0, 0);
		test.setSize(100, 100); //set ขนาด
		
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//สร้างปลา
	public void draw(SpriteBatch batch) {
		test.draw(batch);
		
	}
	// ฟังก์ชั่นนี้ทำเพื่อให้ปลาเคลื่อนที่ ถ้าปลาชนขอบขวาให้ปลาไปทางซ้ายแทน
	public void update() {
		if(this.x >= 1280) {
			check = false;
		}
		if (this.x <= 0) {
			check = true;
		}
		if (check) {
			this.x++;
			this.x = x + a;
		}else {
			this.x--;
			this.x = x - a;
		}
		test.setPosition(this.x, this.y);
	}

	
}

package GameManager;

import com.mygdx.game.MenuStage;
import com.mygdx.game.PlayState;

public class GameStateManager {

	public static GameState state;
	
	public static final int PLAY = 1;
	public static final int MENU = 0;
	
	
	public void setState(int state) {
		
		if (this.state != null) {
			this.state.dispose();
		}
		
		if(state == MENU) {
			this.state = new MenuStage(this);
		}
		
		if(state == PLAY) {
			this.state = new PlayState(this);
		}
		
		this.state.create();
		
	}
	
	
	public void render() {
		state.render();
	}
	
	public void dispose() {
		state.dispose();
	}
	
	
}

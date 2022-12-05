package Entities;

import java.io.IOException;
import java.util.Random;

import info3.game.EntityManager;
import info3.game.Game;

public class Boss extends Entity {

	public Boss(int m_x, int m_y, Game game) throws IOException {
		super(game, "Boss");
		m_images = loadSprite("resources/Boss.png", 1, 1);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(40, x, y);
		type = 1;
		speed = 4;
		vie = 25;
		moveCDR = 20;
		waitR = 500;

	}

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);
	}

	public void egg(Direction dir) {
		Random r = new Random();
		int j = r.nextInt(3) + 2;
		for (int i = 0; i < j; i++) {
			try {
				game.EM.EM_add(new Ennemis(x, y, game));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		wait = waitR;
	}
}

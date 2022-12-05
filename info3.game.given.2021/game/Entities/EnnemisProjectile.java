package Entities;

import java.io.IOException;

import info3.game.EntityManager;
import info3.game.Game;

public class EnnemisProjectile extends Entity {
	public EnnemisProjectile(int m_x, int m_y, Game game) throws IOException {
		super(game, "EnnemisP");
		m_images = loadSprite("resources/idle.png", 4, 12);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(25, x, y);
		type = 1;
		speed = 1;
		vie = 2;
		moveCDR = 10;
	}

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);
	}

	public void move(Direction dir) {
		super.move(dir);
	}

	public void pop(Direction dir) {
		if (hitCD > 0)
			return;
		hitCD = 2000;

		Entity player1 = game.getPlayer1();
		Entity player2 = game.getPlayer2();
		double p1 = game.modele.distance(this.x, this.y, player1.x, player1.y);
		double p2 = game.modele.distance(this.x, this.y, player2.x, player2.y);

		if (p1 < p2) {
			dir = targetDirection(player1.x, player1.y, 100);
		} else {
			dir = targetDirection(player2.x, player2.y, 100);
		}
		try {
			EM.EM_add(new Projectile(x, y, 2, dir, 3, 2, 4000, "Balle","balleE", 10, game));
		} catch (IOException e) {
			e.printStackTrace();
		}
		hitCD = hitCDR;

	}
}

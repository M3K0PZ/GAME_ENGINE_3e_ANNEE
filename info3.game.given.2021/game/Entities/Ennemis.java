package Entities;

import java.io.IOException;

import info3.game.EntityManager;
import info3.game.Game;

public class Ennemis extends Entity {

	public Ennemis(int m_x, int m_y, Game game) throws IOException {
		super(game, "Ennemis");
		m_images = loadSprite("resources/idle.png", 4, 12);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(25, x, y);
		type = 1;
		speed = 3;
		vie = 3;
		waitR = 30;
	}

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);
	}

	public void pop(Direction dir) {
		Entity player1 = game.getPlayer1();
		Entity player2 = game.getPlayer2();
		double p1 = game.modele.distance(this.x, this.y, player1.x, player1.y);
		double p2 = game.modele.distance(this.x, this.y, player2.x, player2.y);
		if (p1 < p2) {
			dir = targetDirection(player1.x, player1.y, 200);
		} else {
			dir = targetDirection(player2.x, player2.y, 200);
		}

		this.direction = dir;
	}
}

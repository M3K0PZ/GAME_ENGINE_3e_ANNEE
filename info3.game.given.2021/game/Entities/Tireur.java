package Entities;

import java.io.IOException;

import info3.game.EntityManager;
import info3.game.Game;

public class Tireur extends Entity {

	public Tireur(int m_x, int m_y, String name, Game game) throws IOException {
		super(game, name);
		m_images = loadSprite("resources/Tireur.png", 4, 6);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(25, x, y);
		type = 0;
		speed = 6;
		vie = 10;
		damageCDR = 1500;
	}

	public void Teleporte_joueur(int m_x, int m_y) {
		x = m_x;
		y = m_y;
	}

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);
	}

	public void move(Direction dir) {
		super.move(dir);
		set_orientation();
	}

	public void set_orientation() {
		switch (this.direction) {
		case NW:
			m_imageIndex = 10;
			break;
		case NE:
			m_imageIndex = 16;
			break;
		case SW:
			m_imageIndex = 4;
			break;
		case SE:
			m_imageIndex = 23;
			break;
		case W:
			m_imageIndex = 7;
			break;
		case E:
			m_imageIndex = 20;
			break;
		case N:
			m_imageIndex = 13;
			break;
		case S:
			m_imageIndex = 1;
			break;
		default:
			break;
		}
	}

	public void pop(Direction dir) {
		if (hitCD > 0)
			return;
		hitCD = 750;
		Projectile balle;
		try {
			balle = new Projectile(x, y, 3, this.direction, 3, 2, 4000, "Balle","balle", 10, game);
			this.EM.EM_add(balle);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package Entities;

import java.io.IOException;

import info3.game.EntityManager;
import info3.game.Game;

public class Fantome extends Entity {

	public Fantome(String name, int m_x, int m_y, Game game) throws IOException {
		super(game, name);

		m_images = loadSprite("resources/Fantome.png", 4, 6);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(25, x, y);
		type = 0;
		speed = 3;
		vie = 1;
		moveCDR = 8;
		damageCDR = 2000;
	}

	public void Teleporte_joueur(int m_x, int m_y) {
		x = m_x;
		y = m_y;
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

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);

	}

	public void move(Direction dir) {
		super.move(dir);
		set_orientation();
	}

}

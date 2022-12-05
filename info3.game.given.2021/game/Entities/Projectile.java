package Entities;

import java.io.IOException;

import info3.game.EntityManager;
import info3.game.Game;

public class Projectile extends Entity {

	long duree = 4000;

	public Projectile(int m_x, int m_y, int type, Direction dir, int speed, int tickRate, int duree, String name,
			String spriteName, int r, Game game) throws IOException {
		super(game, name);
		m_images = loadSprite("resources/" + spriteName + "." + "png", 1, 1);
		this.Name = name;
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(r, x, y);
		this.type = type;
		this.speed = speed;
		this.moveCDR = tickRate;
		this.direction = dir;
		this.duree = duree;
		vie = 1;
	}

	public void tick(EntityManager EM, long elapsed) throws IOException {
		super.tick(EM, elapsed);
		duree -= elapsed;
		if (duree < 0) {
			vie = 0;
		}
	}
}

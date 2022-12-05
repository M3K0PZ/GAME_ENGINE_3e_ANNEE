package Entities;

import java.awt.Graphics;
import automaton.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import info3.game.*;

public abstract class Entity extends Object {

	static final Direction[] boussole = { Direction.N, Direction.NE, Direction.E, Direction.SE, Direction.S,
			Direction.SW, Direction.W, Direction.NW };
	public Automate Aut; //
	public String Name; //
	protected Game game;
	protected BufferedImage[] m_images; //
	protected int m_imageIndex;
	protected int x = 0, y = 0;
	protected Hitbox hitbox; //
	protected int type; //
	protected Modele modele;
	protected EntityManager EM;
	public Direction direction = Direction.E;

	// Stats
	protected int speed; //
	protected int vie; //

	// Cooldowns
	protected long moveCD = 0;
	protected long hitCD = 0;
	protected long damageCD = 0;
	public long wait = 0;

	// Valeur
	protected long moveCDR = 25;
	protected long hitCDR = 200;
	protected long damageCDR = 250;
	protected long waitR = 5000;

	public Entity(Game game) {
		this.Name = "Undefined";
		this.game = game;
		m_images = null;
		m_imageIndex = 0;
		this.type = -1;
		this.modele = game.modele;
		this.EM = game.EM;
		vie = 1000;
		speed = 0;
		// game.automatemap.associate(this);
	}

	public Entity(Game game, String name) {
		this.Name = name;
		this.game = game;
		m_images = null;
		m_imageIndex = 0;
		this.type = -1;
		this.modele = game.modele;
		this.EM = game.EM;
		vie = 1000;
		speed = 0;
		game.automatemap.associate(this);
	}

	public Entity(Modele modele, String Name) {
		System.out.print(Name);
		this.Name = Name;

		this.modele = modele;

		m_images = null;
		m_imageIndex = 0;
		vie = 1;
		speed = 4;
	}

	public void move(Direction dir) {
		if (moveCD > 0) {
			return;
		}

		switch (dir) {
		case F:
		case R:
		case L:
		case B:
			dir = boussole(dir);
			break;
		default:
			break;
		}

		switch (dir) {
		case NW:
			x -= speed;
			y -= speed;
			break;
		case NE:
			x += speed;
			y -= speed;
			break;
		case SW:
			x -= speed;
			y += speed;
			break;
		case SE:
			x += speed;
			y += speed;
			break;
		case W:
			x -= speed;
			break;
		case E:
			x += speed;
			break;
		case N:
			y -= speed;
			break;
		case S:
			y += speed;
			break;
		default:
			break;
		}
		this.direction = dir;
		moveCD = moveCDR;

	}

	public void Wait() {
		if (wait > 0)
			return;
		wait = waitR;
	}

	public void pop(Direction dir) {

	}

	public void wizz(Direction dir) {

	}

	public void jump(Direction dir) {

	}

	public void turn(Direction dir) {
		switch (dir) {
		case F:
		case R:
		case L:
		case B:
			dir = boussole(dir);
			break;
		default:
			break;
		}
		this.direction = dir;

	}

	public void hit(Direction dir) {
		if (hitCD > 0) {
			return;
		}
		hitCD = hitCDR;
	}

	public void protect(Direction dir) {

	}

	public void pick(Direction dir) {

	}

	public void Throw(Direction dir) {

	}

	public void store() {

	}

	public void get() {

	}

	public void power() {

	}

	public void explode() {

	}

	public void egg(Direction dir) {
	}

	public void paint(Graphics g, int originex, int originey) {
		BufferedImage img = m_images[m_imageIndex];
		int scale = 2;
		g.drawImage(img, x - originex - getWidth(), y - originey - getHeight(), scale * img.getWidth(),
				scale * img.getHeight(), null);
		g.drawOval(x - originex - hitbox.getRayon(), y - originey - hitbox.getRayon(), hitbox.getRayon() * 2,
				hitbox.getRayon() * 2);
	}

	public void degatVie(int degat) {
		if (damageCD > 0)
			return;
		vie -= degat;
		damageCD = damageCDR;
	}

	public int getx() {
		return x;
	}

	public int gety() {

		return y;
	}

	public int getvie() {
		return vie;
	}

	public int getSpeed() {
		return speed;
	}

	public void setVie(int i) {
		vie = i;
	}

	public void Teleporte_joueur(int m_x, int m_y) {
		x = m_x;
		y = m_y;
	}

	public void step() throws Exception {
		if (wait > 0)
			return;
		this.Aut.step(this);
	}

	public void tick(EntityManager em, long elapsed) throws IOException {
		if (this.Aut.current().getName().equals(""))
			vie = 0;
		if (moveCD > 0)
			moveCD -= elapsed;
		if (damageCD > 0)
			damageCD -= elapsed;
		if (wait > 0)
			wait -= elapsed;
		if (hitCD > 0)
			hitCD -= elapsed;
		hitbox.relocate(x, y);
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public int getType() {
		return type;
	}

	public int getWidth() {
		return m_images[m_imageIndex].getWidth();
	}

	public int getHeight() {
		return m_images[m_imageIndex].getHeight();
	}

	public static BufferedImage[] loadSprite(String filename, int nrows, int ncols) throws IOException {
		File imageFile = new File(filename);
		if (imageFile.exists()) {
			BufferedImage image = ImageIO.read(imageFile);
			int width = image.getWidth(null) / ncols;
			int height = image.getHeight(null) / nrows;

			BufferedImage[] images = new BufferedImage[nrows * ncols];
			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < ncols; j++) {
					int x = j * width;
					int y = i * height;
					images[(i * ncols) + j] = image.getSubimage(x, y, width, height);
				}
			}
			return images;
		}
		return null;
	}

	public boolean MyDir(Direction Dir) {
		return Dir == this.direction;
	}

	public boolean GotPower() {
		return vie > 0;
	}

	public boolean GotStuff() {
		return false;
	}

	public boolean key(Key k) {
		return this.game.getListener().key(k);
	}

	public boolean cell(Direction dir, Type type) {

		return game.modele.collisions(this, game.EM.sort_affichage(), boussole(dir), type); // ICI J'AVAIS MIS BOUSSOLE
	}

	public boolean closest(Direction dir, Type type) {

		return false;// game.modele.collisions(this, game.EM.sort_affichage(), boussole(dir), type);
	}

	public Direction targetDirection(int x, int y, int tolerance) {
		String res = "";

		if ((this.y + tolerance >= y && this.y - tolerance <= y)) {
			if ((this.x + tolerance >= x && this.x - tolerance <= x)) {
				return targetDirectionSharp(x, y);
			}
		}

		if (this.y + tolerance < y) {
			res += "S";
		} else if (this.y - tolerance > y) {
			res += "N";
		}

		if (this.x + tolerance < x) {
			res += "E";
		} else if (this.x - tolerance > x) {
			res += "W";
		}

		return Direction.valueOf(res);
	}

	public Direction targetDirectionSharp(int x, int y) {
		String res = "";
		if (this.y != y) {
			if (this.y > y) {
				res += "N";
			} else {
				res += "S";
			}
		}
		if (this.x != x) {
			if (this.x > x) {
				res += "W";
			} else {
				res += "E";
			}
		}
		if (res == "") {
			return Direction.F;
		}
		return Direction.valueOf(res);
	}

	// Prend une direction relative, renvoie la direction absolue correspondante a
	// cette entitée

	public Direction boussole(Direction dir) {
		int index = 0;
		switch (this.direction) {
		case E:
			index = 2;
			break;
		case N:
			index = 0;
			break;
		case NE:
			index = 1;
			break;
		case NW:
			index = 7;
			break;
		case S:
			index = 4;
			break;
		case SE:
			index = 3;
			break;
		case SW:
			index = 5;
			break;
		case W:
			index = 6;
			break;
		default:
			break;
		}

		switch (dir) {
		case E:
			index = 2;
			break;
		case N:
			index = 0;
			break;
		case NE:
			index = 1;
			break;
		case NW:
			index = 7;
			break;
		case S:
			index = 4;
			break;
		case SE:
			index = 3;
			break;
		case SW:
			index = 5;
			break;
		case W:
			index = 6;
			break;
		case F:
			return this.direction;
		case L:
			index = (index + 7) % 8;
			break;
		case R:
			index = (index + 1) % 8;
			break;
		case B:
			index = (index + 4) % 8;
			break;
		default:
			break;
		}
		return boussole[index];
	}
}

package Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import info3.game.*;

import javax.imageio.ImageIO;

public class Mur extends Entity {
	int taille;

	public Mur(int m_x, int m_y, String name, int r, Game game) throws IOException {
		super(game, "Mur");
		m_images = loadSprite("resources/images_test/noir_20x20.png", 1, 1);
		x = m_x;
		y = m_y;
		hitbox = new Hitbox(r, x, y);
		type = 6;
	}

	public static Image loadImage(String filename) throws IOException {
		File imageFile = new File(filename);
		if (imageFile.exists()) {
			BufferedImage image = ImageIO.read(imageFile);
			return image;
		}
		return null;
	}
}
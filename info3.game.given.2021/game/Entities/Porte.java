package Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import Map.Salle;
import info3.game.*;

public class Porte extends Entity {

	public boolean etat; // =false si porte fermé, =true si porte ouverte

	public Salle salle_origine;
	public Salle salle_destination;

	public int orientation_salle_origine; // Indique l'orientation de la porte dans la salle 1
	public int orientation_salle_destination; // Indique l'orientation de la porte dans la salle 2
	/*
	 * Valeurs : 0 = Nord 1 = Est 2 = Sud 3 = Ouest
	 */

	public Porte(int m_x, int m_y, Game game) { // Porte spéciale qui enclenche le changement de niveau
		super(game, "Portail");
		try {
			this.m_images = loadSprite("resources/images_test/jaune_20x20.jpg", 1, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		salle_origine = null;
		orientation_salle_origine = -1;
		salle_destination = null;
		orientation_salle_destination = -1;
		this.etat = true;
		x = m_x;
		y = m_y;
		this.type = 7;
		hitbox = new Hitbox(20, x, y);

	}

	public Porte(Salle salle, int orientation, Game game) throws IOException { // Créer une porte dans une salle sans la
																				// lié à une autre salle
		super(game, "Porte");
		this.m_images = loadSprite("resources/images_test/jaune_20x20.jpg", 1, 1);
		salle_origine = salle;
		orientation_salle_origine = orientation;
		salle_destination = null;
		orientation_salle_destination = -1;
		this.etat = false;

		switch (orientation) {
		case 0:
			x = 24 * 40;
			y = 0;
			break;
		case 1:
			x = 48 * 40;
			y = 24 * 40;
			break;
		case 2:
			x = 24 * 40;
			y = 48 * 40;
			break;
		default:
			x = 0;
			y = 24 * 40;
			break;

		}
		hitbox = new Hitbox(20, x, y);
		type = 7;
	}

	public static Image loadImage(String filename) throws IOException {
		File imageFile = new File(filename);
		if (imageFile.exists()) {
			BufferedImage image = ImageIO.read(imageFile);
			return image;
		}
		return null;
	}

	void Destination_porte(Salle s, int orientation) {
		salle_destination = s;
		orientation_salle_destination = orientation;
	}

	public boolean GotStuff() { // Change l'etat de la porte en true s'il n'y a plus d'ennemis dans la salle
		List<Entity> list = game.EM.getDynamic();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).type == 1) {
				return false;
			}
		}
		wait = waitR;
		// Change l'etat de la salle_origine en salle_vide = true si renvoie true
		return true;
	}

	public void pop(Direction dir) {
		this.etat = true;
		salle_origine.salle_vide = true;
	}

}

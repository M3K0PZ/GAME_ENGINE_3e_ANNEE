package Entities;

import java.io.IOException;

import info3.game.Game;

public class Rocher extends Entity {
	int taille;
	
	public Rocher (int m_x, int m_y,Game game) throws IOException{
		super(game,"Rocher");
		m_images = loadSprite("resources/images_test/marron_20x20.jpg",1,1);
		// this.m_images = loadSprite("resources/images_test/Rocher2.png",1,1);
		x = m_x;
		y = m_y;
				
		hitbox = new Hitbox(20,x,y);
		type = 5;
	}
	
	
	
	
}

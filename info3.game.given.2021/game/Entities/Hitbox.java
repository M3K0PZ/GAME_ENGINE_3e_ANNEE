package Entities;

public class Hitbox {

	private int rayon;
	private int x, y;

	public Hitbox(int rayon, int m_x, int m_y) {
		this.rayon = rayon;
		this.x = m_x;
		this.y = m_y;
	}

	public void relocate(int m_x, int m_y) {
		this.x = m_x;
		this.y = m_y;
	}

	public int getRayon() {
		return rayon;
	}

	public int getAbscisse() {
		return x;
	}

	public int getOrdonnee() {
		return y;
	}
}

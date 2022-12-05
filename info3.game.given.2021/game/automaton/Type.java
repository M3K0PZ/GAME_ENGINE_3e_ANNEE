package automaton;

public enum Type {
	
	/*
	A, //Adversaire	- 1: Ennemi 
	C, //Clue		- 3: Missile Joueur 
	D, //Danger		-
	G, //Gate		- 7: Porte
	J, //Jumpable	- 5: Rocher
	M, //Missile	- 2: Missile Ennemi 
	O, //Obstacle	- 6: Mur 
	P, //Prendre	-
	T, //Team 
	V, //Void		- 4: Fantome
	@, //Joueur		- 0: Joueur
	_  //NIMPORTE
	 */
	
	ADVERSAIRE("A"), CLUE("C"), DANGER("D"), GATE("G"), JUMPABLE("J"), MISSILE("M"), OBSTACLE("O"), PRENDRE("P"),
	TEAM("T"), VOID("V"), PLAYER("@"), NIMPORTE("_");

	private String value;

	private Type(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	

}

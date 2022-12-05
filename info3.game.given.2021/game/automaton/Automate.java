package automaton;

import java.util.List;

import Entities.Entity;

public class Automate {
	public String name;
	Etat current;
	List<Etat> etats;

	public Automate() {
	}

	public Automate(String name, Etat initial, List<Etat> etats, Type type) {
		this.name = name;
		this.current = initial;
		this.etats = etats;
	}

	public Automate(String Name) {
		name = Name;
		current = new Etat("Init");
	}

	public Automate copy() {
		Automate a = new Automate();
		a.name = this.name;
		a.current = current;
		a.etats = etats;
		return a;
	}

	public Etat current() {
		return current;
	}

	public void addEtat(Etat e) {
		etats.add(e);
	}

	public void step(Entity e) throws Exception {
		Etat etat = null;
		etat = current.doTransition(e);
		if (etat != null) {
			current = etat;
		}
	}

	public boolean autStatic() {
		return (this.name.equals("Static"));
	}

}

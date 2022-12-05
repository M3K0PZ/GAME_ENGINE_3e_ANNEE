package automaton;

import java.util.LinkedList;
import java.util.List;

import Entities.Entity;

public class Etat {
	String name;
	List<ATransition> transitions;

	public Etat(String name) {
		this.name = name;
		transitions = new LinkedList<ATransition>();
	}

	public Etat(String name, List<ATransition> list) {
		this.name = name;
		this.transitions = list;
	}

	public void addTransition(ATransition t) {
		transitions.add(t);
	}

	public Etat doTransition(Entity e) throws Exception {
		for (int i = 0; i < transitions.size(); i++) {
			if (transitions.get(i).testTransition(e)) {
				return transitions.get(i).applyTransition(e);
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}
}

package automaton;

import Entities.Entity;

public class Explode implements IAction {

	public Explode() {
	}

	@Override
	public void apply(Entity e) {
		e.explode();
	}
}

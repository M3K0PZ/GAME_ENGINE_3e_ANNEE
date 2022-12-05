package automaton;

import Entities.Entity;

public class Store implements IAction {

	public Store() {
	}

	@Override
	public void apply(Entity e) {
		e.store();
	}
}

package automaton;

import Entities.Entity;

public class Get implements IAction {

	public Get() {
	}

	@Override
	public void apply(Entity e) {
		e.get();
	}
}

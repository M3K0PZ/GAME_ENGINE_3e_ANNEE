package automaton;

import Entities.Entity;

public class Power implements IAction {

	public Power() {
	}

	@Override
	public void apply(Entity e) {
		e.power();
	}
}

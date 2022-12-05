package automaton;

import Entities.Entity;

public class GotStuff implements ICondition {

	public GotStuff() {
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return e.GotStuff();
	}
}

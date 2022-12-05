package automaton;

import Entities.Entity;

public class GotPower implements ICondition {

	public GotPower() {

	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return e.GotPower();
	}
}

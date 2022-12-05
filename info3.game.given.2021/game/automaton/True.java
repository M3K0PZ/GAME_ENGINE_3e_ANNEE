package automaton;

import Entities.Entity;

public class True implements ICondition {

	public True() {
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return true;
	}

}

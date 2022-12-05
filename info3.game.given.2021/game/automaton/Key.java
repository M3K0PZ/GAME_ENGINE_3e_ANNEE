package automaton;

import Entities.Entity;

public class Key implements ICondition {
	Entities.Key k;

	public Key(String s) {
		this.k = Entities.Key.valueOf(s.toUpperCase());
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return e.key(k);
	}
}

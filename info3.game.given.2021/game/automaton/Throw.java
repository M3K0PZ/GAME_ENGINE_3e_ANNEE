package automaton;

import Entities.Direction;
import Entities.Entity;

public class Throw implements IAction {
	Direction dir;

	public Throw() {
		dir = Direction.F;
	}

	public Throw(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.Throw(dir);
	}
}

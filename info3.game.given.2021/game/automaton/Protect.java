package automaton;

import Entities.Direction;
import Entities.Entity;

public class Protect implements IAction {
	Direction dir;

	public Protect() {
		dir = Direction.F;
	}

	public Protect(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.protect(dir);
	}
}

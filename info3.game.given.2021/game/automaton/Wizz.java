package automaton;

import Entities.Direction;
import Entities.Entity;

public class Wizz implements IAction {

	Direction dir;

	public Wizz() {
		dir = Direction.F;
	}

	public Wizz(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.wizz(dir);
	}

}

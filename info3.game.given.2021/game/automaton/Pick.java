package automaton;

import Entities.Direction;
import Entities.Entity;

public class Pick implements IAction {

	Direction dir;

	public Pick() {
		dir = Direction.F;
	}

	public Pick(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.pick(dir);
	}
}

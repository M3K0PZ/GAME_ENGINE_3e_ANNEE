package automaton;

import Entities.Direction;
import Entities.Entity;

public class Jump implements IAction {
	Direction dir;

	public Jump() {
		dir = Direction.F;
	}

	public Jump(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.jump(dir);
	}
}

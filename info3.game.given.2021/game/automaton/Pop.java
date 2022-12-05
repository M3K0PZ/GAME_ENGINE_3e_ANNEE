package automaton;

import Entities.Direction;
import Entities.Entity;

public class Pop implements IAction {

	Direction dir;

	public Pop() {
		dir = Direction.F;
	}

	public Pop(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.pop(dir);
	}

}

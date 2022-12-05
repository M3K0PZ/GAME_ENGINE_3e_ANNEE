package automaton;

import Entities.Direction;
import Entities.Entity;

public class Move implements IAction {

	Direction dir;

	public Move() {
		dir = Direction.F;
	}

	public Move(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.move(dir);
	}

}

package automaton;

import Entities.Direction;
import Entities.Entity;

public class Turn implements IAction{
	Direction dir;

	public Turn() {
		dir = Direction.F;
	}

	public Turn(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.turn(dir);
	}
}

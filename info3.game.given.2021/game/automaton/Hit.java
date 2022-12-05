package automaton;

import Entities.Direction;
import Entities.Entity;

public class Hit implements IAction {
	Direction dir;

	public Hit() {
		dir = Direction.F;
	}

	public Hit(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.hit(dir);
	}
}

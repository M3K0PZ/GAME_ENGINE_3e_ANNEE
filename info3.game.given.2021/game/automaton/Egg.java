package automaton;

import Entities.Direction;
import Entities.Entity;

public class Egg implements IAction {

	Direction dir;

	public Egg() {
		dir = Direction.F;
	}

	public Egg(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public void apply(Entity e) {
		e.egg(dir);
	}
}

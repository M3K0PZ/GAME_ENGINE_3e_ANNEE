package automaton;

import Entities.Direction;
import Entities.Entity;

public class MyDir implements ICondition {
	Direction dir;

	public MyDir(String s) {
		dir = Direction.valueOf(s);
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return e.MyDir(dir);
	}
}

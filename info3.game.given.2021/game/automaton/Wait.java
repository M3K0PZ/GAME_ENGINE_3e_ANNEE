package automaton;

import Entities.Entity;

public class Wait implements IAction {

	public Wait() {
	}

	@Override
	public void apply(Entity e) {
		e.Wait();

	}

}

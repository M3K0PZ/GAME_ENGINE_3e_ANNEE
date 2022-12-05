package automaton;

import Entities.*;

public interface ICondition {

	public boolean eval(Entity e) throws Exception;
}

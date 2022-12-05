package automaton;

import Entities.Entity;

public class UnaryOperation implements ICondition {
	ICondition cond;
	String operator;

	public UnaryOperation(ICondition cond, String op) {
		this.cond = cond;
		operator = op;
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		switch (operator) {
		case "!":
			return !(cond.eval(e));
		default:
			return cond.eval(e);
		}
	}
}

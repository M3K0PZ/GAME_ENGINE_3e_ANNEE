package automaton;

import Entities.Entity;

public class BinaryOperation implements ICondition {

	ICondition left;
	ICondition right;
	String operator;

	public BinaryOperation(ICondition l, ICondition r, String op) {
		left = l;
		right = r;
		operator = op;
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		switch (operator) {
		case "&":
			return left.eval(e) && right.eval(e);
		case "/":
			return left.eval(e) || right.eval(e);
		default:
			throw new Exception("Erreur eval BinaryOperation Operator inconnue");

		}
	}
}

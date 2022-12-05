package automaton;

import Entities.Direction;
import Entities.Entity;

public class Closest implements ICondition {
	Direction dir;
	Type type;

	public Type convert(String s) {
		switch (s) {
		case "A":
			return Type.ADVERSAIRE;
		case "C":
			return Type.CLUE;
		case "D":
			return Type.DANGER;
		case "G":
			return Type.GATE;
		case "J":
			return Type.JUMPABLE;
		case "M":
			return Type.MISSILE;
		case "O":
			return Type.OBSTACLE;
		case "P":
			return Type.PRENDRE;
		case "T":
			return Type.TEAM;
		case "V":
			return Type.VOID;
		case "@":
			return Type.PLAYER;
		case "_":
			return Type.NIMPORTE;
		default:
			return Type.NIMPORTE;

		}
	}

	public Closest(String dir, String type) {
		this.dir = Direction.valueOf(dir);
		this.type = convert(type);
	}

	@Override
	public boolean eval(Entity e) throws Exception {
		return e.closest(dir, type);
	}

}

/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Created on: March, 2020
 *      Author: Dr. Michaël Périn, Univ. Grenobles-Alpes
 */

package automaton;

import info3.game.automata.ast.*;
import info3.game.automata.ast.Transition;
import info3.game.automata.parser.AutomataParser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BotBuilder implements IVisitor {

	List<Automate> automates;
	Automate current;

	public BotBuilder() {
		automates = new LinkedList<Automate>();
	}

	@Override
	public Object visit(Category cat) {
		return cat.terminal.content;
	}

	@Override
	public Object visit(Direction dir) {
		return dir.terminal.content;
	}

	@Override
	public Object visit(info3.game.automata.ast.Key key) {
		return key.terminal.content;
	}

	@Override
	public Object visit(Value v) {
		return v.value;
	}

	@Override
	public Object visit(Underscore u) {
		return u.toString();
	}

	@Override
	public void enter(FunCall funcall) {
	}

	@Override
	public Object exit(FunCall funcall, List<Object> parameters) {
		if (parameters.isEmpty())
			return new AppelFonc(funcall.name, funcall.percent);
		else {
			List<String> arg = new LinkedList<String>();
			for (Object temp : parameters) {
				arg.add((String) temp);
			}
			return new AppelFonc(funcall.name, funcall.percent, arg);
		}
	}

	@Override
	public Object visit(BinaryOp operator, Object left, Object right) {

		try {
			left = (ICondition) convertAppelFonc((AppelFonc) left);
		} catch (Exception e) {
		}
		try {
			right = (ICondition) convertAppelFonc((AppelFonc) right);
		} catch (Exception e) {
		}

		return new BinaryOperation((ICondition) left, (ICondition) right, operator.operator);
	}

	@Override
	public Object visit(UnaryOp operator, Object expression) {

		try {
			return new UnaryOperation((ICondition) convertAppelFonc((AppelFonc) expression), operator.operator);
		} catch (Exception e) {
			return new UnaryOperation((ICondition) expression, operator.operator);
		}

	}

	@Override
	public Object visit(State state) {
		for (Etat temp : current.etats) {
			if (temp.name.equals(((State) state).toString())) {
				return temp;
			}
		}
		Etat e = new Etat(((State) state).toString());
		current.addEtat(e);
		return e;
	}

	@Override
	public void enter(Mode mode) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object exit(Mode mode, Object source_state, Object behaviour) {
		for (Object transitions : (List<ATransition>) behaviour) {
			((Etat) source_state).addTransition((ATransition) transitions);
		}
		return behaviour;
	}

	@Override
	public Object visit(Behaviour behaviour, List<Object> transitions) {
		return transitions;
	}

	@Override
	public void enter(Condition condition) {
	}

	@Override
	public Object exit(Condition condition, Object expression) {
		try {
			return convertAppelFonc((AppelFonc) expression);
		} catch (Exception e) {
			return expression;
		}
	}

	@Override
	public void enter(Action action) {
	}

	@Override
	public Object exit(Action action, List<Object> funcalls) {
		Map<IAction, Integer> actions = new HashMap<IAction, Integer>();
		for (Object currentAction : funcalls) {
			actions.put((IAction) convertAppelFonc((AppelFonc) currentAction), ((AppelFonc) currentAction).percent);
		}
		return actions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object visit(Transition transition, Object condition, Object action, Object target_state) {
		return new ATransition((ICondition) condition, (Etat) target_state, (Map<IAction, Integer>) action);
	}

	@Override
	public void enter(Automaton automaton) {
		current = new Automate(automaton.name, null, new LinkedList<Etat>(), null);
	}

	@Override
	public Object exit(Automaton automaton, Object initial_state, List<Object> modes) {
		current.current = current.etats.get(0);
		return current;
	}

	@Override
	public Object visit(AST bot, List<Object> automata) {
		return automata;
	}

	public Object convertAppelFonc(AppelFonc af) {
		if (!(af.arguments.isEmpty()))
			return convertAppelFonc2(af);
		switch (af.name) {

		// ACTIONS
		case "Move":
			return new Move();
		case "Pop":
			return new Pop();
		case "Wizz":
			return new Wizz();
		case "Wait":
			return new Wait();
		case "Jump":
			return new Jump();
		case "Turn":
			return new Turn();
		case "Hit":
			return new Hit();
		case "Protect":
			return new Protect();
		case "Pick":
			return new Pick();
		case "Throw":
			return new Throw();
		case "Store":
			return new Get();
		case "Power":
			return new Power();
		case "Explode":
			return new Explode();
		case "Egg":
			return new Egg();

		// CONDITIONS
		case "True":
			return new True();
		case "GotPower":
			return new GotPower();
		case "GotStuff":
			return new GotStuff();

		default:
			System.out.println("Non ajouté dans le switch convertAppelFonc dans BotBuilder :" + af.name);
			return null;
		}
	}

	public Object convertAppelFonc2(AppelFonc af) {
		switch (af.name) {

		// ACTIONS
		case "Move":
			return new Move(af.arguments.get(0));
		case "Pop":
			return new Pop(af.arguments.get(0));
		case "Wizz":
			return new Wizz(af.arguments.get(0));
		case "Jump":
			return new Jump(af.arguments.get(0));
		case "Turn":
			return new Turn(af.arguments.get(0));
		case "Hit":
			return new Hit(af.arguments.get(0));
		case "Protect":
			return new Protect(af.arguments.get(0));
		case "Pick":
			return new Pick(af.arguments.get(0));
		case "Throw":
			return new Throw(af.arguments.get(0));
		case "Egg":
			return new Egg(af.arguments.get(0));

		// CONDITIONS

		case "Key":
			return new Key(af.arguments.get(0));
		case "MyDir":
			return new MyDir(af.arguments.get(0));
		case "Cell":
			return new Cell(af.arguments.get(0), af.arguments.get(1));
		case "Closest":
			return new Closest(af.arguments.get(0), af.arguments.get(1));
		default:
			System.out.println("Non ajouté dans le switch AppelFonc2 dans BotBuilder :" + af.name);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Automate> loadAutomata(String filename) {
		try {
			AST ast = (AST) AutomataParser.from_file(filename);

			List<Object> a = new LinkedList<Object>();
			a = (List<Object>) ast.accept(this);
			List<Automate> liste = new LinkedList<Automate>();

			for (Object current : a) {
				liste.add((Automate) current);
			}
			return liste;
		} catch (Exception ex) {
			return null;
		}
	}

}

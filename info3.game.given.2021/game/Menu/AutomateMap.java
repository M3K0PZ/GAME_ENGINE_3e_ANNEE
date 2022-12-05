package Menu;

import java.util.HashMap;
import java.util.Map;

import Entities.Entity;
import automaton.Automate;

public class AutomateMap {
	Map<String,Automate> associator;
	
	public AutomateMap() {
		associator = new HashMap<String,Automate>();
	}
	
	public void addAutomate(String entityName, Automate automate) {
		associator.put(entityName, automate);
	}
	
	public void associate(Entity e) {
		Automate a = associator.get(e.Name);
		e.Aut = a.copy();
	}

}

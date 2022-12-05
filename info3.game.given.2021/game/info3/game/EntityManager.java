package info3.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Entities.Entity;
import Entities.Porte;

public class EntityManager {

	protected Game game;

	protected ArrayList<Entity> Dynamic;
	protected ArrayList<Entity> Static;

	protected ArrayList<Entity> New_Dynamic;
	protected ArrayList<Entity> New_Static;

	EntityManager(Game game) {
		this.game = game;
		Dynamic = new ArrayList<Entity>();
		Static = new ArrayList<Entity>();
		New_Dynamic = new ArrayList<Entity>();
		New_Static = new ArrayList<Entity>();
	}

	public ArrayList<Entity> getDynamic() {
		return Dynamic;
	}

	public ArrayList<Entity> getStatic() {
		return Static;
	}

////////////////////////////////// ADD	
	public void EM_add(Entity obj) {
		System.out.println(obj.Name);
		if ((obj.getType() == 6) || (obj.getType() == 5)) {
			New_Static.add(obj);
		} else {
			New_Dynamic.add(obj);
		}
	}

//////////////////////////////////REMOVE
	public void EM_remove(Entity obj) {
		if ((obj.getType() == 6) || (obj.getType() == 5)) {// alors il est static;
			Static.remove(obj);
		} else {// alors il est dynamic;
			Dynamic.remove(obj);
		}
	}

	public void vider_EM_except_players() {
		this.New_Dynamic.clear();
		this.New_Static.clear();
		this.Static.clear();
		Dynamic.removeIf(n -> n.getType() != 0);
	}

	public void vider_EM() {
		this.New_Dynamic.clear();
		this.New_Static.clear();
		this.Static.clear();
		this.Dynamic.clear();
	}

	protected void organize() { // regarde toutes les entitées dynamiques, si leur flag vie = 0, alors elles
								// dégagent car elles sont mortes.
								// les static ne peuvent pas mourir car pas de concept de vie
		for (int i = 0; i < Dynamic.size(); i++) {
			if (Dynamic.get(i).getvie() == 0) { // mort : ça dégage
				if ((Dynamic.get(i).getType() != 0) && (Dynamic.get(i).getType() != 4)) {
					if ((Dynamic.get(i).getType() == 1) && (Dynamic.get(i).Name == "Boss")) {
						this.EM_add(new Porte(Dynamic.get(i).getx(), Dynamic.get(i).gety(), this.game));
					}
					Dynamic.remove(i);
					i--;
				}
			}
		}
	}

	public ArrayList<Entity> sort_affichage() {
		ArrayList<Entity> New_List = new ArrayList<Entity>();
		New_List.addAll(Dynamic);
		New_List.addAll(Static);

		Collections.sort(New_List, new Comparator<Entity>() {

			@Override
			public int compare(Entity o1, Entity o2) {
				return Integer.compare(o1.gety(), o2.gety());
			}
		});
		return New_List;
	}

	// stocks a list of entities into a list of dyn and static appart.
	public void list_to_EM(ArrayList<Entity> List) {
		for (int i = 0; i < List.size(); i++) {
			if ((List.get(i).getType() == 6) || (List.get(i).getType() == 5)) {
				Static.add(List.get(i));
			} else {
				Dynamic.add(List.get(i));
			}
		}
	}

	public void afficher_EM() {
		System.out.print(" ENTITY MANAGER AFFICHAGE : \n");

		System.out.print(" DYNAMIC LIST : \n");
		for (int i = 0; i < Dynamic.size(); i++) {
			System.out.print("Name : " + Dynamic.get(i).Name + " Automaton : " + Dynamic.get(i).Aut.name + "Life :"
					+ Dynamic.get(i).getvie() + "\n");
		}
		System.out.print("\n");
	}

	public void tick(long elapsed) throws Exception {

		for (int i = 0; i < Dynamic.size(); i++) { // seulement les dynamic font un step;
			Entity e = Dynamic.get(i);
			e.step(); // on ajoute pour les créations qui se font dans les nouvelles listes.
			e.tick(this, elapsed);
		}
		organize();
		Dynamic.addAll(New_Dynamic);
		Static.addAll(New_Static);
		New_Dynamic.clear();
		New_Static.clear();

	}

}
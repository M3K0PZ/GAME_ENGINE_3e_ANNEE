package Menu;

import java.util.List;

import javax.swing.JOptionPane;

import automaton.Automate;
import automaton.BotBuilder;
import info3.game.Game;

public class Menu {
	static Game game;

	/**
	 * Type 0: Joueur 1: Ennemi 2: Missile Ennemi 3: Missile Joeur 4: Fnatome 5:
	 * Rocher 6: Mur 7: Porte
	 * @throws Exception 
	 **/

	

	public static void main(String[] args) throws Exception {
		BotBuilder b = new BotBuilder();
		List<Automate> ListAut = b.loadAutomata("gal/exemple/test.gal");
		AutomateMap map = new AutomateMap();
		String[] Entities = { "Joueur1", "Joueur2", "Ennemis", "EnnemisP", "Boss", "Fantome1", "Fantome2", "Balle", "Coup", "Porte", "Portail", "Mur", "Rocher"};
		AutomatonAssociator(map,ListAut, Entities);
		GameLauncher(map);
		
	}

	public static void AutomatonAssociator(AutomateMap map, List<Automate> ListAut, String[] Entities) throws Exception {
		int len = ListAut.size();
		int curseur = 0;
		String[] optionsToChoose = new String[len];
		for (int k = 0; k < len; k++) {
			optionsToChoose[k] = ListAut.get(k).name;
		}
		Automate chosen = null;
		for (int i = 0; i < Entities.length; i++) {
			if(i>ListAut.size()-1)
				curseur = 0;
			else
				curseur = i;
			String playerAut = (String) JOptionPane.showInputDialog(null,
					"Choisissez un automate pour " + Entities[i] + " :", "Choose Automaton",
					JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[curseur]);
			for (Automate temp : ListAut) {
				if (temp.name == playerAut) {
					chosen = temp;
					break;
				}
			}
			if(chosen == null) {
				throw new Exception("AutomatonAssociator : Aucun automate trouvé");
			}
			map.addAutomate(Entities[i], chosen);
		}
	}

	public static void GameLauncher(AutomateMap map) {

		try {
			System.out.println("Game starting...");
			game = new Game(map);

			System.out.println("Game started.");
		} catch (Throwable th) {
			th.printStackTrace(System.err);
		}
	}

}

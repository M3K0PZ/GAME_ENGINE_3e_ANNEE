package Map;

import java.io.IOException;
import java.util.Random;

import info3.game.EntityManager;
import info3.game.Game;
import info3.game.Modele;

public class Etage {

	Modele modele; // On en a besoin pour les constructeur d'entité dans les salles

	public Salle[] salles; // Tableau des salle. salles[0] est l'entrée, et la dernière est la salle du
	// boss
	Game game;
	int niveau;

	public Etage(int niv, Game game) throws IOException {
		this.modele = game.modele;
		this.game = game;
		salles = new Salle[niv + 3];
		this.niveau = niv;
		this.init_etage(game.EM);
		this.creer_salles(game.EM);
		this.lier_salles();
		this.Ajout_salle_boss(game.EM);
	}

	void init_etage(EntityManager EM) throws IOException { // Créer l'entrée
		Random r = new Random();
		int j = r.nextInt(3) + 1;
		salles[0] = new Salle(j, "entree", game);
	}

	void creer_salles(EntityManager EM) throws IOException { // créé toutes les salles et leur portes entre l'entrée et
																// le boss

		for (int i = 1; i < niveau + 2; i++) {
			int nbr_de_porte_valide = 0; // Passe à un lorsque le nombre de porte choisi ne créer pas une boucle
			int nbr_a_eviter = nbr_de_portes_dispo(i);
			int j = 0;
			while (nbr_de_porte_valide == 0) {
				Random r = new Random();
				j = r.nextInt(3) + 1;
				if (nbr_a_eviter != j) {
					nbr_de_porte_valide = 1;
				}
			}
			if (i == niveau + 1) {
				j = nbr_a_eviter + 1;
			}
			salles[i] = new Salle(j, "normale", game);
		}

	}

	int nbr_de_portes_dispo(int indice) { // Renvoie le nombre de portes qu'il ne faut pas mettre à la salle pour pas
											// faire boucler l'étage

		switch (indice) {
		case 1: // Si on créer la première salle normale
			if (salles[0].nbr_portes == 1) {
				return 1;
			} else {
				return 0;
			}
		case 2: // Si on créer la deuxième salle normale
			if (salles[0].nbr_portes - 1 + salles[1].nbr_portes - 1 == 1) {
				return 1;
			} else {
				return 0;
			}
		default: // Pour toutes les autres salles normales
			int sum_portes = 0;
			for (int i = 0; i < indice; i++) {
				sum_portes += salles[i].nbr_portes;
			}
			if (sum_portes % 2 == 0) {
				return 2;
			} else {
				return 1;
			}

		}
	}

	void lier_salles() {
		for (int i = 0; i < niveau + 1; i++) { // On lie les salles entres elles avant de faire celle du boss
			int j = 1;
			while (salles[i].Porte_non_liees() == true) { // Tant que la salle a des portes non lié
				if (salles[i + j].Porte_non_liees() == true) { // Si la salle suivante a une porte non lié
					salles[i].Lier_deux_salles(salles[i + j]); // On lies les deux salles
				}
				j++;
				if (i + j >= niveau + 2) { // Si on arrive sur le dernière salle avant le boss
					if ((salles[i].Porte_non_liees() == true) && (salles[i + j - 1].Porte_non_liees() == false)) {
						salles[i].Retirer_Portes(salles[i].Trouver_porte_disponible());
					}
					j = 1;
				}

			}
		}
	}

	void Ajout_salle_boss(EntityManager EM) throws IOException {
		salles[niveau + 2] = new Salle(1, "boss", game); // On créer la salle du boss

		if (salles[niveau + 1].Porte_non_liees() == false) { // Si pas assez de porte dans la salle précédent le boss
			salles[niveau + 1].Ajouter_portes(1, EM); // On en rajoute une
		}

		salles[niveau + 1].Lier_deux_salles(salles[niveau + 2]); // On lie la salle du boss et l'avant dernière salle

		while (salles[niveau + 1].Porte_non_liees() == true) { // On supprime les portes de l'avant dernière salle si
																// elles ne sont pas lié
			salles[niveau + 1].Retirer_Portes(salles[niveau + 1].Trouver_porte_disponible());
		}
	}

}

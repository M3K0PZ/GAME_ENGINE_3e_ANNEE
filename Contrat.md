

**Contrat**

**Principe du jeu :**

Notre jeu est un jeu de type rogue-like, c'est-à- dire que les joueurs évoluent dans un donjon

et combattent des monstres, leur but étant d’aller le plus loin possible.

**Le monde :**

Le “monde” du jeu se décompose en étages qui sont tous composés de salles. 

`[DEMO]` Chaque étage possède une disposition de salles aléatoire, et une salle de boss qui permet de changer d’étage. 

[PAS CLAIR, vous n'expliquez pas ce qui est aléatoire.]
Les salles seront générées semi-aléatoirement, elles prendront pour base une disposition prédéfinie dans laquelle on placera des ennemis piochés aléatoirement dans le bestiaire du jeu. Nous choisissons de partir de bases prédéfinies ce qui évite de devoir implémenter des algorithmes avancés (comme celui de A\*, basé sur l’algorithme de Dijkstra) et d’éviter potentiellement de trop longues générations de salles.

[Les salles sont prédéfinies, la disposition des salles est aléatoire. On devra le voir dans la DEMO]

Le nombre d'étages est donc infini, et chaque étage sera plus difficile que son précédent.

(Optionnel) Des salles spéciales de bonus ou de malus.

**Gameplay :**

Pour la partie gameplay, les deux joueurs contrôlent un héros, l’un sera le “Tank”, un

personnage très résistant mais qui ne peut attaquer qu’au corps à corps. L’autre sera le

“Tireur”, un personnage plus fragile mais pouvant attaquer à distance. `[DEMO]` [TRANSFERT] A intervalle de temps

régulier, les deux joueurs se verront échanger leurs rôles. L’un deviendra le tireur à la place

du Tank et vice-versa, tout cela sans changer de position sur le clavier. Cet élément rentre

donc dans la contrainte de transfert des entités.

(Optionnel) Des compétences spéciales, des armes différentes.

La condition de défaite est la mort des deux joueurs. Nous avons donc décidé que si un des

deux joueurs meurt, il pourra se transformer en fantôme et remplir une mission afin de

revenir à la vie. Cela rentre dans la contrainte de la doublure. `[DEMO]` [DOUBLURE = si les déplacements du fantome sont très différents]

**Entités**

[MULTIPLICATION par action EGG] Pour l’entité qui pullule, nous avons plusieurs idées, celle que nous implémenterons est celle

du nid de monstres, un entité qui fait apparaître des monstres régulièrement tant que ce

dernier n’est pas détruit. `[DEMO]`

(Optionnel) Faire un ennemis de type “Slime” qui commence à une certaine taille et qui, à sa

mort, se divise en deux jusqu'à qu'il atteigne une taille donnée ce qui le tuera définitivement.

[+ menu d'attribution des automates au début du jeu]

**Planning**

\-

\-

\-

Faire automates des entités mortes et vivantes [??] (Jeudi 16)

Finir génération aléatoire des salles + intégrer les visuels, textures (Mercredi 15)

Finir sprites des entités (Tank, tireur, boss, nid de monstres, rocher, projectiles)

(Semaine 3)

\-

\-

\-

Gérer caméra pour deux joueurs (À optimiser)

Finir collisions (Mercredi 15)

Gérer les projectiles (Commencer Vendredi, finir Lundi 20)





\-

\-

\-

Gérer les dégâts (Commencer Vendredi 17, finir Lundi 20)

Créer un monde et avancer dans les salles (Vendredi 17, finir Lundi 20)

Reste du temps phase de tests, améliorations et points optionnels


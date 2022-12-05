Contrat Projet PLA- Groupe 6 BOMPARD-GUERIN-JOUVE-KHELIFI-MACHENAUD-RIFFARD

*Projet :* [nom du jeu] **Description :**

Le jeu est un Rogue-Like, c'est-à-dire un jeu mélangeant donjons et monstres. Il possède un niveau infini d’étages, de plus en plus difficiles, et possédant chacun un niveau aléatoire de salles (avec un intervalle, afin d’éviter d’avoir un nombre de salle trop faible, tout en conservant un niveau de difficulté correspondant à l’étage).

*Exemple de création d’étages :*

![](Aspose.Words.81f5e2b7-b276-4afa-a48c-e0969871d296.001.png)

Les joueurs évolueront en coopération dans ces différentes salles, à travers 2 personnages possédant des caractéristiques propres à chacun. L’un jouera un «*tank»*, qui possédera une vie plus élevée, et attaquera seulement au corps à corps. L’autre joueur incarnera un joueur «*tireur»*, qui aura une vie plus faible que le «*tank»*, mais aura la particularité de pouvoir tirer à distance des projectiles. Leur objectif sera de détruire tous les monstres qui apparaîtront de manière aléatoire dans la salle. Les joueurs devront ainsi coopérer pour  vaincre tous les ennemis, ce qui déclenchera l'ouverture des portes vers les différentes salles voisines.

Afin d’accéder à l’étage suivant, les deux joueurs devront vaincre le boss du niveau (salle rouge). Il n’est donc pas obligatoire de finir toutes les salles avant de passer à l’étage suivant. La difficulté augmente au fil des étages, et non des salles. En parlant de difficulté, les joueurs se verront attribuer un transfert de personnage toutes les X minutes, ce qui rendra le jeu plus difficile. Pour les doublures des personnages, nous avons 2 idées : soit faire des salles différentes, qui permettent de créer des doublures pour les avatars des joueurs. L’autre option est de gérer le cas de la mort d’un des deux joueurs, et dans ce cas, le transformer en fantôme, et lui attribuer une mécanique différente.

Comme indiqué ci-dessus, les salles seront infestées de monstres, que les joueurs devront affronter. Ces monstres auront plusieurs caractéristiques :

- Tout d’abord, nous voulons intégrer des monstres qui pullulent, mais nous n’avons pas encore fait notre choix. Différentes solutions se présentent à nous : Un nid de monstres, qui ferait apparaître 1 ou 2 monstres à une fréquence régulière tant que le nid est en vie. Nous avions aussi pensé à un monstre, qui, lorsque sa vie est nulle, se divise en 2 nouvelles entités.
- Nous nous sommes ensuite fixés des objectifs à réaliser pour les “IA” des monstres:
- ***1er temps :*** les monstres effectuent des attaques au corps à corps, en se dirigeant vers un des joueurs.

![](Aspose.Words.81f5e2b7-b276-4afa-a48c-e0969871d296.002.png)

*En rouge, l’ennemi, qui va se diriger vers le joueur (en vert)*

- ***2ème temps :*** des nouveaux ennemis font leur apparition : ce sont des ennemis lançant des projectiles dans des directions prédéfinies, tout en se déplaçant.

![](Aspose.Words.81f5e2b7-b276-4afa-a48c-e0969871d296.003.png)

*En rouge, l’ennemi qui envoie des projectiles (flèches rouges) et se déplace aléatoirement dans la salle*

- ***3ème temps :*** les ennemis du 2ème temps lancent des projectiles orientés, pour éviter de les lancer dans des directions où les joueurs ne se trouvent pas, et qui donc n’augmentent pas la difficulté.

![](Aspose.Words.81f5e2b7-b276-4afa-a48c-e0969871d296.004.png)

*L’ennemi va tirer son projectile dans la direction d’un des joueurs, augmentant la difficulté*

**Jouabilité :**

Les 2 joueurs pourront jouer sur le même clavier. Les commandes se trouvent uniquement sur ce dernier. Il n’y a donc pas besoin de souris. Les joueurs se déplaceront avec les touches ZQSD et les flèches directionnelles. En plus du déplacement, les joueurs auront une touche d’attaque, qui sera à définir lors du projet.

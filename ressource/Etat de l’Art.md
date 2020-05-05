# Etat de l’Art



Projet PTS2 : Nintendo Wars



## Vue Globale

Nintendo Wars est une série de jeu développé par Nintendo qui a commencé par Famicom Wars en 1988 au Japon sur Nes(Famicom), puis est arrivé en Occident en 2001 avec Advance War sur Nintendo DS.

Ce sont des jeux de tactiques au tour par tour où 2 équipes s’affrontent dans le but de conquérir un territoire.



### principe du jeu

Deux équipes, chaque équipe étant contrôlée par un joueur et/ou IA, s’affrontent sur un plateau composé d’emplacements carrés symbolisant une ville, village , territoire … Chaque emplacement peut ou non contenir une unité. Le but étant de conquérir des points stratégiques ( ville ) apportant de l’or permettant l’achat de nouvelles troupes. L’équipe réussissant à capturer toutes les villes gagnent la partie.



### modes de jeu

- Entraînement : tutoriels permettant aux nouveaux joueurs d’apprendre les bases du jeu

- Campagne : Le joueur fait des missions scénarisées

- Versus : Permet d’affronter un joueur et ou une IA

- Editeur de niveaux : permet de créer ses propres terrains

- Scores : Permet de consulter ses meilleurs scores en mode versus ( basé sur le nombre de tours effectués pour gagner, le nombre d’unités ennemies tuées et nombre d’unités alliées tuées ).

## Gameplay

### les Unités

Les unités possèdent plusieurs caractéristiques :

- Type : catégorie de l’unité (Infanterie, véhicule, bateau, hélicoptère, avion, sous-marin ) chaque type possédant des particularités ( ex : les infanteries peuvent aller sur des cases de type montagne tandis que les autres unités ne peuvent pas )

- Coût : prix d’achat de l’unité

- Portée : distance d’attaque maximale de l’unité

- Fuel : point de déplacement qu’il ne puisse plus se déplacer ( rechargement dans une ville )

- Vision : jusqu’où l’unité peut voir les ennemis

- Point de vie : nombre de points avant que l’unité ne meurt ( 100 pour chaque unité )

- Point d’attaque : définit selon les faiblesses et résistance des unités subissant l’attaque

- Point de mouvement : déplacement possible par tour ( chaque déplacement consomme des unités de fuel variables selon l’unité )



### Règles du jeu

- Le Plateau : composé de cases de différents types : eau, plaine, montagnes, forêt, ville, usines. Chaque case ne pouvant contenir qu’une seule unité à la fois .

- Les cases :
  
  - plaine : accessible par toutes les unités sauf les bateaux et sous-marins, pas d’effets négatifs lors des déplacements et sur le champ de vision.
  
  - eau : accessible pour les bateaux, sous-marins et avions, pas d’effets négatifs lors des déplacements et sur le champ de vision.
  
  - forêt : accessible par toutes les unités terrestres et aériennes, effet négatif uniquement sur les unités terrestres ( multiplication des points de mouvements nécessaires et vision divisée par 2 ).
  
  - montagne : accessible uniquement par les infanteries et véhicules aériens, bonus sur la vision, et déplacement uniquement une case par une case.
  
  - ville : accessible par toutes les unités sauf véhicules marins, trois états possibles : neutre, possédée par le Joueur1 ou possédée par le Joueur 2. Tout les tours une somme d’or est reversée au joueur la possédant ; Pour conquérir une case une infanterie doit être placée pendant 2tours.
  
  - usines : Accessible par toutes les unités sauf les unités navales. Chaque usine se  comporte comme une ville une fois conquit, on peut générer des unités contre de l’or, s’affiliant à cette usine ( port pour les unités navales, aéroport pour les véhicules aériens, et usine pour les unités terrestres ).

### Système de combat

    Chaque unité a un nombre de dégâts définis contre chaque unité. Le joueur a qui est le tour attaque en premier ensuite selon les cas les unités adverses se défendent ou pas ( impossibilité de se défendre par exemple les unités d’infanterie ne peuvent pas se défendre face à des unités aériennes, ou certaines unités ne peuvent tout simplement pas attaquer ). Le combat se termine lorsque les deux unités ont attaqué. Une unité avec une plus grosse portée peut attaquer sans craindre une défense de la part de l’unité attaquée.

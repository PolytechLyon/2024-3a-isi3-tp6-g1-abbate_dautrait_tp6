# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : Antoine Dautrait & Titouan Abbate 

## Exercices 1
Composite
## Exercices 2

Patron de conception et avantages
Le patron de conception utilisé dans la méthode getVelocity() est l'itérateur. Ce patron permet de parcourir une collection d'objets sans avoir à connaître sa structure interne.

Avantages:

Flexibilité: Le code est plus flexible car il ne dépend pas de la structure de la collection.
Découplage: Le code est découplé de la structure de la collection, ce qui le rend plus facile à maintenir et à tester.
Extensibilité: Il est facile d'ajouter de nouveaux types de composants au véhicule sans modifier la méthode getVelocity().## Exercices 3

rien beosin de changer
## Exercices 3
on créer un pattern singloton pour Clock notament en méttant en private le constructeur et on supprimer les this dans Wheel et Clock. Cependant, this fait référence à l'instance actuelle de la classe, ce qui n'est pas pertinent dans le contexte d'un singleton.
## Exercices 4
même package, 
dépendance cyclique, 
non pas les bonnes pratiques de conception pcq du coup la dependance cyclique en elle-même est un problème, c'est un anti patron
la méthode getPush,
oui c'est l'abstraction vehicle
dans le même
dans wheel on remplace bike par vehicle
## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8



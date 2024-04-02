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
Nous avons utilisé le patron de méthode pour centraliser la méthode log dans la classe abstraite NamedLogger. Les sous-classes FileLogger et ConsoleLogger implémentent une méthode abstraite logFinalMessage pour spécifier comment le message final doit être traité ce qui évite ainsi les doublons

## Exercice 6

On a créé une classe LoggerFactory qui va forcer à utiliser le console log car dans le logger factory, on crée une méthode getLog qui instancie un nouveau ConsoleLogger, de plus on a retiré le "public" dans le constructeur de ConsoleLogger pour créer une sorte de "package private" et que ca ne puisse être que la fabrique qui créer des nouvelles instances de logger.
La différence avec singleton pour ce patron est qu'on veut plusieurs instances de log car sinon on en créer qu'une on ne pourrait pas savoir où est l'erreur dans le code.

## Exercices 7
Ce code définit une nouvelle classe TimestampedLoggerDecorator qui hérite de l'interface Logger. Elle prend une instance existante de Logger en argument de son constructeur. La méthode log du décorateur intercepte le message et lui ajoute un horodatage (obtenu par la méthode getHorodatageActuel) avant de déléguer l'enregistrement réel au logger encapsulé.

Voici une explication plus détaillée du code :

Déclaration de la classe: La classe TimestampedLoggerDecorator est déclarée avec les modificateurs public et final. Elle hérite de l'interface Logger.

Constructeur: La classe a un unique constructeur qui prend une instance de Logger en argument. Le constructeur stocke la référence vers le logger encapsulé dans le champ logger.

Méthode log: La méthode log redéfinit l'implémentation de l'interface Logger. Elle formate d'abord le message en utilisant la méthode formaterMessage. Ensuite, elle récupère l'horodatage actuel à l'aide de la méthode getHorodatageActuel. Finalement, elle délègue l'enregistrement réel au logger encapsulé en appelant sa méthode log avec l'horodatage et le message formaté comme arguments.

Méthode getHorodatageActuel: Cette méthode sert à récupérer l'horodatage actuel. Dans cet exemple, elle renvoie simplement un horodatage simulé. Dans une application réelle, vous utiliseriez une librairie d'horodatage pour obtenir l'heure actuelle.

Méthode formaterMessage: Cette méthode permet de formater le message avant son enregistrement. Dans cet exemple, elle renvoie simplement le message formaté. Vous pouvez redéfinir cette méthode dans une sous-classe pour ajouter un formatage supplémentaire au message.

## Exercices 8

Injection de dépendance et Context
1. Patron de conception de la classe Context

La classe Context suit le patron de conception Singleton vis-à-vis de l'outil ServiceLoader. Le Singleton est un patron de conception qui garantit qu'une seule instance d'une classe est créée et accessible dans tout le contexte de l'application.

Dans le cas de la classe Context, elle utilise la propriété statique INSTANCE pour garantir qu'une seule instance est créée. La méthode get est également statique et permet de récupérer l'instance unique de la classe.
3. Fichier fr.polytech.sim.cycling.Bike

Le fichier fr.polytech.sim.cycling.Bike dans le dossier META-INF/services peut contenir plusieurs lignes. Chaque ligne correspond à une implémentation concrète de Bike que l'on souhaite injecter. Par exemple, si le fichier contient les deux lignes suivantes :

fr.polytech.sim.cycling.SimpleBike
fr.polytech.sim.cycling.TagAlongBike
Cela signifie que l'application peut injecter soit un SimpleBike soit un TagAlongBike en fonction du contexte.

Injection de dépendance et Context
1. Patron de conception de la classe Context

La classe Context suit le patron de conception Singleton vis-à-vis de l'outil ServiceLoader. Le Singleton est un patron de conception qui garantit qu'une seule instance d'une classe est créée et accessible dans tout le contexte de l'application.

Dans le cas de la classe Context, elle utilise la propriété statique INSTANCE pour garantir qu'une seule instance est créée. La méthode get est également statique et permet de récupérer l'instance unique de la classe.

2. Injection de Bike avec Context

Pour injecter un objet de type Bike dans la simulation à l'aide de la classe Context, il faut modifier le code de la classe BikeSimulator comme suit :

Java
public class BikeSimulator implements Simulation {

    private final Bike bike = Context.get(Bike.class);

    public void run() {
        bike.getVelocity();
        bike.getMass();
    }
}
Utilisez ce code avec précaution.
Le code utilise la méthode get de la classe Context pour obtenir une instance de Bike. La classe Context utilise ensuite ServiceLoader pour charger les implémentations disponibles de Bike et injecter la plus appropriée.

3. Fichier fr.polytech.sim.cycling.Bike

Le fichier fr.polytech.sim.cycling.Bike dans le dossier META-INF/services peut contenir plusieurs lignes. Chaque ligne correspond à une implémentation concrète de Bike que l'on souhaite injecter. Par exemple, si le fichier contient les deux lignes suivantes :

fr.polytech.sim.cycling.SimpleBike
fr.polytech.sim.cycling.TagAlongBike
Cela signifie que l'application peut injecter soit un SimpleBike soit un TagAlongBike en fonction du contexte.

4. Correspondance entre les lignes et les implémentations

Chaque ligne du fichier fr.polytech.sim.cycling.Bike correspond à une classe concrète qui implémente l'interface Bike. L'ordre des lignes n'a pas d'importance.

Lorsqu'une instance de Bike est demandée via la classe Context, ServiceLoader charge toutes les implémentations disponibles et utilise un algorithme interne pour sélectionner la plus appropriée. L'algorithme prend en compte plusieurs facteurs, notamment la présence d'annotations et le contexte d'exécution.
La classe Context, vis-à-vis de l'outil ServiceLoader, suit le patron de conception Singleton. Ce patron garantit qu'une seule instance de la classe Context est créée et fournit un point d'accès global à cette instance.

Pour utiliser la classe utilitaire Context pour injecter un objet de type Bike dans la simulation, nous devons d'abord modifier le fichier Bike dans le dossier src/main/resources/META-INF/services pour spécifier quelle classe doit être injectée lorsqu'un Bike est attendu par l'application. Dans ce cas, nous voulons injecter TagAlongBike :
## Exercice 9



# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : Antoine Dautrait & Titouan Abbate 

## Exercice 1
Ce patron de conception ressemble au design pattern *Composite*.
Ici, le *Composant* serait *MobileObject*, le *Composite* la classe *Vehicle* et la *Feuille* la classe *Wheel*, comme composant sans sous-élément.
Il n'est pas nécessaire de réécrire les méthodes *getVelocity()* et *getMass()* puisqu'elles héritent du calcul dans les composants.

## Exercice 2
Le patron de conception utilisé dans la méthode *getVelocity()* est *Iterator*. Ce patron permet de parcourir une collection d'objets sans avoir à connaître sa structure interne.
Le code est plus flexible et découplé de la structure de la collection, ce qui le rend plus facile à maintenir, à étendre et à tester.
Il n'est donc pas nécessaire de modifier la réalisation de la méthode *getVelocity()* si l'on change la structure de données.

## Exercice 3
On adapte au pattern *Singleton* en rendant premièrement le constructeur de *Clock* privé, puis en supprimant les *this* dans *Wheel* et *Clock*.
Pour s'assurer de l'existence d'une instance unique, on préfère *getInstance()* à la création brute d'un nouvel objet.

## Exercice 4
Les classes *Bike* et *Wheel* sont dans le même package.
Il existe une dépendance cyclique entre les deux classes ce qui va à l'encontre des bonnes pratiques de conception, on parle d'anti-patron.
La classe *Wheel* utilise la méthode *getPush()* de *Bike* bien que cette fonctionnalité soit déjà présente dans la classe abstraite *Vehicle*.
Pour casser la dépendance cyclique, il convient d'utiliser la classe *Vehicle* dans la classe *Wheel* en lieu et place de la classe *Bike*.

## Exercice 5
Nous avons utilisé le patron de méthode *(Template)* pour centraliser la méthode *log* dans la classe abstraite *NamedLogger*. Les sous-classes *FileLogger* et *ConsoleLogger* implémentent une méthode abstraite *logFinalMessage()* pour spécifier le traitement du message final en évitant les doublons.

## Exercice 6
Pour centraliser le choix de réalisation de l'interface *Logger*, nous avons créé une classe *LoggerFactory*.
Dans celle-ci, on crée une méthode *getLog()* qui instancie un nouveau *ConsoleLogger*, en prenant soin de rendre son constructeur "privé" en créant une sorte de "package private".
Ainsi, nous pourrons créer différentes instances pour trouver les erreurs dans le code, contrairement au design pattern *Singleton* qui n'autorise pas l'instanciation multiple.

## Exercice 7
Ce code définit une nouvelle classe *TimestampedLoggerDecorator* qui hérite de l'interface *Logger*.
Elle prend une instance existante de *Logger* en argument de son constructeur.
La méthode du décorateur intercepte le message et lui ajoute un horodatage (obtenu par la méthode *getHorodatageActuel()*) avant de déléguer l'enregistrement réel au *logger* encapsulé.

## Exercice 8
La classe *Context* suit le patron de conception *Singleton* vis-à-vis de l'outil *ServiceLoader*.
Le fichier *fr.polytech.sim.cycling.Bike* dans le dossier *META-INF/services* peut contenir plusieurs lignes. Chaque ligne correspond à une implémentation concrète de *Bike* que l'on souhaite injecter.
Par exemple, si le fichier contient les deux lignes suivantes :
`fr.polytech.sim.cycling.SimpleBike
fr.polytech.sim.cycling.TagAlongBike`
Alors l'application peut injecter soit un *SimpleBike* soit un *TagAlongBike* en fonction du contexte.

Plus précisément, on obtient une instance de *Bike* grâce à la méthode *get()* de la classe *Context*.
Cette dernière utilise ensuite *ServiceLoader* pour charger les implémentations disponibles de *Bike* et injecter la plus appropriée en fonction de plusieurs facteurs tels que la présence d'annotations ou le contexte d'exécution.

## Exercice 9
Cette méthode de parcours des objets disponibles pour un type donné est issue du design pattern *Iterator*.
Comme la méthode *injectAll()* renvoie un *Iterator*, nous proposons de retourner un objet `ServiceLoader.load(klass).iterator()`.
Ainsi, dans *BikeSimulator*, nous continuons d'afficher en utilisant l'itérateur retourné par *injectAll()* tant qu'il contient des éléments.


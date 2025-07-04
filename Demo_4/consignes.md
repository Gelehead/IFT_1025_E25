0. Les classes LinkedList<Integer> et ArrayList<Integer> de la
   librairie standard de Java sont respectivement des implantations d'une
   liste chaînée et d'un tableau dynamique.

(Considérez que le <Integer> fait partie du nom de la classe, ce
concept sera vu plus en détail dans les prochains cours)


La classe ListeChainee disponible sur StudiUM est une implantation
minimaliste d'une liste chaînée en Java.

Familiarisez-vous avec le code. Expliquer le concept de classe
interne.



1. Écrivez un programme qui permet de générer une liste de N nombres
   au hasard. Chaque nouveau nombre est ajouté à la fin de la liste.

Pour générer vos nombres, utilisez :

Random random = new Random();
random.nextInt();


a) Implémentez ce programme en utilisant un ArrayList<Integer>

b) Implémentez ce programme en utilisant la ListeChainee sur StudiUM

c) Implémentez ce programme en utilisant une LinkedList<Integer> de Java


2. Benchmarkez ces trois programmes. Calculez le temps d'exécution
   lors de l'ajout de chaque élément pour N=1 à N=5000 et dessinez le
   résultat du temps d'exécution selon N graphiquement.


Utilisez :

for(int n=1; n<=5000; n++) {
long time = System.nanoTime();

    // -> liste.add() ou liste.addLast() ici <-

    long deltaTime = System.nanoTime() - time;
    System.out.println(deltaTime);
}

Pour afficher le temps requis pour ajouter chaque élément à la liste.


Sous GNU/Linux ou Mac, installez le programme gnuplot et utilisez le
code suivant dans un terminal pour visualiser graphiquement les temps
d'exécution :

javac Q1*.java
java Q1a > q1a
java Q1b > q1b
java Q1c > q1c
gnuplot
plot 'q1a' title 'ArrayList', '' smooth bezier title '', \
'q1b' title 'ListeChainee', '' smooth bezier title '', \
'q1c' title 'LinkedList', '' smooth bezier title ''


Que pouvez-vous dire de l'implémentation de LinkedList en Java ?
(Liste simplement chaînée ? Doublement chaînée ?)

Réfléchissez à l'ordre de grandeur du nombre d'opérations nécessaires
pour ajouter un élément à la fin d'une liste en fonction du nombre
d'éléments déjà présents.


3. Modifiez vos programmes pour utiliser plutôt : addFirst(...)

a) De quoi les nouvelles courbes auront l'air si vous dessinez
graphiquement le temps d'exécution pour N=1 à N=5000 ? Faites une
hypothèse

b) Affichez les courbes et vérifiez votre hypothèse


4. Implémentez une File d'attente (Queue) en utilisant deux Piles
   (servez-vous de l'implémentation `Stack` de la librairie de
   collections)

S'il y a N éléments dans votre File, combien d'opérations sont
requises pour ajouter un nouvel élément ?

Considérez l'ordre O(...) en fonction du nombre d'éléments N tel que
vu en classe



5. Adaptez le code de la liste chaînée pour en faire une
   ListeCirculaire

Une liste circulaire fonctionne similairement à une liste chaînée, à
la différence que le n.prochain du "dernier" noeud de la liste
circulaire == le "premier" noeud de la liste


Une liste circulaire a un "premier" mais ne stocke pas de référence
vers le dernier :


       +-----------------+
       |                 |
       | ListeCirculaire .
       |                 |\
       +-----------------+ \ premier
                            \
                             \
                              V
                              +-------+       +--------+        +--------+
                              |   1   |       |    2   |        |    3   |
                        +---> |       +------>|        |------->|        |
                        |     +-------+       +--------+        +--------+
                        |                                            |
                        |                                            |
                        |                                            |
                        +--------------------------------------------+

Aucun noeud ne devrait avoir de `prochain = null`

a) Faites une première version de ListeCirculaire qui contient
toujours ces 3 noeuds : 1, 2 et 3 (comme dans le diagramme
précédent). Créez ces trois noeuds dans le constructeur
directement.

Ne vous souciez pas de addFirst(), addLast() et size() pour le moment.


Ajoutez une méthode :

    public void print(int n) {
        // ...
    }

Qui affiche les valeurs de n noeuds à partir du premier sur la console

Pour le moment, le code :

     liste.print(5);

Devrait afficherait :

    1
    2
    3
    1
    2


b) Faites fonctionner la méthode size(). Attention aux boucles
infinies...


c) Retirez les trois noeuds 1, 2 et 3 du constructeur et modifiez les
méthodes addFirst() et addLast() pour les faire fonctionner avec le
concept de liste circulaire


d) Analysez le nombre d'opérations nécessaires pour exécuter
addFirst() et addLast() dans votre ListeCirculaire en fonction du
nombre d'éléments N dans la liste

Donnez votre réponse selon l'ordre de grandeur en fonction de N avec
la notation vue en classe : O(...)


e) Trouvez une façon d'améliorer la performance de la méthode
liste.get(i)

Pour la liste contenant [1, 2, 3], on devrait pouvoir utiliser :

    System.out.println(liste.get(0)); // => 1
    System.out.println(liste.get(3)); // => 1
    System.out.println(liste.get(33)); // => 1
    System.out.println(liste.get(34)); // => 2
    System.out.println(liste.get(35)); // => 3


Quel est l'ordre de grandeur du nombre d'opérations pour accéder à
l'élément #i en fonction du nombre d'éléments N dans la liste ?
Utilisez la notation O(...)

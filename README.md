# BigData
#HomeWork

# Le principe de Map Reduce en Java

##Le principe de Map Reduce en Java a certaines diférences par rapport à celui en Python.
<p>En effet, on remarque que l'exécution du code en Java est plus rapide qu'avec Python.
Cependant, le developpement du code en python est plus rapide à celui en java.

En Java, on a besoin d'implémenter le mapper, reducer et le driver.
Ce dernier permet de spécifier le mapper et reducer pour après exécuter le job.
L'instance Job spécifie plusieurs choses sur le job: un nom pour les fins d'affichage,
les classes de mappeur et de reducer et les types de sortie de tâche 
qui doivent correspondre aux types de sortie du mappeur et du reducer.

Il est à noter que le type de sortie de mapper doit correspondre au type d'entrée de reducer.
Dans notre cas l'output du mapper est de type <Text,FloatWritable> : ( store, cost )
En java, Hadoop transforme la sortie de mapper pour que les valeurs soient réunies 
pour une clé donnée, dans un processus appelé shuffle.
L'entrée du reducer est la suivante : (store, [cost1, cost2, ..., costn]).

On remarque bien que cette entrée du reducer en Java différe de celle de Python, 
d'où le traitement sera différent.

</p>

###Activité 4
<p> 
Dans le premier exemple du TP où on doit déterminer le total des ventes par magasin:
Dans le package 'training':
on crée un mapper appelé 'StoreMapper' permettant d'extraire le 2éme et 4éme element 
(store et cost) dont la sortie qui est ce couple sera dans le context traité par Hadoop.

Une fois le couple (key,value) a été généré à partir de mapper, Hadoop intervient à cette
étape afin de faire le sort et shuffle. En effet, pour une clé, il mettra toutes ses valeurs
correspondantes.
exemple: (Washington, [100.55,1444.88, .....])

Ensuite, le reducer intervient et effectue la somme de ces valeurs pour une clé donnée.

On exécute ensuite le Job définit par le driver où on spécifie notre mapper et reducer,  FileInputFormat, 
 FileOutputFormat ...

En exécutant le Job,on aboutit à la sortie suivante qui sera dans le fichier 'output' passé en argument :

[cloudera@quickstart output]$ cat part-r-00000 
Albuquerque	2216237.0
Anaheim	2302442.0
Anchorage	2268631.8
Arlington	2238866.0
Atlanta	2287626.2
Aurora	2214034.0
Austin	2279272.8
Bakersfield	2213881.5
Baltimore	2257129.8
Birmingham	2259366.8
Boise	2228528.5
Boston	2220960.5
Buffalo	2208887.8
Chandler	2199660.0
Charlotte	2316797.5
Chesapeake	2261491.2
Chicago	2256960.8
Cincinnati	2296379.5
Cleveland	2302777.0
Columbus	2222749.0
Dallas	2268878.2
Denver	2239562.0


</p>

##Activité 5

<p>On crée le package activity5 où on implémente le code de mapper
ProduitMapper permettant de mettre comme clé et valeur (item,cost) ainsi
que le code de ProduitReducer qui est le meme que StorerReducer.
Enfin, le ProduitDriver permettant de matcher le mapper et reducer déjà cités.

le fichier de sortie passé en paramétre est sous /home/cloudra/outputActivity5:
[cloudera@quickstart outputActivity5]$ cat part-r-00000 
Baby	1.732749E7
Books	1.7360372E7
CDs	1.7349714E7
Cameras	1.7280536E7
Computers	1.7175854E7
Crafts	1.73289E7
DVDs	1.736925E7
Garden	1.739174E7
Music	1.7346166E7
Toys	1.7354996E7

</p>

##Activité 6

Dans le package activity6, On garde le mapper de l'activité 4
et on crée un nouveau reducer 'MaxCostDriver'permettant de
 chercher le max de vente par magasin.
L'output sera dans le fichier passé en argument:

[cloudera@quickstart outputActivity6]$ cat part-r-00000 
Albuquerque	499.98
Anaheim	499.95
Anchorage	499.78
Arlington	499.95
Atlanta	499.91
Aurora	499.93
Austin	499.95
Bakersfield	499.97
Baltimore	499.92
Birmingham	499.99
Boise	499.97
Boston	499.83
Buffalo	499.97
Chandler	499.96
Charlotte	499.93
Chesapeake	499.97
Chicago	499.99
Cincinnati	499.93
Cleveland	499.93
Columbus	499.98
Dallas	499.91
Denver	499.97
Detroit	499.94
Durham	499.88
Fremont	499.95
Fresno	499.95
Garland	499.99
Gilbert	499.97
Glendale	499.97
Greensboro	499.99
Henderson	499.96
Hialeah	499.97
Honolulu	499.99
Houston	499.93
Indianapolis	499.94
Irvine	499.94
Irving	499.92


##Execution

Une fois le test est réussi en local, on exporte le jar

on exécute ainsi le jar :
hadoop jar /home/cloudera/Desktop/Tp1.jar training.Driver  myinput/purchases.txt.part outputhomework




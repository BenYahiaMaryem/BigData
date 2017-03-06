# BigData
HomeWork

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
d'où le traitement sera différent.<p>






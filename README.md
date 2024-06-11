# Spring-Security
Learning Spring Security sur Open class room

En sécurité sur les applications Web, il existe deux attaques les plus communes : le piratage informatique des données et l'injection de code.
Un organisme à but lucratif, OWASP (Open Web Application Security Project) a été créé pour informer le publique des attaques à l'encontre des application Web, les étudier et donner des informations sur la manière de les prévenir.
Les développeurs peuvent utiliser des librairies dédiées à la sécurité, afin de protéger vos applications web.
Spring Security est un framework garantissant une utilisation facile des application Java, en particulier Spring Boot. Il permet de configurer Spring pour prévenir les attaques en ayant recours à très peu, voire à aucune configuration.
Spring Security est le module qui gère la sécurité dans les applications Web.
Une appliication Spring est modulaire et Spring Security en est un module.
Après l'installation Spring Security, elle a pour objectif première de protéger les requetes Http; pour cela elle propose troix niveaux successifs de protections:
-Pare feu Http: Dans le contexte de Spring Security, un "pare-feu" (firewall) fait référence à des mécanismes qui contrôlent l'accès aux ressources de l'application web en fonction de règles de sécurité. Donc le pare feu bloque toutes mauvaise requetes.
-Proxy: Un proxy est un intermédiaire qui relaie les requêtes entre un client et un serveur. Ces roles sont :
  *Accélérer la navigation : mémoire cache, compression de données1.
  *Historique (logs) : journalisation des requêtes1.
  *Sécuriser le réseau local.
  *Filtrer : restrictions de sites, blocage des publicités ou des contenus lourds (Java, Flash)1.
  *Assurer l'anonymat.
En Spring Boot, ces proxys permettent d'intercepter les appels de méthode et d'ajouter des fonctionnalités de sécurité, comme la vérification des permissions ou l'authentification des utilisateurs.
-Filter chain: Les filtres s’assurent que toutes les requêtes HTTP qui pénètrent dans votre application web sont sécurisées. Chaque filtre fournit une configuration de sécurité que vous pouvez intégrer à votre application web. Cette collection de filtres de servlet est appelée chaîne de filtres de Spring Security.
Quelques définitions :
-Dans Java, un servlet est un programme qui fonctionne sur votre application web pour traiter les requêtes HTTP entrantes. 
-Un filtre de servlet est un composant qui peut agir en amont sur la requête reçue par le ou les servlets concernés par le filtre en question. 
-Une chaîne de filtres est un ensemble de filtres qui se succèdent.
En effate, le framework Spring Security ajoute trois niveaux de sécurité à Spring Boot. Les trois niveaux de sécurité sont le pare-feu HTTP pour filtrer les requêtes HTTP suspectes, le DelegatingFilterProxy pour envoyer les requêtes HTTP aux bons filtres de sécurité, et la chaîne de filtres de sécurité, qui héberge les configurations de sécurité.
Explication : 
Premièrement, le pare-feu HTTP bloque les requêtes suspectes. 
Deuxièmement, le proxy (DelegatingFilterProxy) prend en charge le reste des requêtes HTTP, et les envoie vers la chaîne de filtres de Spring Security. 
Enfin, les filtres de la chaîne s’assurent que ces requêtes HTTP soient conformes à leurs critères de sécurité.
N.B: Si on ajoute manuellement les dépendances, on doit s'assurer que c'est dans le bon ordre car pour l'exemple de OAuth2 et Spring Security, OAuth2 doit venir en premier. Ce meme principe doit etre appliqué sur les filtres de Spring Security.
A Retenir : L’architecture Spring se sert de Spring Security pour ajouter trois niveaux de sécurité à votre application web : 
le pare-feu HTTP empêche les flux suspects de pénétrer dans votre application ;
DelegatingFilterProxy dirige le reste des flux HTTP vers les filtres de sécurité appropriés ;
la chaîne de filtres sécurisée héberge les règles de sécurité pour votre application web. 

Deux fonctionnalités de sécurisation proposées par Spring Sécurity:
-Authentification: permet de vérifier qui vous etes. Il existe deux types d'authentification en Spring Security :
 *Authentification par session: C'est le plage de temps que vous pouvez naviguer sur le site. Le principe est que le navigateur recupère un cookie du serveur et à 
  chaque fois qu'on fait une requete, le navigateur l'enverra au serveur.
 *Authentification par Token: C'est un jeton qui contient les données de session cripté. Le principe est qu'à chaque connexion, le serveur nous l'envoie et on le 
  stocke et qu'à chaque fois qu'on fait une requete, on le met sur le header et notre serveur va le recupérer et le décrypter afin d'identifier qu'il s'agit de quel    utilisateur.   
-Autorisation: permet de vérifier ce que vous pouvez faire (les pages que vous pouvez accéder)
 N.B.: Authentification + Autorisation = Controle d'Accés
       nomUtilisateur + mot de passe = authentification à facteur unique
       nomUtiisateur + mot de passe + empreintes ou preuve physique 09 un badge = authentification à facteur multiple

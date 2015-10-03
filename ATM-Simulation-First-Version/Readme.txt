==========================================
How to Install -- Syteme Bancaire ATM ---
==========================================

La solution est une Application web, fournie en .WAR.

Elle est configurée pour fonctionner avec  MySQL. 

D'autes BD peuvent etre utilisés, il faudra cependant

ajouter à la librairie le .jar correspondant du driver connector.



Je présente ci-dessous une manière de déployer le WAR sur un serveur Tomcat. Il en exite d'autres, et l'application fonctionne

également sur d'autres serveurs d'applications(testé avec succès dans Eclipse avec Glassfish). Vous êtes libre de deployer l'application différement.



=====================================================
--- Déploiment du fichier WAR sur Serveur Tomcat  ---
=====================================================


- Copier le fichier WAR sous le répertoire webapps de Tomcat. Le fichier sera décompressé lors du démarrage de Tomcat, dans un répertoire portant le même nom que le fichier WAR.

- Utiliser les scipts create_tables.sql  et load_data.sql  pour creer les tables et  charger minimalement les données dans la BD. D'autres données peuvent etre rajoutées à convenance.

- Editer le fichier jdbc.properties (/WEB-INF/classes/ ) pour la connection à la base de données.

- L'applicataion est disponible via un navigateur web à l'adresse http://hote/Nom_ du_ WAR_sans_extension/login.htm

- Le Login se fait avec un numéro de carte(carNumber) et un nip.

- Une logique de limite de montant par transaction a été effectuée comme suit: 

Max_depot: 1000
Min_depot: 20
Max_retrait: 20 
Min_retrait: 500

- le choix a été fait d'enregistrer des transactions rejetées, lorsqu'elles sont rejetées en aval par la Banque et non en amont par le validateur.
  Par exemple, un retrait avec un montant valide mais supérieur au solde du client sera enregistrée (avec un status à false),
  alors qu'une transaction avec un montant invalide ne sera pas enregistrée.
  
 
Informations des données initiales: 3 tables au total, Account, CustomerCare, Transaction. Le table Transaction est vide.

|-----------------------------|
|           Account           |
|--------------|--------------|
| accountNumber|  balance     |
|--------------|--------------|
| 411 1111 1   |  120.00      |
|--------------|--------------|
| 411 2222 2   |  3000.00     |
|--------------|--------------|
| 411 3333 3   | 10000.00     |
|------------- |--------------|
| 411 4444 4   | 30000.00     |
|-----------------------------|
    
	
|-------------------------------------------------------|
|                   customercard                        |
|------------------|--------------|---------------------|
| cardNumber       |     nip      |   accountNumber     |
|------------------|--------------|---------------------|
| 4519 04 5768 06  |  12345       |  411 1111 1         |
|------------------|--------------|---------------------|
| 4519 06 9474 37  |  1a2b3c4d    |  411 2222 2         |
|------------------|--------------|---------------------|
| 4519 05 3724 58  |  zz00xx11    |  411 4444 4         |
|------------------------------------------------------ |
	
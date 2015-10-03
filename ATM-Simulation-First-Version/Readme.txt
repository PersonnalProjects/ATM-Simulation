==========================================
How to Install -- Syteme Bancaire ATM ---
==========================================

La solution est une Application web, fournie en .WAR.

Elle est configur�e pour fonctionner avec  MySQL. 

D'autes BD peuvent etre utilis�s, il faudra cependant

ajouter � la librairie le .jar correspondant du driver connector.



Je pr�sente ci-dessous une mani�re de d�ployer le WAR sur un serveur Tomcat. Il en exite d'autres, et l'application fonctionne

�galement sur d'autres serveurs d'applications(test� avec succ�s dans Eclipse avec Glassfish). Vous �tes libre de deployer l'application diff�rement.



=====================================================
--- D�ploiment du fichier WAR sur Serveur Tomcat  ---
=====================================================


- Copier le fichier WAR sous le r�pertoire webapps de Tomcat. Le fichier sera d�compress� lors du d�marrage de Tomcat, dans un r�pertoire portant le m�me nom que le fichier WAR.

- Utiliser les scipts create_tables.sql  et load_data.sql  pour creer les tables et  charger minimalement les donn�es dans la BD. D'autres donn�es peuvent etre rajout�es � convenance.

- Editer le fichier jdbc.properties (/WEB-INF/classes/ ) pour la connection � la base de donn�es.

- L'applicataion est disponible via un navigateur web � l'adresse http://hote/Nom_ du_ WAR_sans_extension/login.htm

- Le Login se fait avec un num�ro de carte(carNumber) et un nip.

- Une logique de limite de montant par transaction a �t� effectu�e comme suit: 

Max_depot: 1000
Min_depot: 20
Max_retrait: 20 
Min_retrait: 500

- le choix a �t� fait d'enregistrer des transactions rejet�es, lorsqu'elles sont rejet�es en aval par la Banque et non en amont par le validateur.
  Par exemple, un retrait avec un montant valide mais sup�rieur au solde du client sera enregistr�e (avec un status � false),
  alors qu'une transaction avec un montant invalide ne sera pas enregistr�e.
  
 
Informations des donn�es initiales: 3 tables au total, Account, CustomerCare, Transaction. Le table Transaction est vide.

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
	
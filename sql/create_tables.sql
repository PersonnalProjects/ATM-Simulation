DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS CustomerCard;
DROP TABLE IF EXISTS TransactionTbl;
DROP TABLE IF EXISTS Role;

CREATE TABLE IF NOT EXISTS  Account
(id					INTEGER 			NOT NULL AUTO_INCREMENT,
 balance 			DECIMAL(10,2) 		NOT NULL,
 accountNumber 		VARCHAR(20) 		NOT NULL,
 PRIMARY KEY 		(id),
 UNIQUE KEY			(accountNumber)
);

CREATE TABLE IF NOT EXISTS  CustomerCard
(id							INTEGER NOT NULL AUTO_INCREMENT,
 holderFirstName 			VARCHAR(20) 		NOT NULL,
 holderLastName  			VARCHAR(20) 		NOT NULL,
 cardNumber 				VARCHAR(20) 		NOT NULL,
 nip						VARCHAR(40) 		NOT NULL,
 expirationDate				DATE				NOT NULL, 
 accountNumber 				VARCHAR(20) 		NOT NULL 			REFERENCES Account(accountNumber),
 PRIMARY KEY 				(id),
 UNIQUE KEY					(cardNumber)
);

CREATE TABLE IF NOT EXISTS  TransactionTbl
(id							INTEGER NOT NULL AUTO_INCREMENT,
 amount 					DECIMAL(10,2) 							NOT NULL,
 status						BOOLEAN 								NOT NULL,
 transactionType			ENUM('DEPOSIT', 'WITHDRAWAL') 			NOT NULL,
 transactionDate			TIMESTAMP  								NOT NULL, 
 accountNumber 				VARCHAR(20) 							NOT NULL		REFERENCES Account(accountNumber),
 PRIMARY KEY 				(id)
);

CREATE TABLE IF NOT EXISTS  Role
(accountNumber 				VARCHAR(20) 									NOT NULL		REFERENCES Account(accountNumber),
 role 						ENUM('ROLE_USER', 'ROLE_MAINTENANCE') 			NOT NULL,
 PRIMARY KEY 				(accountNumber)
);

-- Insertion de comptes clients
INSERT INTO `atm`.`account` (`id`, `balance`, `accountNumber`) VALUES (NULL, '200', '411 1111 1');
INSERT INTO `atm`.`account` (`id`, `balance`, `accountNumber`) VALUES (NULL, '3000', '411 2222 2');
INSERT INTO `atm`.`account` (`id`, `balance`, `accountNumber`) VALUES (NULL, '10000', '411 3333 3');
INSERT INTO `atm`.`account` (`id`, `balance`, `accountNumber`) VALUES (NULL, '30000', '411 4444 4');


-- Insertion de cartes clients
INSERT INTO `atm`.`customercard` (`id`, `holderFirstName`, `holderLastName`, `cardNumber`, `nip`, `expirationDate`, `accountNumber`) VALUES (NULL, 'Jean', 'Boivert', '4519 04 5768 06', MD5('12345'), '2015-01-01', '411 1111 1');
INSERT INTO `atm`.`customercard` (`id`, `holderFirstName`, `holderLastName`, `cardNumber`, `nip`, `expirationDate`, `accountNumber`) VALUES (NULL, 'Christophe', 'Delarue', '4519 06 9474 37', MD5('1a2b3c4d'), '2012-01-01', '411 2222 2');
INSERT INTO `atm`.`customercard` (`id`, `holderFirstName`, `holderLastName`, `cardNumber`, `nip`, `expirationDate`, `accountNumber`) VALUES (NULL, 'Bernard', 'Laroche', '4519 05 3724 58', MD5('zz00xx11'), '2018-01-01', '411 4444 4');
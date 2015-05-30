--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `emergency`.`user` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`suivi_alerte` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`alerte` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`piece_jointe` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`recepteurs_situation` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`situation` DROP PRIMARY KEY;

ALTER TABLE `emergency`.`recepteurs_situation` DROP INDEX `emergency`.`fk_user_has_situation_situation1_idx`;

ALTER TABLE `emergency`.`alerte` DROP INDEX `emergency`.`fk_alerte_situation1_idx`;

ALTER TABLE `emergency`.`suivi_alerte` DROP INDEX `emergency`.`fk_alerte_has_user_alerte1_idx`;

ALTER TABLE `emergency`.`recepteurs_situation` DROP INDEX `emergency`.`fk_user_has_situation_user1_idx`;

ALTER TABLE `emergency`.`piece_jointe` DROP INDEX `emergency`.`fk_piece_jointe_alerte1_idx`;

ALTER TABLE `emergency`.`situation` DROP INDEX `emergency`.`fk_situation_user_idx`;

ALTER TABLE `emergency`.`suivi_alerte` DROP INDEX `emergency`.`fk_alerte_has_user_user1_idx`;

DROP TABLE `emergency`.`piece_jointe`;

DROP TABLE `emergency`.`situation`;

DROP TABLE `emergency`.`suivi_alerte`;

DROP TABLE `emergency`.`user`;

DROP TABLE `emergency`.`recepteurs_situation`;

DROP TABLE `emergency`.`alerte`;

CREATE TABLE `emergency`.`piece_jointe` (
	`id_piece_jointe` INT NOT NULL,
	`id_alerte` INT NOT NULL,
	`url` VARCHAR(100),
	`date_creation` DATETIME,
	`type` VARCHAR(20),
	PRIMARY KEY (`id_piece_jointe`)
) ENGINE=InnoDB;

CREATE TABLE `emergency`.`situation` (
	`id_situation` INT NOT NULL,
	`id_emetteur` VARCHAR(20) NOT NULL,
	`titre` VARCHAR(45) NOT NULL,
	`message` TEXT,
	`pieces_jointes` SMALLINT,
	`type_envoi` SMALLINT,
	PRIMARY KEY (`id_situation`)
) ENGINE=InnoDB;

CREATE TABLE `emergency`.`suivi_alerte` (
	`id_alerte` INT NOT NULL,
	`id_recepteur` VARCHAR(20) NOT NULL,
	`localisation_re_x` VARCHAR(45),
	`localisation_re_y` VARCHAR(45),
	`etat_suivi` SMALLINT,
	`date_maj` DATETIME,
	PRIMARY KEY (`id_recepteur`,`id_alerte`)
) ENGINE=InnoDB;

CREATE TABLE `emergency`.`user` (
	`telephone` VARCHAR(20) NOT NULL,
	`nom` VARCHAR(30),
	`prenom` VARCHAR(30),
	`date_naissance` DATE,
	`sexe` SMALLINT,
	`group_sanguin` SMALLINT,
	`diabete` SMALLINT,
	`cholesterol` SMALLINT,
	`autres_infos` TEXT,
	`gcm_device_id` VARCHAR(200),
	`digits_id` BIGINT,
	PRIMARY KEY (`telephone`)
) ENGINE=InnoDB;

CREATE TABLE `emergency`.`recepteurs_situation` (
	`id_recepteur` VARCHAR(20) NOT NULL,
	`id_situation` INT NOT NULL,
	`date_creation` DATETIME,
	`date_modification` DATETIME,
	PRIMARY KEY (`id_recepteur`,`id_situation`)
) ENGINE=InnoDB;

CREATE TABLE `emergency`.`alerte` (
	`id_alerte` INT NOT NULL,
	`id_situation` INT NOT NULL,
	`date_envoi` DATETIME,
	`localisation_em_x` VARCHAR(45),
	`localisation_em_y` VARCHAR(45),
	`statut` SMALLINT,
	PRIMARY KEY (`id_alerte`)
) ENGINE=InnoDB;

CREATE INDEX `fk_user_has_situation_situation1_idx` ON `emergency`.`recepteurs_situation` (`id_situation` ASC);

CREATE INDEX `fk_alerte_situation1_idx` ON `emergency`.`alerte` (`id_situation` ASC);

CREATE INDEX `fk_alerte_has_user_alerte1_idx` ON `emergency`.`suivi_alerte` (`id_alerte` ASC);

CREATE INDEX `fk_user_has_situation_user1_idx` ON `emergency`.`recepteurs_situation` (`id_recepteur` ASC);

CREATE INDEX `fk_piece_jointe_alerte1_idx` ON `emergency`.`piece_jointe` (`id_alerte` ASC);

CREATE INDEX `fk_situation_user_idx` ON `emergency`.`situation` (`id_emetteur` ASC);

CREATE INDEX `fk_alerte_has_user_user1_idx` ON `emergency`.`suivi_alerte` (`id_recepteur` ASC);


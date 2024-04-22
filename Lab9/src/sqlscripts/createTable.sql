CREATE TABLE `demo`.`persoana` (
                                    `id` INT NOT NULL,
                                    `nume` VARCHAR(45) NULL,
                                    `prenume` VARCHAR(45) NULL,
                                    `varsta` INT NULL,
                                    PRIMARY KEY (`id`));

INSERT INTO demo.persoana VALUES (1, 'POPA', 'Maria', 20);
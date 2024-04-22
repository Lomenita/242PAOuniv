CREATE TABLE `proiectpao`.`student` (
                                        `studentNumber` INT NOT NULL,
                                        `averageMark` FLOAT NULL,
                                        `clasa` VARCHAR(45) NULL,
                                        `name` VARCHAR(45) NULL,
                                        `phoneNumber` VARCHAR(45) NULL,
                                        `emailAddress` VARCHAR(45) NULL,
                                        PRIMARY KEY (`studentNumber`));

CREATE TABLE `proiectpao`.`profesor` (
                                        `year` INT NOT NULL,
                                        `course` VARCHAR(45) NULL,
                                        `name` VARCHAR(45) NULL,
                                        `phoneNumber` VARCHAR(45) NULL,
                                        `emailAddress` VARCHAR(45) NULL);


DELETE FROM proiectpao.student s WHERE s.name = 'ionescu a';
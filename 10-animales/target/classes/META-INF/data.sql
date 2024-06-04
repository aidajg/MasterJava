CREATE TABLE `Animales` (`cod_animal` VARCHAR(255) NOT NULL,`tipo` VARCHAR(255),`nombre` VARCHAR(255) ,`sexo` VARCHAR(255) ,`edad` INT,`enfermedad` BIT, `vacunas` INT,`citas_vet` INT, PRIMARY KEY (`cod_animal`));

INSERT INTO Animales (cod_animal, tipo, nombre, sexo, edad, enfermedad, vacunas, citas_vet) VALUES ("LOLA01", "Gato", "Lola", "hembra", 7, 1, 2, 0);
INSERT INTO Animales (cod_animal, tipo, nombre, sexo, edad, enfermedad, vacunas, citas_vet) VALUES ("BOBI01", "Hamster", "Bobi", "macho", 2, 0, 0, 0);
INSERT INTO Animales (cod_animal, tipo, nombre, sexo, edad, enfermedad, vacunas, citas_vet) VALUES ("LOLA02", "Iguana", "Lola", "hembra", 5, 1, 3, 3);






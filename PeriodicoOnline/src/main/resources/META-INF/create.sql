CREATE TABLE `Noticia` (`titulo` VARCHAR(255) NOT NULL,`autor` VARCHAR(255) NOT NULL,`fecha` VARCHAR(255) ,PRIMARY KEY (`titulo`));
CREATE TABLE `Comentarios` (`id` VARCHAR(255) NOT NULL,`texto` VARCHAR(255) NOT NULL,`autor` VARCHAR(255), `titulo_noticia` VARCHAR(255), PRIMARY KEY (`id`));
ALTER TABLE `Comentarios` ADD CONSTRAINT `Comentarios_fk0` FOREIGN KEY (`titulo_noticia`) REFERENCES `Noticia`(`titulo`);
 
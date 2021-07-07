DROP SCHEMA IF EXISTS fil_rouge_db;

CREATE SCHEMA fil_rouge_db;

use fil_rouge_db;

DROP TABLE IF EXISTS artistes;

CREATE TABLE artistes (
  id int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(45) DEFAULT NULL,
  url_photo varchar(128),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS genres;

CREATE TABLE genres (
  id int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS albums;

CREATE TABLE albums (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_artiste int(11),
  nom_album varchar(45),
  date_sortie varchar(45),
  url_couverture varchar(128) DEFAULT NULL,
  PRIMARY KEY (id),
   KEY FK_ARTISTE_ALBUM_idx (id_artiste),
  CONSTRAINT FK_ARTISTE_ALBUM FOREIGN KEY (id_artiste) REFERENCES artistes (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS sons;

DROP TABLE IF EXISTS morceaux;

CREATE TABLE morceaux (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_artiste int(11),
  id_album int(11),
  id_genre int(11) DEFAULT NULL,
  Nom varchar(128) DEFAULT NULL,
  Duree int(11) DEFAULT NULL,
  url_son varchar(128),
  PRIMARY KEY (id),
  KEY FK_ARTISTE_idx (id_artiste),
  CONSTRAINT FK_ARTISTE FOREIGN KEY (id_artiste) REFERENCES artistes (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY FK_ALBUM_idx (id_album),
  CONSTRAINT FK_ALBUM FOREIGN KEY (id_album) REFERENCES albums (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY FK_GENRE_idx (id_genre),
  CONSTRAINT FK_GENRE FOREIGN KEY (id_genre) REFERENCES genres (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(128) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `authorities`  varchar(128) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS playlist;

Create Table playlist(
 id int(11) NOT NULL AUTO_INCREMENT,
 titre varchar(128) default "playlist",
 createur varchar(50) NOT NULL,
PRIMARY KEY (id),
KEY FK_UTILISATEURS_idx (createur),
  CONSTRAINT FK_UTILISATEURS FOREIGN KEY (createur) REFERENCES users (username) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

Insert into artistes(id,nom,url_photo) Values (1,'AC/DC','https://drive.google.com/uc?export=view&id=1B5JxRxksapCV1v65JPHpGdqVfzbYO32z'),(2,'EMINEM','https://drive.google.com/uc?export=view&id=1Jcv9535ymvtYrqM3yvOc6wzLnhqIvvFR');

Insert into genres(id,nom) Values (1,'Hard Rock'),(2,'Rap'),(3,'Electro'),(4,'Pop'),(5,'Rock'),(6,'Hip Hop');

Insert into albums (id,id_artiste,nom_album,date_sortie,url_couverture) values (1,1,'Highway to Hell','27-07-1979','https://drive.google.com/uc?export=view&id=1AEMbY3-u5mDmjCnaofIoTGCKjV8FxHNn');
Insert into albums (id,id_artiste,nom_album,date_sortie,url_couverture) values (2,1,'Power Up','13-11-2020','https://drive.google.com/uc?export=view&id=1F9yQM6GKzHmFROczmfTLuMdwQmzTAavy');
Insert into albums (id,id_artiste,nom_album,date_sortie,url_couverture) values (3,2,'The Eminem Show','26-05-2002','https://drive.google.com/uc?export=view&id=1sIKok9Y1CtVZYLzCb0FG8tACQHiLAerS');
Insert into albums (id,id_artiste,nom_album,date_sortie,url_couverture) values (4,2,'Kamikaze','31-08-2018','https://drive.google.com/uc?export=view&id=1y1WFPb1FngdRKbwplpL7fEJs524PTpK_');

Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,url_son) values (1,1,1,1,'Highway to Hell',206,'https://drive.google.com/file/d/1ZWuV87gqhsM2o_8LXGP1CkNy39w66HLS/preview'),(2,1,1,1,'Girls got Rhythm',203,'https://drive.google.com/file/d/1bxz_YxnLXnD79XleODFgor4VhdgO-6ql/preview');
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,url_son) values (3,1,2,1,'Realize',218,'https://drive.google.com/file/d/1rjV_UyyoD-fc21IcrApvmFh_Y2dX4l00/preview'),(4,1,2,1,'Shot in the Dark',215,'https://drive.google.com/file/d/1rjV_UyyoD-fc21IcrApvmFh_Y2dX4l00/preview');
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,url_son) values (5,2,3,2,'Business',253,'https://drive.google.com/file/d/1PzOlmAWOGLvbZV0KypeLVAWzYhsGLSiU/preview'),(6,2,3,2,'Sing for the Moment',340,'https://drive.google.com/file/d/1V0kCkqH-WKhookrUtl9RqyW9j5oWqPbP/preview');
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,url_son) values (7,2,4,2,'Fall',269,'https://drive.google.com/file/d/1tvWAHPlr1DzEOeC7HprYanps6xwn_PCy/preview'),(8,2,4,2,'Nice Guy',155,'https://drive.google.com/file/d/1F5Xw-LMW9Q-U2-iMjiBU_K3MFDUogKgG/preview');

INSERT INTO `users` (`username`,`password`,`enabled`,`authorities`) VALUES ('admin','{bcrypt}$2y$12$2VyXh575.GE.JCPMyLRkz.ha7op/qH16ZvqEmNzpCooBPrybCB9Q6',1,'ROLE_USER;ROLE_MANAGER');
INSERT INTO `users` (`username`,`password`,`enabled`,`authorities`) VALUES ('bob','{bcrypt}$2y$12$Iolk0w0pNhJP2f2GDSueBeI07N/iyAYjDUTJ.R70laveh/JMXH.Zy',1,'ROLE_USER');

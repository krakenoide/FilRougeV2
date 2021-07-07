DROP SCHEMA IF EXISTS fil_rouge_db;

CREATE SCHEMA fil_rouge_db;

use fil_rouge_db;

DROP TABLE IF EXISTS artistes;

CREATE TABLE artistes (
  id int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(45) DEFAULT NULL,
  photo mediumBlob,
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
  couverture mediumblob DEFAULT NULL,
  PRIMARY KEY (id),
   KEY FK_ARTISTE_ALBUM_idx (id_artiste),
  CONSTRAINT FK_ARTISTE_ALBUM FOREIGN KEY (id_artiste) REFERENCES artistes (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS sons;

CREATE TABLE sons (
  id int(11) NOT NULL AUTO_INCREMENT,
  Son mediumblob DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS morceaux;

CREATE TABLE morceaux (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_artiste int(11),
  id_album int(11),
  id_genre int(11) DEFAULT NULL,
  Nom varchar(128) DEFAULT NULL,
  Duree int(11) DEFAULT NULL,
  id_son int(11),
  PRIMARY KEY (id),
  KEY FK_ARTISTE_idx (id_artiste),
  CONSTRAINT FK_ARTISTE FOREIGN KEY (id_artiste) REFERENCES artistes (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY FK_ALBUM_idx (id_album),
  CONSTRAINT FK_ALBUM FOREIGN KEY (id_album) REFERENCES albums (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY FK_GENRE_idx (id_genre),
  CONSTRAINT FK_GENRE FOREIGN KEY (id_genre) REFERENCES genres (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY FK_SON_idx (id_son),
  CONSTRAINT FK_SON FOREIGN KEY (id_son) REFERENCES sons (id) ON DELETE NO ACTION ON UPDATE NO ACTION
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

Insert into artistes(id,nom,photo) Values (1,'AC/DC',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoArtistes/ACDC.jpg')),(2,'EMINEM',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoArtistes/eminem.jpg'));

Insert into genres(id,nom) Values (1,'Hard Rock'),(2,'Rap'),(3,'Electro'),(4,'Pop'),(5,'Rock'),(6,'Hip Hop');

Insert into albums (id,id_artiste,nom_album,date_sortie,couverture) values (1,1,'Highway to Hell','27-07-1979',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoAlbums/Highway_to_Hell.jpg'));
Insert into albums (id,id_artiste,nom_album,date_sortie,couverture) values (2,1,'Power Up','13-11-2020',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoAlbums/Power_Up.jpg'));
Insert into albums (id,id_artiste,nom_album,date_sortie,couverture) values (3,2,'The Eminem Show','26-05-2002',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoAlbums/The_Eminem_Show.jpg'));
Insert into albums (id,id_artiste,nom_album,date_sortie,couverture) values (4,2,'Kamikaze','31-08-2018',load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/photoAlbums/Kamikaze.jpg'));

Insert into sons(id,Son) Values (1,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Highway to Hell.mp3')),(2,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Girls Got Rhythm.mp3'));
-- Insert into sons(id,Son) Values (1,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Highway to Hell.mp3')),(2,load_file('https://drive.google.com/file/d/1bxz_YxnLXnD79XleODFgor4VhdgO-6ql/view?usp=sharing'));
Insert into sons(id,Son) Values (3,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Realize.mp3')),(4,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Shot in the Dark.mp3'));
Insert into sons(id,Son) Values (5,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Business.mp3')),(6,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Sing For The Moment.mp3'));
Insert into sons(id,Son) Values (7,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Fall.mp3')),(8,load_file('C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Sons/Nice Guy.mp3'));

Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,id_son) values (1,1,1,1,'Highway to Hell',206,1),(2,1,1,1,'Girls got Rhythm',203,2);
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,id_son) values (3,1,2,1,'Realize',218,3),(4,1,2,1,'Shot in the Dark',215,4);
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,id_son) values (5,2,3,2,'Business',253,5),(6,2,3,2,'Sing for the Moment',340,6);
Insert into morceaux (id,id_artiste,id_album,id_genre,Nom,Duree,id_son) values (7,2,4,2,'Fall',269,7),(8,2,4,2,'Nice Guy',155,8);

INSERT INTO `users` (`username`,`password`,`enabled`,`authorities`) VALUES ('admin','{bcrypt}$2y$12$2VyXh575.GE.JCPMyLRkz.ha7op/qH16ZvqEmNzpCooBPrybCB9Q6',1,'ROLE_USER;ROLE_MANAGER');
INSERT INTO `users` (`username`,`password`,`enabled`,`authorities`) VALUES ('bob','{bcrypt}$2y$12$Iolk0w0pNhJP2f2GDSueBeI07N/iyAYjDUTJ.R70laveh/JMXH.Zy',1,'ROLE_USER');

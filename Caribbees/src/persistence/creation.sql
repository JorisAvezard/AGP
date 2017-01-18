-- file to copy in your database

CREATE TABLE TouristicSites (
	id_site INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_site VARCHAR(20),
	id_isle varchar(20),
	type_site ENUM('Activity','HistoricSite'),
    price INT,
	visit_time INT
);

CREATE TABLE Isle (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_isle VARCHAR(20)
);

CREATE TABLE Transport (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type_transport ENUM('Boat','Bus'),
	price INT,
	time_transport INT
);

CREATE TABLE Hotel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_hotel VARCHAR(20),
	id_isle varchar(20),
	standing INT,
	price_per_night INT
);


INSERT INTO TouristicSites (name_site, id_isle, price, visit_time)
 VALUES
 ('AAA', 2, 15, 3),
 ('BBB', 4, 5, 2)
 ('CCC', 4, 5, 2);
 
 INSERT INTO Hotel (name_hotel, id_isle, standing, price_per_night )
 VALUES
 ('Hotel1', 2, 2, 50),
 ('Hotel2', 6, 5, 150),
 ('Hotel3', 3, 4, 50);


CREATE TABLE TouristicSites (
	id_site INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_site VARCHAR(50),
	id_isle INT,
	type_site ENUM('Activity','HistoricSite'),
    price INT,
	visit_time INT,
	FOREIGN KEY (id_isle) REFERENCES id_isle(Isle)
);


CREATE TABLE Isle (
	id_isle INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_isle VARCHAR(20)
);

CREATE TABLE Transport (

	id_transport INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type_transport ENUM('Boat','Bus'),
	price INT,
	time_transport INT
);

CREATE TABLE Hotel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_hotel VARCHAR(50),
	id_isle INT,
	standing INT,
	price_per_night INT,
	FOREIGN KEY (id_isle) REFERENCES id_isle(Isle)
);

-- Table to store the transit time between two touristic places
CREATE TABLE TransitTimeSS (
	begin_place varchar(50),
	end_place varchar(50),
	transit_time INT,
	FOREIGN KEY (begin_place) REFERENCES TouristicSites(name_site),
	FOREIGN KEY (end_place) REFERENCES TouristicSites(name_site)

);

-- Table to store the transit time between two places : touristic site and hotel
CREATE TABLE TransitTimeSH (
	begin_place varchar(50),
	end_place varchar(50),
	transit_time INT,
	FOREIGN KEY (begin_place) REFERENCES TouristicSites(name_site),
	
		FOREIGN KEY (end_place) REFERENCES Hotel(name_hotel)
);

-- insertion isle

insert into isle (name_isle) values ('guadeloupe'),('Dominique'), ('Anguilla'), ('saba'), ('barbuda'),('Antigua'), ('redonda'), ('barbade'), ('Ronde'), ('Coche'), ('Aruba');



insert into Hotel (name_hotel,id_isle,standing,price_per_night) values

('Jungle Bay Resort & Spa','2','2','40')
,('Pirate','2','2','60')
,('Rosalie Bay Resort','2','4','80')
,('calibichi','2','3','70')
,('portland','2','3','70')
,('kapok','1','3','70')
,('royal beach','1','4','90')
,('alegria','1','4','100')
,('sxm','1','1','30')
,('sea','1','4','70')
,('el momo','4','3','70')
,('the old','4','2','50')
,('golden era','4','5','200')
,('la vista','4','1','30')
,('simpson','4','3','70');


insert into touristicSites (name_site,id_isle,type_site,price,visit_time) values
('diving','2','Activity','20','2'),
('cruise','2','Activity','60','1'),
('the dominica museum','2','HistoricSite','50','4'),
('ti tou gorge','2','HistoricSite','70','5'),
('water skiing','2','Activity','30','1'),
('treetop','1','Activity','25','2'),
('water skiing','1','Activity','40','3'),
('Maison Petrelluzzi','1','HistoricSite','20','5'),
('Harry L. Johnson Museum','4','HistoricSite','45','3'),
('hiking','4','Activity','50','4'),
('cruise','1','Activity','30','3'),
('Monument aux morts','1','HistoricSite','35','2'),
('Dutch Museum Saba','4','HistoricSite','45','2'),
('water skiing','4','Activity','60','2');
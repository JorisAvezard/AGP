

CREATE TABLE TouristicSites (
	id_site INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_site VARCHAR(20),
	id_isle varchar(20),
	type_site ENUM('Activity','HistoricSite'),
    price varchar(20),
	visit_time varchar(20),
	FOREIGN KEY (id_isle) REFERENCES id_isle(Isle))
);


CREATE TABLE Isle (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_isle VARCHAR(20)
);

CREATE TABLE Transport (

	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	type_transport ENUM('Boat','Bus'),
	price varchar(20),
	time_transport varchar(20)
);

CREATE TABLE Hotel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name_hotel VARCHAR(20),
	id_isle varchar(20),
	standing varchar(20),
	price_per_night varchar(20),
	FOREIGN KEY (id_isle) REFERENCES id_isle(Isle))
);


	
		FOREIGN KEY (end_place) REFERENCES Hotel(name_hotel)
);

----- insertion isle

insert into isle (name_isle) values ('guadeloupe'),('Dominique'), ('Anguilla'), ('saba'), ('barbuda'),('Antigua'), ('redonda'), ('barbade'), ('Ronde'), ('Coche'), ('Aruba');

--insertion hotel--

insert into hotel (name_hotel,id_isle,standing,price_per_night) values
--------dominique-----
('Jungle Bay Resort & Spa','2','2','40')
,('Pirate','2','2','60')
,('Rosalie Bay Resort','2','4','80')
,('calibichi','2','3','70')
,('portland','2','3','70')
-------------guadeloupe---------
,('kapok','1','3','70')
,('royal beach','1','4','90')
,('alegria','1','4','100')
,('sxm','1','1','30')
,('sea','1','4','70')
-------------saba---------
,('el momo','4','3','70')
,('the old','4','2','50')
,('golden era','4','5','200')
,('la vista','4','1','30')
,('simpson','4','3','70');


-------------------touristique sites---------------------

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





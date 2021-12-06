CREATE SCHEMA IF NOT EXISTS christiansoe_db;
USE christiansoe_db;

INSERT INTO animal(title,report) VALUES ("Sæl","Dette er en sæl!");

INSERT INTO image(filepath,location_id,animal_id)
VALUES ("C:\Users\Laust\IdeaProjects\ChristiansoeExamProject\src\main\resources\static\images\seal.jpeg",null,1);

INSERT INTO sound(filepath,location_id,animal_id)
VALUES ("C:\Users\Laust\IdeaProjects\ChristiansoeExamProject\src\main\resources\static\sounds\seal.wav",null,1);

INSERT INTO location(title,report,longitude,latitude)
VALUES ("Danmarks østligeste punkt","Du kan ikke finde et andet punkt i Danmark der er mere østligt end dette!",15.192853298391688,55.32029540616608);

INSERT INTO location(title,report,longitude,latitude) VALUES ("Badebro","Dette er en badebro!",15.183442624715434,55.32128710201616);

INSERT INTO location_animals(location_id,animal_id) VALUES (1,1);
INSERT INTO location_animals(location_id,animal_id) VALUES (2,1);

INSERT INTO tour(title,report) VALUES ("Fra vest til øst","Denne tur er fra vest til øst!");

INSERT INTO tour_locations(tour_id,location_id) VALUES (1,1);
INSERT INTO tour_locations(tour_id,location_id) VALUES (1,2);
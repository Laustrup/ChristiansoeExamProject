CREATE SCHEMA IF NOT EXISTS christiansoe_db;
USE christiansoe_db;

INSERT INTO animal(title,report) VALUES ("Sæl","Dette er en sæl!");

INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Danmarks østligeste punkt","Du kan ikke finde et andet punkt i Danmark der er mere østligt end dette!",15.192853298391688,55.32029540616608);

INSERT INTO location(dtype, title,report,longitude,latitude) VALUES ("Attraction", "Badebro","Dette er en badebro!",15.183442624715434,55.32128710201616);

INSERT INTO image(file_path, title, image_animal, image_location)
VALUES (".../static/images/seal.jpeg", "Sæl billede", null,1);

INSERT INTO sound(file_path, title, sound_animal, sound_location)
VALUES (".../static/sounds/seal.wav", "Sæl hyl lyd", null,1);

INSERT INTO animal_locations(animals_id,locations_id) VALUES (1,1);
INSERT INTO animal_locations(animals_id,locations_id) VALUES (1,2);

INSERT INTO tour(title,report) VALUES ("Fra vest til øst","Denne tur er fra vest til øst!");

INSERT INTO tour(title,report) VALUES ("Spøgelseturen","Du bliver hjemsøgt, hvis du tager på denne faaaarlige tur");
INSERT INTO tour(title,report) VALUES ("Frøturen","Elsker du frølyde? Hedder du Janus? Dette er turen for dig");

INSERT INTO tour_locations(tours_id,locations_id) VALUES (1,1);
INSERT INTO tour_locations(tours_id,locations_id) VALUES (1,2);
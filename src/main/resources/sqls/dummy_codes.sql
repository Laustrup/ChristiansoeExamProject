CREATE SCHEMA IF NOT EXISTS christiansoe_db;
USE christiansoe_db;

/*Animals*/
INSERT INTO animal(title,report) VALUES ("Sæl","Dette er en sæl!");

/*Locations*/
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Danmarks østligeste punkt","Du kan ikke finde et andet punkt i Danmark der er mere østligt end dette!",15.192853298391688,55.32029540616608);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Badebro","Dette er en badebro",15.183442624715434,55.32128710201616);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Lægens Hus","Lægen brygger dejlig øl her",15.189756,55.320371);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Christiansø Kirke","Flot og hyggelig kirke",15.187077,55.321370);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Hestehytten","Her har der været heste",15.187525,55.322229);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Rantzaus Bastion","Prøv at skyd med kannon her",15.188344,55.323089);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Lille tårn","Museum i fæstningstårn fra 1800-tallet",15.183792,55.322042);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Store tårn","Forsvarstårn med historieudstilling",15.187002,55.320715);
INSERT INTO location(dtype, title,report,longitude,latitude)
VALUES ("Attraction", "Kongens Bastion","Den sydlige fæstning på Christiansø",15.188455,55.317975);

/*Images*/
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/seal.jpeg", "Sæl billede", null,1);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/badebro.jpeg", "Badebroen", null,2);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/ol.jpeg", "Lægens hjemmebryg", null,3);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/church.jpeg", "Christiansø Kirke", null,4);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/hestehytten.jpeg", "Hestehytten på Christiansø", null,5);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/rantzaus.jpeg", "Rantzaus Bastion", null,6);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/lilletårn.jpeg", "Lille tårn", null,7);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/storetårn.jpeg", "Store tårn", null,8);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/kongensbastion.jpeg", "Kongens Bastion", null,9);
INSERT INTO image(file_path, title, image_animal, image_location)
VALUES ("/images/østligstepunkt.jpeg", "Danmarks østligste punkt", null,1);


/*Sounds*/
INSERT INTO sound(file_path, title, sound_animal, sound_location)
VALUES ("/sounds/seal.wav", "Sæl hyl lyd", null,1);
INSERT INTO sound(file_path, title, sound_animal, sound_location)
VALUES ("/sounds/seal.wav", "Sæl hyl lyd", 1,null);
INSERT INTO sound(file_path, title, sound_animal, sound_location)
VALUES ("/sounds/junglebird.wav", "Fuglelyd", null,1);
INSERT INTO sound(file_path, title, sound_animal, sound_location)
VALUES ("/sounds/seal.wav", "Sæl hyl lyd", null,6);

/*Animal Locations*/
INSERT INTO animal_locations(animals_id,locations_id) VALUES (1,1);
INSERT INTO animal_locations(animals_id,locations_id) VALUES (1,2);

/*Tours*/
INSERT INTO tour(title,report) VALUES ("Fra vest til øst","Denne tur er fra vest til øst!");
INSERT INTO tour(title,report) VALUES ("Den nordlige tur","Se den nordlige del af øen");
INSERT INTO tour(title,report) VALUES ("Tårnturen","Her ser du de to tårne, samt Kongens Bastion");

/*Tour Locations*/
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (1,2,1);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (1,3,2);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (1,1,3);

INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (2,4,1);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (2,5,2);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (2,6,3);

INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (3,7,1);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (3,8,2);
INSERT INTO tour_locations(tours_id,locations_id,step) VALUES (3,9,3);


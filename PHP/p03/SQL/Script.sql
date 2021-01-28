CREATE DATABASE Documents;
USE Documents;

CREATE TABLE Document(
	isbn VARCHAR(15),
	title VARCHAR(40),
	yearPublished int,
	
	PRIMARY KEY (isbn)
);

CREATE TABLE User (
	email VARCHAR(30),
	password VARCHAR(30),
	firstName VARCHAR(30),
	lastName VARCHAR(30),
	
	PRIMARY KEY (email)
);

INSERT INTO User VALUES ("admin@gmail.com", "admin", "Soufiane", "Ammy Driss"), ("guest@gmail.com", "", "Mehdi", "Assabbane");

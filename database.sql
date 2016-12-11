CREATE SCHEMA airdrone

create TABLE airdrone.User(
              idUser SERIAL NOT NULL,
              email VARCHAR(100) PRIMARY KEY NOT NULL,
              password VARCHAR(100) NOT NULL,
              username VARCHAR(100),
              countGames INT DEFAULT 0,
              winGames INT DEFAULT 0
            );
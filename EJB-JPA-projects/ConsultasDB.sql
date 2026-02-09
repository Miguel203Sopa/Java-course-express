
SELECT * FROM persona

CREATE TABLE usuario(
	id_usuario INT PRIMARY KEY,
	id_persona INT NOT NULL,
	username_ VARCHAR(45) ,
	password_ VARCHAR (45)
);

ALTER TABLE usuario 
ADD CONSTRAINT FK_id_persona
FOREIGN KEY (id_persona)
REFERENCES persona(id_persona)
ON DELETE SET NULL
ON UPDATE NO ACTION 




ALTER TABLE persona
ADD CONSTRAINT email_extd UNIQUE  (email)
GO
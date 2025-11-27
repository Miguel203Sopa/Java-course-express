/*Practica.1 MDB*/

CREATE DATABASE DB_Generic_1

ON PRIMARY(NAME = 'Primera_db',
FILENAME = 'E:\Eclipse\repo-java-cou\Java-course-express\SQL-Queries\FirstDB.mdf',
SIZE= 10MB,
MAXSIZE = 20MB,
FILEGROWTH =15MB )
LOG ON(NAME = 'Primera_db_',
FILENAME = 'E:\Eclipse\repo-java-cou\Java-course-express\SQL-Queries\Firstdb_.idf',
SIZE = 10MB,
MAXSIZE = 20MB,
FILEGROWTH =15MB)
COLLATE Latin1_General_CI_AI;


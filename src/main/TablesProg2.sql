CREATE TABLE Patient (
AMKA varchar NOT NULL PRIMARY KEY
Name varchar(40) NOT NULL
Surname varchar(40) NOT NULL
dateOfBirth date NOT NULL
phoneNumber varchar NOT NULL
adress varchar(225) NOT NULL
email varchar NOT NULL
medicalRecord varchar
gender char(1)
)

CREATE TABLE Doctor(
docCode varchar(40) NOT NULL PRIMARY KEY
name varchar(40)
surname varchar(40)
specialization varchar(40)
availableTime time
)

CREATE TABLE Appointment(
docCode REFERENCES Doctor(docCode)
specialization varchar(40)
apptTime time
apptDate date
patientName varchar(40) REFERENCES Patient(Name)
)
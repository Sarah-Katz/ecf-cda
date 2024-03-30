CREATE SEQUENCE bed_seq START WITH 1 increment by 50;

CREATE SEQUENCE patient_seq START WITH 1 increment by 50;

CREATE SEQUENCE room_seq START WITH 1 increment by 50;

CREATE SEQUENCE service_seq START WITH 1 increment by 50;

CREATE TABLE bed (
    id_bed integer NOT NULL,
    id_room integer,
    primary key (id_bed)
);

CREATE TABLE patient (
    id_bed integer,
    birthdate date NOT NULL,
    created_at date NOT NULL,
    id_patient integer NOT NULL,
    modified_at date,
    social_security_number varchar(15) NOT NULL UNIQUE,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    primary key (id_patient)
);

CREATE TABLE room (
    id_room integer NOT NULL,
    id_service integer NOT NULL,
    number varchar(4) NOT NULL,
    primary key (id_room)
);

CREATE TABLE service (
    id_service integer NOT NULL,
    name varchar(50) NOT NULL,
    primary key (id_service)
);

ALTER TABLE
    IF EXISTS bed
ADD
    constraint FK_bed_room foreign key (id_room) references room;

ALTER TABLE
    IF EXISTS room
ADD
    constraint FK_bed_service foreign key (id_service) references service;

ALTER TABLE
    IF EXISTS patient
ADD
    constraint FK_patient_bed foreign key (id_bed) references bed;
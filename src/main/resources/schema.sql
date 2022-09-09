CREATE TABLE prisoner
(
    id uuid PRIMARY KEY Not Null  ,
    name varchar(255),
    prisonedDate timestamp

);
CREATE TABLE prisonerStuff
(
    id integer PRIMARY KEY auto_increment,
    name varchar(255) ,
    prisonerId INTEGER Not Null


);
ALTER TABLE prisonerStuff

    ADD CONSTRAINT prisonerToStuff FOREIGN KEY (prisonerId) REFERENCES prisoner (id) on DELETE cascade ;

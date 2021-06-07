create table university
(
   id Long not null,
   name varchar(255) not null,
   location varchar(255),
   established timestamp,
   noofstudents integer(255),
   primary key(id)
);

INSERT INTO university (ID, NAME, LOCATION, ESTABLISHED, NOOFSTUDENTS )
VALUES(10001,  'Wright State University', 'Dayton',sysdate(),2500);
INSERT INTO university (ID, NAME, LOCATION, ESTABLISHED, NOOFSTUDENTS )
VALUES(10002,  'JNTU', 'Hyderabad',sysdate(), 19000);
INSERT INTO university (ID, NAME, LOCATION, ESTABLISHED, NOOFSTUDENTS )
VALUES(10003,  'Berkeley', 'SFO',sysdate(),3000);
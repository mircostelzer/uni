CREATE TABLE Sailors (
sid int,
sname varchar(255) not null,
rating int,
age float,
CONSTRAINT PK_S1 PRIMARY KEY (sid)
);

CREATE TABLE Boats (
bid int,
bname varchar(255) not null,
color varchar(255),
CONSTRAINT PK_B PRIMARY KEY (bid)
);

CREATE TABLE Reserves (
sid int,
bid int,
day date,
CONSTRAINT PK_R1 PRIMARY KEY (sid,bid,day)
);

insert into Sailors
values 
(22, 'Dustin', 7, 45),
(29, 'Brutus', 1, 33),
(31,'lubber',8,55.5),
(32, 'Andy', 8, 25.5),
(58,'Rusty',10,35),
(64, 'Horatio', 7,35),
(71,'Zorba', 10, 16),
(74, 'Horatio', 9, 35),
(85,'Art', 3, 22.5),
(95, 'Bob', 3, 63.5);

insert into Reserves
values 
(22,101,'1998-10-10'),
(22,102,'1998-10-10'),
(22,103,'1998-08-10'),
(22,104,'1998-07-10'),
(31,102, '1998-10-11'),
(31,103, '1998-06-11'),
(31,104, '1998-1-11'),
(64,101,'1998-05-09'),
(64,102,'1998-08-09'),
(74,103,'1998-08-09');

insert into Boats
values 
(101,'Interlake','blue'),
(102,'Interlake','red'),
(103,'Clipper','green'),
(104,'Marine','red');

alter table Reserves
add constraint FK1_R foreign key (sid) 
references Sailors (sid);

alter table Reserves 
add constraint FK2_R foreign key (bid) 
references Boats (bid);


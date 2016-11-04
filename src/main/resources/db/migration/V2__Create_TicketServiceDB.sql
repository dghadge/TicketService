create table if not exists seats(
	seatId          int auto_increment primary key, 
	rowNumber       int  not null, 
	seatNumber      int  not null,
	description     varchar(200) not null,  
	seatHoldId      int not null default 0,  //FK to seathold. Serves dual purpose of Hold & Confirmation ID
	status          int not null default 0,  //0=Available, 1=OnHold, 2=Reserved
	lastHeldTime    timestamp default CURRENT_TIMESTAMP
);

create table if not exists seathold(
	seatHoldId      int auto_increment primary key, 
	email           varchar(100) not null,
);


insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 1, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 2, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 3, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 4, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 5, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 6, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 7, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 8, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 9, 'Up Close Seats', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(1, 10, 'Up Close Seats', 0, 0);

insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 1, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 2, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 3, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 4, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 5, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 6, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 7, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 8, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 9, 'Awesome View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(2, 10, 'Awesome View', 0, 0);

insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 1, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 2, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 3, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 4, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 5, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 6, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 7, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 8, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 9, 'Good View', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(3, 10, 'Good View', 0, 0);

insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 1, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 2, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 3, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 4, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 5, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 6, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 7, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 8, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 9, 'Family Section', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(4, 10, 'Family Section', 0, 0);

insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 1, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 2, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 3, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 4, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 5, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 6, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 7, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 8, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 9, 'Bleachers', 0, 0);
insert into seats(rownumber, seatnumber, description, seatholdid, status)  values(5, 10, 'Bleachers', 0, 0);

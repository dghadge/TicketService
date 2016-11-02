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

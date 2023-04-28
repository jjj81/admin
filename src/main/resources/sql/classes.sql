


drop table if  exists classes;

create table classes(
flagBit varchar(10) ,
className varchar(19) default null unique,
primary key(flagBit)
);


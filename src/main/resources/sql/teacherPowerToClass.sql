drop table if exists teacherPowerToClass;

create table teacherPowerToClass(
teacherId varchar(30) not null,
className varchar(30) not null,
primary key(teacherId,className)
);

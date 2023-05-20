drop table if exists teacherPowerToClass;

create table teacherPowerToClass(
teacherId varchar(30) not null,
clazzId int  not null,
primary key(teacherId,clazzId)
);

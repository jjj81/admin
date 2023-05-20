drop table if exists clazz;
drop table if exists college;
drop table if exists faculty;
create table college(
college varchar(20) not null unique,
id int auto_increment,
primary key(id)
);
insert into college(college) values ("纺织学院");
insert into college(college) values ("能源与环境学院");
insert into college(college) values ("机电学院");
insert into college(college) values ("电子信息学院");
insert into college(college) values ("材料与化工学院");
insert into college(college) values ("计算机学院");
insert into college(college) values ("建筑工程学院");
insert into college(college) values ("服装学院");
insert into college(college) values ("艺术设计学院");
insert into college(college) values ("经济管理学院");
insert into college(college) values ("新闻与传播学院");
insert into college(college) values ("法学院知识产权学院");
insert into college(college) values ("马克思主义学院");
insert into college(college) values ("外国语学院");
insert into college(college) values ("理学院");
insert into college(college) values ("国际教育学院");
insert into college(college) values ("软件学院");
insert into college(college) values ("中原彼得堡学院");
insert into college(college) values ("亚太国际学院");
insert into college(college) values ("纺织服装产业研究院");
insert into college(college) values ("数据科学与技术系");
insert into college(college) values ("轩辕学院");
insert into college(college) values ("就业指导中心创新创业学院");
create table faculty(
id int auto_increment,
faculty varchar(20) not null ,
parentId int not null,
unique(faculty,parentId),
primary key(id)
);
create table clazz(
id int auto_increment,
clazz varchar(20) not null,
parentId int  not null,
unique(clazz,parentId),
primary key(id)
);

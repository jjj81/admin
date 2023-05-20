drop table if exists webSiteUrlAndPower;


create table webSiteUrlAndPower(
webSiteUrl varchar(30) not null,
urlPower float(10,7) not null,
primary key(webSiteUrl)
);

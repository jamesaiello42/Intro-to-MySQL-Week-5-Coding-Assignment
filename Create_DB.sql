-- Used https://www.mockaroo.com/ to mock up data

create database if not exists cars;

use cars;

create table if not exists car (
	id int(11) auto_increment primary key,
	car_make varchar(500) not null,
	car_model varchar(500) not null,
	car_year int(4) not null
);

insert into car (car_make, car_model, car_year) values ('Hummer', 'H2', 2009);
insert into car (car_make, car_model, car_year) values ('Chevrolet', '3500', 1993);
insert into car (car_make, car_model, car_year) values ('Pontiac', 'Grand Prix', 1979);
insert into car (car_make, car_model, car_year) values ('Buick', 'Lucerne', 2010);
insert into car (car_make, car_model, car_year) values ('Chevrolet', 'Corvette', 2004);
insert into car (car_make, car_model, car_year) values ('Dodge', 'Viper', 2008);
insert into car (car_make, car_model, car_year) values ('Bentley', 'Azure', 2009);
insert into car (car_make, car_model, car_year) values ('Dodge', 'Ram 1500', 1994);
insert into car (car_make, car_model, car_year) values ('Chevrolet', 'Silverado 1500', 2007);
insert into car (car_make, car_model, car_year) values ('GMC', 'Savana 2500', 2012);
insert into car (car_make, car_model, car_year) values ('Chevrolet', '1500', 1996);
insert into car (car_make, car_model, car_year) values ('Chrysler', 'LHS', 1996);
insert into car (car_make, car_model, car_year) values ('Buick', 'Rainier', 2004);
insert into car (car_make, car_model, car_year) values ('GMC', 'Savana 1500', 2008);
insert into car (car_make, car_model, car_year) values ('Oldsmobile', 'Silhouette', 2004);
insert into car (car_make, car_model, car_year) values ('Dodge', 'Ram Wagon B350', 1993);
insert into car (car_make, car_model, car_year) values ('GMC', '2500', 1998);
insert into car (car_make, car_model, car_year) values ('Buick', 'Terraza', 2006);
insert into car (car_make, car_model, car_year) values ('GMC', 'Jimmy', 2000);
insert into car (car_make, car_model, car_year) values ('Oldsmobile', 'Ciera', 1993);
insert into car (car_make, car_model, car_year) values ('Honda', 'Odyssey', 2002);
insert into car (car_make, car_model, car_year) values ('Lotus', 'Evora', 2010);
insert into car (car_make, car_model, car_year) values ('Dodge', 'Intrepid', 2001);
insert into car (car_make, car_model, car_year) values ('Ford', 'Courier', 1988);
insert into car (car_make, car_model, car_year) values ('Kia', 'Sportage', 1999);
insert into car (car_make, car_model, car_year) values ('Aston Martin', 'V8 Vantage', 2007);
insert into car (car_make, car_model, car_year) values ('Cadillac', 'Escalade ESV', 2012);
insert into car (car_make, car_model, car_year) values ('Buick', 'LeSabre', 1992);
insert into car (car_make, car_model, car_year) values ('Mazda', '626', 2002);
insert into car (car_make, car_model, car_year) values ('Honda', 'Passport', 1996);
insert into car (car_make, car_model, car_year) values ('Suzuki', 'X-90', 1996);
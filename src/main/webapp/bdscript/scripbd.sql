create database if not exists `eva_continua2_java`;
use eva_continua2_java;

drop table if exists `tabla_demo`;
create table `tabla_demo`(
`id` int not null,
`NombreLibro` varchar(120) not null,
`Autor` varchar(120) not null,
`AnioPublicacion` int not null,
`fecha` date not null
);

Alter table `tabla_demo` Add constraint `PK_tabla_demo` primary key (`id`);
Alter table `tabla_demo` Modify column `id` int not null auto_increment;

insert into `tabla_demo`(`NombreLibro`,`Autor`,`AnioPublicacion`,`fecha`) values 
('Libro 1','Jhon Reyes',2022, '2001-01-20 '),
('Libro 2','Javier Reyes',2023, '2001-01-20');

select * from tabla_demo;
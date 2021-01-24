drop database academy;
create database academy;
use academy;

create table country(
  country_id int primary key auto_increment,
  country_name varchar(20) not null
);

create table state(
  state_id int primary key auto_increment,
  state_name varchar(20) not null,
  country_id int ,
  constraint fk_country_id foreign key (country_id) references country(country_id)
);

create table city(
       city_id int primary key auto_increment,
       city_name varchar(20) not null,
       state_id int,
       constraint fk_state_id foreign key (state_id) references state(state_id)
);

create table class(
  class_id int primary key auto_increment,
  class_name varchar(60) not null
);
 
 create table subject(
  subject_id int primary key auto_increment,
  subject_name varchar(60) not null
);

create table class_subject(
   cs_id int primary key auto_increment,
   class_id int,
   subject_id int,
   unique key uk_class_id_subject_id (class_id, subject_id),
   constraint fk_class_id foreign key (class_id) references class(class_id),
   constraint fk_subject_id  foreign key (subject_id) references subject(subject_id)
);

create table user_type(
   user_type_id int primary key auto_increment,
   user_type_desc varchar(10) not null
);

create table user(
  user_id int primary key auto_increment,
  user_name varchar(60) not null,
  login_name varchar(30),
  password varchar(30),
  user_type_id int
);

create table student(
  student_id int primary key auto_increment,
  student_name varchar(60) not null,
  address_line1 varchar(30) not null,
  address_line2 varchar(30),
  city_id int,
  state_id int,
  country_id int,
  class_id int,
  dob varchar(15), #DD/MM/YYYY
  unique key uk_student_name (student_name),
  constraint fk_student_class_id foreign key (class_id) references class(class_id),
  constraint fk_student_city_id foreign key (city_id) references city(city_id),
  constraint fk_student_country_id foreign key (country_id) references country(country_id),
  constraint fk_student_state_id  foreign key (state_id) references state(state_id)
);

create table teacher (
  teacher_id int primary key auto_increment,
  teacher_name varchar(60) not null,
  address_line1 varchar(30) not null,
  address_line2 varchar(30),
  dob varchar(15), #DD/MM/YYYY,
  city_id int,
  state_id int,
  country_id int,  
  unique key uk_teacher_name (teacher_name),
  constraint fk_teacher_city_id foreign key (city_id) references city(city_id),
  constraint fk_teacher_country_id foreign key (country_id) references country(country_id),
  constraint fk_teacher_state_id  foreign key (state_id) references state(state_id)
);


create table class_subject_teacher(
    cs_id int,
    teacher_id int,
    primary key (cs_id, teacher_id),
    constraint fk_cs_id foreign key (cs_id) references class_subject(cs_id),
    constraint fk_cst_teacher_id foreign key (teacher_id) references teacher(teacher_id)
);

insert into user_type values(1, "ADMIN");
commit;

insert into country(country_name) values ("India");
insert into state(state_name, country_id) values ("Andhra Pradesh", 1);
insert into state(state_name, country_id) values ("Arunachal Pradesh", 1);
insert into state(state_name, country_id) values ("Assam", 1);
insert into state(state_name, country_id) values ("Bihar", 1);
insert into state(state_name, country_id) values ("Karnataka", 1);
insert into state(state_name, country_id) values ("Kerala", 1);
insert into state(state_name, country_id) values ("Uttar Pradesh", 1);
insert into state(state_name, country_id) values ("Goa", 1);
insert into state(state_name, country_id) values ("Gujarat", 1);
insert into state(state_name, country_id) values ("Madhya Pradesh", 1);
insert into state(state_name, country_id) values ("Maharashtra", 1);
insert into state(state_name, country_id) values ("Punjab", 1);
insert into state(state_name, country_id) values ("Rajasthan", 1);
insert into state(state_name, country_id) values ("Telangana", 1);
insert into state(state_name, country_id) values ("Tamil Nadu", 1);
commit;

insert into city(city_name, state_id) values("Mumbai", 11);
insert into city(city_name, state_id) values("Hyderabad ", 14);
insert into city(city_name, state_id) values("Bhopal ", 10);
commit;

insert into user(user_name, login_name, password, user_type_id) 
  values("Sonali P", "sonali", "sonali123", 1);
commit;

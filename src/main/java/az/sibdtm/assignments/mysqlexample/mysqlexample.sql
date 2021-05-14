-- __________________________________CREATE_______________________________
CREATE database java_backend_course;

create table courses (id INTEGER PRIMARY KEY,NAME VARCHAR(15));
DROP TABLE COURSES;

SELECT * FROM COURSES;

create table assignments (id int primary key,name varchar(100)
    ,course_id int, FOREIGN KEY(course_id) REFERENCES courses(id) );

select * from assignments;

create table teachers(id int primary key
    ,name varchar(20)
    ,surname varchar(20)
    ,course_id int
    ,FOREIGN KEY(course_id) REFERENCES courses(id));
-- drop table students;
create table students(id int primary key
    ,name varchar(20)
    ,surname varchar(20)
    ,phone varchar(15)
    , email varchar(50)
    , birthdate date
    ,course_id int
    ,teacher_id int
    ,assignment_id int
    ,foreign key(course_id) references courses(id)
    ,foreign key(teacher_id) references teachers(id)
    ,foreign key(assignment_id) references assignments(id)
);

-- ______________________________________create end_______________________________

-- ______________________________________insert courses_________________________________
insert into courses(id,name) values(1,'Java');
insert into courses(id,name) values(2,'C#');
insert into courses(id,name) values(3,'Python');
select * from courses;
-- ______________________________________insert teachers_________________________________
insert into teachers(id,name,surname,course_id) values(1,'JENNIFER','DAVIS',1);
insert into teachers(id,name,surname,course_id) values(2,'JOHNNY','NICHOLSON',2);
insert into teachers(id,name,surname,course_id) values(3,'CHRISTIAN','GABLE',3);
insert into teachers(id,name,surname,course_id) values(4,'KARL','BERRY',1);
insert into teachers(id,name,surname,course_id) values(5,'SANDRA','STREEP',3);
select * from teachers;
-- ______________________________________insert assignments_________________________________
insert into assignments(id,name,course_id)
values(1,'loop example',1);
insert into assignments(id,name,course_id)
values(2,'array example',1);
insert into assignments(id,name,course_id)
values(3,'Collections framework example',1);
insert into assignments(id,name,course_id)
values(4,'JPA framework example ',1);
insert into assignments(id,name,course_id)
values(5,'Spring framework example',1);
insert into assignments(id,name,course_id)
values(6,'Springboot',1);
insert into assignments(id,name,course_id)
values(7,'loop example',2);
insert into assignments(id,name,course_id)
values(8,'array example',2);
insert into assignments(id,name,course_id)
values(9,'.Net framework example',2);
insert into assignments(id,name,course_id)
values(10,'MSSQL',2);
insert into assignments(id,name,course_id)
values(11,'Operators',2);
insert into assignments(id,name,course_id)
values(12,'Azure',2);

insert into assignments(id,name,course_id)
values(13,'Method example',3);
insert into assignments(id,name,course_id)
values(14,'Class example',3);
insert into assignments(id,name,course_id)
values(15,'OPP',3);
insert into assignments(id,name,course_id)
values(16,'Django',3);
insert into assignments(id,name,course_id)
values(17,'CherryPy',3);
insert into assignments(id,name,course_id)
values(18,'SQLIte',3);
insert into assignments(id,name,course_id)
values(19,'Web2py',3);
insert into assignments(id,name,course_id)
values(20,'FastAPI',3);
select * from assignments;
-- ______________________________________insert students_________________________________


--  burda mysql de gelen hazir cedvelden  istifade etmisem cedveli doldurmaq ucunteachers
--  tapsiriqin sonunda hemin ccedvelin skripti var
insert into students (id ,name,surname,phone,email)
select
        actor_id-20
     ,first_name
     ,last_name
     ,concat('055',round(rand()*10000000))
     ,concat(first_name,'_',last_name,'@gmail.com')
from sakila.actor where actor_id between 21 and 71;
update students set course_id=1 where id<20 ;
update students set course_id=2 where id>19 and id<35;
update students set course_id=3 where id>34 ;

update students set birthdate='2004-09-15' where id=35;
update students set teacher_id=4 where course_id=1 and id>10;
update students set teacher_id=2 where course_id=2;
update students set teacher_id=3 where course_id=3 and id<43;
update students set teacher_id=5 where course_id=3 and id>=43;
update students set assignment_id=1 where id=17;
update students set assignment_id=2 where id=18;
update students set assignment_id=3 where id=19;
update students set assignment_id=4 where id=20;


update students set assignment_id=
                        (select id from assignments where  students.id-10=assignments.id and course_id=1)where teacher_id=4;

update students set assignment_id=
                        (select id from assignments where  students.id-13=assignments.id and course_id=1)where teacher_id=2;
update students set assignment_id=20 where id=50;
update students set assignment_id=13 where id=49;
update students set assignment_id=14 where id=48;
update students set assignment_id=15 where id=47;
update students set assignment_id=16 where id=46;
update students set assignment_id=17 where id=45;
update students set assignment_id=18 where id=44;
update students set assignment_id=19 where id=51;
update students set birthdate=date_format('1996-12-10','%Y-%m-%d') where id=22;
--  update students set birthdate=(select concat(1993+round(rand()*10),'-',substr(round(rand()*121),1,1),'-',round(rand()*30))from dual where students.id<>0) ;

select * from students;
commit;
-- ________________________________________join_______________________________
select * from courses c join assignments a on (c.id=a.course_id);
select a.name,c.name from courses c join assignments a on (c.id=a.course_id);
select * from teachers t join courses c on(t.course_id=c.id);
select t.name,t.surname,c.name from teachers t join courses c on(t.course_id=c.id);
select * from teachers t join assignments a on(t.course_id=a.course_id);
select * from teachers t left join assignments a on(t.course_id=a.course_id);
select * from teachers t right join assignments a on(t.course_id=a.course_id);
select * from teachers t cross join assignments a on(t.course_id=a.course_id);
select * from students s join teachers t on(s.teacher_id=t.id);
select * from students s join courses c on (s.course_id=c.id);
select * from students s join assignments a on(s.assignment_id=a.id);
select * from students s join teachers t
                              on(s.teacher_id=t.id)
                         join courses c
                              on (t.course_id=c.id);

select * from students s join assignments a
                              on(s.assignment_id=a.id)
                         join courses c
                              on (a.course_id=c.id);

select * from students s join teachers t
                              on(s.teacher_id=t.id)
                         join assignments a
                              on(s.assignment_id=a.id)
                         join courses c
                              on (t.course_id=c.id);

-- _______________________________________sort_______________

select * from students;
select s.* from students s
order by s.birthdate desc;

-- _________________________________copy table____________________

create table copy_courses as select * from courses;
select * from copy_courses;

create table copy_teachers as select * from teachers;

create table copy_assignments as select * from assignments;

create table copy_seudents as select * from students;

-- ________________________truncate table___________
truncate copy_teachers;
truncate copy_courses;
truncate copy_assignments;
truncate copy_seudents;

-- ______________________-____drop table_________________

drop table copy_teachers;
drop table copy_courses;
drop table copy_assignments;
drop table copy_seudents;


-- _______________________________between age_______________________

select s.* from students s
where not (s.birthdate>(SELECT DATE_ADD(sysdate(),INTERVAL -40 YEAR)) and s.birthdate<(SELECT DATE_ADD(sysdate(),INTERVAL -18 YEAR)));

SELECT DATE_ADD(sysdate(),INTERVAL -40 YEAR),DATE_ADD(sysdate(),INTERVAL -18 YEAR);

-- ____________________________________studets first_name and last_name the first two letters____________

select substr(name,1,2),substr(surname,1,2)from students;


-- ______________________________doldurmaq ucun istifade etdiyim cedvell________________
-- create table actor as select * from sakila.actor where 1=-1;
CREATE TABLE actor (
                       actor_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
                       first_name VARCHAR(45) NOT NULL,
                       last_name VARCHAR(45) NOT NULL,
                       last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       PRIMARY KEY  (actor_id),
                       KEY idx_actor_last_name (last_name)
);

INSERT INTO actor
VALUES (1,'PENELOPE','GUINESS','2006-02-15 04:34:33'),
       (2,'NICK','WAHLBERG','2006-02-15 04:34:33'),
       (3,'ED','CHASE','2006-02-15 04:34:33'),
       (4,'JENNIFER','DAVIS','2006-02-15 04:34:33'),
       (5,'JOHNNY','LOLLOBRIGIDA','2006-02-15 04:34:33'),
       (6,'BETTE','NICHOLSON','2006-02-15 04:34:33'),
       (7,'GRACE','MOSTEL','2006-02-15 04:34:33'),
       (8,'MATTHEW','JOHANSSON','2006-02-15 04:34:33'),
       (9,'JOE','SWANK','2006-02-15 04:34:33'),
       (10,'CHRISTIAN','GABLE','2006-02-15 04:34:33'),
       (11,'ZERO','CAGE','2006-02-15 04:34:33'),
       (12,'KARL','BERRY','2006-02-15 04:34:33'),
       (13,'UMA','WOOD','2006-02-15 04:34:33'),
       (14,'VIVIEN','BERGEN','2006-02-15 04:34:33'),
       (15,'CUBA','OLIVIER','2006-02-15 04:34:33'),
       (16,'FRED','COSTNER','2006-02-15 04:34:33'),
       (17,'HELEN','VOIGHT','2006-02-15 04:34:33'),
       (18,'DAN','TORN','2006-02-15 04:34:33'),
       (19,'BOB','FAWCETT','2006-02-15 04:34:33'),
       (20,'LUCILLE','TRACY','2006-02-15 04:34:33'),
       (21,'KIRSTEN','PALTROW','2006-02-15 04:34:33'),
       (22,'ELVIS','MARX','2006-02-15 04:34:33'),
       (23,'SANDRA','KILMER','2006-02-15 04:34:33'),
       (24,'CAMERON','STREEP','2006-02-15 04:34:33'),
       (25,'KEVIN','BLOOM','2006-02-15 04:34:33'),
       (26,'RIP','CRAWFORD','2006-02-15 04:34:33'),
       (27,'JULIA','MCQUEEN','2006-02-15 04:34:33'),
       (28,'WOODY','HOFFMAN','2006-02-15 04:34:33'),
       (29,'ALEC','WAYNE','2006-02-15 04:34:33'),
       (30,'SANDRA','PECK','2006-02-15 04:34:33'),
       (31,'SISSY','SOBIESKI','2006-02-15 04:34:33'),
       (32,'TIM','HACKMAN','2006-02-15 04:34:33'),
       (33,'MILLA','PECK','2006-02-15 04:34:33'),
       (34,'AUDREY','OLIVIER','2006-02-15 04:34:33'),
       (35,'JUDY','DEAN','2006-02-15 04:34:33'),
       (36,'BURT','DUKAKIS','2006-02-15 04:34:33'),
       (37,'VAL','BOLGER','2006-02-15 04:34:33'),
       (38,'TOM','MCKELLEN','2006-02-15 04:34:33'),
       (39,'GOLDIE','BRODY','2006-02-15 04:34:33'),
       (40,'JOHNNY','CAGE','2006-02-15 04:34:33'),
       (41,'JODIE','DEGENERES','2006-02-15 04:34:33'),
       (42,'TOM','MIRANDA','2006-02-15 04:34:33'),
       (43,'KIRK','JOVOVICH','2006-02-15 04:34:33'),
       (44,'NICK','STALLONE','2006-02-15 04:34:33'),
       (45,'REESE','KILMER','2006-02-15 04:34:33'),
       (46,'PARKER','GOLDBERG','2006-02-15 04:34:33'),
       (47,'JULIA','BARRYMORE','2006-02-15 04:34:33'),
       (48,'FRANCES','DAY-LEWIS','2006-02-15 04:34:33'),
       (49,'ANNE','CRONYN','2006-02-15 04:34:33'),
       (50,'NATALIE','HOPKINS','2006-02-15 04:34:33'),
       (51,'GARY','PHOENIX','2006-02-15 04:34:33'),
       (52,'CARMEN','HUNT','2006-02-15 04:34:33'),
       (53,'MENA','TEMPLE','2006-02-15 04:34:33'),
       (54,'PENELOPE','PINKETT','2006-02-15 04:34:33'),
       (55,'FAY','KILMER','2006-02-15 04:34:33'),
       (56,'DAN','HARRIS','2006-02-15 04:34:33'),
       (57,'JUDE','CRUISE','2006-02-15 04:34:33'),
       (58,'CHRISTIAN','AKROYD','2006-02-15 04:34:33'),
       (59,'DUSTIN','TAUTOU','2006-02-15 04:34:33'),
       (60,'HENRY','BERRY','2006-02-15 04:34:33'),
       (61,'CHRISTIAN','NEESON','2006-02-15 04:34:33'),
       (62,'JAYNE','NEESON','2006-02-15 04:34:33'),
       (63,'CAMERON','WRAY','2006-02-15 04:34:33'),
       (64,'RAY','JOHANSSON','2006-02-15 04:34:33'),
       (65,'ANGELA','HUDSON','2006-02-15 04:34:33'),
       (66,'MARY','TANDY','2006-02-15 04:34:33'),
       (67,'JESSICA','BAILEY','2006-02-15 04:34:33'),
       (68,'RIP','WINSLET','2006-02-15 04:34:33'),
       (69,'KENNETH','PALTROW','2006-02-15 04:34:33'),
       (70,'MICHELLE','MCCONAUGHEY','2006-02-15 04:34:33'),
       (71,'ADAM','GRANT','2006-02-15 04:34:33'),
       (72,'SEAN','WILLIAMS','2006-02-15 04:34:33'),
       (73,'GARY','PENN','2006-02-15 04:34:33'),
       (74,'MILLA','KEITEL','2006-02-15 04:34:33'),
       (75,'BURT','POSEY','2006-02-15 04:34:33'),
       (76,'ANGELINA','ASTAIRE','2006-02-15 04:34:33'),
       (77,'CARY','MCCONAUGHEY','2006-02-15 04:34:33'),
       (78,'GROUCHO','SINATRA','2006-02-15 04:34:33'),
       (79,'MAE','HOFFMAN','2006-02-15 04:34:33'),
       (80,'RALPH','CRUZ','2006-02-15 04:34:33'),
       (81,'SCARLETT','DAMON','2006-02-15 04:34:33'),
       (82,'WOODY','JOLIE','2006-02-15 04:34:33'),
       (83,'BEN','WILLIS','2006-02-15 04:34:33'),
       (84,'JAMES','PITT','2006-02-15 04:34:33'),
       (85,'MINNIE','ZELLWEGER','2006-02-15 04:34:33'),
       (86,'GREG','CHAPLIN','2006-02-15 04:34:33'),
       (87,'SPENCER','PECK','2006-02-15 04:34:33'),
       (88,'KENNETH','PESCI','2006-02-15 04:34:33'),
       (89,'CHARLIZE','DENCH','2006-02-15 04:34:33'),
       (90,'SEAN','GUINESS','2006-02-15 04:34:33'),
       (91,'CHRISTOPHER','BERRY','2006-02-15 04:34:33'),
       (92,'KIRSTEN','AKROYD','2006-02-15 04:34:33'),
       (93,'ELLEN','PRESLEY','2006-02-15 04:34:33'),
       (94,'KENNETH','TORN','2006-02-15 04:34:33'),
       (95,'DARYL','WAHLBERG','2006-02-15 04:34:33'),
       (96,'GENE','WILLIS','2006-02-15 04:34:33'),
       (97,'MEG','HAWKE','2006-02-15 04:34:33'),
       (98,'CHRIS','BRIDGES','2006-02-15 04:34:33'),
       (99,'JIM','MOSTEL','2006-02-15 04:34:33'),
       (100,'SPENCER','DEPP','2006-02-15 04:34:33'),
       (101,'SUSAN','DAVIS','2006-02-15 04:34:33'),
       (102,'WALTER','TORN','2006-02-15 04:34:33'),
       (103,'MATTHEW','LEIGH','2006-02-15 04:34:33'),
       (104,'PENELOPE','CRONYN','2006-02-15 04:34:33'),
       (105,'SIDNEY','CROWE','2006-02-15 04:34:33'),
       (106,'GROUCHO','DUNST','2006-02-15 04:34:33'),
       (107,'GINA','DEGENERES','2006-02-15 04:34:33'),
       (108,'WARREN','NOLTE','2006-02-15 04:34:33'),
       (109,'SYLVESTER','DERN','2006-02-15 04:34:33'),
       (110,'SUSAN','DAVIS','2006-02-15 04:34:33'),
       (111,'CAMERON','ZELLWEGER','2006-02-15 04:34:33'),
       (112,'RUSSELL','BACALL','2006-02-15 04:34:33'),
       (113,'MORGAN','HOPKINS','2006-02-15 04:34:33'),
       (114,'MORGAN','MCDORMAND','2006-02-15 04:34:33'),
       (115,'HARRISON','BALE','2006-02-15 04:34:33'),
       (116,'DAN','STREEP','2006-02-15 04:34:33'),
       (117,'RENEE','TRACY','2006-02-15 04:34:33');
select * from actor;





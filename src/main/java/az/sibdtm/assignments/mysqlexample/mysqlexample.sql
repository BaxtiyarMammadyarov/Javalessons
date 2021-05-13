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
--  burda mysql de gelen hazir cedvelden  istifade etmisem cedveli doldurmaq ucun

insert into students (id ,name,surname,phone,email)
select
        actor_id-20
     ,first_name
     ,last_name
     ,concat('055',round(rand()*10000000)),concat(first_name,'_',last_name,'@gmail.com')
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




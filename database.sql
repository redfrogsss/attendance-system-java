UPDATE mysql.user
SET
    host = '%'
WHERE
    user = 'root';

-- DROP DATABASE sams;

-- CREATE DATABASE sams;
USE sams;

CREATE TABLE User (
    id int NOT NULL AUTO_INCREMENT,
    user_name varchar(100),
    email varchar(100) NOT NULL,
    pwd varchar(100) NOT NULL,
    user_role varchar(50),
    PRIMARY KEY (id)
);
CREATE TABLE Course (
    id int NOT NULL AUTO_INCREMENT,
    course_name varchar(100),
    course_code varchar(100),
    PRIMARY KEY (id)
);
CREATE TABLE Teach (
    id int NOT NULL AUTO_INCREMENT,
    teacher_id int NOT NULL,
    course_id int NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE Lesson (
    id int NOT NULL AUTO_INCREMENT,
    lesson_name varchar(100),
    course_id int NOT NULL,
    time_started varchar(50),
    time_ended varchar(50),
    lesson_date varchar(50),
    PRIMARY KEY (id)
);
CREATE TABLE Attendance (
    id int NOT NULL AUTO_INCREMENT,
    student_id int NOT NULL,
    lesson_id int NOT NULL,
    attendance_time varchar(50),
    attendance_date varchar(50),
    attendance_status varchar(50),
    PRIMARY KEY (id)
);

INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Cxxx Mx", "ccm@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Cxxxx Fxxx", "ccf@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Mxx Yxxx", "cmy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Txxx Lxx", "ctl@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Wxxx Hxx", "cwh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAN Yxxx Nx", "cyn@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHANG Wxx Cxxxx", "cwc@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHAU Yxx Hxx", "cyh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHENG Sxxxx", "cs@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHONG Cxxxx Mxx", "ccm@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHOU Cxxx Yx", "ccy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHU Sxxx Hxx", "csh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("CHUNG Wxxx Hxx", "cwh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("FAN Txx Kxx", "ftk@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("HEUNG Wxxx Kxx", "hwk@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("HUANG Jxxxxx", "hj@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("HUANG Yxxxxx", "hy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("HUI Wxxx Hxx", "hwh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("HUI Yxx Nxx", "hyn@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("KU Mx Kxx", "kmk@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("KWAN Cxxxx Mxx", "kcm@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("KWONG Hxx Yxx", "khy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LAI Cxxxx Mxx", "lcm@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LAM xx Hxx", "lh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LEE Kxxx Hxx", "lkh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LI Px Lxxx", "lpl@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LI Wxxxxxx", "lw@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LI Wx Hxxx", "lwh@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LIANG Yxx Sxx", "lys@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LIN Zxxxx", "lz@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("LIU Kxx Cxxx", "lkc@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("NG Hxxx Wxxx", "ngw@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("PUN Yxx Kxxx", "pyk@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("TAM Txx Hxx", "tth@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("TANG Wxxx Yxx", "twy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("WANG Yxxxxx", "wy@test.com", "testes", "student");
INSERT INTO User (user_name, email, pwd, user_role) value ("WONG Cxx Hxx", "wch@test.com", "testes", "student");


INSERT INTO User (user_name, email, pwd, user_role) value ("Liu", "liu@test.com", "testes", "teacher");
INSERT INTO User (user_name, email, pwd, user_role) value ("Yan", "yan@test.com", "testes", "teacher");
INSERT INTO User (user_name, email, pwd, user_role) value ("Pang", "pang@test.com", "testes", "teacher");

-- INSERT INTO Teacher (teacher_name, pwd) value ("Liu", "teacher");
-- INSERT INTO Teacher (teacher_name, pwd) value ("Yan", "teacher");
-- INSERT INTO Teacher (teacher_name, pwd) value ("Pang", "teacher");

INSERT INTO Course (course_code, course_name) value ("AST10201", "Computer Organization");
INSERT INTO Course (course_code, course_name) value ("AST10303", "Understanding the Network-Centric World");
INSERT INTO Course (course_code, course_name) value ("AST10106", "Introduction to Programming");

INSERT INTO Teach (teacher_id, course_id) value (38, 1);
INSERT INTO Teach (teacher_id, course_id) value (39, 2);
INSERT INTO Teach (teacher_id, course_id) value (40, 3);

INSERT INTO Lesson (lesson_name, course_id, time_started, time_ended, lesson_date) value ("Test Lesson", 1, "17:00", "18:00", "2021-05-14");
INSERT INTO Attendance (student_id, lesson_id, attendance_time, attendance_date, attendance_status) value (14, 1, "17:14", "2021-05-14", "Present");

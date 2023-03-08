create database Task1
create table workerTable(
	Worker_ID int not null primary key,
    First_Name varchar(30) not null,
    Last_Name varchar(30) not null,
    Salary int not null,
    Joining_Date varchar(20) not null,
    Department varchar(20) not null
);
insert into workerTable values (001,"Monika","Arora",100000,"2014-02-20 09:00:00","HR"),
(002,"Niharika","Verma",80000,"2014-02-20 09:00:00","Admin"),
(003,"Vishal","Singhal",300000,"2014-02-20 09:00:00","HR"),
(004,"Amitabh","Singh",500000,"2014-02-20 09:00:00","Admin"),
(005,"Vivek","Bhati",500000,"2014-02-20 09:00:00","Admin"),
(006,"Vipul","Diwan",200000,"2014-02-20 09:00:00","Account"),
(007,"Satish","Kumar",75000,"2014-02-20 09:00:00","Account"),
(008,"Geetika","Chouhan",90000,"2014-02-20 09:00:00","Admin");

-- Q-1. Write an SQL query to fetch “FIRST_NAME” from the Worker table using the alias name <WORKER_NAME>.
 select First_Name as Worker_Name from workerTable;
-- Q-2. Write an SQL query to find the position of the alphabet (‘a’) in the first name column ‘Amitabh’ from the Worker table.
select POSITION("a" IN First_Name ) As positionIs from workerTable where First_Name="Amitabh";
-- Q-3. Write an SQL query to print the FIRST_NAME from the Worker table after replacing ‘a’ with ‘A’.
select REPLACE(First_Name, 'A', 'a') as FirstName from workerTable where First_Name="Amitabh"; 
-- Q-4. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending.
select * from workerTable order by First_Name ;
-- Q-5. Write an SQL query to print all Worker details from the Worker table order by FIRST_NAME Ascending and DEPARTMENT Descending.
select First_Name, Department from workerTable order by First_Name  ,Department desc;
-- Q-6. Write an SQL query to print details for Workers with the first name as “Vipul” and “Satish” from the Worker table.
select * from workerTable where First_Name="Vipul" or First_Name="Satish";
-- Q-7. Write an SQL query to print details of Workers with DEPARTMENT name as “Admin”.
select * from workerTable where Department="Admin";
-- Q-8. Write an SQL query to print details of the Workers whose FIRST_NAME contains ‘a’.
select * from workerTable where First_Name like 'a%'; 
-- Task-2
-- Q-9. Write an SQL query to print details of the Workers whose SALARY lies between 100000 and 500000.
select * from workerTable where  Salary between 100000 and 500000;
-- Q-10. Write an SQL query to print details of the Workers whose FIRST_NAME ends with ‘h’ and contains six alphabets.
select * from workerTable where right(First_Name,1)='h' and length(First_Name)=6;
-- Q-11. Write an SQL query to print details of the Workers who have joined in Feb’2014.
select * from workerTable where Joining_Date like '2014-02%';
-- Q-12. Write an SQL query to fetch worker names with salaries >= 50000 and <= 100000.
select * from workerTable where Salary >= 50000 and  Salary<= 100000;


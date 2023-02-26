create database Employee
create table EmployeeDetails(
Employee_id int  primary key not null,
Emp_Name varchar(30) not null,
job_Name varchar(30) not null,
Manager_id int not null,
Hire_date date not null,
Salary int not null,
Dep_id int not null
);
USE Employee;

INSERT INTO EmployeeDetails (Employee_id,Emp_name, job_name, Manager_id, Hire_date, Salary, Dep_id)
VALUES
(1, 'Manikanta', 'Developer', 2, '2022-01-01', 50000, 1),
(2, 'satya', 'Manager', 2, '2001-06-11', 80000, 1),
(3, 'chandra', 'Web-Developer', 2, '2022-02-24', 55000, 2),
(4, 'Bobby', 'Excutivite-Manager', 2, '2003-06-24', 75000, 2),
(5, 'Charlie', 'Developer', 2, '2022-03-01', 60000, 1),
(6, 'Lee', 'FSD-Developer', 4, '2022-04-24', 65000, 3),
(7, 'Chandu', 'Manager', 4, '2020-02-14', 90000, 3),
(8, 'Mavieen', 'FrontEnd-Developer', 4, '2022-05-01', 70000, 1),
(9, 'Veera', 'Backend-Developer', 4, '2022-06-01', 75000, 2),
(10, 'Jagadish', 'Asur-Developer', 4, '2021-03-01', 85000, 2);
select Emp_Name,Salary from employeedetails;
select distinct  job_Name from employeedetails;
update employeedetails set Salary =900000 where Emp_Name="Manikanta";



drop database if exists quanlynhansu;
create database quanlynhansu;
use quanlynhansu;

drop table if exists Employee;
drop table if exists Department;

create table Department(
                           department_id int auto_increment primary key,
                           department_name varchar(255) not null unique,
                           description text,
                           status bit default(1)
);

create table Employee(
                         employee_id int auto_increment primary key,
                         full_names varchar(100) not null,
                         email varchar(100) not null unique,
                         phone_number varchar(20) not null unique,
                         avatar_url varchar(255),
                         status bit default(1),
                         created_at datetime default(current_timestamp()),
                         department_id int not null,
                         foreign key (department_id) references Department(department_id)
);

delimiter //

create procedure find_all_department()
begin
    select department_id, department_name, description, status from Department;
end //

create procedure find_department_by_id(p_id int)
begin
    select department_id, department_name, description, status from Department where department_id = p_id;
end //

create procedure find_department_by_name(p_d_name varchar(255))
begin
    select department_id, department_name, description, status from Department where department_name like concat('%', p_d_name, '%');
end //

create procedure find_department_by_page(p_page int)
begin
    declare offset_value int;
    set offset_value = (p_page - 1) * 5;
    select department_id, department_name, description, status from Department limit 5 offset offset_value;
end //

create procedure get_d_total_page(out total_page int)
begin
    declare count_page int;
    select count(department_id) count_page from Department;
    set total_page = (count_page / 5) + 1;
end //

create procedure add_department(
    p_d_name varchar(255),
    p_description text
)
begin
    insert into Department(department_name, description)
        values (p_d_name, p_description);
end //

create procedure update_department(
    p_d_id int,
    p_d_name varchar(255),
    p_description text,
    p_status bit
)
begin
    update Department
        set
            department_name = p_d_name,
            description = p_description,
            status = p_status
    where Department.department_id = p_d_id;
end //

create procedure delete_department(
    p_d_id int
)
begin
    delete from Department
        where department_id = p_d_id;
end //

create procedure unique_name(p_name varchar(255))
begin
    select count(department_id) from Department
        where department_name = p_name;
end //

delimiter ;

delimiter //

create procedure find_all_employee()
begin
    select employee_id, full_names, email, phone_number, avatar_url, status, created_at, department_id from Employee;
end //

create procedure find_page_employee(p_page int)
begin
    declare offset_value int;
    set offset_value = (p_page - 1) * 5;
    select employee_id, full_names, email, phone_number, avatar_url, status, created_at, department_id from Employee limit 5 offset offset_value;
end //

create procedure get_e_total_page(out total_page int)
begin
    declare count_page int;
    select count(employee_id) as count_page from Employee;
    set total_page = count_page / 5;
end //

create procedure include_employee(p_d_id int)
begin
    select count(department_id) from Employee
    where department_id = p_d_id;
end //

create procedure find_employee_by_id(p_id int)
begin
    select p_id from Employee where employee_id = p_id;
end //

create procedure find_employee_by_name(p_name varchar(255))
begin
    select employee_id, full_names, email, phone_number, avatar_url, status, created_at, department_id from Employee
        where full_names like concat('%', p_name, '%');
end //

create procedure add_employee(
    p_f_names varchar(100),
    p_email varchar(100),
    p_p_number varchar(20),
    p_a_url varchar(255),
    p_d_id int
)
begin
    insert into Employee(full_names, email, phone_number, avatar_url, department_id)
        values(p_f_names, p_email, p_p_number, p_a_url, p_d_id);
end //

create procedure update_employee(
    p_e_id int,
    p_f_names varchar(100),
    p_email varchar(100),
    p_p_number varchar(20),
    p_a_url varchar(255),
    p_d_id int,
    p_status bit
)
begin
    update Employee
        set
            full_names = p_f_names,
            email = p_email,
            phone_number = p_p_number,
            avatar_url = p_a_url,
            department_id = p_d_id,
            status = p_status
    where department_id = p_e_id;
end //

create procedure delete_employee(p_e_id int)
begin
    delete from Employee
        where employee_id = p_e_id;
end //
delimiter ;
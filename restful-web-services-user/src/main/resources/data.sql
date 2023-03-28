insert into user_details(id,birth_date,name)
values(10001, current_date(), 'Sach JPA');

insert into user_details(id,birth_date,name)
values(10002, current_date(), 'Ravi JPA');

insert into user_details(id,birth_date,name)
values(10003, current_date(), 'Akku JPA');

insert into post(id,description,user_id)
    values(20001,'Learn Spring', 10001);

insert into post(id,description,user_id)
values(20002,'Learn DevOps', 10001);

insert into post(id,description,user_id)
values(20003,'Get AWS Certified', 10002);

insert into post(id,description,user_id)
values(20004,'Learn Google Cloud', 10002);
-- <===--- DB FILLING ---===>

-- password: 1111
insert into usr (password, username, role, first_name, last_name)
values ('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'sadmin', 0, 'sadmin_f', 'sadmin_l');
insert into admin (user_id)
values ((select ident_current('usr')));

insert into user_departments(user_id, departments)
values ((select ident_current('usr')), 0);

insert into usr (password, username, role, first_name, last_name)
values ('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'doctor', 2, 'doctor_f', 'doctor_l');
insert into doctor (user_id, medical_institution)
values ((select ident_current('usr')), 'Institution of Perdaevo');

insert into user_departments(user_id, departments)
values ((select ident_current('usr')), 1),
       ((select ident_current('usr')), 2);

insert into usr (password, username, role, first_name, last_name)
values ('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'patient', 3, 'patient_f', 'patient_l');
insert into patient (user_id, doctor_user_id, date_of_birth)
values (3, 2, '2011-12-25');

insert into user_departments(user_id, departments)
values ((select ident_current('usr')), 1),
       ((select ident_current('usr')), 2);

insert into usr (password, username, role, first_name, last_name)
values ('$2a$10$sHgL69a1/nWRll0EJ8hzfeJaydLO/U6cgrdzgjyksS4HT71fMzBhu', 'admin', 1, 'admin_f', 'admin_l');
insert into admin (user_id)
values ((select ident_current('usr')));

insert into user_departments(user_id, departments)
values ((select ident_current('usr')), 1);
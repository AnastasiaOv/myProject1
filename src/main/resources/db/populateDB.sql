-- password
INSERT INTO users (id, name, email, password, surname, firstName, secondName)
VALUES
  (100000, 'User', 'user@yandex.ru', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni', 'user', 'user',
   NULL);
-- admin
INSERT INTO users (id, name, email, password, surname, firstName, secondName)
VALUES
  (100001, 'Admin', 'admin@gmail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju', 'admin', 'admin',
   'admin');

INSERT INTO user_roles (user_id, role) VALUES (100000, 'ROLE_USER');
INSERT INTO user_roles (user_id, role) VALUES (100001, 'ROLE_ADMIN');

INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 09:00:00', 'завтрак', 500, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 13:00:00', 'обед', 1000, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 00:00:00', 'ужин', 600, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 13:00:00', 'еще обед', 1300, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 14:00:00', 'еда админа', 2000, 100001);

INSERT INTO process (id, process_name, level, start_time, end_time, description)
VALUES (100019, 'proc_name', 2, '2015-01-06 14:00:00', NULL, 'desc');
INSERT INTO process (id, process_name, level, start_time, end_time, description)
VALUES (100020, 'proc_name2', 3, '2017-11-06 14:00:00', NULL, 'desc2');

INSERT INTO position_dict (id, name, department) VALUES (100021, 'название должности', 'департамент1');
INSERT INTO position_dict (id, name, department) VALUES (100022, 'название должности2', 'департамент2');

INSERT INTO position (id, user_id, process_id, rate_amount, is_owner, is_executor, is_responsible, position_id)
VALUES (100017, 100001, 100020, 0.2, TRUE, FALSE, FALSE, 100021);
INSERT INTO position (id, user_id, process_id, rate_amount, is_owner, is_executor, is_responsible, position_id)
VALUES (100018, 100001, 100019, 0.2, TRUE, TRUE, TRUE, 100022);

INSERT INTO rate (id, user_id, position_id, rate_amount) VALUES (100015, 100001, 100017, 0.5);
INSERT INTO rate (id, user_id, position_id, rate_amount) VALUES (100016, 100001, 100018, 0.3);






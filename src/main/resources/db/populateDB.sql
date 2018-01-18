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
INSERT INTO users (id, name, email, password, surname, firstName, secondName)
VALUES
  (10, 'Иванов', 'шмфтщм@mail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju', 'Иванов', 'Иван',
   'Иванович');


INSERT INTO user_roles (user_id, role) VALUES (100000, 'ROLE_USER');
INSERT INTO user_roles (user_id, role) VALUES (100001, 'ROLE_ADMIN');

INSERT INTO process (id, process_name, level, start_time, end_time, description)
VALUES (100019, 'тестовый процесс 2', 2, '2015-01-06 14:00:00', NULL, 'desc');
INSERT INTO process (id, process_name, level, start_time, end_time, description)
VALUES (100020, 'тестовый процесс 1', 3, '2017-11-06 14:00:00', NULL, 'desc2');
INSERT INTO process (id, process_name, level, start_time, end_time, description)
VALUES (9, 'тестовый процесс 3', 3, '2017-11-06 14:00:00', NULL, 'desc2');

INSERT INTO position_dict (id, name, department) VALUES (100021, 'руководитель', 'департамент1');
INSERT INTO position_dict (id, name, department) VALUES (100022, 'заместитель руководителя', 'департамент2');
INSERT INTO position_dict (id, name, department) VALUES (123, 'инспектор отдела кадров', 'департамент2');
INSERT INTO position_dict (id, name, department) VALUES (124, 'аналитик', 'департамент2');
INSERT INTO position_dict (id, name, department) VALUES (125, 'руководитель департамента', 'департамент2');


INSERT INTO rate (id, user_id, position_id, rate_amount, position_name) VALUES (12, 10, 124, 0.5, 'аналитик');
INSERT INTO rate (id, user_id, position_id, rate_amount, position_name) VALUES (13, 10, 125, 0.3, 'руководитель департамента');
INSERT INTO rate (id, user_id, position_id, rate_amount, position_name) VALUES (14, 100000, 123, 0.8, 'инспектор отдела кадров');
INSERT INTO rate (id, user_id, position_id, rate_amount, position_name) VALUES (16, 100001, 125, 0.7, 'руководитель');

INSERT INTO position (id, rate_id, process_id, is_owner, is_executor, is_responsible)
VALUES (100017, 14, 100019, TRUE, FALSE, FALSE);
INSERT INTO position (id, rate_id, process_id, is_owner, is_executor, is_responsible)
VALUES (100018, 16, 100020, TRUE, TRUE, TRUE);


INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 09:00:00', 'завтрак', 500, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 13:00:00', 'обед', 1000, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 00:00:00', 'ужин', 600, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-07 13:00:00', 'еще обед', 1300, 100000);
INSERT INTO meals (datetime, description, calories, user_id) VALUES ('2015-01-06 14:00:00', 'еда админа', 2000, 100001);

INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100023, 100019, 'rateName1', 'description1', 0.5, 0.7, 0.5, 1);
INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100024, 100019, 'rateName2', 'description2', 0.6, 0.7, 0.6, 1);
INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100025, 100019, 'rateName3', 'description3', 0.7, 0.7, 0.99, 1);
INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100026, 100020, 'rateName1', 'description1', 0.3, 0.7, 0.2, 1);
INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100027, 100020, 'rateName2', 'description2', 0.2, 0.7, 0.3, 1);
INSERT INTO criteria (id, process_id, name, description, value, target_value, weight, reduce_factor)
VALUES (100028, 100020, 'rateName3', 'description3', 0.1, 0.7, 0.8, 1);


INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (25, 'тестовый процесс 1', 'критерий 1', 0.7, 0.5);
INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (26, 'тестовый процесс 1', 'критерий 2', 0.87, 1);
INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (27, 'тестовый процесс 1', 'критерий 3', 0.456, 1);
INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (28, 'тестовый процесс 2', 'критерий 1', 0.35, 0.7);
INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (29, 'тестовый процесс 2', 'критерий 2', 0.56, 0.9);
INSERT INTO target_criteria (id, process_name, name, target_value, weight)
VALUES (30, 'тестовый процесс 2', 'критерий 3', 0.99, 1);
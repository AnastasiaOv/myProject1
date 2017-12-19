DROP TABLE users CASCADE;
DROP TABLE user_roles;
DROP TABLE meals;
DROP TABLE position_dict CASCADE;
DROP TABLE process CASCADE;
DROP TABLE position CASCADE;
DROP TABLE rate CASCADE;
DROP TABLE criteria CASCADE;
DROP SEQUENCE global_seq CASCADE;

*/
CREATE SEQUENCE global_seq;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR,
  email            VARCHAR   NOT NULL,
  password         VARCHAR   NOT NULL,
  surname          VARCHAR,
  firstName        VARCHAR,
  secondName       VARCHAR,
  registered       TIMESTAMP NOT NULL  DEFAULT now(),
  enabled          BOOL                DEFAULT TRUE,
  calories_per_day INTEGER   NOT NULL  DEFAULT 2000
);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER NOT NULL,
  datetime    TIMESTAMP,
  description TEXT,
  calories    INT,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE process (
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  process_name VARCHAR,
  level        INTEGER,
  start_time   TIMESTAMP,
  end_time     TIMESTAMP NULL,
  description  TEXT
);

CREATE TABLE position_dict (
  id         INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  department VARCHAR NOT NULL
);


CREATE TABLE rate (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id       INTEGER NOT NULL,
  position_id   INTEGER NOT NULL,
  rate_amount   DECIMAL NOT NULL,
  position_name VARCHAR,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (position_id) REFERENCES position_dict (id) ON DELETE CASCADE
);

CREATE TABLE position (
  id             INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('global_seq'),
  rate_id        INTEGER NOT NULL,
  process_id     INTEGER NOT NULL,
  is_owner       BOOLEAN,
  is_executor    BOOLEAN,
  is_responsible BOOLEAN,
  FOREIGN KEY (rate_id) REFERENCES rate (id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (process_id) REFERENCES process (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE criteria (
  id            INTEGER NOT NULL PRIMARY KEY DEFAULT nextval('global_seq'),
  process_id    INTEGER NOT NULL REFERENCES process (id) ON DELETE CASCADE ON UPDATE CASCADE,
  name          VARCHAR NOT NULL,
  description   VARCHAR,
  value         DECIMAL NOT NULL,
  target_value  DECIMAL NOT NULL,
  weight        DECIMAL NOT NULL,
  reduce_factor DECIMAL NOT NULL
)

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('marten@ya2do.io', 'user', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('admin@ya2do.io', 'secret', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('jdoe@does.net', 'unknown', 0);

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('marten@ya2do.io', 'USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('jdoe@does.net', 'USER');

INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('admin@ya2do.io', 'USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('admin@ya2do.io', 'ADMIN');
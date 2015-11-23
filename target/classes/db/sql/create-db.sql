CREATE TABLE users (
  id  CHAR(36) PRIMARY KEY,
  firstName VARCHAR(30),
  middleName VARCHAR(30),
  lastName VARCHAR(30),
  age INTEGER,
  gender CHAR(1),
  phone CHAR(10),
  zip  VARCHAR(10)
);

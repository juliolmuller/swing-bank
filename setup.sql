
-- PostgreSQL

DROP TABLE IF EXISTS customers;

CREATE TABLE customers(
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(150) NOT NULL,
  date_birth DATE NOT NULL,
  address VARCHAR,
  rg CHAR(9),
  cpf CHAR(11) NOT NULL
);

SELECT * FROM customers;


DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(100),
  rg VARCHAR(11),
  cpf CHAR(11) UNIQUE,
  address VARCHAR(200)
);

CREATE TABLE accounts (
  id SERIAL PRIMARY KEY,
  customer_cpf CHAR(11) REFERENCES customers(cpf),
  tpye VARCHAR(20),
  balance NUMERIC(12,2),
  max_limit NUMERIC(12,2),
  initial_depositl numeric(12,2),
  min_balance numeric(12,2),
  min_deposit numeric(12,2)
);

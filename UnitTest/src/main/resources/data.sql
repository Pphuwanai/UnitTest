DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  account_number VARCHAR(10) NOT NULL,
  citizen_id VARCHAR(13) DEFAULT NULL,
  amount_money INT
);
 
INSERT INTO customer (customer_id, name, account_number, citizen_id, amount_money) VALUES
  (1, 'Wick', '7190542388', '1720800125381', 500000);
  
INSERT INTO customer (customer_id, name, account_number, citizen_id, amount_money) VALUES
  (2, 'John', '7898885410', '1720800125999', 3000);
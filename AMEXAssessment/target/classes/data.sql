DROP TABLE IF EXISTS goods;

CREATE TABLE goods (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(30),
  price double
);


INSERT INTO goods (id, name, price) VALUES
 (1,"apple",0.6),
 (2, "orange",0.25);


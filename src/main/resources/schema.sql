drop table if exists colors;
CREATE TABLE colors (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(25)
);

drop table if exists brands;
CREATE TABLE brands (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(30)
);

drop table if exists products;
CREATE TABLE products (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  modified_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  brand_id int,
  color_id int,
  sku varchar(25) NOT NULL,
  title varchar(100) NOT NULL,
  description text,
  img_url varchar(255)
);

drop table if exists stock;
CREATE TABLE stock (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  product_id int,
  quantity int,
  price decimal(8,2)
);

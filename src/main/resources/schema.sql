drop table if exists product_groups;
CREATE TABLE product_groups (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL
);

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

drop table if exists price_intervals;
CREATE TABLE price_intervals (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(45),
  min_price decimal(8, 2),
  max_price decimal(8, 2)
);

drop table if exists products;
CREATE TABLE products (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  brand_id int,
    group_id int,
  code varchar(25) NOT NULL,
  name varchar(100) NOT NULL,
  short_description text,
  order_count int DEFAULT 0,
  FOREIGN KEY (brand_id) REFERENCES brands(id),
    FOREIGN KEY (group_id) REFERENCES product_groups(id)
);

drop table if exists product_variants;
CREATE TABLE product_variants (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  product_id int,
  color_id int,
  img_url varchar(255),
  full_price decimal(8, 2),
  monthly_price decimal(8, 2),
  default_variant boolean,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (color_id) REFERENCES colors(id)
);

drop table if exists stock;
CREATE TABLE stock (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  variant_id int,
  qty_in_stock int,
  FOREIGN KEY (variant_id) REFERENCES product_variants(id)
);

drop table if exists customers;
CREATE TABLE customers (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name varchar(75) NOT NULL,
  last_name varchar(75) NOT NULL,
  email varchar(100) NOT NULL,
  telephone varchar(50) NOT NULL
);

drop table if exists addresses;
CREATE TABLE addresses (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  customer_id int,
  address1 varchar(100) NOT NULL,
  address2 varchar(100) NOT NULL,
  city varchar(50) NOT NULL,
  country varchar(50) NOT NULL,
  default_address boolean,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
);

drop table if exists order_header;
CREATE TABLE order_header (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  order_no int NOT NULL,
  order_date timestamp NOT NULL,
  customer_id int,
  billing_address varchar(100) NOT NULL,
  shipping_address varchar(100) NOT NULL,
  total_amount decimal(8, 2) NOT NULL,
  status varchar(25) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
);

drop table if exists order_lines;
CREATE TABLE order_lines (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  header_id int,
  line_no int NOT NULL,
  variant_id int,
  quantity int NOT NULL,
  total_amount decimal(8, 2) NOT NULL,
  FOREIGN KEY (header_id) REFERENCES order_header(id),
  FOREIGN KEY (variant_id) REFERENCES product_variants(id)
);
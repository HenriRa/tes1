drop table if exists product_groups;
CREATE TABLE product_groups (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL
);

drop table if exists colors;
CREATE TABLE colors (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(30)
);

drop table if exists brands;
CREATE TABLE brands (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(30)
);

drop table if exists price_intervals;
CREATE TABLE price_intervals (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name varchar(50),
  min_price decimal(8, 2),
  max_price decimal(8, 2)
);


drop table if exists products;
CREATE TABLE products (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  brand_id int,
  group_id int,
  code varchar(30) NOT NULL,
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
  price_int_id int,
  default_variant boolean,
  FOREIGN KEY (product_id) REFERENCES products(id),
  FOREIGN KEY (color_id) REFERENCES colors(id),
  FOREIGN KEY (price_int_id) REFERENCES price_intervals(id)
);

drop table if exists stock;
CREATE TABLE stock (
  id int NOT NULL AUTO_INCREMENT,
  variant_id int NOT NULL,
  qty_in_stock int DEFAULT 0,
  PRIMARY KEY (id, variant_id),
  FOREIGN KEY (variant_id) REFERENCES product_variants(id)
);


drop table if exists customers;
CREATE TABLE customers (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name varchar(100) NOT NULL,
  last_name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  telephone varchar(50) NOT NULL
);

drop table if exists order_header;
CREATE TABLE order_header (
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  order_no int UNIQUE NOT NULL,
  order_date timestamp NOT NULL,
  customer_id int,
  total_amount decimal(8, 2) NOT NULL,
  order_status varchar(45) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
);

drop table if exists order_lines;
CREATE TABLE order_lines (
  line_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  header_id int NOT NULL,
  line_no int NOT NULL,
  variant_id int NOT NULL,
  quantity int NOT NULL,
  total_line_amount decimal(8, 2) NOT NULL,
  FOREIGN KEY (header_id) REFERENCES order_header(id),
  FOREIGN KEY (variant_id) REFERENCES product_variants(id)
);
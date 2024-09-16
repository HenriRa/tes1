INSERT INTO colors (id, name)
VALUES (1,'Black'), (2,'Blue'), (3,'White'), (4,'Green'), (5,'Purple'), (6,'Grey'), (7,'Yellow'),
(8,'Silver'), (9,'Pink'), (10,'Red'), (11,'Almond'), (12,'Lavender'), (13,'Orange');

INSERT INTO brands (id, name)
VALUES (1, 'Samsung'), (2, 'Xiaomi'), (3, 'Apple'), (4, 'POCO'), (5, 'Nokia'), (6, 'Sony'),
(7, 'Redmi'), (8, 'LG');

INSERT INTO price_intervals (id, name, min_price, max_price)
VALUES (1, 'price_monthly_0_10', 0.00, 10.00), (2, 'price_monthly_10_50', 10.00, 50.00),
(3, 'price_monthly_50_100', 50.00, 100.00),(4, 'price_monthly_100_150', 100.00, 150.00),
(5, 'price_monthly_150_200', 150.00, 200.00);

INSERT INTO products (id, brand_id, code, name, short_description, order_count)
VALUES (1, 1, 'G10SAM FL6 512 GR', 'Samsung Galaxy Flip6',
'A feature-packed Galaxy smartphone with a sleek design and a high-quality camera.', 0),
(2, 2, 'G10XIAO 14 UL 512 BL', 'Xiaomi 14 Ultra',
'A budget-friendly smartphone with a large display and a powerful camera.', 0),
(3, 3, 'G10IPHONE 15P 128 BL', 'Apple iPhone 15',
'The latest iPhone model with advanced features and a powerful processor.', 0);

INSERT INTO product_variants (id, product_id, color_id, img_url, full_price, monthly_price, default_variant)
VALUES (1, 1, 1, '/images/samsung_Galaxy_Flip6_black.png', 1149.00, 95.75, true),
(2, 1, 2, '/images/samsung_Galaxy_Flip6_blue.png', 1149.00, 95.75, false),
(3, 1, 3, '/images/samsung_Galaxy_Flip6_white.png', 1149.00, 95.75, false),
(4, 2, 1, '/images/xiaomi_14_Ultra_black.png', 659.00, 54.92, true),
(5, 2, 2, '/images/xiaomi_14_Ultra_blue.png', 659.00, 54.92, false),
(6, 2, 3, '/images/xiaomi_14_Ultra_white.png', 659.00, 54.92, false),
(7, 3, 9, '/images/apple_iPhone_15_pink.png', 1510.00, 125.83, true),
(8, 3, 10, '/images/apple_iPhone_15_red.png', 1510.00, 125.83, false);

INSERT INTO stock (id, variant_id, qty_in_stock)
VALUES (1, 1, 10), (2, 2, 5), (3, 3, 3), (4, 4, 15), (5, 5, 8), (6, 6, 0), (7, 7, 20), (8, 8, 10);


INSERT INTO customers (id, first_name, last_name, email, telephone)
VALUES
(1, 'John', 'Doe', 'john.doe@google.com', '123-456-7890'),
(2, 'Jane', 'Smith', 'jane.smith@yahoo.com', '234-567-8901'),
(3, 'Alice', 'Johnson', 'ajohnson@yahoo.com', '345-678-9012'),
(4, 'Bob', 'Brown', 'bob.brown@outlook.com', '456-789-0123'),
(5, 'Charlie', 'Davis', 'charlie.davis@gmail.com', '567-890-1234');

INSERT INTO addresses (id, customer_id, address1, address2, city, country, default_address)
VALUES
(1, 1, '123 Main St', 'Apt 4', 'Springfield', 'USA', true),
(2, 2, '456 Elm St', '', 'Shelbyville', 'USA', true),
(3, 3, '789 Oak St', 'Suite 12', 'Capital City', 'USA', true),
(4, 3, '1210 5th St', '', 'Washington DC', 'USA', false),
(5, 4, '101 Maple St', '', 'Ogdenville', 'USA', true),
(6, 5, '202 Pine St', 'Apt 8', 'North Haverbrook', 'USA', true),
(7, 5, '212 Deer Creek Pkwy', '', 'Belle Plaine', 'USA', false);

INSERT INTO order_header (id, order_no, order_date, customer_id, billing_address, shipping_address, total_amount, status)
VALUES
(1, 1001, '2023-10-01 10:00:00', 1, '123 Main St', '123 Main St', 200.00, 'Processing'),
(2, 1002, '2023-10-02 11:00:00', 2, '456 Elm St', '456 Elm St', 150.00, 'Shipped'),
(3, 1003, '2023-10-03 12:00:00', 3, '789 Oak St', '789 Oak St', 300.00, 'Delivered'),
(4, 1004, '2023-10-04 13:00:00', 4, '101 Maple St', '101 Maple St', 250.00, 'Cancelled'),
(5, 1005, '2023-10-05 14:00:00', 5, '202 Pine St', '202 Pine St', 100.00, 'Processing');

INSERT INTO order_lines (id, header_id, line_no, variant_id, quantity, total_amount)
VALUES
(1, 1, 1, 1, 1, 95.75),
(2, 1, 2, 2, 1, 95.75),
(3, 2, 1, 4, 1, 54.92),
(4, 2, 2, 5, 1, 54.92),
(5, 3, 1, 7, 1, 125.83),
(6, 3, 2, 8, 1, 125.83),
(7, 4, 1, 1, 1, 95.75),
(8, 5, 1, 3, 1, 95.75);



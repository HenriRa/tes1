INSERT INTO product_groups (id, name)
VALUES (1, 'Mobile phones'), (2, 'Accessories');

INSERT INTO colors (id, name)
VALUES (1,'Black'), (2,'Blue'), (3,'White'), (4,'Green'), (5,'Purple'), (6,'Gray'), (7,'Yellow'),
(8,'Silver'), (9,'Pink'), (10,'Red'), (11,'Almonds'), (12,'Lavender'), (13,'Orange');

INSERT INTO brands (id, name)
VALUES (1, 'Samsung'), (2, 'Xiaomi'), (3, 'Apple'), (4, 'POCO'), (5, 'Nokia'), (6, 'Sony'),
(7, 'LG'), (8, 'OnePlus');

INSERT INTO price_intervals (id, name, min_price, max_price)
VALUES (1, 'price_monthly_0_10', 0.00, 10.00), (2, 'price_monthly_10_50', 10.00, 50.00),
(3, 'price_monthly_50_100', 50.00, 100.00),(4, 'price_monthly_100_150', 100.00, 150.00),
(5, 'price_monthly_150_200', 150.00, 200.00);


INSERT INTO products (id, brand_id, group_id, code, name, short_description, order_count)
VALUES (1, 1, 1, 'TES1010SAMS S901', 'Samsung Galaxy S22',
'A feature-packed Galaxy smartphone with a sleek design and a high-quality camera.', 46),
(2, 2, 1, 'TES1010XIAO 14', 'Xiaomi 14',
'A mid-range smartphone with a large display and a powerful camera.', 27),
(3, 3, 1, 'TES1010IPHONE 14', 'Apple iPhone 14',
'The latest iPhone model with advanced features, a powerful processor and exceptional performance.', 93),
(4, 4, 1, 'TES1010POCO X6', 'Xiaomi POCO X6',
'A budget-friendly smartphone with a large-capacity battery and a high-resolution display.', 18),
(5, 5, 1, 'TES1010NOK 8210', 'Nokia 8210',
'A classic durable and simple phone with long battery life, big display and an in-built camera.', 8),
(6, 6, 1, 'TES1010SONY XPERIA 10V', 'Sony Xperia 10 V',
'A premium smartphone built for everyday use with a 4K display and a high-quality camera.', 2),
(7, 2, 1, 'TES1010REDMI NOTE 13 ', 'Xiaomi Redmi Note 13',
'A budget-friendly smartphone with a large display and a powerful camera.', 33),
(8, 8, 1, 'TES1010ONEPLUS NORD 3', 'OnePlus Nord 3',
'An exceptional smartphone that features a simple, understated design and some powerful characteristics.', 7),
(9, 1, 1, 'TES1010SAMS S23', 'Samsung Galaxy S23',
'A new generation AI-powered smartphone with a sleek design, ultra-fast processor and a high-quality camera.', 121);

INSERT INTO product_variants (id, product_id, color_id, img_url, full_price, monthly_price, price_int_id, default_variant)
VALUES
(1, 1, 1, '/images/samsung-galaxy-s22-black.png', 459.00, 19.13, 2, false),
(2, 1, 5, '/images/samsung-galaxy-s22-purple.png', 459.00, 19.13, 2, true),
(3, 1, 3, '/images/samsung-galaxy-s22-white.png', 459.00, 19.13, 2, false),
(4, 1, 4, '/images/samsung-galaxy-s22-green.png', 459.00, 19.13, 2, false),
(5, 1, 9, '/images/samsung-galaxy-s22-pink.png', 459.00, 19.13, 2, false),
(6, 2, 1, '/images/xiaomi-14-black.png', 689.00, 24.92, 2, true),
(7, 2, 4, '/images/xiaomi-14-green.png', 689.00, 24.92, 2, false),
(8, 2, 3, '/images/xiaomi-14-white.png', 689.00, 24.92, 2, false),
(9, 3, 5, '/images/apple-iphone-14-purple.png', 735.00, 60.70, 3, false),
(10, 3, 10, '/images/apple-iphone-14-red.png', 735.00, 60.70, 3, true),
(11, 3, 7, '/images/apple-iphone-14-yellow.png', 735.00, 60.70, 3, false),
(12, 3, 2, '/images/apple-iphone-14-blue.png', 735.00, 60.70, 3, false),
(13, 3, 3, '/images/apple-iphone-14-white.png', 735.00, 60.70, 3, false),
(14, 3, 1, '/images/apple-iphone-14-black.png', 735.00, 60.70, 3, false),
(15, 4, 2, '/images/poco-x6-blue.png', 279.00, 11.65, 2, true),
(16, 4, 3, '/images/poco-x6-white.png', 279.00, 11.65, 2, false),
(17, 4, 1, '/images/poco-x6-black.png', 279.00, 11.65, 2, false),
(18, 5, 2, '/images/nokia-8210-blue.png', 79.00, 5.75, 1, true),
(19, 6, 12, '/images/sony-xperia-10v-lavender.png', 329.00, 43.71, 2, false),
(20, 6, 3, '/images/sony-xperia-10v-white.png', 329.00, 43.71, 2, true),
(21, 6, 4, '/images/sony-xperia-10v-green.png', 329.00, 43.71, 2, false),
(22, 6, 1, '/images/sony-xperia-10v-black.png', 329.00, 43.71, 2, false),
(23, 7, 1, '/images/xiaomi-redmi-note-13-black.png', 199.00, 33.95, 2, false),
(24, 7, 4, '/images/xiaomi-redmi-note-13-green.png', 199.00, 33.95, 2, true),
(25, 7, 2, '/images/xiaomi-redmi-note-13-blue.png', 199.00, 33.95, 2, false),
(26, 8, 6, '/images/oneplus-nord3-gray.png', 366.40, 22.43, 2, true),
(27, 8, 4, '/images/oneplus-nord3-green.png', 366.40, 22.43, 2, false),
(28, 9, 12, '/images/samsung-galaxy-s23-lavender.png', 1100.00, 135.25, 4, false),
(29, 9, 1, '/images/samsung-galaxy-s23-black.png', 1100.00, 135.25, 4, false),
(30, 9, 4, '/images/samsung-galaxy-s23-green.png', 1100.00, 135.25, 4, false),
(31, 9, 11, '/images/samsung-galaxy-s23-almonds.png', 1100.00, 135.25, 4, true);


INSERT INTO stock (id, variant_id, qty_in_stock)
VALUES (1, 1, 10), (2, 2, 5), (3, 3, 0), (4, 4, 15), (5, 5, 8), (6, 6, 0), (7, 7, 20), (8, 8, 10),
(9, 9, 5), (10, 10, 10), (11, 11, 0), (12, 12, 8), (13, 13, 0), (14, 14, 20), (15, 15, 10),
(16, 16, 5), (17, 17, 1), (18, 18, 15), (19, 19, 8), (20, 20, 0), (21, 21, 20), (22, 22, 8),
(23, 23, 5), (24, 24, 120), (25, 25, 2), (26, 26, 15), (27, 27, 23), (28, 28, 54), (29, 29, 12),
(30, 30, 0), (31, 31, 9);


INSERT INTO customers (id, first_name, last_name, email, telephone)
VALUES
(1, 'John', 'Doe', 'john.doe@google.com', '123-456-7890'),
(2, 'Jane', 'Smith', 'jane.smith@yahoo.com', '234-567-8901'),
(3, 'Alice', 'Johnson', 'ajohnson@yahoo.com', '345-678-9012'),
(4, 'Bob', 'Brown', 'bob.brown@outlook.com', '456-789-0123'),
(5, 'Charlie', 'Davis', 'charlie.davis@gmail.com', '567-890-1234');

INSERT INTO order_header (id, order_no, order_date, customer_id, total_amount, order_status)
VALUES
(1, 1001, '2023-10-01 10:00:00', 1, 200.00, 'Processing'),
(2, 1002, '2023-10-02 11:00:00', 2, 150.00, 'Shipped'),
(3, 1003, '2023-10-03 12:00:00', 3, 300.00, 'Delivered'),
(4, 1004, '2023-10-04 13:00:00', 4, 250.00, 'Cancelled'),
(5, 1005, '2023-10-05 14:00:00', 5, 100.00, 'Processing');

INSERT INTO order_lines (line_id, header_id, line_no, variant_id, quantity, total_line_amount)
VALUES
(1, 1, 1, 1, 1, 95.75),
(2, 1, 2, 2, 1, 95.75),
(3, 2, 1, 4, 1, 54.92),
(4, 2, 2, 5, 1, 54.92),
(5, 3, 1, 7, 1, 125.83),
(6, 3, 2, 8, 1, 125.83),
(7, 4, 1, 1, 1, 95.75),
(8, 5, 1, 3, 1, 95.75);



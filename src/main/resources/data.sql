INSERT INTO colors (id, name)
VALUES (1,'Black'), (2,'Blue'), (3,'White'), (4,'Green'), (5,'Purple'), (6,'Grey'), (7,'Yellow'),
(8,'Silver'), (9,'Pink'), (10,'Red'), (11,'Almond'), (12,'Lavender'), (13,'Orange');

INSERT INTO brands (id, name)
VALUES (1, 'Samsung'), (2,  'Xiaomi'), (3, 'Apple'), (4, 'POCO'), (5, 'Nokia'), (6, 'Sony'),
(7, 'Redmi'), (8, 'LG');

INSERT INTO products (id, created_on, modified_on, brand_id, color_id, sku, title, description, img_url)
VALUES (1, now(), now(), 1, 4, 'G10SAM FL6 512 GR', 'Samsung Galaxy Flip6',
'A feature-packed Galaxy smartphone with a sleek design and a high-quality camera.',
'/images/samsung_Galaxy_S23_FE.png'),
(2, now(), now(), 2, 1, 'G10XIAO 14 UL 512 BL', 'Xiaomi 14 Ultra',
'A budget-friendly smartphone with a large display and a powerful camera.',
'/images/xiaomi_Redmi_Note_13.png'),
(3, now(), now(), 3, 9, 'G10IPHONE 15P 128 BL', 'Apple iPhone 15',
'The latest iPhone model with advanced features and a powerful processor.',
'/images/apple_iPhone_15_pink.png');

INSERT INTO stock (id, product_id, quantity, price)
VALUES (1, 1, 5, 1149.00),
(2, 2, 0, 659.00),
(3, 3, 10, 1510.00);



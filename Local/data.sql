CREATE TABLE users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(100) NOT NULL,
  price DECIMAL(10, 2),
  stock INT DEFAULT 0
);

CREATE TABLE orders (
  order_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  product_id INT,
  quantity INT,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
);

INSERT INTO users (username, email) VALUES
('john_doe', 'john@email.com'),
('jane_smith', 'jane@email.com'),
('mike_wilson', 'mike@email.com');

INSERT INTO products (product_name, price, stock) VALUES
('Laptop', 999.99, 15),
('Mouse', 29.99, 50),
('Keyboard', 79.99, 30),
('Monitor', 299.99, 10);

INSERT INTO orders (user_id, product_id, quantity) VALUES
(1, 1, 1),
(2, 2, 2),
(1, 3, 1),
(3, 4, 1),
(2, 1, 1);

SELECT * FROM users;

SELECT product_name, price FROM products WHERE price > 100;

SELECT users.username, products.product_name, orders.quantity
FROM orders
JOIN users ON orders.user_id = users.user_id
JOIN products ON orders.product_id = products.product_id;

SELECT product_id, SUM(quantity) AS total_sold
FROM orders
GROUP BY product_id;

SELECT users.username, COUNT(orders.order_id) AS order_count
FROM users
LEFT JOIN orders ON users.user_id = orders.user_id
GROUP BY users.user_id, users.username;

UPDATE products SET stock = 20 WHERE product_id = 1;

DELETE FROM orders WHERE order_id = 5;

SELECT * FROM products ORDER BY price DESC LIMIT 3;

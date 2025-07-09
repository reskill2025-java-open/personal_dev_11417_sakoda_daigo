-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS cart;

-- ユーザーテーブル
CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   name TEXT,
   password TEXT,
   email TEXT,
   address TEXT,
   status INTEGER
);

-- 商品テーブル
CREATE TABLE drink(
   drink_id SERIAL PRIMARY KEY,
   drink_name TEXT,
   price INTEGER,
   category_id INTEGER,
   amount INTEGER,
   factory TEXT
);

-- カテゴリーテーブル
CREATE TABLE category(
   category_id SERIAL PRIMARY KEY,
   category_name TEXT
);

-- 注文テーブル
CREATE TABLE cart
(
   cart_id SERIAL PRIMARY KEY,
   id INTEGER,
   quantity INTEGER,
   total_price INTEGER
   
);
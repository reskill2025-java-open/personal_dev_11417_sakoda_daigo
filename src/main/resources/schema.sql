-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS drink;
DROP TABLE IF EXISTS category;

-- ユーザーテーブル
CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   name TEXT,
   password TEXT,
   email TEXT,
   address TEXT,
   age INTEGER,
   status INTEGER
);

-- 商品テーブル
CREATE TABLE drink(
   drink_id SERIAL PRIMARY KEY,
   drink_name TEXT,
   price INTEGER,
   category_id INTEGER,
   amount INTEGER,
   factory TEXT,
   img TEXT
);

-- カテゴリーテーブル
CREATE TABLE category(
   category_id SERIAL PRIMARY KEY,
   category_name TEXT
);

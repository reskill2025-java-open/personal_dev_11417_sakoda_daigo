-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS premiere;
DROP TABLE IF EXISTS drink;

-- ユーザーテーブル
CREATE TABLE users(
   user_id SERIAL PRIMARY KEY,
   user_name TEXT,
   password TEXT,
   email TEXT,
   address TEXT
);

-- プレミアテーブル
CREATE TABLE premiere(
   premiere_id SERIAL PRIMARY KEY,
   premiere_name TEXT,
   password TEXT,
   email TEXT,
   address TEXT
);

-- 商品テーブル
CREATE TABLE drink(
   drink_id SERIAL PRIMARY KEY,
   drink_name TEXT,
   price INTEGER,
   category TEXT,
   amount INTEGER,
   factory TEXT
);
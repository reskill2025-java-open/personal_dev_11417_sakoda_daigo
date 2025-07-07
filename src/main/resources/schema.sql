-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS drink;

-- ユーザーテーブル
CREATE TABLE users(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   user_name TEXT,
   password TEXT,
   email TEXT,
   address TEXT,
   status INTEGER
);

-- 商品テーブル
CREATE TABLE drink(
   id SERIAL PRIMARY KEY,
   drink_id INTEGER,
   drink_name TEXT,
   price INTEGER,
   category TEXT,
   amount INTEGER,
   factory TEXT
);
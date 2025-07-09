-- ユーザーテーブルデータ
INSERT INTO users(name, password, email, address, status) VALUES('周東佑京', 'himitu', 'syutou210@aaa', '福岡県福岡市中央区地行浜2-2-2', 1);
INSERT INTO users(name, password, email, address, status) VALUES('柳田悠岐', 'himitu', 'gita1009@aaa', '福岡県福岡市中央区地行浜2-2-2', 2);


-- 商品テーブルデータ
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('厳選静岡茶', 250, 1, 650, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('BASS', 120, 2, 500, 'SONTORY');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('いろばす', 100, 3, 500, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('クラフトコーラ', 120, 4, 350, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('エベレストの水', 200, 3, 1000, 'ネパール株式会社');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('おいしいお茶', 120, 1, 600, 'イ・トウエン');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('ポカエリアス', 130, 4, 550, 'コ・カコーラ');
INSERT INTO drink(drink_name, price, category_id, amount, factory) VALUES('GEORGEAN', 150, 2, 300, 'コ・カコーラ');

-- カテゴリーテーブルデータ
INSERT INTO category(category_name) VALUES('お茶');
INSERT INTO category(category_name) VALUES('コーヒー');
INSERT INTO category(category_name) VALUES('水');
INSERT INTO category(category_name) VALUES('清涼飲料水');


-- ユーザーテーブルデータ
INSERT INTO users(name, password, email, address, age,	status) VALUES('周東佑京', 'himitu', 'syutou210@aaa', '福岡県福岡市中央区地行浜2-2-2', 29,1);
INSERT INTO users(name, password, email, address, age, status) VALUES('柳田悠岐', 'himitu', 'gita1009@aaa', '福岡県福岡市中央区地行浜2-2-2', 36, 2);
INSERT INTO users(name, password, email, address, age, status) VALUES('石垣元気', 'himitu', 'gaki816@aaa', '群馬県高崎市中大類町531', 17, 1);
INSERT INTO users(name, password, email, address, age, status) VALUES('周東希虎', 'himitu', 'sudou226@aaa', '神奈川県川崎市麻生区栗木3-12-1', 15, 2);


-- 商品テーブルデータ
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('厳選静岡茶', 250, 1, 650, 'イ・トウエン', 'drink_tea_tokuho.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('BASS', 120, 2, 500, 'SONTORY', 'drink_petbottle_coffee.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('いろばす', 100, 3, 500, 'コ・カコーラ', 'drink_petbottle_tsumetai.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('ハイパードライ', 300, 5, 500, 'アーサヒ' , 'drink_beer_can_long.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('クラフトコーラ', 120, 4, 350, 'コ・カコーラ', 'drink_cola_petbottle.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('エベレストの水', 200, 3, 1000, 'ネパール株式会社', 'science_junsui.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('おいしいお茶', 120, 1, 600, 'イ・トウエン' , 'petbottle_tea.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('ポカエリアス', 130, 4, 550, 'コ・カコーラ' , 'petbottle_sports.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('GEORGEAN', 150, 2, 300, 'コ・カコーラ', 'coffee_chilled_cup.png');
INSERT INTO drink(drink_name, price, category_id, amount, factory, img) VALUES('水結', 250, 5, 350, 'キリソ', 'drink_chu-hi.png');




-- カテゴリーテーブルデータ
INSERT INTO category(category_name) VALUES('お茶');
INSERT INTO category(category_name) VALUES('コーヒー');
INSERT INTO category(category_name) VALUES('水');
INSERT INTO category(category_name) VALUES('清涼飲料水');
INSERT INTO category(category_name) VALUES('お酒');



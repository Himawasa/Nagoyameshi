-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '侍 太郎', 'サムライ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '侍 花子', 'サムライ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.samurai@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '侍 義勝', 'サムライ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '侍 幸美', 'サムライ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '侍 雅', 'サムライ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '侍 正保', 'サムライ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '侍 真由美', 'サムライ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '侍 安民', 'サムライ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '侍 章緒', 'サムライ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '侍 祐子', 'サムライ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (11, '侍 秋美', 'サムライ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.samurai@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (12, '侍 信平', 'サムライ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.samurai@example.com', 'password', 1, false);

-- shopsテーブルへのデータ挿入
INSERT IGNORE INTO shops (id, category_id, name, image, description, business_hours, price, postal_code, address, phone_number, regular_holiday) VALUES
(1, 1, 'SAMURAIの宿', 'house01.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '9:00-18:00', 6000, '073-0145', '北海道砂川市西五条南X-XX-XX', '012-345-678', '日曜'),
(2, 2, 'ペンション SAMURAI', 'house02.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '10:00-19:00', 7000, '030-0945', '青森県青森市桜川X-XX-XX', '012-345-678', '月曜'),
(3, 3, 'SAMURAI荘', 'house03.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '8:00-20:00', 8000, '029-5618', '岩手県和賀郡西和賀町沢内両沢X-XX-XX', '012-345-678', '火曜'),
(4, 1, 'ゲストハウス SAMURAI', 'house04.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '9:30-17:30', 9000, '989-0555', '宮城県刈田郡七ヶ宿町滝ノ上X-XX-XX', '012-345-678', '水曜'),
(5, 2, 'SAMURAI屋', 'house05.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '10:00-18:00', 10000, '018-2661', '秋田県山本郡八峰町八森浜田X-XX-XX', '012-345-678', '木曜'),
(6, 3, '民宿 SAMURAI', 'house06.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '8:00-19:00', 6000, '999-6708', '山形県酒田市泉興野X-XX-XX', '012-345-678', '金曜'),
(7, 1, 'SAMURAIハイツ', 'house07.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '9:00-18:00', 7000, '969-5147', '福島県会津若松市大戸町芦牧X-XX-XX', '012-345-678', '土曜'),
(8, 2, 'メゾンSAMURAI', 'house08.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '10:00-20:00', 8000, '310-0021', '茨城県水戸市南町X-XX-XX', '012-345-678', '祝日'),
(9, 3, 'SAMURAIマンション', 'house09.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '9:00-17:00', 9000, '323-1101', '栃木県下都賀郡藤岡町大前X-XX-XX', '012-345-678', 'なし'),
(10, 1, 'コーポSAMURAI', 'house10.jpg', '最寄り駅から徒歩10分。自然豊かで閑静な場所にあります。長期滞在も可能です。', '10:00-18:00', 10000, '370-0806', '群馬県高崎市上和田町X-XX-XX', '012-345-678', '日曜');

INSERT IGNORE INTO categories (id, name) VALUES
(1, '和食'),
(2, '洋食'),
(3, '中華'),
(4, 'カフェ'),
(5, 'スイーツ');
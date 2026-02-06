-- Tạo bảng sinh viên (giống cấu trúc Entity Lab 2)
CREATE TABLE IF NOT EXISTS students (
 id INTEGER PRIMARY KEY,
 name TEXT,
 email TEXT,
 age INTEGER
);
-- Thêm dữ liệu mẫu
INSERT INTO students (id, name, email, age) VALUES (1, 'Nguyen Van A', 'vana@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (2, 'Tran Thi B', 'thib@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (3, 'Le Van C', 'vanc@example.com', 22);
INSERT INTO students (id, name, email, age) VALUES (4, 'Pham Quang D', 'quangd@example.com', 19);
INSERT INTO students (id, name, email, age) VALUES (5, 'Hoang Thi E', 'thie@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (6, 'Do Minh F', 'minhf@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (7, 'Vo Thanh G', 'thanhg@example.com', 22);
INSERT INTO students (id, name, email, age) VALUES (8, 'Phan Ngoc H', 'ngoch@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (9, 'Bui Kim I', 'kimi@example.com', 19);
INSERT INTO students (id, name, email, age) VALUES (10, 'Dang Van J', 'vanj@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (11, 'Nguyen Hoang K', 'hoangk@example.com', 22);
INSERT INTO students (id, name, email, age) VALUES (12, 'Ly My L', 'myl@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (13, NULL, 'nhi.tranduongkhiet@gamil.com', 21);
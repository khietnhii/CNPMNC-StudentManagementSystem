-- Tạo bảng sinh viên (giống cấu trúc Entity Lab 2)
CREATE TABLE IF NOT EXISTS students (
 id INTEGER PRIMARY KEY,
 name TEXT,
 email TEXT,
 age INTEGER
);

-- Thêm dữ liệu mẫu
INSERT INTO students (id, name, email, age) VALUES (1, 'Nguyễn Văn A', 'vana@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (2, 'Trần Thị B', 'thib@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (3, 'Lê Văn C', 'vanc@example.com', 18);
INSERT INTO students (id, name, email, age) VALUES (4, 'Phạm Quang D', 'quangd@example.com', 19);
INSERT INTO students (id, name, email, age) VALUES (5, 'Hoàng Thị E', 'thie@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (6, 'Đỗ Minh F', 'minhf@example.com', 17);
INSERT INTO students (id, name, email, age) VALUES (7, 'Võ Thanh G', 'thanhg@example.com', 22);
INSERT INTO students (id, name, email, age) VALUES (8, 'Phan Ngọc H', 'ngoch@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (9, 'Bùi Kim I', 'kimi@example.com', 19);
INSERT INTO students (id, name, email, age) VALUES (10, 'Đặng Văn J', 'vanj@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (11, 'Nguyễn Hoàng K', 'hoangk@example.com', 22);
INSERT INTO students (id, name, email, age) VALUES (12, 'Lý Mỹ L', 'myl@example.com', 20);
INSERT INTO students (id, name, email, age) VALUES (13, 'Trần Nhi', 'nhi.tran@example.com', 21);
INSERT INTO students (id, name, email, age) VALUES (14, 'Hà Nhi', 'nhiha@example.com', 17),
												   (15, 'Đào Thị J', 'jthi.dao@exmp.com', 18),
												   (16, 'Lương Ngọc V', 'vil@example.com', 15);
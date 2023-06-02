INSERT INTO worker(name, level, salary, birthday) VALUES
	('Adel', 'Junior', 1000, '2003-01-01'),
	('Bell', 'Middle', 1700, '2000-05-10'),
	('Eren', 'Middle', 1500, '2002-08-05'),
	('Obi', 'Trainee', 800, '2001-10-13'),
	('Mariia', 'Trainee', 800, '2005-08-04'),
	('Bakugo', 'Middle', 1700, '2001-07-18'),
	('Rihanna', 'Middle', 2000, '1998-12-01'),
	('Hak', 'Senior', 3000, '1992-05-05'),
	('Leo', 'Senior', 3000, '1989-01-01'),
	('Riuu', 'Junior', 1000, '2002-03-27');

INSERT INTO client(name) VALUES
	('Mikasa'),
	('Levi'),
	('Shoto'),
	('Gon'),
	('Killua'),
	('Izuku'),
	('Armin');

INSERT INTO project(client_id,start_date, finish_date, name) VALUES
	(1, '2023-01-01', '2023-12-01', 'Project A'),
	(1, '2016-07-10', '2023-07-10', 'Project B'),
	(2, '2020-01-01', '2023-08-05', 'Project C'),
	(4, '2019-11-01', '2023-10-13', 'Project D'),
	(5, '2023-02-01', '2023-08-04', 'Project E'),
	(5, '2022-12-01', '2023-07-18', 'Project F'),
	(6, '2018-04-18', '2023-12-01', 'Project G'),
	(6, '2022-04-30', '2023-05-30', 'Project H'),
	(6, '2023-01-10', '2023-10-01', 'Project I'),
	(7, '2022-04-04', '2023-06-06', 'Project L');

INSERT INTO project_worker(worker_id, project_id) VALUES
	(21, 1),
	(15, 3),
	(21, 2),
	(16, 3),
	(12, 3),
	(14, 4),
	(13, 5),
	(15, 5),
	(20, 6),
	(17, 7),
	(12, 8),
	(14, 9),
	(18, 9),
	(15, 9),
	(20, 10),
	(19, 10);
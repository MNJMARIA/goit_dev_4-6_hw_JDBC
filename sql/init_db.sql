CREATE TABLE IF NOT EXISTS worker(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(1000) NOT NULL,
	birthday DATE CHECK(YEAR(birthday)>1900),
	level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
	salary INT CHECK(salary>=100 AND salary<=100000)
);

CREATE TABLE IF NOT EXISTS client(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(1000) NOT NULL CHECK(LENGTH(name)>=2 AND LENGTH(name)<=1000)
);

CREATE TABLE IF NOT EXISTS project(
	id INT PRIMARY KEY AUTO_INCREMENT,
	start_date DATE NOT NULL,
	finish_date DATE NOT NULL,
    client_id BIGINT NOT NULL,
    name VARCHAR(1000)
);

ALTER TABLE project 
ADD CONSTRAINT client_id_fk 
FOREIGN KEY(client_id) 
REFERENCES client(id);

CREATE TABLE IF NOT EXISTS project_worker(
	project_id BIGINT NOT NULL,
	worker_id BIGINT NOT NULL,
	PRIMARY KEY (worker_id, project_id),
	FOREIGN KEY (worker_id) REFERENCES worker (id),
	FOREIGN KEY (project_id) REFERENCES project (id)
);


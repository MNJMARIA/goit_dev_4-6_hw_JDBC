--Завдання №4 - знайти клієнта з найбільшою кількістю проєктів
SELECT client.name, COUNT(project.id) AS PROJECT_COUNT
FROM client
JOIN project ON client.id = project.client_id
GROUP BY client.id
-- Фільтруємо результати, залишаючи лише тих клієнтів, у яких кількість проєктів дорівнює найбільшій кількості проєктів
HAVING COUNT(project.id) = (
        -- Вибираємо максимальну кількість проєктів серед усіх клієнтів
	SELECT MAX(project_count)
	FROM (
                -- Обчислюємо кількість проєктів для кожного клієнта
		SELECT COUNT(id) AS project_count
		FROM project
		GROUP BY client_id
        -- AS counts дозволяє звертатися до результату підзапиту за допомогою counts.
	) AS counts
);
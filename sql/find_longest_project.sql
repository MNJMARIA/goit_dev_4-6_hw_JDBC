--Завдання №5 - знайти проєкт з найбільшою тривалістю
SELECT project.name, TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count
FROM project
WHERE TIMESTAMPDIFF(MONTH, start_date, finish_date) = (
     SELECT MAX(month_count) 
     FROM (
            SELECT project.name, TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count
            FROM project
     )
);
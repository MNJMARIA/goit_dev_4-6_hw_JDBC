--Завдання №7 - вивести вартість кожного проєкту
SELECT project.name, SUM(worker.salary * TIMESTAMPDIFF(MONTH, start_date, finish_date)) AS project_cost
FROM project
JOIN project_worker ON project.id = project_worker.project_id
JOIN worker ON worker.id = project_worker.worker_id
GROUP BY project.id
ORDER BY project_cost DESC;


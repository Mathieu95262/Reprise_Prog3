/*Afficher l’id, first_name, last_name des employés qui n’ont jamais pris de congé de leur vie.*/
SELECT e.id, e.first_name, e.last_name
FROM Employee e
LEFT JOIN take t ON e.id = t.employee_id
WHERE t.leave_id IS NULL;

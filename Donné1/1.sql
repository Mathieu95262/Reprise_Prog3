/*Afficher l’id, first_name, last_name des employés qui n’ont pas d’équipe.*/

SELECT e.id, e.first_name, e.last_name
FROM Employee e
LEFT JOIN Team t ON e.id = t.employee_id
WHERE t.id IS NULL;

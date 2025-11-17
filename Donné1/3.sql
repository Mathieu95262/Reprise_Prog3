/*Afficher les congés de tel sorte qu’on voie l’id du congé, le début du congé, la fin du congé, le nom & prénom de l’employé qui prend congé et le nom de son équipe.*/
SELECT l.id AS leave_id, l.start_date, l.end_date,
       e.first_name, e.last_name,
       tm.name AS team_name
FROM leave l
JOIN take t ON l.id = t.leave_id
JOIN employee e ON t.employee_id = e.id
LEFT JOIN belong b ON e.id = b.employee_id
LEFT JOIN team tm ON b.team_id = tm.id;

/*Afficher l’id, le nom, le prénom de tous les employés + le nom de leur équipe qui sont en congé aujourd’hui. Pour rappel, la end_date est incluse dans le congé, l’employé ne revient que le lendemain. */
SELECT e.id, e.first_name, e.last_name, tm.name AS team_name
FROM employee e
JOIN take t ON e.id = t.employee_id
JOIN leave l ON t.leave_id = l.id
LEFT JOIN belong b ON e.id = b.employee_id
LEFT JOIN team tm ON b.team_id = tm.id
WHERE CURRENT_DATE BETWEEN l.start_date AND l.end_date;

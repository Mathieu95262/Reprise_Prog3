/*Afficher le nombre d’employés en congé aujourd'hui. La période de congé s'étend de start_date inclus jusqu’à end_date inclus.*/
SELECT COUNT(*) AS employees_on_leave
FROM take t
JOIN leave l ON t.leave_id = l.id
WHERE CURRENT_DATE BETWEEN l.start_date AND l.end_date;

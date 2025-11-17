/*Affichez par le nombre d’employés par contract_type, vous devez afficher le type de contrat, et le nombre d’employés associés.*/
SELECT contract_type, COUNT(*) AS total_employees
FROM employee
GROUP BY contract_type;

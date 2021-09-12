SELECT employees.email, employees.phone_number FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id
INNER JOIN locations ON departments.location_id = locations.location_id
INNER JOIN countries ON locations.country_id = countries.country_id
INNER JOIN regions ON countries.region_id = regions.region_id
WHERE regions.region_id = 1 AND employees.phone_number IS NOT NULL;



SELECT dependents.first_name, dependents.last_name FROM dependents
INNER JOIN employees ON dependents.dependent_id = employees.department_id
WHERE salary IN (SELECT MAX(salary) FROM employees);



SELECT  country_name FROM countries
INNER JOIN locations ON countries.country_id = locations.country_id
INNER JOIN departments ON locations.location_id = departments.location_id
INNER JOIN employees ON departments.department_id = employees.department_id
GROUP BY countries.country_name
ORDER BY SUM (employees.salary) DESC;

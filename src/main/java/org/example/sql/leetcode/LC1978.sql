SELECT e1.employee_id
from Employees e1
WHERE e1.salary < 30000 and e1.manager_id is not null and e1.manager_id not in (select e2.employee_id from Employees e2)
ORDER BY e1.employee_id;


SELECT e1.employee_id
FROM Employees e1
         LEFT JOIN Employees e2
                   ON e1.manager_id = e2.employee_id
WHERE e1.salary < 30000 AND e2.employee_id IS NULL AND e1.manager_id IS NOT NULL
ORDER BY employee_id;
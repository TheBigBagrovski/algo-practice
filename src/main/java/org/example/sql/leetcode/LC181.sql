select e1.name as Employee
from Employee e1 join Employee e2 on e1.managerId = e2.id
where e1.salary > e2.salary;

SELECT emp.name AS Employee
FROM Employee AS emp INNER JOIN Employee AS mgr
                                ON emp.managerId = mgr.id AND
                                   emp.salary > mgr.salary
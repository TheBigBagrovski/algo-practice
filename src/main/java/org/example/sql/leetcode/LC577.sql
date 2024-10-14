select e.name, b.bonus
from Employee e left join Bonus b on e.empId = b.empId
where b.bonus < 1000 or e.empId not in (select empId from Bonus); ТУПОЕ


SELECT e.name,b.bonus
FROM Employee e
LEFT JOIN Bonus b ON e.empID = b.empID
WHERE b.bonus < 1000 OR b.bonus IS NULL ;
select t2.email
from (
         select t1.email, count(*) cnt
         from Person as t1
         group by t1.email) as t2
where t2.cnt > 1;



select email
from Person
group by email
having count(*) > 1;




SELECT DISTINCT(p1.email) from Person p1, Person p2
where p1.id <> p2.id AND p1.email = p2.email;




SELECT DISTINCT(p1.email) from
    Person p1 JOIN Person p2 ON
        p1.email = p2.email AND p1.id <> p2.id;
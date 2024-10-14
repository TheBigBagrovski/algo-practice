SELECT name as Customers
from Customers
where id not in (
    select customerId
    from Orders
);




SELECT name as Customers FROM customers
WHERE (SELECT COUNT(*) FROM orders WHERE customerId = customers.id) < 1;
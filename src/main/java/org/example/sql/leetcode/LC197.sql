SELECT id
FROM Weather w1
WHERE temperature > (
    SELECT temperature
    FROM Weather w2
    WHERE w2.recordDate = DATE_SUB(w1.recordDate, INTERVAL 1 DAY)
);


SELECT w1.id
FROM Weather w1, Weather w2
WHERE DATEDIFF(w1.recordDate, w2.recordDate) = 1
  AND w1.temperature > w2.temperature;



/* MS SQL Server */
SELECT W1.id
FROM Weather W1
         JOIN Weather W2
              ON W1.recordDate = DATEADD(day, 1, W2.recordDate)
WHERE W1.temperature > W2.temperature;



SELECT W1.id
FROM Weather W1
         JOIN Weather W2
              ON W1.recordDate = DATE_ADD(W2.recordDate, INTERVAL 1 DAY)
WHERE W1.temperature > W2.temperature;
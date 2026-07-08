# Write your MySQL query statement below

# if use below query then it wont habdle empty set as null...so to return null... we use max() as it automatically return s nullm if result set is emoty

-- select num from MyNumbers 
-- group by num
-- having count(*)=1
-- order by num desc
-- limit 1;

select max(num) as num from                                                                 (select num from MyNumbers
group by num
having count(*)=1)AS subquery_Variable;
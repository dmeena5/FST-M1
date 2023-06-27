-- Write an SQL statement to find the total purchase amount of all orders.
select SUM(purchase_amount) Total_sum from orders;

-- Write an SQL statement to find the average purchase amount of all orders.
select AVG(purchase_amount) Average from orders;

-- Write an SQL statement to get the maximum purchase amount of all the orders.
select MAX(purchase_amount) Maximum from orders;

-- Write an SQL statement to get the minimum purchase amount of all the orders.
select MIN(purchase_amount) Minumum from orders;

-- Write an SQL statement to find the number of salesmen listed in the table.
select COUNT(distinct salesman_id) Total_count from orders;
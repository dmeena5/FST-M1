-- Activity9
select * from salesman;
select * from orders;
select * from customers;
--Write an SQL statement to know which salesman are working for which customer.
select a.salesman_id, a.salesman_name,a.commission, b.customer_id, b.customer_name,b.city 
from salesman a inner join customers b on a.salesman_id = b.salesman_id;
--Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 
--and works either through a salesman.
select a.customer_id, a.customer_name,  a.city, a.grade, b.salesman_id, b.salesman_name,b.salesman_city
from customers a left outer join salesman b on a.salesman_id = b.salesman_id where a.grade < 300 order by a.customer_id;
--Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets 
--a commission from the company is more than 12%.
select a.customer_name, a.city, b.salesman_name, b.commission from customers a inner join salesman b 
on a.salesman_id = b.salesman_id where b.commission > 12;
--Write an SQL statement to find the details of a order i.e. order number, order date, amount of order,
--which customer gives the order and which salesman works for that customer and commission rate he gets for an order.
select a.order_no, a.order_date, a.purchase_amount, b.customer_name, b.grade, c.salesman_name, c.commission 
from orders a inner join customers b on a.customer_id = b.customer_id inner join   salesman c on a.salesman_id = c.salesman_id;
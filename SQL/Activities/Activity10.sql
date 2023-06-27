-- Activity10
select * from salesman;
select * from orders;
select * from customers;
--Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
select * from orders where salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007); 
--Write a query to find all orders attributed to a salesman in New York.(using Paris as i dont have data for New york)
select * from orders where salesman_id IN (select salesman_id from salesman where salesman_city='Paris');
--Write a query to count the customers with grades above New York's average.
select grade, count(*) from customers group by grade having grade > (select avg(grade) from customers where city = 'New York');
--Write a query to extract the data from the orders table for those salesman who earned the maximum commission
select order_no, purchase_amount, order_date, salesman_id from orders 
where salesman_id in (select salesman_id from salesman where commission = (select max(commission) from salesman));
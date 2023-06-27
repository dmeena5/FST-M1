-- Activity5

-- Update the grade score of salesmen from Rome to 200
update salesman set grade = 200 where salesman_city = 'Rome';

-- Update the grade score of James Hoog to 300.
update salesman set grade = 300 where salesman_name = 'James Hoog';

-- Update the name McLyon to Pierre.
update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

select * from salesman;

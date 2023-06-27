-- Activity4
-- Add a new column - grade - to the salesman table
alter table salesman add grade int;

-- Set the value in the grade column for everyone to 100
update salesman set grade = 100;

-- Use SELECT command to display the results.
select * from salesman;
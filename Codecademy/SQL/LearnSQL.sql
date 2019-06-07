--Manipulation--
-- Use keyword to select the database
USE javabase;
-- select mean fetch the data
SELECT * FROM test; -- where test is a table, * means everything. This return everything in the table of test
-- Most Common type in SQL INTEGER, TEXT(string), DATE, REAL(a decimal value)
--Statement is text that the database recognize as a vaild command. End in a semicolon
SELECT name FROM test; -- just fetch the name column from table test
-- CREATE to create something
-- create is clause (uppercase), table_name is name of table, the body is the parameters which will be the column of the table
CREATE TABLE table_name (
  id INTEGER,
  name TEXT,
  age INTEGER
);
--INSERT - insert the data into the table
--INSERT INTO is clause -> table name (the argument is not necessary) -> VALUES another caluse to indicate corresponding position of value
INSERT INTO table_name(id,name,age) VALUES(1, "Random",22), (1,"2",33);
--ALTER TABLE - add a new column to the table
ALTER TABLE table_name ADD COLUMN name_2 text;
--UPDATE for edit the row in a table
--SET change the data
--WHERE is the clause for condition
UPDATE table_name SET name = "Updated Name" where id = 1;
--DELETE FROM --delete the row where matches to the condition
DELETE FROM table_name WHERE id = 1;
--Constraint - add the information about the row when creating the tables
--Primary Key, use for unique row,
--Unique, use for unique data,
--NOT null, cannot be null
--DEFAULT 'text' -> if didn't set the data, default is text
CREATE TABLE celebs (
   id INTEGER PRIMARY KEY,
   name TEXT UNIQUE,
   date_of_birth TEXT NOT NULL,
   date_of_death TEXT DEFAULT 'Not Applicable'
);
--Queries--
--SELECT can be select more column from table
SELECT id, name FROM table_name;
--AS keyword for rename the column for readability
SELECT id AS 'ID' FROM table_name;
--DISTINCT key, only show the DISTINCT data
SELECT DISTINCT name from table_name;
--WHERE restrict the result by providing some boolean expression
SELECT name FROM table_name WHERE name = 'Abc';
--LIKE for similar value
--wildcard character - placeholder
--"-" is a wildcard character for holding individual character
SELECT * FROM table_name WHERE name LIKE 'ab_de';
--% is a wildcard to represent mutil characters before, after, middle
SELECT * FROM table_name WHERE name LIKE 'U%';
--It is impossible to test null by using operation != or =
--use is not null or is null to verfiy the null
SELECT * FROM table_name WHERE name is not null; -- is null
--between to search between the range
SELECT * FROM table_name WHERE name between 'A' and 'G'; -- G is exclusive
SELECT * FROM table_name WHERE id between 1 and 3; -- 3 is inclusive
--And operation for multiple conditions
--OR operation for multiple conditions
--Order by sort the row
--desc and asc for descending and ascending order
SELECT name FROM table_name ORDER BY id desc; --default asc
--limit - for limit amount of row
SELECT * FROM table_name limit 10;
--case statment, when and then => if and result,
SELECT name,
	case
    when genre = 'romance'then 'Chill'
    when genre = 'comedy' then 'Chill'
    else 'Intense'
  end as 'Mood'
FROM movies;
--Aggregate Function--
--meaning performed on multiple rows of a table
--Count() count amount of rows
SELECT COUNT(*) FROM table_name;
--sum, sum all the value together
SELECT SUM(id) FROM table_name;
--min and max return max and min
SELECT MAX(id) from table_name;
--AVG avg of values
SELECT AVG(id) from table_name;
--round, take two argument, one column and one INTEGER, round to INTEGER decimal place
SELECT round(age,0) from table_name;
--group by, a clause for aggregate functions, which arrange identical data into groups, must before order by and limit
SELECT count(*) from table_name group by age; --this count all people with the same age as one group.
-- group by 1 -> 1 means the first column that select is selecting,
-- group by column one, column 2, identical for both column
--Having, include or exclude groups
--come after group by
SELECT count(*) from table_name group by age having age > 10;
--for better management it is better for use id to represent the repeated information
--join, combine two tables by same column information
SELECT *
FROM orders
JOIN subscriptions
  ON orders.subscription_id = subscriptions.subscription_id;
--inner join - regular join, if the row is not matching will not be merge => means if there subscription_id is not in subscriptions
--             that row will not be merge together
--For solve this problem - keep the one is not match
--we use left join
SELECT *
FROM orders
LEFT JOIN subscriptions
  ON orders.subscription_id = subscriptions.subscription_id;
--primary key is the key to idential the row: cannot be null, cannot be repeated, a table cannot have more than on pk
--foreign key is the key when the pk of a table is the another table.
--cross join - to find all the combinations
select * from table_name cross join table_name2;
--union to stack one table with another table - duplicate row will be exclusive
--therefore, they must be equal in column and name
select * from table_name union select * FROM table_name2;
--with - to combine one table which is the calculation on another table
WITH previous_query AS (
   SELECT customer_id,
      COUNT(subscription_id) AS 'subscriptions'
   FROM orders
   GROUP BY customer_id
)
SELECT customers.customer_name,
   previous_query.subscriptions
FROM previous_query
JOIN customers
  ON previous_query.customer_id = customers.customer_id;
  

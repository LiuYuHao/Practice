--Aggregation is a calcuation on a set of value and return a single value
--Query a count of the number of cities in CITY having a Population larger than .
select count(*) from city where population > 100000;
--Query the total population of all cities in CITY where District is California.
select sum(population) from city where district = 'california';
--Query the avg population of all cities in CITY where District is California.
select avg(population) from city where district = 'california';
--Query the average population for all cities in CITY, rounded down to the nearest integer.
select round(avg(population), 0) from city;
--Query the sum of the populations for all Japanese cities in CITY. The COUNTRYCODE for Japan is JPN.
select sum(population) from city where countrycode ='jpn';
--Query the difference between the maximum and minimum populations in CITY.
select (max(population) - min(population)) from city;
--Write a query calculating the amount of error (i.e.: actual - miscalculated average monthly salaries), and round it up to the next integer.
select CEIL(avg(salary) - avg(convert(replace(convert(salary,char),'0',''), UNSIGNED INTEGER))) from EMPLOYEES;
/*
Write a query to find the maximum total earnings for all employees as well as the total number of employees who have maximum total earnings.
Then print these values as 2 space-separated integers.
*/
select (salary * months)as earnings ,count(*) from employee group by earnings order by earnings desc limit 1;
/*
Query the following two values from the STATION table:

The sum of all values in LAT_N rounded to a scale of 2 decimal places.
The sum of all values in LONG_W rounded to a scale of 2 decimal places.
*/
select round(sum(LAT_N),2), round(sum(LONG_W),2) from station;

/*
Query the sum of Northern Latitudes (LAT_N) from STATION having values greater than 38.7880 and less than 137.2345
Truncate your answer to 4 decimal places.
*/
select round(sum(LAT_N),4) from station where LAT_N > 38.7880 and LAT_N < 137.2345;
--Query the greatest value of the Northern Latitudes (LAT_N) from STATION that is less than 137.2345. Truncate your answer to 4 decimal places.
select round(max(lat_N),4) from station where lat_n <137.2345;
/*
Query the Western Longitude (LONG_W) for the largest Northern Latitude (LAT_N) in STATION that is less than 137.2345.
Round your answer to 4 decimal places.
*/
select round(long_w,4) from station where lat_n = (select max(lat_n) from station where lat_n < 137.2345);
/*
Query the smallest Northern Latitude (LAT_N) from STATION that is greater than 38.7780 Round your answer to 4 decimal places.
*/
select round(min(lat_N),4) from station where lat_n > 38.7780;
/*
Query the Western Longitude (LONG_W)where the smallest Northern Latitude (LAT_N) in STATION is greater than 38.7780.
Round your answer to 4 decimal places.
*/
select round(long_w, 4) from station where lat_n = (select min(lat_n) from station where lat_n > 38.7780);
/*
Consider P1(a,b) and P2(c,d) to be two points on a 2D plane.

 happens a to equal the minimum value in Northern Latitude (LAT_N in STATION).
 happens b to equal the minimum value in Western Longitude (LONG_W in STATION).
 happens c to equal the maximum value in Northern Latitude (LAT_N in STATION).
 happens d to equal the maximum value in Western Longitude (LONG_W in STATION).
 Query the Manhattan Distance between points P1 and P2 and round it to a scale of 4 decimal places.
*/
select round(abs(max(lat_n) - min(lat_n)) + abs(max(long_W) - min(long_w)),4) from station;
--Query the Euclidean Distance between points P1 and P2 and format your answer to display 4 decimal digits.
select round(sqrt(power(max(lat_N) - min(lat_N),2) + power(max(long_w) - min(long_w),2)),4) from station;
/*
A median is defined as a number separating the higher half of a data set from the lower half.
 Query the median of the Northern Latitudes (LAT_N) from STATION and round your answer to 4 decimal places.
*/
set @r1 =-1;
select round(avg(s.lat_n),4) from
(select @r1:=@r1 + 1 as r1,
        lat_n from station
        order by lat_N) as s
where s.r1 in (floor(@r1/2), ceil(@r1/2));

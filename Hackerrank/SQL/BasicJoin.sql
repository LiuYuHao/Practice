--Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.
select sum(city.population) from city join country on city.countrycode = country.code where country.continent ='asia';
--Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.
select city.name from city join country on city.countrycode = country.code where continent = 'Africa';
/*
Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent)
and their respective average city populations (CITY.Population) rounded down to the nearest integer.
*/
select country.continent, floor(avg(city.population))from city join country on city.countrycode = country.code group by country.continent;
/*
generate a report containing three columns: Name, Grade and Mark.
Ketty doesn't want the NAMES of those students who received a grade lower than 8.
The report must be in descending order by grade -- i.e. higher grades are entered first.
If there is more than one student with the same grade (8-10) assigned to them,
order those particular students by their name alphabetically.
Finally, if the grade is lower than 8, use "NULL" as their name and list them by their grades in descending order.
If there is more than one student with the same grade (1-7) assigned to them, order those particular students by their marks in ascending order.
*/
select if(grades.grade > 7,students.name,'NULL'), grades.grade, students.marks from students join grades on students.marks
between Grades.Min_Mark and Grades.Max_Mark order by grades.grade desc, students.name;
--Write a query to print the respective hacker_id and name of hackers who achieved full scores for more than one challenge.
select b.hacker_id, hackers.name from
  (select submissions.hacker_id, count(submissions.hacker_id) as total_cha
    from Submissions join challenges on submissions.challenge_id = challenges.challenge_id
    join Difficulty on Difficulty.Difficulty_level = challenges.Difficulty_level and Submissions.score = Difficulty.score
    group by submissions.hacker_id) b, hackers where b.total_cha > 1 and hackers.hacker_id = b.hacker_id order by b.total_cha desc, b.hacker_id;

/*
Hermione decides the best way to choose is by determining the minimum number of gold galleons needed to buy each non-evil wand of high power and age.
Write a query to print the id, age, coins_needed, and power of the wands that Ron's interested in, sorted in order of descending power.
If more than one wand has same power, sort the result in order of descending age.
*/
select b2.id, b.age, b.coins, b.power from
(select wands_property.age,min(wands.coins_needed) as coins, wands.power from wands join wands_property on wands.code = wands_property.code
where wands_property.is_evil = 0 group by wands_property.age, wands.power) b,
(select wands.id, wands_property.age, wands.coins_needed, wands.power from wands join wands_property on wands.code = wands_property.code
  where wands_property.is_evil = 0) b2
  where b2.age = b.age and b2.power = b.power and b.coins = b2.coins_needed order by b.power desc, b.age desc;
/*
Write a query to print the hacker_id, name, and the total number of challenges created by each student.
Sort your results by the total number of challenges in descending order.
If more than one student created the same number of challenges, then sort the result by hacker_id.
If more than one student created the same number of challenges and the count is less than the maximum number of challenges created,
then exclude those students from the result.
*/
select b.hacker_id, b.n, b.c from
(select hackers.hacker_id, count(*) as c, max(hackers.name) as n
from hackers join challenges on hackers.hacker_id = challenges.hacker_id group by hackers.hacker_id) b where b.c not in (select b2.c from
    (select b.c, count(*) as c2 from
        (select hackers.hacker_id, count(*) as c, max(hackers.name) as n
        from hackers join challenges on hackers.hacker_id = challenges.hacker_id group by hackers.hacker_id) b group by b.c) b2
        where b2.c != (select max(a.c) from
            (select hackers.hacker_id, count(*) as c, max(hackers.name) as n
            from hackers join challenges on hackers.hacker_id = challenges.hacker_id group by hackers.hacker_id) a) and b2.c2 > 1)
            order by b.c desc, b.hacker_id;
/*
The total score of a hacker is the sum of their maximum scores for all of the challenges.
 Write a query to print the hacker_id, name, and total score of the hackers ordered by the descending score.
  If more than one hacker achieved the same total score, then sort the result by ascending hacker_id.
Exclude all hackers with a total score of 0 from your result.
*/
select b2.hacker_id, b2.name, b2.c2 from
(select b.hacker_id, b.name, sum(b.c) as c2 from
(select hackers.hacker_id, hackers.name, max(submissions.score) as c
from hackers join submissions
where hackers.hacker_id = submissions.hacker_id
group by hackers.hacker_id, hackers.name, submissions.challenge_id) b group by b.hacker_id, b.name) b2
 where b2.c2 > 0 order by b2.c2 desc, b2.hacker_id;
 

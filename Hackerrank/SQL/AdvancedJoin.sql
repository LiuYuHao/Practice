/*
Write a query to output the start and end dates of projects listed by the number of days it took to complete the project in ascending order.
If there is more than one project that have the same number of completion days, then order by the start date of the project.
*/

set @r1 = 0, @r2= 0;
select start_date, end_date from
((select @r1:=@r1 + 1 as r1, start_date from projects where start_date not in (select end_date from projects)) a join
(select @r2:=@r2 + 1 as r2, end_date from projects where end_date not in (select start_date from projects)) a2 on a.r1 = a2.r2)
order by DATEDIFF(end_date, start_date), start_date;

/*
Write a query to output the names of those students whose best friends got offered a higher salary than them.
Names must be ordered by the salary amount offered to the best friends. It is guaranteed that no two students got same salary offer.
*/
select name from
((select students.id, students.name, packages.salary, friends.friend_id from students join packages on students.id = packages.id
  join friends on friends.id = students.id) a join
(select students.id as friend_id, packages.salary as friend_salary from students
  join packages on students.id = packages.id) a2 on a.friend_id = a2.friend_id) where friend_salary > salary order by friend_salary;

--Write a query to output all such symmetric pairs in ascending order by the value of X.

SELECT f1.X, f1.Y FROM Functions f1
JOIN Functions f2 ON f1.X=f2.Y AND f1.Y=f2.X
group by f1.X, f1.Y
having count(f1.X) > 1 or f1.X < f1.Y
order by f1.X;

/*
Write a query to print the contest_id, hacker_id, name, and the sums of total_submissions, total_accepted_submissions, total_views,
 and total_unique_views for each contest sorted by contest_id.
 Exclude the contest from the result if all four sums are 0.
*/
select contests.contest_id,
       max(contests.hacker_id),
       max(contests.name), sum(ts),
       sum(tas), sum(tv), sum(tuv) from contests
       join colleges on contests.contest_id = colleges.contest_id
       join challenges on challenges.college_id = colleges.college_id
       left join (select challenge_id,sum(total_views) as tv, sum(total_unique_views) as tuv from view_stats group by view_stats.challenge_id) v on v.challenge_id = challenges.challenge_id
       left join (select challenge_id, sum(total_submissions) as ts, sum(total_accepted_submissions) as tas from submission_stats group by submission_stats.challenge_id) s on s.challenge_id = challenges.challenge_id
       group by contest_id order by contest_id;
/*
Write a query to print total number of unique hackers who made at least 1 submission each day (starting on the first day of the contest),
and find the hacker_id and name of the hacker who made maximum number of submissions each day.
If more than one such hacker has a maximum number of submissions, print the lowest hacker_id.
The query should print this information for each day of the contest, sorted by the date.
*/

select submission_date,
(select count(distinct hacker_id) from submissions s2 where s2.submission_date = s1.submission_date and (select count(distinct s3.submission_date) from submissions s3 where s3.hacker_id = s2.hacker_id and s3.submission_date < s1.submission_date) = datediff(s1.submission_date, '2016-03-01')),
(select hacker_id from submissions s2 where s2.submission_date = s1.submission_date group by hacker_id order by count(submission_date) desc, hacker_id limit 1) as id,
(select name from hackers where hacker_id = id)
from
(select distinct submission_date from submissions) s1;

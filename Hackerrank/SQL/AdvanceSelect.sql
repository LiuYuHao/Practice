/*
Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. Output one of the following statements for each record in the table:

Equilateral: It's a triangle with 3 sides of equal length.
Isosceles: It's a triangle with 2 sides of equal length.
Scalene: It's a triangle with all sides of differing lengths. --> a + b > c, b + c > a, c + a > b
Not A Triangle: The given values of A, B, and C don't form a triangle.
*/
select case when A + B <= C or A + C <= B or B + C <= A then 'Not A Triangle'
        when A = B and A = C then 'Equilateral'
        when A = B or A = C or B = C then 'Isosceles'
        else 'Scalene'
    end
from triangles;
/*
Generate the following two result sets:

Query an alphabetically ordered list of all names in OCCUPATIONS, immediately followed by
      the first letter of each profession as a parenthetical (i.e.: enclosed in parentheses).
      For example: AnActorName(A), ADoctorName(D), AProfessorName(P), and ASingerName(S).
Query the number of ocurrences of each occupation in OCCUPATIONS.
      Sort the occurrences in ascending order, and output them in the following format:
*/
select concat(name, '(', substr(occupation, 1,1), ')') from occupations order by name;
select concat('There are a total of ', count(*), ' ',lower(occupation), 's.') from occupations group by occupation order by count(*), occupation;

/*
Pivot the Occupation column in OCCUPATIONS so that each Name is sorted alphabetically and displayed underneath its corresponding Occupation.
 The output column headers should be Doctor, Professor, Singer, and Actor, respectively.

Note: Print NULL when there are no more names corresponding to an occupation.
*/

set @r1=0, @r2=0, @r3=0, @r4=0; --global varaible define
select    min(Doctor), min(Professor), min(singer), min(Actor)
from(
  select case when Occupation='Doctor' then (@r1:=@r1+1) --how to assign to the variable
            when Occupation='Professor' then (@r2:=@r2+1)
            when Occupation='Singer' then (@r3:=@r3+1)
            when Occupation='Actor' then (@r4:=@r4+1) end as RowNumber,
    case when Occupation='Doctor' then Name end as Doctor,
    case when Occupation='Professor' then Name end as Professor,
    case when Occupation='Singer' then Name end as Singer,
    case when Occupation='Actor' then Name end as Actor
  from OCCUPATIONS
  order by Name
) Temp
group by RowNumber;

--You are given a table, BST, containing two columns: N and P, where N represents the value of a node in Binary Tree, and P is the parent of N.
SELECT N, case when p is null then 'Root' when N in (select p from bst) then 'Inner' Else 'Leaf' end FROM BST ORDER BY N;
SELECT N, IF(P IS NULL,'Root',IF((SELECT COUNT(*) FROM BST WHERE P=B.N)>0,'Inner','Leaf')) FROM BST AS B ORDER BY N; -- know the logical but didn't understand the syntax
/*
Given the table schemas below, write a query to print the company_code, founder name, total number of lead managers,
total number of senior managers, total number of managers, and total number of employees. Order your output by ascending company_code.
*/
select c.company_code, c.founder,
    count(distinct l.lead_manager_code), count(distinct s.senior_manager_code),
    count(distinct m.manager_code),count(distinct e.employee_code)
from Company c, Lead_Manager l, Senior_Manager s, Manager m, Employee e
where c.company_code = l.company_code
    and l.lead_manager_code=s.lead_manager_code
    and s.senior_manager_code=m.senior_manager_code
    and m.manager_code=e.manager_code
group by c.company_code, c.founder order by c.company_code;

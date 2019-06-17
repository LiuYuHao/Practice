-- ****
-- ***
-- **
-- *
-- write a queries for 20
set @r1 = 21;
select repeat('* ', @r1 := @r1 - 1) from
    (select 1 union select 2 union select 3) a,
    (select 1 union select 2 union select 3) b,
    (select 1 union select 2 union select 3) c
limit 20;
-- downward
set @r1 = 0;
select repeat('* ', @r1 := @r1 + 1) from
  (select 1 union select 2 union select 3) a,
  (select 1 union select 2 union select 3) b,
  (select 1 union select 2 union select 3) c limit 20;
--list all the prime < 1000
set @number = 1;
set @number_2 = 1;
select GROUP_CONCAT(number SEPARATOR '&') from (select @number := @number + 1 as number from
  (select 1 union select 2 union select 3 union select 4) a,
  (select 1 union select 2 union select 3 union select 4) b,
  (select 1 union select 2 union select 3 union select 4) c,
  (select 1 union select 2 union select 3 union select 4) d,
  (select 1 union select 2 union select 3 union select 4) e limit 999) number_table
  where not exists (select * from (select @number_2 := @number_2 + 1 as d from
  (select 1 union select 2 union select 3 union select 4) a,
  (select 1 union select 2 union select 3 union select 4) b,
  (select 1 union select 2 union select 3 union select 4) c,
  (select 1 union select 2 union select 3 union select 4) d,
  (select 1 union select 2 union select 3 union select 4) e limit 999) number_table where MOD(number, d) = 0 and number != d);

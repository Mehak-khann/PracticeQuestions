# Write your MySQL query statement below
-- select teacher_id ,subject_id,count(*) AS cnt from Teacher
-- group by teacher_id,subject_id;

-- select teacher_id,count(subject_id) As cnt from teacher 
-- group by teacher_id;
-- | teacher_id | cnt |
-- | ---------- | --- |
-- | 1          | 3   |
-- | 2          | 4   |

select teacher_id,count(distinct subject_id) As cnt from teacher 
group by teacher_id;
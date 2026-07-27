/*
# 2356. Number of Unique Subjects Taught by Each Teacher

Problem Statement:

Table: Teacher

+-------------+------+
| Column Name | Type |
+-------------+------+
| teacher_id  | int  |
| subject_id  | int  |
| dept_id     | int  |
+-------------+------+

- (subject_id, dept_id) is the primary key.
- Each row indicates that a teacher teaches a subject in a department.

Write an SQL query to find the number of unique subjects each teacher teaches.

Example:

Input: Teacher table

+------------+------------+---------+
| teacher_id | subject_id | dept_id |
+------------+------------+---------+
| 1          | 2          | 3       |
| 1          | 2          | 4       |
| 1          | 3          | 3       |
| 2          | 1          | 1       |
| 2          | 2          | 1       |
| 2          | 3          | 1       |
| 2          | 4          | 1       |
+------------+------------+---------+

Output:

+------------+-----+
| teacher_id | cnt |
+------------+-----+
| 1          | 2   |
| 2          | 4   |
+------------+-----+

Approach:
1. Group rows by teacher_id.
2. Count distinct subject_id for each teacher.
3. Return the count as cnt.

SQL Solution:

*/

SELECT
    teacher_id,
    COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id;

/*
Complexity:
Time Complexity: O(n)
Space Complexity: O(n)
*/

SELECT * FROM techjobs.employer;
SELECT * FROM techjobs.skill;
SELECT * FROM techjobs.job;
SELECT * FROM techjobs.job_skills;

-- Part 1: Test it with SQL
SELECT * FROM techjobs.job;

-- Part 2: Test it with SQL
SELECT name FROM employer WHERE location = "St. Louis City";

-- Part 3: Test it with SQL
drop table job;

-- Part 4: Test it with SQL
SELECT * 
FROM skill
LEFT JOIN job_skills ON job_skills.skills_id = skill.id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;

-- "SELECT * FROM skill" +
-- LEFT JOIN job_skills ON skill.id = job_skills.skills_id|job_skills.skills_id =  skill.id)" +
--                 WHERE job_skills.jobs_id IS NOT NULL
--                 "\\s*ORDER\\s+BY\\s+name\\s+ASC;"

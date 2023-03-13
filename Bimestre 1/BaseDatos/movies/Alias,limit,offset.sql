SELECT title AS titulo
FROM series;

SELECT title, rating
FROM movies
WHERE rating > 3 AND awards > 1 AND
release_date between "1988-01-01" and "2009-12-31"
order by rating DESC;

SELECT title, rating
FROM movies
WHERE rating > 3 AND awards > 1 AND
release_date between "1988-01-01" and "2009-12-31"
order by rating DESC
limit 3
offset 10;

SELECT title, rating
from episodes
order by rating ASC
limit 3;


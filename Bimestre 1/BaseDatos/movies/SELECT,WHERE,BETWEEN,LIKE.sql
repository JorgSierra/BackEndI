SELECT * FROM movies;
SELECT first_name, last_name, rating FROM actors;
SELECT title FROM series;

SELECT first_name, last_name 
FROM actors 
WHERE rating > 7.5;

SELECT title, rating, awards
FROM movies
WHERE rating > 7.5 AND awards > 2;

SELECT title, rating 
FROM movies
ORDER BY rating ASC;

SELECT title , rating 
FROM movies 
WHERE title LIKE "%toy story%";

SELECT *
FROM actors
WHERE first_name LIKE "Sam%";

SELECT title
FROM movies
where release_date BETWEEN "2004-01-01" AND "2008-12-31";
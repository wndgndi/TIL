WITH CTE AS (
    SELECT FISH_TYPE, FISH_NAME, MAX(LENGTH) AS LENGTH
    FROM FISH_INFO
    NATURAL JOIN FISH_NAME_INFO
    GROUP BY FISH_TYPE, FISH_NAME
)

SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO
NATURAL JOIN CTE
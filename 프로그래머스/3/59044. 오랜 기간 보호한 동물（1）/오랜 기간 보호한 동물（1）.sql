-- 코드를 입력하세요
SELECT
ai.name,
ai.datetime
FROM animal_ins ai
 LEFT JOIN animal_outs ao
 ON ao.animal_id = ai.animal_id
WHERE ao.datetime IS NULL
ORDER BY ai.datetime LIMIT 3
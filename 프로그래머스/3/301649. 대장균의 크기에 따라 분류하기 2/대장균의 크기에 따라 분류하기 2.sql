SELECT ID, CASE WHEN RANKING <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.25) THEN 'CRITICAL'
           WHEN RANKING <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.5) THEN 'HIGH'
           WHEN RANKING <= ((SELECT COUNT(*) FROM ECOLI_DATA) * 0.75) THEN 'MEDIUM'
           ELSE 'LOW' END COLONY_NAME
FROM (SELECT ID, RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) RANKING
      FROM ECOLI_DATA) E
ORDER BY ID
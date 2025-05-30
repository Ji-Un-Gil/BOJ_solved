SELECT DISTINCT(H.CAR_ID) AS CAR_ID, C.CAR_TYPE AS CAR_TYPE, CAST(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) * 0.3 AS SIGNED) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H
INNER JOIN (
    SELECT CAR_ID, CAR_TYPE, DAILY_FEE
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE = '세단' OR CAR_TYPE = 'SUV'
) AS C
ON H.CAR_ID = C.CAR_ID
INNER JOIN (
    SELECT CAR_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE DURATION_TYPE = '30일 이상'
) AS P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE H.CAR_ID NOT IN (
    SELECT DISTINCT(CAR_ID)
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE (START_DATE BETWEEN DATE('2022-11-01') AND DATE('2022-11-30'))
    OR (END_DATE BETWEEN DATE('2022-11-01') AND DATE('2022-11-30'))
    OR (START_DATE < DATE('2022-11-01') AND END_DATE > DATE('2022-11-30'))
)
AND (CAST(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) * 0.3 AS SIGNED) >= 500000 AND CAST(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) * 0.3 AS SIGNED) <= 2000000)
ORDER BY CAST(C.DAILY_FEE * (100 - P.DISCOUNT_RATE) * 0.3 AS SIGNED) DESC, C.CAR_TYPE, C.CAR_ID DESC
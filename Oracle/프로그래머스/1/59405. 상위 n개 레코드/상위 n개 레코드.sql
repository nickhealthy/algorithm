-- 코드를 입력하세요
SELECT  NAME
FROM    (
            SELECT  NAME
            FROM    ANIMAL_INS
            ORDER
            BY      DATETIME
        )
WHERE   ROWNUM <= 1
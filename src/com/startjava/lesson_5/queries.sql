\echo Вывод всей таблицы
SELECT *
    FROM jaegers
   ORDER BY model_name;

\echo Вывод не уничтоженных роботов
SELECT * 
    FROM jaegers
   WHERE status = 'Destroyed';

\echo Вывод только роботов серии Mark-1 и Mark-4
SELECT * 
    FROM jaegers 
   WHERE mark IN(1,4);

\echo Вывод всех роботов, кроме Mark-1 и Mark-4, отсортировав таблицу по убыванию по столбцу mark
SELECT * 
    FROM jaegers 
   WHERE mark NOT IN(1,4) 
   ORDER BY mark DESC;

\echo Вывод информацию о самых старых роботах
SELECT * 
    FROM jaegers 
   WHERE launch <= (SELECT MIN(launch)
                        FROM jaegers);

\echo Вывод информации из столбцов model_name, mark, launch, kaiju_kill тех роботов, которые уничтожили больше всех kaiju
SELECT model_name, mark, launch, kaiju_kill
    FROM jaegers
   WHERE kaiju_kill = (SELECT MAX(kaiju_kill)
                           FROM jaegers);

\echo Вывод среднего веса роботов, округлив его до трех знаков после запятой. Отображайте над результатом avg_weight вместо round
SELECT ROUND(AVG(weight),3) AS avg_weight
    FROM jaegers;

\echo увеличьте на единицу количество уничтоженных kaiju у неразрушенных роботов, а затем выведите таблицу
UPDATE jaegers
    SET kaiju_kill = kaiju_kill + 1
   WHERE status != 'Destroyed';

\echo удалите уничтоженных роботов, а затем выведите оставшихся
DELETE
    FROM jaegers AS deleted_table
   WHERE status = 'Destroyed';

\echo Вывод таблицы после удаления строк
SELECT *
    FROM jaegers
   ORDER BY model_name;








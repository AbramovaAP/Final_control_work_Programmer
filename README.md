# Итоговая контрольная работа

**Информация о проекте**    
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.   
Текст задания находится [здесь](Задание.pdf)

## Задание 1. 
Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл (Лошадьми, верблюдами и ослами), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).

**ШАГ 1**   
В операционной системы Linux создаем два файла:
1. Pets (Домашние животные) – Заполним его Dogs (собаки), Cats (кошки) и Hamsters (хомяки);
2. Pack_animals (Вьючные животные) – Заполним его Horses (лошади), Camels (верблюды) и Donkeys (ослы);
![alt text](/Images/image-0.png)

**ШАГ 2**    
Объединим данные из двух файлов, Pets и Pack_animals, в один файл All_animals:
![alt text](/Images/image-1.png)

**ШАГ 3**
Переименуем файл All_animals в Human_friends (Друзья человека)
![alt text](/Images/image-2.png)

## Задание 2. 
Создать директорию, переместить файл туда.   

**ШАГ 1**   
Создаем новую директорию:
![alt text](/Images/image-3.png)

**ШАГ 2**   
Перемешаем файл Human_friends в директорию Final_control_work
![alt text](/Images/image-4.png)

## Задание 3. 
Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
![alt text](/Images/image-5.png)

## Задание 4.
Установить и удалить deb-пакет с помощью dpkg.
![alt text](/Images/image-6.png)

## Задание 5. 
Выложить историю команд в терминале ubuntu
![alt text](/Images/image-7.png)

## Задание 6. 
Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.
![alt text](/Images/image-8.png)
 
## Задание 7. 
В подключенном MySQL репозитории создать базу данных «Друзья человека»

## Задание 8. 
Создать таблицы с иерархией из диаграммы в БД

## Задание 9. 
Заполнить низкоуровневые таблицы именами(животных), командами, которые они выполняют, и датами рождения

## Задание 10. 
Удалить из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

## Задание 11. 
Создать новую таблицу «молодые животные» в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице

## Задание 12. 
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
![alt text](/Images/image-9.png)

Задания с 7 по 12 были выполнены в среде MySQL, а не через терминал, в связи с техническими трудностями и нестабильной работой ОС Linux Ubuntu. Решение приведено в файле: [База данных](/DataBase/Human_Friends.sql)

## Задание 13. 
Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
![alt text](/Images/image-10.png)

## Задание 14. 
Написать программу, имитирующую работу реестра домашних животных.   
В программе должен быть реализован следующий функционал:   
    14.1 Завести новое животное   
    14.2 определять животное в правильный класс   
    14.3 увидеть список команд, которое выполняет животное   
    14.4 обучить животное новым командам   
    14.5 Реализовать навигацию по меню   
![alt text](/Images/image-11.png)

## Задание 15. 
Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1 при нажатие «Завести новое животное». Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведении животного заполнены все поля.

Работа программы и класса Счетчик:   
![alt text](/Images/image-12.png)

![alt text](/Images/image-13.png)

![alt text](/Images/image-14.png)






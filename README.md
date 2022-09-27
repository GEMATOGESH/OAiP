# OAiP
# Лабораторная работа 1
Дан массив B[1]..B[N]. Вычислить:  
Y[i] = ((C * B[i] + 1)^2)^(1/3) if B[i] <= 1  
Y[i] = B[i] + C if B[i] > 1  
C = min(B[i]) + max(B[i]) 

# Лабораторная работа 2

# Лабораторная работа 3
Дана строка символов S, состоящая из латинских букв. Группы символов, разделенные пробелами и не содержащие пробелов внутри себя, будем называть словами. Преобразовать исходную строку в строки S1 и S2 в соответствии с пунктами 1 и 2 задания, выданного преподавателем. Если какая-либо из итоговых строк окажется пустой, выводить соответствующее сообщение.  
п.1. – Напечатать слова, отличные от последнего слова, если в них есть повторяющиеся буквы.  
п.2. - Напечатать слова, отличные от последнего слова, удалив из них все последующие вхождения первой буквы.  

# Лабораторная работа 4
Решить задачу двумя способами – с применением рекурсии и без нее.
Вычислить произведение двух целых положительных чисел p = a * b по следующему алгоритму: p = 2 * (a * b / 2), если b четное; p= a + ( a * (b - 1)), если b нечетное. Если b = 0, то p = 0. a и b ввести с клавиатуры. Вывести на экран результат, полученный первым и вторым способом.

# Лабораторная работа 5
Произвести анализ сортировок массивов в соответствии с вариантом, выданным преподавателем.  
Отсортировать по возрастанию  массивы целочисленных элементов  различной размерности: 100 элементов, 10000 элементов, 100000 элементов. Анализ произвести по числу сравнений и перестановок двух элементов,  а также времени, затраченном на упорядочивание элементов массива. Исследования производить над массивами трех типов:  
1.	Массив, содержащий неотсортированные элементы;  
2.	Массив, содержащий отсортированные элементы;  
3.	Массив, содержащий элементы, отсортированные в обратном порядке.  

Выбранные алгоритмы: Бинарные вставки. Сортировка прямым выбором. Quicksort.  

# Тема
У администратора железнодорожных касс хранится информация о свободных местах в поездах. Информация представлена в следующем виде: номер поезда, пункт назначения, время отправления, число свободных мест. Вывести информацию о поездах, в которых имеются свободные места до заданного пункта назначения. 

# Лабораторная работа 6
Описать класс, а также конструктор класса для создания объектов согласно варианту, выданному преподавателем. Создать ArrayList, содержащий  объекты описанного ранее класса. При добавлении объекта в ArrayList конструктор создаваемого объекта передать в качестве параметра. Организовать меню для вызова следующих подпрограмм: «Добавление объекта в ArrayList(в конец или по индексу)», «Вывод всех объектов ArrayList на экран»,  «Удаление объекта из ArrayList , «Установить новое значение по индексу объекта ArrayList », «Вывод на экран объектов ArrayList  согласно варианту». Дополнительные массивы не использовать. При вводе данных выполнить все необходимые проверки.  

# Лабораторная работа 7
Расширить меню и функционал задания 6 для работы с файлами. Добавить метод для записи в файл создаваемых объектов (и соответствующий пункт меню). Полученный текстовый файл должен соответствовать шаблону в файле fileExample.txt. Для записи в файл использовать поток FileWriter. Добавить метод для чтения из текстового файла (и соответствующий пункт меню). Для чтения из файла использовать либо метод readAllLines() класса Files либо с помощью Stream API (метод Files.lines()).

# Лабораторная работа 8
Реализовать свой пользовательский LinkedList. Для чего использовать задания 6-7. В программе должны быть реализованы пункты меню: чтение/запись в/из файла, добавление элемента в конец списка или по индексу, удаление элемента из списка по индексу, вывод списка на экран, поиск согласно условию задачи.  Встроенный итератор не использовать.

# Лабораторная работа 9-10
Решить задачу, используя класс LinkedList.
В проектной фирме есть список работ, закрепленный за сотрудниками. Каждая запись списка содержит: название проекта, задание в рамках данного проекта, ФИО исполнителя, ФИО руководителя, дата выдачи задания, срок выполнения. Требуется:
•	Выдать список всех проектов руководителя;
•	Выдать список всех задач сотрудника;
•	Предусмотреть возможность добавлять, удалять и корректировать записи из списка, а так же просматривать весь список.

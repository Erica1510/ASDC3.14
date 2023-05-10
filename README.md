# ASDC3.14 
# Code testing

## Table of contents

* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info

This project is created for ASDC lab work #3.14. Implementation of unit tests for created classes.
В классе ReadFile тестируются два метода: readTxtFile() и serialize(). Метод testReadTxtFile() проверяет,
что метод readTxtFile() корректно читает данные из текстового файла. Метод testSerialize() проверяет, 
что метод serialize() корректно сериализует и десериализует список объектов Video_Cards в файл.

В классе Video_Cards тестируются четыре метода: getters и setters, equals и hashCode, clone, 
и readAndWrite. Метод testGettersAndSetters() проверяет, что все getters и setters корректно работают.
Метод testEqualsAndHashCode() проверяет корректность реализации методов equals и hashCode.
Метод testClone() проверяет корректность реализации метода clone. Метод testReadAndWrite() проверяет,
что метод write() корректно записывает данные объекта в StringBuilder.

Тесты MyStack:
- testSize(): проверяет метод size() класса MyStack, проверяя размер стека до и после удаления элемента.
- testIsEmpty(): тестирует метод isEmpty() класса MyStack, проверяя, пуст ли стек до и после удаления всех элементов.
- testPeek(): проверяет метод peek() класса MyStack, проверяя значение верхнего элемента стека до и после удаления элементов. 
Он также проверяет, генерируется ли исключение при вызове peek() для пустого стека.
- testPush(): тестирует метод push() класса MyStack, добавляя элемент в стек и проверяя правильность его размера и верхнего значения.
- testPop(): тестирует метод pop() класса MyStack, удаляя элементы из стека и проверяя их значения. 
Он также проверяет, возникает ли исключение при вызове pop() для пустого стека.
- testIterator(): проверяет реализацию Iterator класса MyStack, перебирая стек и проверяя значения в обратном порядке.

Тесты VideoCardTree:

- testAddVideoCards(): тестирует метод addVideoCards() класса VideoCardTree, добавляя в дерево два объекта Video_Cards и проверяя, можно ли их найти по их коду.
- testFindVideoCardByCode(): тестирует метод findVideoCardByCode() класса VideoCardTree, создавая дерево с двумя объектами 
Video_Cards и проверяя, можно ли их найти по их коду.
- testFindVideoCardByCodeThrowsException(): Проверяет, возникает ли исключение при вызове findVideoCardByCode() для пустого VideoCardTree.
- testRemoveVideoCard(): тестирует метод removeVideoCard() класса VideoCardTree, создавая дерево с двумя объектами Video_Cards,
 удаляя один из них и проверяя, что он не может быть найден по коду, в то время как другой может.
 
## Technologies

Project is created with:

* OpenJDK-19
* Maven 3.9.1

## Setup

Run this project:

```
$ mvn clean package
$ mvn test
```

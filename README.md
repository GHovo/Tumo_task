# TUMO Portfolio

This is a project of the automation test suite which uses the following technologies stacks:

* JDK 17
* Maven
* Selenium 4.x
* JUnit 5.x
* Allure 2.x

## Installation and Requirements

Before running the tests locally, you should have these tools installed

1. JDK 17 or a later version [https://adoptium.net/temurin/releases/](https://adoptium.net/temurin/releases/)
2. Maven - [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
3. Chrome browser


## How to run tests from IntelliJ IDE

1. Install IntelliJ IDEA or another IDE which you prefer
2. Clone or download project [https://github.com/GHovo/Tumo_task](https://github.com/GHovo/Tumo_task)
3. Open it in IDE as Maven project
4. Wait for dependencies to be downloaded and files to be indexed
5. For running entire suite, select tests package and choose 'Run 'Tests in "tests"'' option.
6. For running specific test, click "Run" button near test class name of method name or right-click name of file with test
   ![runTest](docs/assets/runTest.png)

## How to run tests from Command Line

1. Run all tests

```shell script
mvn clean test
```
1. Run specific test

```shell script
mvn clean test -Dtest=LoginTest
```
1. Run tests in multiple threads, **--Dthreads** parameter, expected values - 2, 3, 4, 5

```shell script
mvn clean test -Dthreads=4
```
## How to Generate and View Allure Reports

1. Run to generate Report

```shell script
mvn allure:report
```
1. Run to open Report on default browser

```shell script
mvn allure:serve
```
![allureReport](docs/assets/allure_report.png)

## Language Support Issue: Armenian Characters Display as ???
In this project, I used ResourceBundle to store and manage localized strings for different languages.

If you try to run the tests and encounter an issue where Armenian characters are displayed as ??? (for example, ???????? ? instead of Մոռացե՞լ ես գաղտնաբառը), it usually means that UTF-8 encoding is not configured correctly in your IDE.

### Solution

1. To fix this issue, please follow these steps in IntelliJ IDEA:

2. Open Settings → Editor → File Encodings

3. Make sure the following values are set:

4. Global Encoding: UTF-8

5. Project Encoding: UTF-8

6. Default encoding for properties files: UTF-8

7. Make sure "Transparent native-to-ascii conversion" is unchecked

8. Restart IntelliJ if needed

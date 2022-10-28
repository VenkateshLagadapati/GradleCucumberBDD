# GradleCucumberBDD

Selenium Gradle Test Framework with BDD (Cucumber)

### Installation

Clone the directory and run

### Run example tests
```
gradle clean test (to run all test tasks)
gradle {taskName} (to run particular task)
gradle tags -P tags=@login (to run using tags)
gradle test -Dcucumber.filter.tags="@login"
```

### Features

> * Hooks
> * Tags Usage
> * Page Object Model
> * Cucumber HTML Report
> * Cucumber Maven Report
> * Gradle Report

```
* Cucumber maven report will be created under target folder
* Gradle report will be created under GradleReport folder
```

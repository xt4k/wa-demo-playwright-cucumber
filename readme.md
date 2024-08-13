# Getting Started

Accelerator project template based on Playwright, Junit and Cucumber

## Reference Documentation
For further reference, please consider the following sections:

Working folder structure :

```text
├───src
    └───test
        ├───java
        │   └───wa
        │       └───────demo   
        │               │ 
        │               │    
        │               ├──── cucumber
        │               │       ├─── listener
        │               │       │    TestAllureListener
        │               │       │       
        │               │       └─── steps
        │               │            CucumberHooks.java
        │               │            CucumberRunner.java
        │               │            CucumberSpringContextConfig.java
        │               │            StaticContextAccessor  
        │               │  
        │               │    
        │               ├──── steps
        │               │    
        │               ├──── pages
        │               │      ├─── popup
        │               │      │    PopupPage1
        │               │      │    ...
        │               │      │    PopupPageN
        │               │      └─── tab
        │               │           TabPage1
        │               │           ...
        │               │           TabPageN
        │               │     Page1
        │               │     ...
        │               │     PageN             
        │               │     
        │               └──── playwright
        │
        └───resources
              │
              ├─── features
              │    test_1.feature
              │    ...
              │    test_N.feature
              │ 
              └─── pages
                   page-1.properties
                   ...
                   page-N.properties              
              allure.properties
              application.properties
              cucumber.properties
              junit-platform.properties
              logback-test.xml     


```
### How to clean old run
```
mvn clean 
```

### How to run tests

```
mvn clean verify
```

### How to show allure report
```
allure serve -h target/allure-results

```

### How to show cucumber report
```
Just open in Browser file  ../target/CucumberReport.html
```

* [Junit5](https://junit.org/junit5/docs/current/user-guide/#overview)
* [Cucumber](https://cucumber.io/docs/cucumber/)
* [Playwright](https://playwright.dev/java/docs/intro)
* [Allure](https://allurereport.org/docs/)


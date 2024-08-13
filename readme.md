# Playwright demo TAF (test automation framework)
<img src="https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/52b31b88-8996-47eb-a8ef-551fae1d70e6" width="100" height="100">

### Qualification task for WA.Technology 
<img src="https://github.com/user-attachments/assets/916e42ef-6c0a-40a4-93b3-8bb7e02cec73" width="300" height="100">


## TABLE OF CONTENT
* [Technology stack](#technology-stack)
* [Allure report](#allure-report)
* [Report pages](#report-pages)
* [Test execution log in console](#test-execution-log-in-console)
* [Project structure](#Project-structure)
* [How to](#how-to)
* [Reference Documentation](#Reference-Documentation) 

## Technology stack
| GitHub | IDEA | Java | Junit5 | Maven | Playwright | Allure | 
|:-----:|:-----:|:----:|:------:|:-----:|:---------:|:--------:|
|<img src="https://user-images.githubusercontent.com/38681283/120561870-048f0480-c40e-11eb-9ff8-c155f9d617c4.png" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> |<img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://github.com/user-attachments/assets/4403360a-0e50-4201-9b60-ed1584bd9eaa" width="40" height="40"> |<img src="https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/52b31b88-8996-47eb-a8ef-551fae1d70e6" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40">|

## Allure report
![image](https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/8d334665-af01-42b9-be82-437a4c1d438d)

## Report pages
![image](https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/9655631d-93ca-40a0-bd98-fe2d42c1f3cc)
![image](https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/0fe55c65-2db7-4119-9828-9928a2684b29)
![image](https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/85c84531-6555-4a5a-9d3f-36c7f9238cbc)
![image](https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/b66fb1e7-2ddb-4c2a-8863-01fc3f32e846)

## Test execution log in console
![image](https://github.com/user-attachments/assets/65e7b9df-c7e7-413c-9e50-28c14de666ec)

### Project structure:
```text
└──src
    ├─ main
    │     └─── java
    │            └─ wa
    │                └─ demo
    │                   Application   
    └─ test
        ├─ java
        │   └─ wa
        │       └───── demo   
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
        └── resources
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
### How to:
#### - clean old run
```
mvn clean 
```
#### - run tests
```
mvn clean verify
```
#### - generate allure report
```
allure serve -h target/allure-results
```
#### - show cucumber report
```
Just open in Browser file  ../target/CucumberReport.html
```
## Reference Documentation
For further reference, please consider the following sections:
* [Junit5](https://junit.org/junit5/docs/current/user-guide/#overview)
* [Cucumber](https://cucumber.io/docs/cucumber/)
* [Playwright](https://playwright.dev/java/docs/intro)
* [Allure](https://allurereport.org/docs/)

[![Telegram](https://img.shields.io/badge/-Telegram-0b0a1a?style=for-the-badge&logo=telegram&logoColor=27A0D9)](https://t.me/yuriy_logvinov)

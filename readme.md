# Playwright demo TAF (test automation framework)
<img src="https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/52b31b88-8996-47eb-a8ef-551fae1d70e6" width="100" height="100">

### Assesment task
<img src="https://github.com/user-attachments/assets/916e42ef-6c0a-40a4-93b3-8bb7e02cec73" width="400" height="100">


## TABLE OF CONTENT
* [Technology stack](#technology-stack)
* [Allure report](#allure-report)
* [Cucumber report](#cucumber-report)
* [Test execution log in console](#test-execution-log-in-console)
* [Project structure](#Project-structure)
* [How to](#how-to)
* [Reference Documentation](#Reference-Documentation) 

## Technology stack
| GitHub | IDEA | Java | Junit5 | Maven | Playwright | Allure | 
|:-----:|:-----:|:----:|:------:|:-----:|:---------:|:--------:|
|<img src="https://user-images.githubusercontent.com/38681283/120561870-048f0480-c40e-11eb-9ff8-c155f9d617c4.png" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> |<img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://github.com/user-attachments/assets/4403360a-0e50-4201-9b60-ed1584bd9eaa" width="40" height="40"> |<img src="https://github.com/xt4k/playwright-junit-allure-demo/assets/38681283/52b31b88-8996-47eb-a8ef-551fae1d70e6" width="40" height="40">|<img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40">|

## Allure report
![image](https://github.com/user-attachments/assets/aa40b1d3-7a36-4f49-958a-aabe40aafb15)
![image](https://github.com/user-attachments/assets/1afbc4f7-1d08-4a18-ba79-b267433e18e1)
![image](https://github.com/user-attachments/assets/70700a18-4e34-4ff7-bd4b-825704cc4be7)
![image](https://github.com/user-attachments/assets/dc50d4ad-0a36-4d11-94a9-08251168852c)
![image](https://github.com/user-attachments/assets/850cbac2-2984-4473-8698-f9f8a5b4c930)
![image](https://github.com/user-attachments/assets/f2cf54b9-d86f-4202-9011-b2eb7430e244)
![image](https://github.com/user-attachments/assets/b29ece7d-65af-4b34-a1e0-e2eccacaa020)



## Cucumber report
![image](https://github.com/user-attachments/assets/9eb69645-176b-4662-bd7f-aa55349eebf8)
![image](https://github.com/user-attachments/assets/98aa787c-0b0a-4bfb-901e-b0b8887589de)
![image](https://github.com/user-attachments/assets/e8399c86-da87-4e54-b50a-03f0334314c5)
![image](https://github.com/user-attachments/assets/61754e48-967d-4e3b-be8b-050306cee39d)







## Test execution log in console
<img src="https://github.com/user-attachments/assets/65e7b9df-c7e7-413c-9e50-28c14de666ec" width="600" height="400">


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

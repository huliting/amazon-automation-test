# amazon-automation-test
Note: This project base on JDK8, maven
### How to start automation test
```bash
mvn package
java -jar target/amazon-automation-test-1.0-SNAPSHOT-jar-with-dependencies.jar ${webDrivePath}
```
note: ${webDriverPath} is your local web driver location path. you can use the web driver in resources folder,but just apply for MAC OS, I have no time prepare for all platforms.<br>
note: it will generate a test_reports folder at root path. and there will generate a html test report. the test case at last will be error, that's an excepted result.
### code structure
Note: * is means it's a java file, else is package folder
>huliting.thoughtworks---------------this is root package<br>
>>scenario---------------------------all need auto test Cards put here<br>
>>>Card(\*)--------------------------Card interface, all cards implements it, has a public method autoTest()<br>
>>>Card001(\*)-----------------------this is one Card need test<br>

>>util-------------------------------put some common util class<br>
>>>BrowserManager(\*)----------------provider webdriver and control all browser behaviour<br>
>>>CardFactory(\*)-------------------manage all need test card, suppor getAllCard() method<br>
>>>Report(\*)------------------------this is a log util, manage all logs and cut screenshot.<br>

>>validators-------------------------assume each page have itself validator<br>
>>>common----------------------------some common validator put here (this project has no)<br>
>>>pages-----------------------------each pages' validator put here<br>
>>>>HomeValidator(\*)----------------home page, validate search and whether get correct result<br>
>>>>ShoppingCartValidator(\*)--------shorpping cart page, validate add item whether success<br>

>>Main(\*)---------------------------the executable jar program entrance

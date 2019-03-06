# Gmail Signup & Check Sending EmailTask
1. Tools & technologies: Java, Selenium, Maven, TestNG and also I used json to save test data and read from it.
2. pom.xml file: contains the dependencies I used it in my code
3. I've used Page Object Model designing the Script so the project is divided into two packages:-
-Src/main/java which contains 2 Packages:
*Package “data”: includes “data.json” file and “dataReader” class that reads the data from the json file so it to not to set the data hard coded in the script
*Package “GmailSignupTest”: includes “mainTest” class that contains the main script that runs the automated test case
4- Testng.xml file: to run the tests from it as automation test

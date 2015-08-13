To use SportsmenTesting framework you need to have installed: 
- jdk 1.7
- maven version 3.1.1 or above

To run tests you need to:
- open cmd
- change directory to SportsmenTesting
- execute command:
	mvn clean test

To generate report execute command:
	mvn site

You can find generated Allure report at:
\SportsmenTesting\target\site\allure-maven-plugin\index.html
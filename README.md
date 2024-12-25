This project is designed for automated website testing, including UI testing using Selenium and API testing using RestAssured.

Tecnology:
- program language: Java;
- UI testing tools: Selenium;
- API testing tools: RestAssured;
- test framework: JUnit;
- generate data tools: Faker framework, Random class
- build: Maven;
- logging: Log4j.


The project consists of 2 testing parts:
1. test.java.by.fixprice.api - automated tests for verifying the functionality of the API;
2. test.java.by.fixprice.ui - automated tests for checking the user interface.

main.java.by.fixprice.ui is created for UI testing and has the following packages:
1. driver: performs actions related to WebDriver class;
2. forms.login: responsible for actions and expectations in site login form;
3. pages contains additional folders providing to perform actions on corresponding pages: home, catalog, cart.

main.java,by.fixprice.api is made to perform API testing actions during login and contains the the following pacakges:
1. requests - to send request parametres;
2. responses - to verify response messages.

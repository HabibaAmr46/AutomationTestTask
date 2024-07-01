# Automate_Amazon_Egypt_Foodics API

## Packages and Classes

### src/main/java

This package contains the main classes of the project.

- **apis**:
   - **Requests.java**: Include post request to perform Login
   - **Specification.java**: Contains RequestSpecification and ResponseSpecification handling
   - **User.java**: POJO class for payload data
- **config**: 
  - **PropertiesFile.java**: Reading data from external property file
- **Pages**:
  - **CartPage.java**: Contains all the locators and their respective actions
  - **HomePage.java**: Contains all the locators and their respective actions
  - **Login.java**: Contains all the locators and their respective actions
- **Utility**:
  - **ElementMethods.java**: Include the neccesary waits to perform different actions on element(Click, SendKeys,...)

### src/test/java

This package contains test classes for the project.

- **APITests**:
   - **loginTests.java**: Include three different cases for login
- **GUI**:
   - **E2ETEST.java**: Include end to end scenario until checking cart items
   - **TestBase.java**: Include driver intialization

## Usage

To run the project, follow these steps:

1. Clone the repository.
2. Navigate to the project directory.
3. Add an active amazon account email and password in config.properties file
4. Make sure to add TESTNG Library to the project
5. Run the method in E2ETest class to run GUI Test.
6. Run the methods in loginTests.java to run API Tests.

Make sure you have Java Development Kit (JDK) installed on your system.

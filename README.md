# Andersen Labs Automation Task
## Task Given

1. Create an autotest that creates an account with a username having 2 characters https://try.vikunja.io/register. You can use any programming language and framework.
2. Create a README.md file with instructions how tо run the test.
3. Expected behaviour in negative flow: the field is highlighted in red a hint under the field is displayed "Username must have at least 3 characters"

## My Understanding/Interpretation
1. I should create an account with a username having 2 characters (ex: ab )
2. I should automate the test scripts for negative use cases as well.

## Found Application Bug
1. There is a bug in the application. We cannot create a username with 2 characters. The application accepts a minimum of 3 characters and a maximum of 250 characters
   Here is the error for this POST API endpoint - https://try.vikunja.io/api/v1/register observed in the Dev Network Tab
    ```JSON
    {
        "code": 2002,
        "message": "Invalid Data",
        "invalid_fields": [
        "username: ab does not validate as length(3|250)"
        ]
    }
    ```
   NOTE: if you still want me to create an account with 2 characters for the username. we can create in this way 'A'
2. The error message that you are expecting is "Username must have at least 3 characters". But the error message has been changed to "Invalid Data"

## How to Run Test cases
### Description:
I have used the **Page Object Model** concept to write the test cases and used **Maven** as a dependency management tool, **TestNG** as a Test Runner, and **Selenium** for Web Automation.

Execute following commands for Test execution
1. `mvn clean` - deletes the target directory
2. `mvn compile` - compiles the java code
3. `mvn test` - executed the test cases

## Evidence
Attached the execution video for reference - [Link](https://drive.google.com/file/d/12sj0Ak8RgDedDL3OWatFq8iJVULRuY7c/view?usp=sharing)
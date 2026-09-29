# OrangeHRM Automation Framework

# Project Overview

This project is a Selenium WebDriver automation framework developed for testing the OrangeHRM demo application. The framework follows the Page Object Model (POM) design pattern and includes reusable components, listeners, screenshots, and Extent Reports for detailed test reporting.

---------------------------------

# Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports

---------------------------------

# Framework Features

- Page Object Model (POM)
- Driver Factory
- Base Test
- Config Reader
- TestNG Listeners
- Extent Reports
- Automatic Screenshot on Test Failure
- Reusable Page Classes
- Cross-browser ready structure

---------------------------------

# Test Scenarios

- Valid Login
- Invalid Login
- Logout

---------------------------------

# Project Structure

```
src
└── test
    ├── java
    │   ├── base
    │   ├── factory
    │   ├── listeners
    │   ├── pages
    │   ├── reports
    │   ├── tests
    │   └── utils
    │
    └── resources
        └── config.properties
```

---------------------------------

# Test Reports

The framework generates **Extent HTML Reports** after each execution, including:

- Test execution summary
- Passed, Failed, and Skipped tests
- Execution time
- Failure details
- Automatic screenshots for failed tests

---------------------------------

# How to Run

1. Clone the repository

```bash
git clone https://github.com/AmrAbdalla74/OrangeHRM-Automation-Framework.git
```

2. Open the project in IntelliJ IDEA.

3. Install Maven dependencies.

4. Run the TestNG test class or `testng.xml`.

---------------------------------

# Future Improvements

- DataProvider with Excel/JSON
- Log4j Logging
- Allure Reports
- Jenkins Integration
- GitHub Actions
- Docker & Selenium Grid

---------------------------------

# Author

*Amr Abdallah*

- GitHub: https://github.com/AmrAbdalla74
- LinkedIn: *(www.linkedin.com/in/amr-abdalla-2b9778359)*

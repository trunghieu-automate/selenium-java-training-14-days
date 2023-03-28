# Day 1 - Introduction to Selenium WebDriver

## Overview of Selenium WebDriver

**Overview:**

- Selenium WebDriver is a popular tool for web automation testing.
- It interacts with web pages just like a user would by clicking on links, filling out forms, and submitting data.
- The tool provides a set of methods to interact with web pages, such as finding elements, sending keys, clicking, and more.
- It also allows you to wait for specific elements to appear on the page before performing an action.
- One of the main benefits of using Selenium WebDriver is that it can automate repetitive tasks, such as regression testing, which can save a lot of time and effort. It can also help ensure that your web application is functioning as expected across different browsers and platforms.

**Pros:**

- Open-source: Selenium WebDriver is an open-source tool, which means that it is freely available and can be used without any licensing costs.
- Cross-browser compatibility: Selenium WebDriver can be used to test web applications across multiple browsers, including Chrome, Firefox, Safari, and Internet Explorer.
- Multi-language support: Selenium WebDriver supports multiple programming languages, including Java, Python, C#, and Ruby, making it accessible to a wide range of developers.
- Extensibility: Selenium WebDriver can be extended to support custom functionality and integration with other tools.
- Community support: The Selenium WebDriver community is large and active, which means that there are plenty of resources available to help you get started and troubleshoot issues.

**Cons:**

- Steep learning curve: Selenium WebDriver can be challenging to learn, especially for beginners with little programming experience.
- Limited support for desktop applications: Selenium WebDriver is primarily designed for web automation testing and does not have much support for automating desktop applications.
- Requires a stable internet connection: Selenium WebDriver relies on a stable internet connection to communicate with the browser and the web application.

# Setting up the development environment and creating maven project with testNG

**We are going to create a maven project using intelliJ IDE for setting deployment environment.**

1. Install Java Development Kit (JDK): You'll need to download and install the latest version of the Java Development Kit from the Oracle website. Follow the instructions provided on the website to install JDK.

2. Install IntelliJ IDEA: Download and install the latest version of IntelliJ IDEA from the JetBrains website. Once you've installed IntelliJ, launch the program.

3. Create a new Maven project: In IntelliJ, click on "File" and then "New" to create a new project. Select "Maven" from the list of options and click "Next." Choose a group ID and artifact ID for your project, and click "Next." Choose a project name and location, and click "Finish."

4. Add Selenium WebDriver to your project: Open your project's pom.xml file, which is located in the root directory of your project.

5. Create a new Java class in following path: src\test\java with name “FirstTest.java”

6. Write your first Selenium test:

7. Run your test: In IntelliJ, right-click on your test class and select "Run FirstTest" Your test should launch the Chrome browser and navigate to the specified website.
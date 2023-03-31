# Day 14: WebDriver and Continuous Integration


## Introduction to Continuous Integration
Continuous Integration (CI) is the practice of automating the integration of code changes from multiple contributors into a single software project. It’s a primary DevOps best practice, allowing developers to frequently merge code changes into a central repository where builds and tests then run. Automated testing is critical to CI, as it verifies the correctness and quality of the code before integration. Automated testing also enables faster and more reliable delivery of software to users.
Some of the benefits of Continuous Integration and automation testing are:
- Faster feedback on code changes
- Reduced manual effort and human error
- Increased confidence and collaboration among developers
- Improved code quality and reliability
- Reduced deployment risks and costs
  Some of the tools that can help you implement Continuous Integration and automation testing are:
- Version control systems, such as Git, that allow you to manage and track code changes
- Continuous integration tools, such as Jenkins, Bamboo, or Azure DevOps, that automate the build and test process
- Testing frameworks and tools, such as JUnit, Selenium, or Cucumber, that enable you to write and run automated tests
- Code quality tools, such as SonarQube or Code Climate, that measure and report on code quality metrics

## Setting up Jenkins
Jenkins is a popular open source CI server that can help you automate the build and test process of your software projects. To set up Jenkins, you will need to have a version of Java supported by Jenkins installed on your system. You can install Jenkins in different ways, depending on your operating system and preferences. Some of the common methods are:

Using Docker: This is a convenient way to run Jenkins as a standalone application in a container. You will need to have Docker installed and running on your system. You can then create a bridged network for the Jenkins container to communicate on, pull the official Jenkins image from Docker Hub, and run it with the appropriate ports and volumes.
Using Linux: You can install Jenkins on Linux using the native package manager of your distribution, such as apt or yum. You will need to add the Jenkins repository to your system and then install the jenkins package. You can then start and stop the Jenkins service using systemctl or service commands.
Using macOS: You can install Jenkins on macOS using Homebrew, a package manager for macOS. You will need to have Homebrew installed and then run brew install jenkins-lts command. You can then start and stop the Jenkins service using brew services command.
Using Windows: You can install Jenkins on Windows using the Windows installer, which is available from the Jenkins website. You will need to download and run the installer, which will guide you through the installation process. You can then start and stop the Jenkins service using the Services app or the command line.
After installing Jenkins, you will need to perform some initial settings, such as creating an admin user, choosing plugins, and configuring security. You can access the Jenkins web interface by visiting http://localhost:8080 (or http://your-server-ip:8080 if you are installing on a remote server) in your browser.

## Running Selenium WebDriver tests on Jenkins
To run Selenium TestNG Maven project on Jenkins, you will need to have Jenkins and Maven installed and configured on your system. You will also need to have a Selenium TestNG Maven project that contains your test scripts and a pom.xml file that defines the dependencies and plugins for your project. You can then follow these steps to set up Jenkins to run your project:

Create a new Jenkins job by clicking on New Item on the Jenkins dashboard. Enter a name for your job and select Freestyle project as the type. Click OK to proceed.
In the job configuration page, go to the Source Code Management section and select Git as the option. Enter the URL of your Git repository that contains your Selenium TestNG Maven project. You can also specify the branch and credentials if needed.
In the Build section, click on Add build step and select Invoke top-level Maven targets as the option. Enter clean test as the Goals and specify the path to your pom.xml file in the POM field. This will tell Jenkins to run Maven with the clean and test goals, which will delete any previous build output and run your TestNG tests.
Optionally, you can also configure other settings for your job, such as Build Triggers, Post-build Actions, Notifications, etc. For example, you can use the TestNG Results plugin to display the test results on the Jenkins dashboard, or use the Email Notification plugin to send an email with the test report after each build.
Click on Save to save your job configuration. You can then click on Build Now to trigger a build manually, or wait for a scheduled or triggered build based on your settings.
After each build, you can view the Console Output to see the details of the Maven execution and the TestNG results. You can also view the TestNG Reports if you have installed the TestNG Results plugin.


## demo running a maven selenium testNG on github Actions CI server
@source code [day14](src/test/java/day14)
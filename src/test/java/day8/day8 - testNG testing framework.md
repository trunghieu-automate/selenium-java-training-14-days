# Day 8: Testing frameworks in Selenium WebDriver

## Introduction to testing frameworks (TestNG)

TestNG is a testing framework for Java applications that facilitates automated testing and simplifies the process of
creating and running test cases. It supports a variety of testing methods such as unit, functional, integration, and
end-to-end testing.

*Pros of using TestNG*:

- It supports annotations, which makes it easy to write and organize tests.
- It allows for test case prioritization, grouping, and parallel execution, which can save time and improve test
  efficiency.
- It provides reporting features that generate detailed test results, making it easier to identify and fix issues.
- It integrates with build tools like Maven and Ant, making it easy to include test cases in the build process.

*Cons of using TestNG*:

- It may have a steeper learning curve than other testing frameworks.
- It may not be as widely used as other frameworks, which can make it harder to find resources and support.
- It requires Java programming knowledge to use effectively.

## Most uses annotations:

Here are some of the most commonly used annotations in TestNG:

`@Test`: This is used to mark a method as a test method. TestNG will execute all methods annotated with @Test as test
cases.

`@BeforeSuite`: This is used to specify actions that should be taken before the entire test suite is run.

`@AfterSuite`: This is used to specify actions that should be taken after the entire test suite has been run.

`@BeforeTest`: This is used to specify actions that should be taken before any test method is run.

`@AfterTest`: This is used to specify actions that should be taken after all test methods have been run.

`@BeforeClass`: This is used to specify actions that should be taken before any test method in a particular class is
run.

`@AfterClass`: This is used to specify actions that should be taken after all test methods in a particular class have
been run.

`@BeforeMethod`: This is used to specify actions that should be taken before each test method is run.

`@AfterMethod`: This is used to specify actions that should be taken after each test method has been run.

`@DataProvider`: This is used to specify a method that provides test data to a test method. The test method can then use
this data to run multiple test cases.

`@Parameters`: This is used to specify parameters that are passed to a test method.

`@Listeners`: This is used to specify listeners that should be notified when test events occur.

## testNG annotations usages

1. `@Parameters`

```java
@Test
@Parameters({"username", "password"})
public void loginTest(String username,String password){
    // Test code that uses the username and password parameters
}
// value will be set at testNG.xml
```

2. `@Listeners`

```java

@Listeners(MyTestListener.class)
public class MyTest {
    // Test methods
}
```

3. Test Grouping:

```java
@Test(groups = {"smoke"})
public void smokeTest(){
    // Test code for smoke test
}


@Test(groups = {"regression"})
public void regressionTest() {
    // Test code for regression test
}
```
4. `Test Skip`
```java
@Test
public void test1() {
   // Test code for test1
}

@Test(enabled = false)
public void test2() {
    // Test code for test2 that will be skipped
}
// In this example, the test2 method is disabled using the enabled=false attribute, so it will not be executed during test runs.
```
5. Test Priority:
```java
@Test(priority = 1)
public void test1() {
   // Test code for test1
}

@Test(priority = 2)
public void test2() {
    // Test code for test2
}
// In this example, the tests are given priority levels of 1 and 2. 
// TestNG will execute tests in order of priority, so test1 will be executed before test2.
```
6. `Running Order`
```java
@Test(priority = 1)
public void test1() {
    // Test code for test1
}

@Test(priority = 2, dependsOnMethods = {"test1"})
public void test2() {
    // Test code for test2
}

@Test(priority = 3)
public void test3() {
    // Test code for test3
}
// In this example, test2 depends on test1 using the dependsOnMethods attribute, so test1 will be executed before test2.
// TestNG will then execute test3, which is not dependent on any other test.
```
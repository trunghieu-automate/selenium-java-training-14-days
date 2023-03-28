# Day 9: testNG configuration

The TestNG XML file is a configuration file that allows you to specify the tests, test classes, test groups, test
suites, and other configurations for TestNG. You can use this file to specify the test configuration and parameters
without modifying the test code.
Here's an example of a TestNG XML file:

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="My Test Suite">
    <test name="My Test">
        <classes>
            <class name="com.example.tests.MyTest1"/>
            <class name="com.example.tests.MyTest2"/>
        </classes>
        <groups>
            <run>
                <include name="smoke"/>
                <exclude name="slow"/>
            </run>
        </groups>
        <parameters>
            <parameter name="username" value="testuser"/>
            <parameter name="password" value="testpass"/>
        </parameters>
    </test>
</suite>
```

In this example, the TestNG XML file specifies a test suite called "My Test Suite" that includes a test called "My Test"
. The test includes two test classes, "MyTest1" and "MyTest2", and specifies that only tests in the "smoke" group should
be run, and tests in the "slow" group should be excluded. The file also specifies two parameters, "username" and "
password", with default values of "testuser" and "testpass", respectively.

To use the TestNG XML file, you can specify it in the TestNG configuration when you run your tests. For example, if your
TestNG XML file is named "testng.xml", you can run your tests using the following command:

java -cp testng.jar org.testng.TestNG testng.xml

This will run the tests specified in the "testng.xml" file using the TestNG framework. You can also configure your
TestNG XML file to use different settings, such as specifying test output directories, listeners, and more. The TestNG
documentation provides detailed information on the various configuration options available in the TestNG XML file.

This is the another way to run test while using testNG

# Run specific specific test class by maven plugin and testNG.xml file

You config testNG.xml file that has 2 tests with name is `demo-test-1` and `demo-test-2`

```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="demo-suite">
    <test name="demo-test-1">
        <classes>
            <class name="tests.MyTest1"/>
        </classes>
    </test>
    <test name="demo-test-2">
        <classes>
            <class name="tests.MyTest2"/>
        </classes>
    </test>
</suite>
```
In pom.xml, let config like this:
```xml
<build>
    <pluginManagement>
        <plugins>
            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testNG.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <properties>
                        <property>
                            <name>testnames</name>
                            <!--suppress UnresolvedMavenProperty -->
                            <value>${testName}</value>
                        </property>
                    </properties>
                </configuration>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```
sample command to run demo-test-1
```cmd
mvn clean test -DtestName=demo-test-1
```

sample command to run demo-test-2
```cmd
mvn clean test -DtestName=demo-test-2
```

sample command to run both test
```cmd
mvn clean test -DtestName=demo-test-1,demo-test-2
```
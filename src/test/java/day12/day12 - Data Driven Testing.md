# Day 12: WebDriver and Data Driven Testing

## Introduction to data-driven testing
- Data-driven testing in Selenium WebDriver Java refers to a technique where test data is stored separately from the test script, and the script reads data from external sources like Excel sheets, CSV files, databases, or XML files during runtime. This approach allows testers to run the same test with different sets of data, which helps in testing different scenarios without modifying the test code.

- In data-driven testing, testers write test scripts to read data from external sources, then use that data to drive the test execution. For example, if we are testing a login page, we can write a script that reads data from an Excel sheet with multiple sets of login credentials, and then uses those credentials to log in to the application.

- Data-driven testing helps testers to achieve better test coverage, reduces the amount of code they need to write, and makes their test scripts more maintainable. It also allows them to easily run the same test with different sets of data, which is useful for testing different scenarios and handling various edge cases.


## Reading data from different sources (Excel, CSV, XML)
`*Reading data from Excel:*`
To read data from an Excel file, you need to use a library like Apache POI. Here's a sample code snippet to read data from an Excel sheet using POI:
```java
// Import required classes from POI library
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

// Create a workbook object from an Excel file
FileInputStream file = new FileInputStream("testdata.xlsx");
Workbook workbook = WorkbookFactory.create(file);

// Get the first sheet from the workbook
Sheet sheet = workbook.getSheetAt(0);

// Loop through rows and columns to read data
for (Row row : sheet) {
    for (Cell cell : row) {
        String value = cell.getStringCellValue();
        System.out.print(value + "\t");
    }
    System.out.println();
}

// Close the workbook and file objects
workbook.close();
file.close();
```

`*Reading data from CSV:*`
To read data from a CSV file, you can use a library like OpenCSV. Here's a sample code snippet to read data from a CSV file using OpenCSV:
```java
// Import required classes from OpenCSV library
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

// Create a CSVReader object from a CSV file
CSVReader reader = new CSVReader(new FileReader("testdata.csv"));

// Read data from the CSV file
String[] record;
while ((record = reader.readNext()) != null) {
    for (String field : record) {
        System.out.print(field + "\t");
    }
    System.out.println();
}
// Close the reader object
reader.close();
```

`*Reading data from XML:*`
To read data from an XML file, you can use a library like JAXB or DOM4J. Here's a sample code snippet to read data from an XML file using DOM4J:

```java
// Import required classes from DOM4J library
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

// Create a SAXReader object to read the XML file
SAXReader reader = new SAXReader();
Document document = reader.read(new File("testdata.xml"));

// Get the root element of the XML document
Element root = document.getRootElement();

// Get a list of child elements under the root element
List<Element> childElements = root.elements();

// Loop through child elements to read data
for (Element child : childElements) {
// Get the value of a specific node within the child element
Node node = child.selectSingleNode("node1");
String value = node.getText();
System.out.println(value);
}

// Close the reader object
reader.close();
```
## writing data-driven test cases

Step to produce data-driven test cases in Selenium WebDriver Java
1. Identify the test scenario: The first step is to identify the test scenario that you want to automate using data-driven testing. For example, if you want to test a login page with multiple sets of login credentials.
2. Create a data source: Next, you need to create a data source that will contain the test data. You can use a spreadsheet like Excel or a CSV file for this purpose.
3. Initialize the WebDriver: In your test script, you need to initialize the WebDriver and navigate to the login page.
4. Read data from the data source: Use the appropriate library to read data from the data source, such as Apache POI for Excel or OpenCSV for CSV. Iterate through the data rows and extract the necessary data for the test case.
5. Perform the test actions: Perform the test actions using the extracted data. For example, enter the username and password from the data source into the login form and submit the form.
6. Verify the test result: Verify the test result based on the expected outcome. For example, check if the login was successful or if an error message was displayed.
7. Repeat for all test data: Repeat steps 4 to 6 for all test data in the data source.
8. Generate the test report: Once the test execution is complete, generate a test report that summarizes the test results and any issues that were encountered.


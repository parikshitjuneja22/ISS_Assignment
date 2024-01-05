import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

class XMLParser {
    public static void main(String[] args) throws Exception {
        // Initialize XML parsing components
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        // Load the XML file
        Document xmlDocument = docBuilder.parse(new File("sample.xml"));
        
        // Normalize the XML structure for easy traversal
        xmlDocument.getDocumentElement().normalize();
        
        // Retrieve the root element
        Element rootElement = xmlDocument.getDocumentElement();
        System.out.println("Root Element: " + rootElement.getNodeName());
        
        // Extract elements with the tag name "employee"
        NodeList employeeList = xmlDocument.getElementsByTagName("employee");
        
        // Iterate through each "employee" element
        for (int index = 0; index < employeeList.getLength(); index++) {
            Node employeeNode = employeeList.item(index);
            System.out.println("\nEmployee Details: ");
            
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNode;
                
                // Extract and display employee attributes and details
                System.out.println("Employee ID: " + employeeElement.getAttribute("id"));
                System.out.println("First Name: " + employeeElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Last Name: " + employeeElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Department: " + employeeElement.getElementsByTagName("department").item(0).getTextContent());
            }
        }
    }
}

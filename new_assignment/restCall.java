package new_assignment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

// Define the classes for the two-level JSON structure
class InnerObject {
    private String innerField;

    public InnerObject(String innerField) {
        this.innerField = innerField;
    }

    public String getInnerField() {
        return innerField;
    }
}

class OuterObject {
    private String outerField;
    private InnerObject innerObject;

    public OuterObject(String outerField, InnerObject innerObject) {
        this.outerField = outerField;
        this.innerObject = innerObject;
    }

    public String getOuterField() {
        return outerField;
    }

    public InnerObject getInnerObject() {
        return innerObject;
    }
}

class Main {

    public static void main(String[] args) {
        // Create instances of the two-level JSON structure
        InnerObject innerObject = new InnerObject("InnerValue");
        OuterObject requestObject = new OuterObject("OuterValue", innerObject);

        // Set up headers and RestTemplate
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        RestTemplate restTemplate = new RestTemplate();

        // Set up the REST endpoint URL
        String apiUrl = "https://example.com/api/endpoint";

        // Create an HttpEntity with the requestObject and headers
        HttpEntity<OuterObject> requestEntity = new HttpEntity<>(requestObject, headers);

        // Make the REST call
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);

        // Print the response
        System.out.println("Response: " + responseEntity.getBody());
    }
}

import org.json.JSONObject;

class Main {
    public static void main(String[] args) {
        // Creating a JSON Object
        JSONObject obj = new JSONObject();
        obj.put("bookName", "Harry Potter");
        obj.put("authorName", "J K Rowling");

        // To convert JSONObject to String
        String jsonString = obj.toString();
        System.out.println("JSON Object: " + jsonString);

        // For parsing JSON String to JSONObject
        JSONObject parsedObj = new JSONObject(jsonString);
        System.out.println("Parsed Book Name: " + parsedObj.getString("bookName"));
    }
}
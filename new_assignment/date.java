package new_assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Main {
    public static void main(String[] args) {
        String originalDateString = "2022-01-06"; // YYYY-MM-DD format

        // Specify the format of the original date string
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Specify the desired format
        SimpleDateFormat desiredFormat = new SimpleDateFormat("dd/MM/yyyy"); // DD/MM/YYYY format

        try {
            // Convert the original date string to a Date object using the original format
            Date date = originalFormat.parse(originalDateString);

            // Format the Date object to the desired format
            String formattedDate = desiredFormat.format(date);

            // Print the formatted date
            System.out.println("Original Date: " + originalDateString);
            System.out.println("Formatted Date: " + formattedDate);

        } catch (ParseException e) {
            System.out.println("Error occurred while parsing the date: " + e.getMessage());
        }
    }
}

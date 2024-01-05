class Example {
    public static void main(String[] args) {
        try {
            // Throw an exception
            throw new Exception("This is an example exception");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        try {
            // Call a method that throws an exception
            methodThatThrows();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void methodThatThrows() throws Exception {
        throw new Exception("This is another example exception");
    }
}

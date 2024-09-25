public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        // Create messages for user1
        Message message1 = new Message(user1, "Hello Alice! This is your first message.");
        Message message2 = new Message(user1, "Hi Alice! Hope you're doing well.");
        Message message3 = new Message(user1, "Alice, don't forget the meeting tomorrow!");

        // Add messages to user1's inbox
        boolean added1 = user1.addMessage(message1);
        boolean added2 = user1.addMessage(message2);
        boolean added3 = user1.addMessage(message3);

        // Check if the messages were added successfully
        System.out.println("Message 1 added to user1's inbox: " + added1); // Expected: true
        System.out.println("Message 2 added to user1's inbox: " + added2); // Expected: true
        System.out.println("Message 3 added to user1's inbox: " + added3); // Expected: true

        // Read and print messages from user1's inbox
        System.out.println("\nReading messages from User1's inbox:");

        // Read the first message
        String readMessage1 = user1.readMessage();
        System.out.println("First message read: " + readMessage1);

        // Read the second message
        String readMessage2 = user1.readMessage();
        System.out.println("Second message read: " + readMessage2);

        // Read the third message
        String readMessage3 = user1.readMessage();
        System.out.println("Third message read: " + readMessage3);

        // Attempt to read a message when the inbox is empty
      //  String readMessage4 = user1.readMessage();
        //System.out.println("Attempt to read when inbox is empty: " + readMessage4); // Expected: "There is no message to read!"

        user1.readAll();
    }
}

import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    private static List<String> messages = new ArrayList<>();

    public static void publish(String message) {
        messages.add(message);
        System.out.println("New message published: " + message);
    }

    public static List<String> getMessages() {
        List<String> currentMessages = new ArrayList<>(messages);
        messages.clear();
        return currentMessages;
    }
}

package org.example.lab.forTestLab;

public class GreetingService {
    private MessageProvider messageProvider;
    public GreetingService(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        String message = messageProvider.getMessage();
        return message + ", " + name;
    }
}

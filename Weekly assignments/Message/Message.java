public class Message{

    private User receiver; //user that receives the message
    private String text; // the text of a message
    
    
    
    public Message(User receiver, String text) {
        this.receiver = receiver;
        this.text = text;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }


    
}


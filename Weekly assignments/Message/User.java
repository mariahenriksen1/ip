public class User {
    
    private String name; //name of the user
    private Message[] inbox; // inbox of a user that has a fixed size
    private int messageCount; //numb of received messages in the inbox
   
   
    public User(String userName) {
        this.name = userName;
        this.inbox = new Message[20]; //initials to 20
        this.messageCount = 0; //

    }

    public boolean addMessage(Message msg){

        if(messageCount < inbox.length){
            inbox[messageCount] = msg;
            messageCount++;
            return true;

        }else{
            return false;
        }

    }

    public String readMessage(){
        if(messageCount > 0){
            String read = inbox[0].getText();
            for(int i= 0; i< messageCount -1; i++){
                inbox[i] = inbox[i+1];
            }
            messageCount --;
            return read;
        }else{
            return "There is no message to read!";
        }
        
    }

    public void readAll(){
        while (messageCount > 0) {
        System.out.println(readMessage());
    }

        }
    }


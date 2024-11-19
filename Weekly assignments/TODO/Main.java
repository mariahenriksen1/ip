public class Main {

    public static void main(String[] args) {
        
    Todo todo = new Todo();

    todo.addTask("Do the laundry", 2, 45);
    todo.addTask("Buy groceries", 1, 30);
    todo.addTask("Study for the exam", 3, 60);
    todo.addTask("Study for the IP", 3, 20);

     
    todo.print();

   // todo.completeTask(2);
    //todo.print();

    //todo.printPriority(1);

    todo.printPrioritized();
    }
    
}

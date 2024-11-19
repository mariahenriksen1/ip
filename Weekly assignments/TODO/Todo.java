import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Todo {
    
    private List<Task>todo;
    private int totalWorkload;


    public Todo() {
        todo = new ArrayList<>();
        totalWorkload = 0;
    }

    public void addTask(String description, int priority, int minutes){
        boolean error = false;


        if(priority < 1 || priority > 4){
            System.out.println(  description + " has invalid priority");
            error = true;
        }
        if (minutes < 0) {
            System.out.println( description+ " has invalid workload");
            error = true;
        }
        if(error){
            return;
        }else todo.add(new Task(description, priority, minutes));
        }


    public void print(){
        System.out.println("Todo:");
        System.out.println("-----");

        if(todo.isEmpty()){
            System.out.println("You're all done for today! #TodoZero");
        
        }else{
            for (Task task : todo) {
                System.out.println(task.toString());;
            }
        }

        if(totalWorkload > 0){
            System.out.println( totalWorkload + " minutes of work done!");

        }

    }


    public void completeTask(int index){
        if(index < 0 || index >= todo.size()){
            System.out.println("Invalid index");
        }else{
            totalWorkload = totalWorkload + todo.get(index).getWorkload();
            todo.remove(index);
        }
    }
    
    public void printPriority(int limit){
        System.out.println("Filtered todo:");
        System.out.println("--------------");

        boolean nothingprinted = true;

        for (Task task : todo) {
            if(task.getPriority() <= limit){
                System.out.println(task.toString());
                nothingprinted = false;

            }
        }

        if(nothingprinted){
            System.out.println("No tasks with given priority");
        }
    }

    public void printPrioritized(){
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");


        Comparator<Task>prioritize = Comparator.comparingInt(Task::getPriority).thenComparing(Task::getWorkload);
        todo.sort(prioritize);

        for (Task task : todo) {
            System.out.println(task.toString());
            
        }
    }

}

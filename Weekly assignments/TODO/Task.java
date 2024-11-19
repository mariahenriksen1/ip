public class Task{

    private String description;
    private int priority; //1 = very important, 2= important, 3 = unimportant, 4= after learn Portuguese
    private int workload; //time in minutes


    
    public Task(String description, int priority, int workload) {
        this.description = description;
        this.priority = priority;
        this.workload = workload;
    }



    public int getPriority() {
        return priority;
    }


    public int getWorkload() {
        return workload;
    }

    public String toString(){
        return description + " takes " + workload + " minutes and has priority " + translatepriotity(priority);
        
    }

    public String translatepriotity(int priority){
        return switch(priority){
            case 1 -> "very important";
            case 2 -> "important";
            case 3 -> "unimportant";
            case 4 -> "after learn Portuguese";

            default -> "not in range";
        };

    }
}
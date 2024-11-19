import java.util.ArrayList;
import java.util.List;

class Pizza extends Food{

protected List<String>toppings;

public Pizza() {
    super("Pizza", 45);
    this.toppings = new ArrayList<>();
    //TODO Auto-generated constructor stub

}

public void addTopping(String topping){
    toppings.add(topping);
     price+=10;
    
}

public void setName(String name){
    super.name = name;
}



@Override
public void display(){
String separator = "";
   super.display();
if(toppings.isEmpty()) {
    System.out.print(" { }");
}

else{
    System.out.print(" { ");
   for (String topping : toppings) {
    System.out.print(separator);
    System.out.print(topping);
    separator = ", ";
    
   }

   System.out.print(" }");
}

}
}

import java.util.ArrayList;
import java.util.List;

public class Order {

    protected List<Food>ordered;
    
public Order(){
    ordered = new ArrayList<>();
}

public void addFood(Food food){
    ordered.add(food);
    
}
    
public int total(){
    int totalPrice = 0;
    for (Food food : ordered) {
        totalPrice = totalPrice + food.getPrice();
    }
    return totalPrice;
}



    

public boolean payWith(CreditCard card){
int amount = total();
boolean succes = card.withdraw(amount);

if(!succes){
    System.out.println("ERROR: Payment failed");
}
return succes;


}
public void display(){
    for (Food food : ordered) {
        food.display();
        System.out.println();
    }
    System.out.println(total() + " kr TOTAL");
        

}
}
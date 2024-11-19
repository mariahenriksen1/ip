public class main {

    public static void main (String []args){

        Pizza p1 = new Pizza();
        Pizza p2 = new Pizza();

    
        p1.addTopping("skinke");
        p1.addTopping("cocktail pøller");
        p1.addTopping("dres");
    
        p2.addTopping("okse");
        p2.addTopping("pep");
    
    
        Order order = new Order();
        order.addFood(p2);
        order.addFood(p1);
        order.display();
    }
    
    }
    

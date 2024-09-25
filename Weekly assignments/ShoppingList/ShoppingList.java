import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList{

//using treeMap because it needs to be sorted alfabetically 
    TreeMap<String, Integer> shoppingList;
    TreeMap<String, Integer> available;
        

public ShoppingList(){
    shoppingList = new TreeMap<>();
    available = new TreeMap<>();

}

//The read() method uses a Scanner to read input from the user. 
//It differentiates between available ingredients and recipe ingredients using the mapPointer variable.
public void read(){
Scanner scanner = new Scanner(System.in);
String ingredient; // Temporary variable to store each line of input

String mapPointer = ""; // This will help us know if we're reading AVAILABLE or RECIPE sections

String name;
String unit;
int amount;


while(scanner.hasNextLine() && !(ingredient  = scanner.nextLine()).isEmpty()){
    String[] ingredientSplit = ingredient.split(" "); //The ingredientSplit array is created by splitting each input line based on spaces. It contains the quantity, unit, and ingredient name.



    //The switch statement is used to determine if the input is switching from "AVAILABLE" to "RECIPE" or vice versa. 
    //This helps to separate the available ingredients from the recipe ingredients.
    switch (ingredientSplit[0]) {
        case ("AVAILABLE"), ("RECIPE"):
            mapPointer = ingredientSplit[0];
            break;  // Always break after the switch
    

    default:
    amount = Integer.parseInt(ingredientSplit[0]);  // First part is the quantity
    unit = ingredientSplit[1];  // Second part is the unit (g or kg)
    name = ingredientSplit[2];  // Third part is the ingredient name

    if ("kg".equals(unit)) {
        amount *= 1000;  // Convert kilograms to grams
    }


    if (mapPointer.equals("AVAILABLE")) available.put(name, amount);  // Add the available ingredient to the available map
    else {  // If we're in the RECIPE section
    if (available.containsKey(name)) {  // Check if we have the ingredient at home
        int availableAmount = available.get(name) - amount;  // Subtract the required amount

        if (availableAmount >= 0) {
            available.replace(name, availableAmount);  // If we still have some left, update available
        } else {
            shoppingList.put(name, -availableAmount);  // Add the missing amount to the shopping list
            available.remove(name);  // Remove the ingredient if none is left
        }
    }
    // If we don't have the ingredient, check if it's already in the shopping list
    else if (shoppingList.containsKey(name)) {
        amount = shoppingList.get(name) + amount;  // Update the quantity in the shopping list
        shoppingList.replace(name, amount);
    }
    // If the ingredient is neither available nor in the shopping list, add it to the shopping list
    else {
        shoppingList.put(name, amount);
    }
}
    }
}
}
public void printShoppingList(){
System.out.println("Shopping List:");

for (String name : shoppingList.keySet()) {
    int amount= shoppingList.get(name);
    System.out.println(amount + " g " + name);
}

}

}

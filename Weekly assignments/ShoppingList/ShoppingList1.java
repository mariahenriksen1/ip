import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList1 {
    private TreeMap<String, Integer> available;
    private TreeMap<String, Integer> shoppingList;

    // Constructor
    public ShoppingList1() {
        available = new TreeMap<>();
        shoppingList = new TreeMap<>();
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("AVAILABLE")) {
                while (!(line = scanner.nextLine()).startsWith("RECIPE")) {
                    processAvailableIngredient(line);
                }
            }

            if (line.startsWith("RECIPE")) {
                processRecipe(scanner);
            }
        }
    }

    public void processAvailableIngredient(String line) {
        String[] parts = line.split(" ");
        int amount = Integer.parseInt(parts[0]);
        String unit = parts[1];
        String ingredient = parts[2];

        if (unit.equals("kg")) {
            amount *= 1000;
        }

        available.put(ingredient, amount);
    }

    public void processRecipe(Scanner scanner) {
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");
            int amount = Integer.parseInt(parts[0]);
            String unit = parts[1];
            String ingredient = parts[2];

            if (unit.equals("kg")) {
                amount *= 1000;
            }

            int availableAmount = available.getOrDefault(ingredient, 0);
            if (amount > availableAmount) {
                int neededAmount = amount - availableAmount;
                shoppingList.put(ingredient, shoppingList.getOrDefault(ingredient, 0) + neededAmount);
            }
        }
    }

    public void printShoppingList() {
        System.out.println("Shopping List:");

        if (shoppingList.isEmpty()) {
            return;
        }

        for (String ingredient : shoppingList.keySet()) {
            System.out.println(shoppingList.get(ingredient) + " g " + ingredient);
        }
    }

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.read();
        shoppingList.printShoppingList();
    }
}

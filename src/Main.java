import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are in your group: ");
        int groupNum = scan.nextInt();
        System.out.print("What's the tip percentage? (0-100): ");
        int tipNum = scan.nextInt();
        double cost = 0;
        String[] itemList = new String[10000]; // makes an array to save the names of the items entered so they can be printed later, learned from https://www.w3schools.com/java/java_arrays.asp
        int index = 0;

        TipCalculator calculator = new TipCalculator(groupNum, tipNum);

        while (cost != -1) {
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): "); // repeatedly asks for cost and item names until the user enters -1
            cost = scan.nextDouble();
            scan.nextLine();
            calculator.addMeal(cost);
            if (cost != -1) {
                System.out.print("Enter the item: ");
                String itemName = scan.nextLine();
                itemList[index] = itemName + ": $" + String.format("%.2f", cost); // changes number to the hundredths, learned from https://stackoverflow.com/questions/2538787/how-to-print-a-float-with-2-decimal-places-in-java#:~:text=In%20short%2C%20the%20%25.,the%20format%20specifier%20(%20%25%20).
                index += 1;
            }
        }
        calculator.addMeal(1);

        System.out.println("---------------------------------------------------"); // displays all the different prices
        System.out.println("Total price: $" + String.format("%.2f",calculator.getTotalBillBeforeTip()));
        System.out.println("Tip percentage: " + calculator.getTipPercentage() + "%");
        System.out.println("Total tip amount: $" + String.format("%.2f",calculator.tipAmount()));
        System.out.println("Total bill after tip: $" + String.format("%.2f",calculator.totalBill()));
        System.out.println("Per person cost before tip: $" + String.format("%.2f",calculator.perPersonCostBeforeTip()));
        System.out.println("Per person tip cost: $" + String.format("%.2f",calculator.perPersonTipAmount()));
        System.out.println("Total cost per person: $" + String.format("%.2f",calculator.perPersonTotalCost()));
        System.out.println("---------------------------------------------------");
        System.out.println("Items ordered: ");

        for (String orders : itemList) { // prints out the names of the items and stops after the limit of the items is reached
            if (orders != null) {
                System.out.println(orders);
            }
        }
    }
}
import java.util.Scanner;

public class QUIAMBAO {

    public static void main(String[] args){
        Item item = new Item();
        Scanner scan = new Scanner(System.in);

        String productName;
        double priceUnit;
        int quantity, allProductQuantity, cash;
        String choose;

        while(true) {
            System.out.print("Enter item: ");
            productName = scan.nextLine();

            System.out.print("Enter price unit: ");
            priceUnit = scan.nextDouble();

            item.itemsWithUnitPrice(productName, priceUnit);

            System.out.print("Enter Quantity: ");
            quantity = scan.nextInt();

            allProductQuantity = item.getTotalQuantity(quantity);
            item.itemsWithQuantity(productName, quantity);


            System.out.print("Add another? (y/n):");
            choose = scan.next();
            if (choose.equalsIgnoreCase("n")){
                break;
            }
            scan.nextLine();

        }
        System.out.println("Total: " + item.getTotalPrice());
        System.out.print("Pay: ");
        cash = scan.nextInt();
        while(cash < item.getTotalPrice()){
            try {
                throw new ArithmeticException("Invalid amount!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                System.out.print("Pay again: ");
                cash = scan.nextInt();
            }
        }

        System.out.println("\nOFFICIAL RECEIPT");
        System.out.println("----------------------------------");
        for (String i : item.getitemsWithUnitPrice().keySet()) {
            System.out.printf("%-17s: ₱ %.2f%n", i.substring(0,1).toUpperCase() + i.substring(1).toLowerCase() , item.getPrice(i));
        }
        System.out.println("----------------------------------");
        System.out.printf("%-17s: ₱ %.2f%n", "Total Price", item.getTotalPrice());
        System.out.printf("%-17s: ₱ %d%n", "Cash", cash);
        System.out.printf("%-17s: ₱ %.2f%n", "Change", item.getchange(cash));
        System.out.println();
        System.out.printf("%-17s: %d%n", "No of Items", allProductQuantity);
        System.out.println();
        System.out.printf("%-17s: ₱ %.2f%n", "Price before VAT", item.getPriceBeforeVAT());
        System.out.printf("%-17s: ₱ %.2f%n", "VAT", item.getVAT());


        System.out.println("\n\n*** INTERNATIONAL BOOKSTORE ***");
        System.out.println("\t\tSales Invoice");
        System.out.println("----------------------------------------");
        for (String i : item.getitemsWithUnitPrice().keySet()) {
            System.out.printf("%2d %-10s @ %6.2f  : ₱ %8.2f%n",
                    item.getItemQuantity(i), i.substring(0,1).toUpperCase() + i.substring(1).toLowerCase(), item.getitemsWithUnitPrice().get(i), item.getPrice(i));
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-24s: ₱ %.2f%n", "TOTAL", item.getTotalPrice());
        System.out.printf("%-24s: ₱ %d%n", "Cash", cash);
        System.out.printf("%-24s: ₱ %.2f%n", "Change", item.getchange(cash));
        System.out.println();
        System.out.printf("%-24s: ₱ %.2f%n", "Price before VAT", item.getPriceBeforeVAT());
        System.out.printf("%-24s: ₱ %.2f%n", "VAT (12%%)", item.getVAT());
        System.out.printf("%-24s: %d%n", "Total Number of Items", allProductQuantity);


    }
}

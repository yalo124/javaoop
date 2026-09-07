import java.util.LinkedHashMap;
import java.util.Scanner;

public class QUIAMBAO {

    public static class Item{
        private LinkedHashMap<String, Double> itemsWithUnitPrice;
        private LinkedHashMap<String, Integer> itemsWithQuantity;

        private int TotalQuantity;


        public Item(){
            itemsWithUnitPrice = new LinkedHashMap<>();
            itemsWithQuantity = new LinkedHashMap<>();

            TotalQuantity = 0;
        }

        public int getTotalQuantity(int quantity){
            return TotalQuantity += quantity;
        }

        public LinkedHashMap<String, Double> getitemsWithUnitPrice() {
            return itemsWithUnitPrice;
        }

        public LinkedHashMap<String, Integer> getitemsWithQuantity() {
            return itemsWithQuantity;
        }

        public void itemsWithUnitPrice(String productName, double priceUnit) {
            itemsWithUnitPrice.put(productName, priceUnit);
        }

        public void itemsWithQuantity(String productName, int quantity){
            itemsWithQuantity.put(productName, quantity);
        }

        public double getPrice(String productName){
            return itemsWithUnitPrice.get(productName) * itemsWithQuantity.get(productName);
        }


        public double getTotalPrice() {
            double total = 0;

            for (String productName : itemsWithUnitPrice.keySet()) {
                total += itemsWithUnitPrice.get(productName)
                        * itemsWithQuantity.get(productName);
            }
            return total;
        }

        public int getItemQuantity(String productName){
            if (itemsWithQuantity.containsKey(productName)) {
                return itemsWithQuantity.get(productName);
            }

            return 0;
        }


        public double getchange(double cash){
            return cash - getTotalPrice();
        }

        public double getPriceBeforeVAT(){
            return getTotalPrice() / 1.12;
        }

        public double getVAT(){
            return getTotalPrice() - getPriceBeforeVAT();
        }

    }

    public static void main(String[] args){
        Item item = new Item();
        Scanner scan = new Scanner(System.in);

        String productName;
        double priceUnit, cash;
        int quantity, allProductQuantity ;
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
        cash = scan.nextDouble();
        while(cash < item.getTotalPrice()){
            try {
                throw new ArithmeticException("Invalid amount!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                System.out.print("Pay again: ");
                cash = scan.nextDouble();
            }
        }

        System.out.println("\nOFFICIAL RECEIPT");
        System.out.println("----------------------------------");
        for (String i : item.getitemsWithUnitPrice().keySet()) {
            System.out.printf("%-17s: ₱ %.2f%n", i.substring(0,1).toUpperCase() + i.substring(1).toLowerCase() , item.getPrice(i));
        }
        System.out.println("----------------------------------");
        System.out.printf("%-17s: ₱ %.2f%n", "Total Price", item.getTotalPrice());
        System.out.printf("%-17s: ₱ %.2f%n", "Cash", cash);
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
        System.out.printf("%-24s: ₱ %.2f%n", "Cash", cash);
        System.out.printf("%-24s: ₱ %.2f%n", "Change", item.getchange(cash));
        System.out.println();
        System.out.printf("%-24s: ₱ %.2f%n", "Price before VAT", item.getPriceBeforeVAT());
        System.out.printf("%-24s: ₱ %.2f%n", "VAT (12%%)", item.getVAT());
        System.out.printf("%-24s: %d%n", "Total Number of Items", allProductQuantity);


        scan.close();
    }
}

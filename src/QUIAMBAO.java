import java.util.LinkedHashMap;
import java.util.Scanner;

public class QUIAMBAO {
    public static void main(String[] args){
        var Item = new LinkedHashMap<String, Double>();
        var FinalItem = new LinkedHashMap<String, Double>();

        var scan = new Scanner(System.in);
        double priceItem = 0;
        int quantity;
        double pricePerUnit;
        int totalQuantity = 0;
        double PriceTotal = 0;

        while(true) {
            System.out.print("Enter item (if done adding item, type done: ");
            String name = scan.nextLine();
            if(name.equalsIgnoreCase("done")){
                break;
            }
            System.out.print("Enter unit price: ");
            double Unit_price = scan.nextDouble();
            scan.nextLine();

            Item.put(name, Unit_price);
        }

        for (String i : Item.keySet()){
            System.out.println("Item: " + i + " Price: P"+ Item.get(i));
        }

        System.out.println("Enter quantity");
        for (String i : Item.keySet()){
            System.out.print("Item: " + i + ": ");
            quantity= scan.nextByte();
            pricePerUnit = Item.get(i);
            priceItem = pricePerUnit * quantity;

            totalQuantity+=quantity;
            PriceTotal += priceItem;


            FinalItem.put(i, priceItem);
        }

        for (String j : FinalItem.keySet()){
            System.out.println("Item: " + j + " Total: P"+ FinalItem.get(j));
        }
        System.out.print("Cash: ");
        int cash = scan.nextInt();
        double change = cash - PriceTotal;
        double PriceBeforeVat = PriceTotal / (1+0.12);
        double VAT = PriceTotal - PriceBeforeVat;
        System.out.println("Price before Vat: " + String.format("%.2f", PriceBeforeVat));
        System.out.println("VAT (12%): " + String.format("%.2f", VAT));
        System.out.println("No of items: " + totalQuantity);
        System.out.println("Total Price: " +  PriceTotal);
        System.out.println("Cash: " + cash);
        System.out.println("Change: " + change);

    }
}

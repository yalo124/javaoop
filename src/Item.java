import java.util.LinkedHashMap;

public  class Item{
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


    public double getchange(int cash){
        return cash - getTotalPrice();
    }

    public double getPriceBeforeVAT(){
        return getTotalPrice() / 1.12;
    }

    public double getVAT(){
        return getTotalPrice() - getPriceBeforeVAT();
    }

}
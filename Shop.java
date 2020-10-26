import java.util.HashMap;

public class Shop {

    private final Integer code;
    private final String name;
    private final String address;
    private HashMap<Product, Integer> items;
    private HashMap<Product, Double> prices;

    Shop(Integer code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
        items = new HashMap<>();
        prices = new HashMap<>();
    }

    void addNewItem(Product product, Integer count, double price) {
        items.put(product, count);
        prices.put(product, price);
    }

    void addItem(Product product, Integer count, double price) {
        items.put(product, items.get(product) + count);
        prices.put(product, price);
    }

    boolean hasItem(Product product) {
        return items.containsKey(product);
    }

    HashMap<Product, Integer> buyAllItems(Double money) {
        HashMap<Product, Integer> result = new HashMap<>();
        items.forEach((key, value) -> result.put(key, (int) (money / prices.get(key))));
        return result;
    }

    Double getPrice(Product product) {
        return prices.get(product);
    }

    Integer getCount(Product product) {
        return items.get(product);
    }

    @Override
    public String toString() {
        return code.toString() + ' ' + name + ' ' + address;
    }

}

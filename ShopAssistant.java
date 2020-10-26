import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class ShopAssistant {
    ArrayList<Shop> shops = new ArrayList<>();

    Shop createShop(Integer code, String name, String address) {
        Shop shop = new Shop(code, name, address);
        addShop(shop);
        return shop;
    }

    Product createProduct(Integer code, String name) {
        return new Product(code, name);
    }

    void addItemToShop(Shop shop, Product product, Integer count, Double price) {
        if (shop.hasItem(product)) {
            shop.addItem(product, count, price);
        } else {
            shop.addNewItem(product, count, price);
        }
    }

    Shop findCheapest(Product product) {
        Double min = Double.MAX_VALUE;
        Shop result = null;
        for (Shop shop : shops) {
            if (shop.hasItem(product) && shop.getPrice(product) < min) {
                min = shop.getPrice(product);
                result = shop;
            }
        }
        return result;
    }

    HashMap<Product, Integer> getAmountOfItems(Shop shop, Double money) {
        return shop.buyAllItems(money);
    }

    Double buyProduct(Shop shop, Product product, Integer count) {
        if (shop.getCount(product) < count) {
            throw new IndexOutOfBoundsException("Not enough items");
        } else {
            double price = count * shop.getPrice(product);
            price = price * 100;
            price = (double) Math.round(price);
            price = price / 100;
            return price;
        }
    }

    Shop findCheapestPackage(HashMap<Product, Integer> productList) {
        Double min = Double.MAX_VALUE;
        Shop result = null;
        AtomicBoolean haveEnough = new AtomicBoolean(true);
        for (Shop shop : shops) {
            haveEnough.set(true);
            AtomicReference<Double> price = new AtomicReference<>(0.0);
            productList.forEach((key, value) -> {
                if (shop.hasItem(key)) {
                    if (shop.getCount(key) < value) {
                        haveEnough.set(false);
                    }
                    price.updateAndGet(v -> v + (shop.getPrice(key) * value));
                } else {
                    haveEnough.set(false);
                }
            });
            if (price.get() < min && haveEnough.get()) {
                min = price.get();
                result = shop;
            }
        }
        if (min == Double.MAX_VALUE) {
            throw new WrongMethodTypeException("Cant complete this order");
        }
        return result;
    }

    private void addShop(Shop shop) {
        shops.add(shop);
    }

}

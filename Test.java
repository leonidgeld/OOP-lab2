import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ShopAssistant assistant = new ShopAssistant();

        Shop petyorochka = assistant.createShop(1, "Petyorochka", "Kronverkskiy 49");
        Shop diksi = assistant.createShop(2, "Diksi", "Rublishteina 24");
        Shop ashan = assistant.createShop(3, "Ashan", "Posrpekt mira dom kefira");

        Product mango = assistant.createProduct(1, "Mango");
        Product pineapple = assistant.createProduct(2, "Pineapple");
        Product sausage = assistant.createProduct(3, "Sausage");
        Product doritos = assistant.createProduct(4, "Doritos");
        Product mountainDew = assistant.createProduct(5, "Mountain Dew");
        Product redBull = assistant.createProduct(6, "Red Bull");
        Product pivo = assistant.createProduct(7, "Leffe");
        Product snikers = assistant.createProduct(8, "Snikers");
        Product bulka = assistant.createProduct(9, "Bulochka");
        Product tapochek = assistant.createProduct(10, "Tapochek");

        assistant.addItemToShop(petyorochka, mango, 7, 79.99);
        assistant.addItemToShop(petyorochka, pineapple, 4, 99.99);

        assistant.addItemToShop(diksi, mango, 5, 74.99);
        assistant.addItemToShop(diksi, pineapple, 3, 99.99);

        assistant.addItemToShop(ashan, redBull, 100, 139.99);

        System.out.println(assistant.getAmountOfItems(diksi, 200.0));
        System.out.println(assistant.findCheapest(mango));
        System.out.println(assistant.buyProduct(diksi, mango, 3));
        System.out.println(assistant.buyProduct(diksi, mango, 2));

        HashMap<Product, Integer> list = new HashMap<>();
        list.put(mango, 6);
        list.put(pineapple, 2);
        System.out.println(assistant.findCheapestPackage(list));

    }
}

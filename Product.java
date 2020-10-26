public class Product {
    Integer code;
    String name;

    Product(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}

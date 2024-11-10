package store;

public class Product {
    private String name;
    private int price;
    private int stock;
    private String promotion;

    public Product(String name, int price, int stock, String promotion) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.promotion = promotion;
    }

    // Getter 메서드
    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }
    public String getPromotion() { return promotion; }

    public String toString() {
        if (promotion == null || promotion.isEmpty()) {
            return String.format("- %s %d원 %d개", name, price, stock);
        } else {
            return String.format("- %s %d원 %d개 %s", name, price, stock, promotion);
        }
    }
}


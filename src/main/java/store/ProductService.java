package store;

import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        loadProducts();
    }

    private void loadProducts() {
        System.out.println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");
        ProductLoader loader = new ProductLoader();
        products = loader.loadProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void checkAndReduceStock(String productName, int quantity) {
        Product product = findProductByName(productName);
        if (product == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }

        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다.");
        }

        product.reduceStock(quantity); // 재고 차감
    }

    private Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null; // 상품을 찾지 못한 경우
    }
}

package store;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        printProduct(); // 현재 보유 상품 출력
    }

    private static void printProduct() {
        System.out.println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");
        ProductLoader loader = new ProductLoader();
        List<Product> products = loader.loadProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

package store;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        printProducts(); // 현재 보유 상품 로드, 출력
        loadPromotions(); // 프로모션 로드
    }

    private static void printProducts() {
        System.out.println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");
        ProductLoader loader = new ProductLoader();
        List<Product> products = loader.loadProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void loadPromotions() {
        PromotionLoader promotionLoader = new PromotionLoader();
        List<Promotion> promotions = promotionLoader.loadPromotions();
    }
}

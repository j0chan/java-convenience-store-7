package store;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        printProducts(); // 현재 보유 상품 로드, 출력
        loadPromotions(); // 프로모션 로드
        InputProductQuantity(); // 상품명, 수량 입력받기
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

    private static void InputProductQuantity() {
        System.out.println("\n구매하실 상품명과 수량을 입력해주세요. (예: [사이다-2],[감자칩-1])");
        InputView inputView = new InputView();
        List<String> items = inputView.readItems();
    }
}

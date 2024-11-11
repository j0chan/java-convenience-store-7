package store;

public class Application {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        PromotionService promotionService = new PromotionService();

        productService.printProducts(); // 현재 보유 상품 출력
        promotionService.loadPromotions(); // 프로모션 로드 및 초기화
        promotionService.processPromotions(productService); // 프로모션 로직 처리
    }
}

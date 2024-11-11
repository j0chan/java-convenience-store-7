package store;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class PromotionService {
    private List<Promotion> promotions;

    public void loadPromotions() {
        PromotionLoader promotionLoader = new PromotionLoader();
        promotions = promotionLoader.loadPromotions();
    }

    public void processPromotions(ProductService productService) {
        InputView inputView = new InputView();
        List<String> items = inputView.readItems();

        for (String item : items) {
            String productName = parseProductName(item);
            int quantity = parseQuantity(item);

            Promotion promotion = getPromotionForProduct(productName);
            if (promotion != null && isPromotionActive(promotion)) {
                if (isEligibleForAdditionalQuantity(promotion, quantity)) {
                    promptAdditionalQuantity(productName, promotion.getBuyQuantity() - quantity);
                } else {
                    checkPromotionStock(productName, quantity, productService);
                }
            }
        }
    }

    private boolean isPromotionActive(Promotion promotion) {
        String currentDate = DateUtil.getCurrentDate();
        return currentDate.compareTo(promotion.getStartDate()) >= 0 &&
                currentDate.compareTo(promotion.getEndDate()) <= 0;
    }

    private boolean isEligibleForAdditionalQuantity(Promotion promotion, int quantity) {
        return quantity < promotion.getBuyQuantity();
    }

    private void promptAdditionalQuantity(String productName, int additionalQuantity) {
        System.out.printf("현재 %s은(는) %d개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)%n", productName, additionalQuantity);
        String response = Console.readLine().trim().toUpperCase();
        validateYesNoInput(response);

        if (response.equals("Y")) {
            System.out.printf("%s %d개를 추가했습니다.%n", productName, additionalQuantity);
            // 추가 수량 처리 로직 예: productService.checkAndReduceStock(productName, additionalQuantity);
        }
    }

    private void checkPromotionStock(String productName, int quantity, ProductService productService) {
        if (hasSufficientPromotionStock(productName, quantity)) {
            return;
        }
        promptFullPricePurchase(productName, quantity);
    }

    private void promptFullPricePurchase(String productName, int quantity) {
        System.out.printf("현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)%n", productName, quantity);
        String response = Console.readLine().trim().toUpperCase();
        validateYesNoInput(response);

        if (response.equals("Y")) {
            System.out.printf("%s %d개를 정가로 결제합니다.%n", productName, quantity);
            // 정가 결제 처리 로직 예: productService.checkAndReduceStock(productName, quantity);
        }
    }

    private void validateYesNoInput(String input) {
        if (!input.equals("Y") && !input.equals("N")) {
            throw new IllegalArgumentException("[ERROR] Y 또는 N만 입력 가능합니다.");
        }
    }

    private Promotion getPromotionForProduct(String productName) {
        for (Promotion promotion : promotions) {
            if (promotion.getName().equals(productName)) {
                return promotion;
            }
        }
        return null;
    }

    private String parseProductName(String item) {
        return item.substring(1, item.indexOf('-')).trim();
    }

    private int parseQuantity(String item) {
        String quantityStr = item.substring(item.indexOf('-') + 1, item.indexOf(']')).trim();
        return Integer.parseInt(quantityStr);
    }

    private boolean hasSufficientPromotionStock(String productName, int quantity) {
        // 실제로 프로모션 재고를 확인하는 로직을 여기에 작성할 수 있습니다.
        // 예제에서는 true를 반환하도록 가정합니다.
        return true;
    }
}

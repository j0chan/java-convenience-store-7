package store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PromotionLoader {
    private static final String PROMOTION_FILE_PATH = "src/main/resources/promotions.md";

    public List<Promotion> loadPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PROMOTION_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 첫 번째 줄 건너뛰기
                }
                Promotion promotion = parsePromotion(line);
                promotions.add(promotion);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] 프로모션 파일을 읽는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return promotions;
    }

    private Promotion parsePromotion(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int buyQuantity = Integer.parseInt(parts[1].trim());
        int getQuantity = Integer.parseInt(parts[2].trim());
        String startDate = parts[3].trim();
        String endDate = parts[4].trim();

        return new Promotion(name, buyQuantity, getQuantity, startDate, endDate);
    }
}

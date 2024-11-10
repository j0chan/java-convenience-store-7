package store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    private static final String PRODUCT_FILE_PATH = "src/main/resources/products.md";

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PRODUCT_FILE_PATH))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 첫 번째 줄 건너뛰기
                }
                Product product = parseProduct(line);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("[ERROR] 상품 파일을 읽는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return products;
    }

    private Product parseProduct(String line) {
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int price = Integer.parseInt(parts[1].trim());
        int stock = Integer.parseInt(parts[2].trim());
        String promotion = (parts.length > 3 && !parts[3].trim().equals("null")) ? parts[3].trim() : "";

        return new Product(name, price, stock, promotion);
    }
}

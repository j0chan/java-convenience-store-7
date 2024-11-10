package store;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<String> readItems() {
        String input = Console.readLine();
        try {
            return parseItems(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return readItems(); // 재입력
        }
    }

    private List<String> parseItems(String input) {
        if (!input.matches("\\[\\w+-\\d+](,\\[\\w+-\\d+])*")) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다. 다시 입력해주세요.");
        }

        List<String> items = new ArrayList<>();
        String[] entries = input.split(",");
        for (String entry : entries) {
            items.add(entry.trim());
        }
        return items;
    }
}

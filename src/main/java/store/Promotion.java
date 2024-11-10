package store;

public class Promotion {
    private String name;
    private int buyQuantity;
    private int getQuantity;
    private String startDate;
    private String endDate;

    public Promotion(String name, int buyQuantity, int getQuantity, String startDate, String endDate) {
        this.name = name;
        this.buyQuantity = buyQuantity;
        this.getQuantity = getQuantity;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getter 메서드
    public String getName() { return name; }
    public int getBuyQuantity() { return buyQuantity; }
    public int getGetQuantity() { return getQuantity; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
}

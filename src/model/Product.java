package model;

public class Product extends Menu {
    private double price;
    private int count;

    // 기본 생성자
    public Product() {
    }

    public Product(String productName, String productInfo, double price) {
        this.name = productName;
        this.info = productInfo;
        this.price = price;
        this.count = 0;
    }

    public String getProductName() {
        return this.name;
    }

    public String getProductInfo() {
        return this.info;
    }

    // getter
    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }
}

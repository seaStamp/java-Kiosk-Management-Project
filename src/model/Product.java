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
        this.count = 1;
        id++;
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

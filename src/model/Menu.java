package model;

public class Menu {
    protected int id = 0;
    protected String name;
    protected String info;
    //private ArrayList<Product> products; // 각 메뉴에 해당하는 상품들을 담는 리스트

    // 기본 생성자
    public Menu() {
    }

    public Menu(String category, String info) {
        this.name = category;
        this.info = info;
        id++;
    }

    // getter
    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getId() {
        return this.id;
    }
}

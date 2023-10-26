package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected String name;
    protected String info;

    // 기본 생성자
    public Menu() {
    }

    public Menu(String category, String info) {
        this.name = category;
        this.info = info;
    }

    // getter
    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.name;
    }
}

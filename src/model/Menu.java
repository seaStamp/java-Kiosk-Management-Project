package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected int id = 0;
    protected String name;
    protected String info;

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

    public int getId(){
        return this.id;
    }
}

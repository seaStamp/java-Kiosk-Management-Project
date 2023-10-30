package product;

import model.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public final static Menu BURGERS = new Menu("Burgers", "앵거스 비프통살을 다져만든 버거");
    public final static Menu CUSTARDS = new Menu("Custards", "매장에서 신선하게 만드는 아이스크림");
    public final static Menu DRINKS = new Menu("Drinks", "매장에서 직접 만드는 음료");
    public final static Menu CONCRETES = new Menu("Concretes", "쫀득하고 진한맛의 커스터드");

   public static List<Menu> mainMenu = new ArrayList<>(Arrays.asList(BURGERS, CUSTARDS, DRINKS, CONCRETES));

}

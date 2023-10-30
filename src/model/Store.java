package model;

import product.MainMenu;
import product.ShakeShackAllMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Store {
    public static HashMap<String, List<Product>> menus = new HashMap<>(); // menu랑 product 연결 (메뉴명, 상품리스트)
    public static List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트 (메뉴명과 메뉴정보)
    //public static ArrayList<Product> products = new ArrayList<>(); // 상품 리스트
    public static List<Order> waitingList = new ArrayList<>(); // 대기중인 주문리스트
    public static List<Order> completedList = new ArrayList<>(); // 완료된 주문리스트
    public ShakeShackAllMenu shackShackAllMenu = new ShakeShackAllMenu();

    public void init() {
        menuList.addAll(MainMenu.mainMenu);
        menus.put(MainMenu.BURGERS.getName(), shackShackAllMenu.burger);
        menus.put(MainMenu.CUSTARDS.getName(), shackShackAllMenu.custard);
        menus.put(MainMenu.DRINKS.getName(), shackShackAllMenu.drink);
        menus.put(MainMenu.CONCRETES.getName(), shackShackAllMenu.concretes);
    }

    // 주문을 완료하는 메서드
    public void changeCompleteOrderState(Order waiting) { //주문상태 변경 (대기 -> 완료)
        if(!waiting.getOrderState()) {
            waiting.setOrderState(true); // waiting.setOrderState(!waiting.getOrderState());
        }
        waitingList.remove(waiting);
        completedList.add(waiting);
    }

    // 메뉴를 생성하는 메서드
    public void createMenu(Menu newMenu) {
        menuList.add(newMenu);


        List<Product> menuItems = new ArrayList<>();
        menus.put(newMenu.getName(), menuItems);
    }

    // 상품을 생성하는 메서드
    public void createProduct(String menuName, Product newProduct) {
        menus.get(menuName).add(newProduct);
    }

    // 상품을 삭제하는 메서드 ( 매개변수 - 삭제할 상품 선택시 선택된 상품 객체 (Product) )
    public void deleteProduct(Menu menu, Product item) {
        menus.get(menu.getName()).remove(item);
        if(menus.get(menu.getName()).isEmpty()){
            menus.remove(menu.getName());
            menuList.remove(menu);
        }
    }
}

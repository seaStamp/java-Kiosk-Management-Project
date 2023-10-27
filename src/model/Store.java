package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Store {
    public static HashMap<String, List<Product>> menus = new HashMap<>(); // menu랑 product 연결 (메뉴명, 상품리스트)
    public static List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트 (메뉴명과 메뉴정보)
    //public static ArrayList<Product> products = new ArrayList<>(); // 상품 리스트
    public static List<Order> waitingList = new ArrayList<>(); // 대기중인 주문리스트
    public static List<Order> completedList = new ArrayList<>(); // 완료된 주문리스트

    public Order order = new Order();


    // 대기 주문을 추가하는 메서드
    public void addWaitingOrder(Order myOrder) {
        waitingList.add(myOrder);
    }

    // 주문을 완료하는 메서드
   /* public void completeOrder(Order myOrder) {
        waitingList.remove(myOrder);
        completedList.add(myOrder);
    }
*/
    // 주문을 완료하는 메서드
    public void changeCompleteOrderState(Order waiting) { //주문상태 변경 (대기 -> 완료)
        if(!waiting.getOrderState()) {
            waiting.setOrderState(true); // waiting.setOrderState(!waiting.getOrderState());
        }
        waitingList.remove(waiting);
        completedList.add(waiting);

        //Order order1 = waitingList.get(order.orderList.get(index));
    }

    // 입력 받은 메뉴가 이미 존재하는건지 확인하는 메서드
    public boolean existOrNotMenu(String menuName) {
        boolean exist = false; // 메뉴 존재하면 true, 존재하지 않으면 false

        for(Menu menu : menuList) {
            if(menu.getName().equals(menuName)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    // 메뉴를 생성하는 메서드
    public void createMenu(String menuName, String menuInfo) {
        Menu newMenu = new Menu(menuName, menuInfo);
        menuList.add(newMenu);

        List<Product> menuItems = new ArrayList<>();
        menus.put(menuName, menuItems);
    }

    // 상품을 생성하는 메서드
    public void createProduct(String menuName, String productName, String productInfo, double price) {
        List<Product> menuItems = menus.get(menuName);
        menuItems.add(new Product(productName, productInfo, price));
    }

    // 상품을 삭제하는 메서드 ( 매개변수 - 삭제할 상품 선택시 선택된 상품 객체 (Product) )
    public void deleteProduct(Product item) {
        for(List<Product> menuInProductList  : menus.values()) { // menus의 모든 값을 가져와
            if(menuInProductList.contains(item)) {
                menuInProductList.remove(item);
            }
            break;
        }
    }
}

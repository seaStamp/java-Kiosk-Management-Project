package controller;

import input.InputDevice;
import model.Menu;
import model.Product;
import model.Store;
import view.ManagerScreen;

import java.util.HashMap;
import java.util.List;

public class ManagerKiosk extends Kiosk {
    // status 상수값
    private final static int HOME = 0;
    private final static int MAIN_MENU = 1;
    private final static int WAITNG_ORDER_LIST = 2;
    private final static int COMPLETED_ORDER_LIST = 3;
    private final static int CREAT_PRODUCT = 4;
    private final static int DELETE_PRODUCT = 5;

    private static ManagerScreen screen = new ManagerScreen();
    private static Store store = new Store();

    public static void managerKioskStart() {
        while (true) {
            switch (status) {
                case HOME -> {
                    return;
                }
                case MAIN_MENU -> {
                    screen.displayMainMenu();
                    handleMainMenu();
                }
                case WAITNG_ORDER_LIST -> {
                    screen.waitingOrderList(Store.waitingList);
                    handleWaitingOrderListMenu();
                }
                case COMPLETED_ORDER_LIST -> {
                    screen.orderCompleteList(Store.completedList);
                    handleCompletedOrderListMenu();
                }
                case CREAT_PRODUCT -> {
                    screen.productCreateMenu(Store.menuList);
                    handleCreateProduct(Store.menuList);
                }
                case DELETE_PRODUCT -> {
                    screen.productDeleteMenu(Store.menuList);
                    handleDeleteProduct(Store.menuList, Store.menus);
                }
            }
        }
    }

    private static void handleMainMenu() {
        status = MAIN_MENU;
        switch (InputDevice.receiveInt(0, 4)) {
            case 0 -> {
                status = HOME;
            }
            case 1 -> {
                status = WAITNG_ORDER_LIST;
            }
            case 2 -> {
                status = COMPLETED_ORDER_LIST;
            }
            case 3 -> {
                status = CREAT_PRODUCT;
            }
            case 4 -> {
                status = DELETE_PRODUCT;
            }
        }
    }

    private static void handleWaitingOrderListMenu() {

        int selectedNumber = InputDevice.receiveInt(0, Store.waitingList.size());
        int answer;
        if (selectedNumber == 0) {
            status = MAIN_MENU;
        } else if (selectedNumber != -1) {
            do {
                screen.orderComplete(Store.waitingList.get(selectedNumber - 1));
                answer = InputDevice.receiveInt(1, 2);
            } while (answer == -1);
            status = MAIN_MENU;
            if (answer == 1) {
                store.changeCompleteOrderState(Store.waitingList.get(selectedNumber - 1));
            }
        }
    }


    // 완료주문 목록
    private static void handleCompletedOrderListMenu() { // 매개변수로 받을 것 : List<Order>
        int selectedNumber = InputDevice.receiveInt(0, Store.completedList.size());
        if (selectedNumber == 0) {
            status = MAIN_MENU;
        } else if (selectedNumber != -1) {
            status = MAIN_MENU;
            screen.orderCompleteNumber(Store.completedList.get(selectedNumber - 1));
        }
    }

    // 상품생성 핸들러
    private static void handleCreateProduct(List<Menu> menuList) { // 리팩터링해야함
        int selectedNumber = InputDevice.receiveInt(1, menuList.size());
        int answer;
        String newMenuName = null;
        String newMenuInfo = null;
        String newProductName;
        String newProductInfo;
        double newProductPrice;

        if (selectedNumber != -1) {
            {
                if (selectedNumber == Store.menuList.size() + 1) { // 신규메뉴 선택
                    System.out.print("생성할 메뉴 이름을 입력해주세요 : ");
                    newMenuName = InputDevice.receiveString();
                    System.out.println("생성할 메뉴에 대한 설명을 입력해주세요 : ");
                    newMenuInfo = InputDevice.receiveString();
                }

                System.out.print("생성할 상품의 이름을 입력해주세요 : ");
                newProductName = InputDevice.receiveString();
                System.out.print("생성할 상품에 대한 설명을 입력해주세요 : ");
                newProductInfo = InputDevice.receiveString();
                System.out.print("생성할 상품의 가격을 입력해주세요 :  ");
                do {
                    newProductPrice = InputDevice.receiveDouble();  // 추가로 예외처리 해야할 수도있음
                } while (newProductPrice == -1);
                screen.productCreate(newMenuName, newMenuInfo, newProductName, newProductInfo, newProductPrice);
                status = MAIN_MENU;
                do {
                    answer = InputDevice.receiveInt(1, 2);
                } while (answer == -1);
                if (answer == 1) {
                    if (selectedNumber == Store.menuList.size() + 1) {
                        store.createMenu(newMenuName, newMenuInfo);
                    }
                    store.createProduct(menuList.get(selectedNumber - 1).getName(), newProductName, newProductInfo, newProductPrice);
                }
            }
        }
    }


    private static void handleDeleteProduct(List<Menu> menuList, HashMap<String, List<Product>> menus) {
        int answer = InputDevice.receiveInt(1, menus.size());
        List<Product> products;
        if (answer != -1) {// 에러가 나지 않는다면
            products = menus.get(menuList.get(answer - 1));
            screen.productDeleteSelect(products);
            do {
                answer = InputDevice.receiveInt(1, products.size());
            } while (answer == -1);
            store.deleteProduct(products.get(answer - 1));
            status = MAIN_MENU;
        }
    }

}

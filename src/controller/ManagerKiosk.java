package controller;

import input.InputDevice;
import model.Menu;
import model.Product;
import model.Store;
import view.ManagerScreen;

import java.util.HashMap;
import java.util.List;

public class ManagerKiosk {
    public static ManagerKioskStatus status;
    private static final ManagerScreen screen = new ManagerScreen();
    private static final Store store = new Store();

    public static void managerKioskStart() {
        status = ManagerKioskStatus.MAIN_MENU;
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
        status = ManagerKioskStatus.MAIN_MENU;
        switch (InputDevice.receiveInt(0, 4)) {
            case 0 -> status = ManagerKioskStatus.HOME;
            case 1 -> status = ManagerKioskStatus.WAITNG_ORDER_LIST;
            case 2 -> status = ManagerKioskStatus.COMPLETED_ORDER_LIST;
            case 3 -> status = ManagerKioskStatus.CREAT_PRODUCT;
            case 4 -> status = ManagerKioskStatus.DELETE_PRODUCT;
        }
    }

    private static void handleWaitingOrderListMenu() {

        int selectedNumber = InputDevice.receiveInt(0, Store.waitingList.size());
        int answer;
        if (selectedNumber == 0) {
            status = ManagerKioskStatus.MAIN_MENU;
        } else if (selectedNumber != -1) {
            screen.orderComplete(Store.waitingList.get(selectedNumber - 1));
            answer = receiveTwoAnswer();
            status = ManagerKioskStatus.MAIN_MENU;
            if (answer == 1) {
                store.changeCompleteOrderState(Store.waitingList.get(selectedNumber - 1));
            }
        }
    }


    // 완료주문 목록
    private static void handleCompletedOrderListMenu() { // 매개변수로 받을 것 : List<Order>
        int selectedNumber = InputDevice.receiveInt(0, Store.completedList.size());
        if (selectedNumber == 0) {
            status = ManagerKioskStatus.MAIN_MENU;
        } else if (selectedNumber != -1) {
            status = ManagerKioskStatus.MAIN_MENU;
            screen.orderCompleteNumber(Store.completedList.get(selectedNumber - 1));
        }
    }

    // 상품생성 핸들러
    private static void handleCreateProduct(List<Menu> menuList) {
        int selectedNumber = InputDevice.receiveInt(1, menuList.size() + 1);
        int answer;
        Menu menu = new Menu();
        Product newProduct;

        if (selectedNumber != -1) {
            {
                if (selectedNumber == Store.menuList.size() + 1) { // 신규메뉴 선택
                    menu = createNewMenu();
                } else {
                    menu.setName(Store.menuList.get(selectedNumber - 1).getName());
                    menu.setInfo(Store.menuList.get(selectedNumber - 1).getInfo());
                }
                newProduct = createNewProduct();
                screen.productCreate(menu, newProduct);
                status = ManagerKioskStatus.MAIN_MENU;
                answer = receiveTwoAnswer();
                if (answer == 1) {
                    if (selectedNumber == Store.menuList.size() + 1) {
                        store.createMenu(menu);
                    }
                    store.createProduct(menu.getName(), newProduct);
                    screen.productCreateComplete(newProduct.getName());
                }
            }
        }
    }

    private static Menu createNewMenu() {
        Menu menu = new Menu();
        System.out.print("생성할 메뉴 이름을 입력해주세요 : ");
        menu.setName(InputDevice.receiveString());
        System.out.println("생성할 메뉴에 대한 설명을 입력해주세요 : ");
        menu.setInfo(InputDevice.receiveString());
        return menu;
    }

    private static Product createNewProduct() {
        Product newProduct = new Product();
        System.out.print("생성할 상품의 이름을 입력해주세요 : ");
        newProduct.setName(InputDevice.receiveString());
        System.out.print("생성할 상품에 대한 설명을 입력해주세요 : ");
        newProduct.setInfo(InputDevice.receiveString());
        System.out.print("생성할 상품의 가격을 입력해주세요 :  ");
        do {
            newProduct.setPrice(InputDevice.receiveDouble());
        } while (newProduct.getPrice() == -1);
        return newProduct;
    }


    private static void handleDeleteProduct(List<Menu> menuList, HashMap<String, List<Product>> menus) {
        int selectedNumber = InputDevice.receiveInt(1, menus.size());
        int answer;
        Menu menu;
        List<Product> products;
        if (selectedNumber != -1) {// 에러가 나지 않는다면
            menu = menuList.get(selectedNumber - 1);
            products = menus.get(menu.getName());
            screen.productDeleteSelect(products);
            do {
                selectedNumber = InputDevice.receiveInt(1, products.size());
            } while (selectedNumber == -1);
            screen.deleteReconfirm();
            answer = receiveTwoAnswer();
            if (answer == 1) {
                screen.deleteComplete(products.get(selectedNumber - 1).getName());
                store.deleteProduct(menu, products.get(selectedNumber - 1));
            }
            status = ManagerKioskStatus.MAIN_MENU;
        }
    }

    private static int receiveTwoAnswer() {
        int answer ;
        do {
            answer = InputDevice.receiveInt(1, 2);
        } while (answer == -1);
        return answer;
    }


}

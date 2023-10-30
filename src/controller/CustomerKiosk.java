package controller;

import input.InputDevice;
import model.Order;
import model.Product;
import model.Store;
import product.ShakeShackAllMenu;
import view.CustomerScreen;

import java.util.List;

public class CustomerKiosk extends Kiosk {
    private final static int HOME = 0;
    private final static int MAIN_MENU = 1;
    private final static int PRODUCT_MENU = 2;
    private final static int PRODUCT_ADD = 3;
    private final static int CART = 4;
    private final static int ORDER_CANCEL = 5;
    private final static int ORDER_COMPLETE = 6;
    private final static int ORDER_STATUS = 7;

    private static CustomerScreen screen = new CustomerScreen();
    private static Order order = new Order();
    private static ShakeShackAllMenu shakeShakeAllMenu = new ShakeShackAllMenu();

    private static List<Product> selectedMenu;
    private static Product selectedProduct;

    private int waitingNumber = 0;
    private String request;

    public void customerKioskStart() throws Exception {
        status = MAIN_MENU;
        while (true) {
            switch (status) {
                case HOME:
                    return;
                case MAIN_MENU:
                    screen.displayMainMenu();
                    handleMainMenu();
                    break;
                case PRODUCT_MENU:
                    screen.displayProductMenu(selectedMenu);
                    handleProductMenu(selectedMenu);
                    break;
                case PRODUCT_ADD:
                    screen.purchaseScreen(selectedProduct);
                    handleCart(selectedProduct);
                    break;
                case CART:
                    screen.orderScreen(order , selectedProduct);
                    handleProductAdd();
                    break;
                case ORDER_CANCEL:
                    screen.orderCancelScreen();
                    handleOrderCancel();
                    break;
                case ORDER_COMPLETE:
                    handleComplete();
                    screen.orderSuccessScreen(waitingNumber);
                    break;
                case ORDER_STATUS:
                    handleStatus();
                    screen.orderStatus(Store.completedList, Store.waitingList);    //최근 주문 3개
                    break;
            }
        }
    }

    public void handleMainMenu() {
        int nRange = Store.menuList.size() + 3;
        int input = InputDevice.receiveInt(0, nRange);
        switch (input) {
            case 0:
                status = HOME;
                break;
            case 1:
                status = PRODUCT_MENU;
                selectedMenu = shakeShakeAllMenu.burger;
                break;
            case 2:
                status = PRODUCT_MENU;
                selectedMenu = shakeShakeAllMenu.custard;
                break;
            case 3:
                status = PRODUCT_MENU;
                selectedMenu = shakeShakeAllMenu.drink;
                break;
            case 4:
                status = PRODUCT_MENU;
                selectedMenu = shakeShakeAllMenu.concretes;
                break;
            case 5:
                cartEmptyCheck();
                break;
            case 6:
                status = ORDER_CANCEL;
                break;
            case 7:
                status = ORDER_STATUS;
                break;
        }
    }

    // 상품 메뉴 화면 관련 메서드
    public void handleProductMenu(List<Product> selectedMenu) {
        int input = InputDevice.receiveInt(1, selectedMenu.size());
        if (input >= 1 && input <= selectedMenu.size()) {
            selectedProduct = selectedMenu.get(input - 1); // 선택된 상품
            status = PRODUCT_ADD;
        }
    }

    // 구매화면 관련 메서드(장바구니)
    public void handleCart(Product currentPickProduct) {
        int input = InputDevice.receiveInt(1, 2);

        if (input >= 1 && input <= 2) {
            if (input == 1) { // 장바구니에 추가
                if (order.alreadyExistInOrderList(currentPickProduct)) { // 이미 존재하면
                    order.addCount(currentPickProduct); // 수량 증가
                } else { // 존재하지 않으면
                    order.orderList.add(currentPickProduct); // 새로 추가
                }
                order.addTotalPrice(currentPickProduct);
            }
            status = MAIN_MENU;
        }

    }

    // 주문화면 관련 메서드
    public void handleProductAdd() throws Exception {
        int input = InputDevice.receiveInt(1, 2);
        request = "";

        if (input == 1) {
            screen.requestedTerm(); // 요청사항 입력받기
            do {
                try {
                    request = InputDevice.receiveString(20);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (request == null || request.equals(""));
            status = ORDER_COMPLETE;
        }
        if (input == 2) {
            status = MAIN_MENU;
        }
    }

    // 주문 완료 관련 메서드
    public void handleComplete() {
        waitingNumber++;
        order.saveOrder(waitingNumber, request); // 값 변경 후, waitingList에 추가.
        order = new Order();
        status = MAIN_MENU;
    }

    // 주문 취소 관련 메서드
    public void handleOrderCancel() {
        int input = InputDevice.receiveInt(1, 2);
        if (input >= 1 && input <= 2) {
            if (input == 1) {
                order.orderList.clear();
                order.setTotalPrice(0);
            }
            status = MAIN_MENU;
        }
    }

    // 주문현황 관련 메서드
    public void handleStatus() {
        status = MAIN_MENU;
    }

    public void cartEmptyCheck() {
        if(order.orderList.size() > 0)
            status = CART;
        else
            System.out.println("장바구니가 비어있습니다. 메뉴를 고른 후 주문을 진행해주세요.\n");
    }
}

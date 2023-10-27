package controller;

import input.InputDevice;
import model.Order;
import model.Product;
import model.Store;
import product.MainMenu;
import product.ShakeShackAllMenu;
import view.CustomerScreen;

import java.util.List;

public class CustomerKiosk extends Kiosk{
    private final static int HOME = 0;
    private final static int MAIN_MENU = 1;
    private final static int PRODUCT_MENU = 2;
    private final static int PRODUCT_ADD = 3;
    private final static int CART = 4;
    private final static int ORDER_CANCEL = 5;
    private final static int ORDER_COMPLETE = 6;
    private final static int ORDER_STATUS = 7;

    private static CustomerScreen screen = new CustomerScreen();
    private static InputDevice inputDevice = new InputDevice();
    private static MainMenu mainMenu = new MainMenu();
    private static Order order = new Order();
    private static Store store = new Store();
    private static ShakeShackAllMenu shakeShakeAllMenu = new ShakeShackAllMenu();

    private static List<Product> selectedMenu;
    private static Product selectedProduct;

    private int waitingNumber = 1;
    private String request;

    public void customerKioskStart() throws Exception {
        while(true) {
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
                    screen.purchaseScreen(selectedProduct); // 매개변수 product로 받아야 함.
                    handleCart(selectedProduct);
                    break;
                case CART:
                    screen.orderScreen(order.orderList); // List<Order>를 매개변수로 받아야 함.
                    handleProductAdd();
                    break;
                case ORDER_CANCEL:
                    screen.orderCancelScreen();
                    handleOrderCancel();
                    break;
                case ORDER_COMPLETE:
                    screen.orderSuccessScreen();
                    handleComplete();
                    break;
                case ORDER_STATUS:
                    screen.orderStatus();
                    handleStatus();
                    break;
            }
        }
    }

    public void handleMainMenu() {
        int nRange = mainMenu.mainMenu.size()+4;
        int input = inputDevice.receiveInt(nRange);

        switch(input) {
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
                status = ORDER_COMPLETE;
                break;
            case 6:
                status = ORDER_CANCEL;
                break;
            case 7:
                status = ORDER_STATUS;
                break;
            case 8:
                status = HOME;
                break;
        }

    }

    // 상품 메뉴 화면 관련 메서드
    public void handleProductMenu(List<Product> selectedMenu) {
        int input = inputDevice.receiveInt(selectedMenu.size());
        selectedProduct = selectedMenu.get(input-1); // 선택된 상품
        status = PRODUCT_ADD;
    }

    // 구매화면 관련 메서드(장바구니)
    public void handleCart(Product currentPickProduct) {
        int input = inputDevice.receiveInt(2);

        if(input == 1) { // 장바구니에 추가
            if(order.alreadyExistInOrderList(currentPickProduct)) { // 이미 존재하면
                order.addCount(currentPickProduct); // 수량 증가
            }
        } else if(input == 2) { // 존재하지 않으면
            order.orderList.add(currentPickProduct); // 새로 추가
        }
        status = MAIN_MENU;
    }

    // 주문화면 관련 메서드
    public void handleProductAdd() throws Exception {
        int input = inputDevice.receiveInt(2);

        if(input == 1) {
            screen.requestedTerm(); // 요청사항 입력받기
            request = inputDevice.receiveString(20);
            //order.saveOrder(waitingNumber++, request);
        }
        status = ORDER_COMPLETE;
    }

    // 주문 완료 관련 메서드
    public void handleComplete() {
        store.addWaitingOrder(order.orderList, waitingNumber);

        order.saveOrder(waitingNumber, request);
        order.orderList.clear();
        waitingNumber++;
        status = MAIN_MENU;
    }

    // 주문 취소 관련 메서드
    public void handleOrderCancel() {
        int input = inputDevice.receiveInt(2);
        if(input == 1) {
            order.orderList.clear();
        }
        status = MAIN_MENU;
    }



    // 주문현황
    public void handleStatus() {
        int input = InputDevice.receiveInt(1);

        if(input == 1) {
            status = MAIN_MENU;
        }
    }
}

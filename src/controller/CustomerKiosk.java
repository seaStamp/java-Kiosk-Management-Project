package controller;

import view.CustomerScreen;

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

    public void customerKioskStart() {
        while(true) {
            switch (status) {
                case HOME:
                    return;
                case MAIN_MENU:
                    screen.displayMainMenu();
                    handleMainMenu();
                    break;
                case PRODUCT_MENU:
                    handleProductMenu();
                    break;
                case PRODUCT_ADD:
                    handleProductAdd();
                    break;
                case CART:
                    handleCart();
                    break;
                case ORDER_CANCEL:
                    handleOrderCancel();
                    break;
                case ORDER_COMPLETE:
                    handleComplete();
                    break;
                case ORDER_STATUS:
                    handleStatus();
                    break;

            }
        }
    }

    public void handleMainMenu() {

    }

    public void handleProductMenu() {
    }

    public void handleProductAdd() {
    }
    public void handleCart() {
    }
    public void handleOrderCancel() {
    }
    public void handleComplete() {
    }
    public void handleStatus() {
    }

}

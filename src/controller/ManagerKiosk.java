package controller;

import view.ManagerScreen;

public class ManagerKiosk extends Kiosk {
    // status 상수값
    private final static int HOME = 0;
    private final static int MAIN_MENU = 1;
    private final static int WAITNG_ORDER_LIST = 2;
    private final static int COMPLETED_ORDER_LIST = 3;
    private final static int CREAT_PRODUCT = 4;
    private final static int DELETE_PRODUCT = 5;

    private static ManagerScreen screen = new ManagerScreen();

    public static void managerKioskStart() {
        while (true) {
            switch (status) {
                case HOME -> {
                    return;
                }
                case MAIN_MENU -> {
                    //displayMainMenu();
                    handleMainMenu();
                }
                case WAITNG_ORDER_LIST -> {
                    //displayWaitingOrderList();
                    handleWaitingOrderMenu();
                }
                case COMPLETED_ORDER_LIST -> {
                    //displayCompletedOrderList();
                    handleCompletedOrderMenu();
                }
                case CREAT_PRODUCT -> {
                    //displayCreatProduct();
                    handleCreateProduct();
                }
                case DELETE_PRODUCT -> {
                    //displayDeleteProduct();
                    handleDeleteProduct();
                }
            }
        }
    }

    public static void handleMainMenu() {

    }
    public static void handleWaitingOrderMenu() {

    }
    public static void handleCompletedOrderMenu() {

    }
    public static void handleCreateProduct() {

    }
    public static void handleDeleteProduct() {

    }


}

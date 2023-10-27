package controller;

import input.InputDevice;
import jdk.jshell.Snippet;
import model.Menu;
import model.Order;
import model.Product;
import model.Store;
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
    private static Store store = new Store();

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

    private static void handleMainMenu() {
        status = MAIN_MENU;
        switch (InputDevice.receiveInt(4)) {
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

    private static void handleWaitingOrderMenu() {
        int selectedNumber = InputDevice.receiveInt(Store.waitingList.size());
        int answer;
        if (selectedNumber == 0) {
            status = MAIN_MENU;
        } else if (selectedNumber != -1) {
            do {
                // 주문 완료 처리하시겠습니까 메서드에 (Store.waitingList.get(answer-1))
                // 출력을 한다면
                answer = InputDevice.receiveInt(2);
            } while (answer == -1);
            status = MAIN_MENU;
            if (answer == 1) {
                store.changeCompleteOrderState(Store.waitingList.get(selectedNumber - 1));
            }
        }
    }

    private static void handleCompletedOrderMenu() {
        int selectedNumber = InputDevice.receiveInt(Store.completedList.size());
        int answer;
        if (selectedNumber == 0) {
            status = MAIN_MENU;
        } else if (selectedNumber != -1) {
                // 완료 메뉴 출력(Store.waitingList.get(answer-1))
                // ! 0에 대한 에러처리가 안되어있음.
            // 5초후 화면 전환이 더 자연스러울듯
            status = MAIN_MENU;
        }
    }

    private static void handleCreateProduct() {

    }

    private static void handleDeleteProduct() {

    }


}

package view;

import controller.CustomerKiosk;
import model.Order;
import model.Product;
import model.Store;
import product.MainMenu;
import product.ShakeShackAllMenu;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class CustomerScreen {
    // mainMenu 불러오기 위해 사용
    MainMenu mainMenu = new MainMenu();
    Store store = new Store();

    // 전체 메뉴 불러오기 위해 사용
    ShakeShackAllMenu shakeShackAllMenu = new ShakeShackAllMenu();

    // 구분 선 표시
    public void displayLine() {
        System.out.println("------------------------------------------------");
    }

    // 환영합니다 메시지 출력
    public void welcomeMsg() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
    }

    // 전체 메뉴 화면 (메인 메뉴)
    public void displayMainMenu() {
        int i=0;

        welcomeMsg();
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." + "\n");
        System.out.println("[ SHAKESHACK MENU ]");
        // 전체 메뉴 불러오기
        for (i = 0; i < store.menus.size(); i++) {
            System.out.println(i + 1 + ". " + store.menuList.get(i).getName() + " | " + store.menuList.get(i).getInfo());
        }
        System.out.println();
        System.out.println(" [ ORDER MENU ] ");
        System.out.println(++i + ". Order            | 장바구니를 확인 후 주문합니다.");
        System.out.println(++i + ". Cancel           | 진행중인 주문을 취소합니다.");
        System.out.println(++i + ". Status of Order  | 주문 현황을 확인합니다.");

        displayLine();
        // Order & Cancel 불러오기
    }

    // 주문 현황
    public void orderStatus(List<Order> completedList, List<Order> waitingList) {
        System.out.println("주문 현황입니다." + "\n");
        System.out.println("[최근 완료된 주문]");
        for (int i = completedList.size() - 1; i > completedList.size() - 4; i--) {
            if (i < 0) {
                break;
            }
            if (i == 0 || i == completedList.size() - 3) {
                System.out.print(completedList.get(i).getWaitingNumber() + "\n");
                break;
            } else {
                System.out.print(completedList.get(i).getWaitingNumber() + " | ");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("[대기중인 주문]");
        for (int i = 0; i < waitingList.size(); i++) {
            if (i == waitingList.size() - 1) {
                System.out.print(waitingList.get(i).getWaitingNumber() + "\n");
            } else {
                System.out.print(waitingList.get(i).getWaitingNumber() + " | ");
            }
        }
        System.out.println("3초후 메뉴판으로 돌아갑니다." + "\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 상품 메뉴 화면
    public void displayProductMenu(List<Product> addList) {
        welcomeMsg();
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." + "\n");

        for (int i = 0; i < addList.size(); i++) {
            System.out.println(i + 1 + ". " +
                    addList.get(i).getName() + " | W " +
                    addList.get(i).getPrice() + " | " +
                    addList.get(i).getInfo());
        }
        // 선택한 메뉴 담기
        displayLine();

    }

    // 구매 화면
    public void purchaseScreen(Product product) {
        // 장바구니에 담긴 메뉴 출력
        System.out.println(product.getName() + " | W " + product.getPrice() + " | "  + product.getInfo() + "\n");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        displayLine();
    }

    // 주문 화면
    public void orderScreen(Order order) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();

        System.out.println("[ Orders ] ");
        // 장바구니에 담긴 메뉴 출력 (orderMenu.add() 된 것을 get()으로 가져오기
        for (int i = 0; i < order.orderList.size(); i++) {
            System.out.printf("%s | W %.1f | %d개 | %s\n", order.orderList.get(i).getName(), order.orderList.get(i).getPrice(), order.orderList.get(i).getCount(),order.orderList.get(i).getInfo());

        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("%.1f\n", order.getTotalPrice());
        System.out.println();
        System.out.println("1. 주문       2. 메뉴판");
        displayLine();
    }

    // 요청사항
    public void requestedTerm() {
        System.out.println("요청사항을 입력해주세요. (20자 제한)");
        displayLine();
    }

    // 주문완료 화면
    public void orderSuccessScreen(int waitingNumber) {
        System.out.println("주문이 완료되었습니다!" + "\n");
        System.out.println("대기번호는 [ " + waitingNumber + " ]" + "번 입니다.");
        System.out.println("3초후 메뉴판으로 돌아갑니다.");
        // 3초
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 주문취소 화면
    public void orderCancelScreen() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소" + "\n");
        System.out.println("주문이 취소되었습니다.");
    }
}

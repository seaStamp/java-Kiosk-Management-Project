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

    // 전체 메뉴 불러오기 위해 사용
    ShakeShackAllMenu shakeShackAllMenu = new ShakeShackAllMenu();

    // 구분 선 표시
    public void displayLine(){
        System.out.println("------------------------------------------------");
    }

    // 환영합니다 메시지 출력
    public void welcomeMsg() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
    }

    // 전체 메뉴 화면 (메인 메뉴)
    public void displayMainMenu(){
        welcomeMsg();
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요." + "\n");
        System.out.println("[ SHAKESHACK MENU ]");
        // 전체 메뉴 불러오기
        for (int i = 0; i < mainMenu.mainMenu.size(); i++){
            System.out.println(i + 1 + ". " + mainMenu.mainMenu.get(i).getName() + " | " + mainMenu.mainMenu.get(i).getInfo());
        }
        System.out.println();
        System.out.println(" [ ORDER MENU ] ");
        System.out.println("5. Order            | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel           | 진행중인 주문을 취소합니다.");
        System.out.println("7. Status of Order  | 주문 현황을 확인합니다.");
        System.out.println("8. 시작 화면으로");
        displayLine();
        System.out.println();
        // Order & Cancel 불러오기
    }


    // 주문 현황
    public void orderStatus (){
        System.out.println("주문 현황입니다." + "\n");
        System.out.println("[최근 완료된 주문]");
        // 예시
        System.out.println("대기번호 | " + "대기번호 | " + "대기번호" + "\n");
        System.out.println("[대기중인 주문]");

        // 예시
        System.out.println("대기번호 | " + "대기번호 | " + "대기번호 | " + "대기번호..." + "\n");

        System.out.println("1. 돌아가기" + "\n");

        CustomerKiosk.status = 1;
    }

    // 상품 메뉴 화면
    public void displayProductMenu(List<Product> addList) {
        welcomeMsg();
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요." + "\n");

        for (int i = 0; i < shakeShackAllMenu.burger.size(); i++) {
            System.out.println(i + 1 + ". " + shakeShackAllMenu.burger.get(i).getName() + " | " + shakeShackAllMenu.burger.get(i).getPrice() + " | " + shakeShackAllMenu.burger.get(i).getInfo());
        }
        // 선택한 메뉴 담기
        //System.out.println(arrayList.get(0).getName());
        displayLine();
        System.out.println();

    }
    // 구매 화면
    public void purchaseScreen(List<Product> order){    //매개변수 Order order 였는데,,
        // 장바구니에 담긴 메뉴 출력
        System.out.println(order.get(0).getName() + " | " + order.get(0).getPrice() + " | " + order.get(0).getInfo() + "\n");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소" + "\n");
        displayLine();
        System.out.println();
    }

    // 주문 화면
    public void orderScreen(List<Product> orderList) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();

        System.out.println("[ Orders ] ");
        // 장바구니에 담긴 메뉴 출력 (orderMenu.add() 된 것을 get()으로 가져오기
        System.out.println(orderList.get(0).getName() + " | " + orderList.get(0).getPrice()+ " | " + orderList.get(0).getInfo());
        System.out.println(orderList.get(1).getName() + " | " + orderList.get(1).getPrice()+ " | " + orderList.get(1).getInfo());
        System.out.println();
        System.out.println("[ Total ]");
        // 각 메뉴들의 가격의 합 출력 (orderMenuPrice.add() 된 것을 get()으로 가져와서 합 구하기

        System.out.println(orderList.get(0).getPrice());
        System.out.println(orderList.get(1).getPrice());
        System.out.println();
        System.out.println("1. 주문       2. 메뉴판");
        displayLine();
        System.out.println();
        }

    // 요청사항
    public void requestedTerm(){
        System.out.println("요청사항을 입력해주세요. (20자 제한)");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        if(str.length() <= 20){
            System.out.println(str);
        }else {
            System.out.println("입력가능한 글자를 초과하였습니다.");
        }
        displayLine();
        System.out.println();
    }

    // 주문완료 화면
    public void orderSuccessScreen() {
        System.out.println("주문이 완료되었습니다!" + "\n");

        System.out.println("대기번호는 [ " + "1" + " ]" + "번 입니다." );
        System.out.println("3초후 메뉴판으로 돌아갑니다." + "\n");
        // 3초
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        displayMainMenu();
        System.out.println();

    }

    // 주문취소 화면
    public void orderCancelScreen() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소" + "\n");
    }

}

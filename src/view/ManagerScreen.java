package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Menu;
import model.Order;
import model.Product;

public class ManagerScreen {
    public void displayLine() {
        System.out.println("------------------------------------------------");
    }

    public List<String> managerMainMenu = new ArrayList<>(Arrays.asList("메인 메뉴", "대기주문 목록", "완료주문 목록", "상품 생성", "상품 삭제"));

    public void welcomeMsg() {
        displayLine();
        System.out.println("\"SHAKESHACK BURGER 관리 메뉴\"");
        System.out.println("아래 목록에서 원하는 명령을 골라 입력해주세요");
    }

    public void displayMainMenu() { //관리자 메인메뉴
        welcomeMsg();
        for (int x = 0; x < managerMainMenu.size(); x++) {
            System.out.println(x + ". " + managerMainMenu.get(x));
        }
        displayLine();
    }

    public void waitingOrderList(List<Order> waitingList) { //1. 대기 주문 목록 화면
        displayLine();
        System.out.println("0. 돌아가기");
        System.out.println("[ 대기주문 목록 ]");
        for (int y = 0; y < waitingList.size(); y++) {
            System.out.println((y + 1) + ". " + waitingList.get(y).getWaitingNumber() + " | " + waitingList.get(y).getTotalPrice() + " | " + waitingList.get(y).getOrderDate());
        }
        displayLine();
    }

    public void orderComplete(Order order) { // 대기주문 목록에서 주문 완료 처리 화면
        displayLine();
        System.out.println("주문을 완료처리 하시겠습니까??");
        System.out.println("No. " + order.getWaitingNumber() + "\n주문 일시 : " + order.getOrderDate());
        System.out.println("\n[ Order ]");
        for (Product product : order.orderList) {
            System.out.println(product.getName() + " | "+product.getCount()+" | "
                    + product.getPrice() + " | "
                    + product.getInfo());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("%.1f\n",order.getTotalPrice());
        System.out.println("\n[ 요청 사항 ]");
        System.out.println(order.getRequest());
        System.out.println("\n1. 완료        2. 돌아가기");
        displayLine();
    }

    public void orderCompleteList(List<Order> completeList) { //완료 주문 목록
        displayLine();
        System.out.println("0. 돌아가기\n");
        System.out.println("[ 완료주문 목록 ]");
        for (int y = 0; y < completeList.size(); y++) {
            System.out.println((y + 1) + ". " + completeList.get(y).getWaitingNumber() + " | " + completeList.get(y).getTotalPrice() + " | " + completeList.get(y).getOrderDate());
        }
        displayLine();
    }

    public void orderCompleteNumber(Order order) { // 완료된 주문 상세보기
        displayLine();
        System.out.println("No. " + order.getWaitingNumber() + "\n주문 일시 : " + order.getOrderDate() + "\n완료 일시 : " + order.getCompleteDate());
        System.out.println("\n[ Order ]");
        for (Product product : order.orderList) {
            System.out.println(product.getName() + " | "+product.getCount()+" | "
                    + product.getPrice() + " | "
                    + product.getInfo());
        }
        System.out.println("\n[ Total ]");
        System.out.printf("%.1f\n",order.getTotalPrice());
        System.out.println("\n[ 요청 사항 ]");
        System.out.println(order.getRequest());
        System.out.println("3초후 메뉴판으로 돌아갑니다." + "\n");
        displayLine();
        // 3초
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void productCreateMenu(List<Menu> menu) {//상품 생성화면 메뉴목록
        displayLine();
        System.out.println("[ 메뉴 목록 ]");
        int x;
        for (x = 0; x < menu.size(); x++) {
            System.out.println(
                    (x + 1) + ". " + menu.get(x).getName() + " | " + menu.get(x).getInfo());
        }
        System.out.println((x + 1) + ". " + "신규 메뉴 생성");
        displayLine();
    }

    public void productCreate(String menuName, String menuInfo, String productName, String productInfo, double productPrice) {
        //상품 생성 멘트
        displayLine();
        System.out.printf("%s | %s \n%s | %s | %.1f\n위 상품을 추가하시겠습니까?\n", menuName, menuInfo, productName, productInfo, productPrice);
        System.out.println("1. 확인        2. 취소");
        displayLine();
    }

    public void productCreateComplete(String newProductName) { //상품 생성 완료 멘트
        displayLine();
        System.out.println(newProductName + " 상품이 추가되었습니다.");
        displayLine();
    }

    public void productDeleteMenu(List<Menu> menu) {//삭제할 상품목록
        displayLine();
        System.out.println("[ 메뉴 목록 ]");
        int x;
        for (x = 0; x < menu.size(); x++) {
            System.out.println(
                    (x + 1) + ". " + menu.get(x).getName() + " | " + menu.get(x).getInfo());
        }
        System.out.println("삭제할 상품이 들어있는 메뉴를 선택해주세요");
        displayLine();

    }

    public void productDeleteSelect(List<Product> product) {//삭제할 상품 목록 선택화면
        displayLine();
        System.out.println("삭제할 상품을 선택해주세요");
        int x;
        for (x = 0; x < product.size(); x++) {
            System.out.println(
                    (x + 1) + ". " + product.get(x).getName() + " | " + product.get(x).getInfo());
        }
        System.out.println("(번호 입력)");
        displayLine();
    }

    public void deleteReconfirm() { //삭제 재확인
        displayLine();
        System.out.println("정말 삭제하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        displayLine();
    }

    public void deleteComplete(String deleteProductName) {//삭제 완료
        displayLine();
        System.out.println(deleteProductName + " 상품이 삭제 되었습니다.");
        displayLine();
    }

}

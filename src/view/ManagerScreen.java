package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Order;
import model.Product;
import model.Store;
import product.MainMenu;

public class ManagerScreen{
    public void displayLine(){
        System.out.println("------------------------------------------------");
    }
    public List<String> managerMainMenu = new ArrayList<>(Arrays.asList("메인 메뉴", "대기주문 목록", "완료주문 목록", "상품 생성", "상품 삭제"));
    Order order = new Order();
    Store store = new Store();
    MainMenu mainMenu = new MainMenu();
    public void welcomeMsg(){
        System.out.println("\"SHAKESHACK BURGER 관리 메뉴\"");
        System.out.println("아래 목록에서 원하는 명령을 골라 입력해주세요");
    }
    public void displayMainMenu(){ //관리자 메인메뉴
        welcomeMsg();
        for(int x =0; x<managerMainMenu.size();x++){
            System.out.println(x+". "+managerMainMenu.get(x));
        }
    }
    public void waitingOrderList(int x){ //1. 대기 주문 목록 화면
        System.out.println("0. 돌아가기\n");
        System.out.println("[ 대기주문 목록 ]");
        for(int y = 0;y<order.orderList.size();y++){
            //System.out.println((x+1)+". "+order.waitingNumber.get(x)+"|"+"주문 총 가격"+"|"+"주문 일시");
        }
    }
    public void orderComplete(int x){ // 대기주문 목록에서 주문 완료 처리 화면
        System.out.println("주문을 완료처리 하시겠습니까??");
        System.out.println("No. "+(x-1)+ "주문 일시 : "+(x-1));
        System.out.println("[ Order ]");
        System.out.println((x-1)+" | "+"price"+"info\n");
        System.out.println("[ Total ]");
        System.out.println("토탈 가격\n");
        System.out.println("[ 요청 사항 ]");
        System.out.println("~~~~~~\n");
        System.out.println("1. 완료        2. 돌아가기");

    }

    public void orderCompleteList(int x){ //완료 주문 목록
        System.out.println("0. 돌아가기\n");
        System.out.println("[ 완료주문 목록 ]");
//        for(int x = 0;x<=store.;x++){
//            System.out.println((x+1)+". "+"대기번호"+"|"+"주문 총 가격"+"|"+"주문 일시");
//        }

    }

    public void orderCompleteNumber(int x){ //완료된 주문 상세내역
        System.out.println("No. "+(x-1)+ "주문 일시 : "+(x-1));
        System.out.println("[ Order ]");
        System.out.println((x-1)+" | "+"price"+"info\n");
        System.out.println("[ Total ]");
        System.out.println("토탈 가격\n");
        System.out.println("[ 요청 사항 ]");
        System.out.println("~~~~~~\n");
        System.out.println("1. 돌아가기");
    }

    public void productCreateMenu(){//상품 생성화면 메뉴목록
        System.out.println("[ 메뉴 목록 ]");
        int x;
        for(x=0;x<mainMenu.mainMenu.size();x++) {
            System.out.println(
                (x + 1) + ". " + mainMenu.mainMenu.get(x).getName() + " | " + mainMenu.mainMenu.get(x)
                    .getInfo());
        }
        System.out.println((x+1)+". "+"신규 메뉴 생성");
    }

    public void productCreate(String newMenuName, String newMenuInfo, String newProductName, String newProductInfo, double newProductPrice){
        //상품 생성 멘트
        System.out.println(newMenuName+" | "+newMenuInfo+" | "+newProductName+" | "+newProductPrice+" | "+newProductInfo+"\n위 상품을 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public void productCreateComplete(String newProductName){ //상품 생성 완료 멘트
        System.out.println(newProductName+" 상품이 추가되었습니다.");
    }

    public void productDelete(){//삭제할 상품목록

        //qqq
    }




}

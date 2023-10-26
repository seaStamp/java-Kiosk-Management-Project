package view;

import model.Menu;
import model.Order;
import model.Product;

public class CustomerScreen {
    private final static Product SHACKBURGER = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9);
    private final static Product SMOKESHACK = new Product("SmokeShack", "베이컨, 체리 패퍼에 쉑소스가 토핑된 치즈버거", 6.9);
    private final static Product SHROOM_BURGER = new Product("ShroomBurger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 6.9);
    private final static Product HAMBURGER = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 6.9);

    public void displayLine(){
        System.out.println("-------------------------------");
    }
    public void welcomeMsg() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
    }
    public void displayMainMenu(){
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요");
        System.out.println("[ SHAKESHACK MENU ]");
        // 메뉴

        System.out.println("[ ORDER MENU ] ");
        //
    }
    public void displayProductMenu() {
        welcomeMsg();
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
    }

//    public void startScreen(){
//        System.out.println("7. 시작 화면으로");
//    }

}

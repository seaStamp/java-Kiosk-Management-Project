package view;

public class CustomerScreen {

    public void displayLine(){
        System.out.println("-------------------------------");
    }
    public void welcomeMsg() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
    }
    public void displayMainMenu(){
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요");
        System.out.println("[ SHAKESHACK MENU ]");
        // 전체 메뉴 불러오기
        // Order & Cancel 불러오기
    }
    public void displayProductMenu() {
        welcomeMsg();
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
    }

//    public void startScreen(){
//        System.out.println("7. 시작 화면으로");
//    }

}

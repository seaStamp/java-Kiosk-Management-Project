package product;

import model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ShakeShackAllMenu {

    // burger 메뉴
    private final static Product SHACKBURGER = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 8.4);
    private final static Product SMOKESHACK = new Product("SmokeShack", "베이컨, 체리 패퍼에 쉑소스가 토핑된 치즈버거", 10.6);
    private final static Product SHROOM_BURGER = new Product("ShroomBurger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 10.0);
    private final static Product HAMBURGER = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 6.8);

    // custard 메뉴
    private final static Product ANTHRACITE_COFFEE_SHAKE = new Product("Anthracite Coffee Shake", "로컬 로스팅 브랜드 앤트러사이트와 협업한 기간 한정 콜라보레이션 커피 쉐이크", 6.5);
    private final static Product CLASSIC_HAND_SPUN_SHAKE = new Product("Classic Hand-Spun Shake", "쫀득하고 진한 커스터트가 들어간 클래식 쉐이크", 6.5);
    private final static Product FLOATS = new Product("Floats", "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료", 6.5);
    private final static Product CUP_CONES = new Product("Cup & Cones", "매일 점포에서 신선하게 제조하는 쫀득하고 진한 아이스크림", 5.4);

    // drink 메뉴
    private final static Product RASPBERRY_LEMONADE = new Product("Raspberry Lemonade", "쉐이크쉑 시그니처 레몬에이드에 상큼 달콤한 라즈베리가 더해진 시즌 한정 레몬에이드", 4.8);
    private final static Product LEMONADE = new Product("Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 4.3);
    private final static Product FRESH_BREWED_ICED_TEA = new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스 티", 3.5);
    private final static Product FIFTY_FIFTY = new Product("Fifty/Fifty", "레몬에이드와 유기농 홍차를 우려낸 아이스티가 만나 탄생한 쉐이크쉑의 시그니처 음료", 3.8);

    // concretes 메뉴
    private final static Product SHACK_ATTACK = new Product("Shack Attack", "진한 초콜릿 커스터드에 퍼지 소스와 세 가지 초콜릿 토핑이 블렌딩된 쉐이크쉑의 대표 콘크리트", 6.2);
    private final static Product HONEY_BUTTER_CRUNCH  = new Product("Honey Butter Crunch", "바닐라 커스터드에 허니 버터 소스와 슈가 콘이 달콤하게 블렌딩된 콘크리트", 6.2);
    private final static Product BETTER_2GETHER = new Product("Better 2Gether", "바닐라와 초콜릿 커스터드를 반씩 넣고 초콜릿 트러플 쿠키 도우와 쇼트브레드를 믹스한, 함께라서 더욱 특별한 콘크리트", 6.2);
    private final static Product SHACK_FFOGATO = new Product("Shack-ffogato", "바닐라 커스터드에 커피 카라멜 소스, 초콜릿 토피, 초콜릿 청크, 코코아 파우더가 어우러진 쉐이크쉑만의 아포가토 콘크리트", 6.2);

    public ArrayList<Product> burger = new ArrayList<>(Arrays.asList(SHACKBURGER, SMOKESHACK, SHROOM_BURGER, HAMBURGER));
    public ArrayList<Product> custard = new ArrayList<>(Arrays.asList(ANTHRACITE_COFFEE_SHAKE, CLASSIC_HAND_SPUN_SHAKE, FLOATS, CUP_CONES));
    public ArrayList<Product> drink = new ArrayList<>(Arrays.asList(RASPBERRY_LEMONADE, LEMONADE, FRESH_BREWED_ICED_TEA, FIFTY_FIFTY));
    public ArrayList<Product> concretes = new ArrayList<>(Arrays.asList(SHACK_ATTACK, HONEY_BUTTER_CRUNCH, BETTER_2GETHER, SHACK_FFOGATO));

}

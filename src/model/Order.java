package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> orderList = new ArrayList<>(); // 주문상품 목록
    private int waitingNumberId = 0; // 대기자번호 id
    private String request = ""; // 요청사항
    private String orderDate = ""; // 주문일시
    private String completeDate = ""; // 완료일시
    private boolean orderState = false; // 주문상태 (대기 - false, 완료 - true)
    private double totalPrice = 0; // 총 가격

    public Order(List<Product> orderList, int waitingNumberId, String request, String orderDate, String completeDate, boolean orderState) {
        this.orderList = orderList;
        this.waitingNumberId = waitingNumberId;
        this.request = request;
        this.orderDate = orderDate;
        this.completeDate = completeDate;
        this.orderState = orderState;
    }

    // 목록의 수량을 반환하는 메서드
    /*public int getCount() {
        return count;
    }*/

    // 총 가격을 반환하는 메서드
    public double getTotalPrice() {
       // totalPrice += Product.price;
        return totalPrice;
    }

    // 주문 상태를 반환하는 메서드 (완료일시가 null이 아니면 True)
    public boolean getOrderState() {
        if(!completeDate.isEmpty()) { // 완료일시가 비어있지 않으면 완료상태
            orderState = true;
        }
        return orderState;
    }
}

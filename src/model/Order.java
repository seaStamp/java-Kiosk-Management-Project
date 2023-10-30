package model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static Product product;
    private static Store store;
    public List<Product> orderList = new ArrayList<>(); // 주문상품 목록 (장바구니)
    private int waitingNumber; // 대기번호 id
    private String request; // 요청사항
    private String orderDate; // 주문일시
    private String completeDate; // 완료일시
    private boolean orderState; // 주문상태 (대기 - false, 완료 - true)
    private double totalPrice; // 총 가격

    public Order() {}

    public Order(List<Product> orderList, int waitingNumber, double totalPrice) {
        this.orderList = orderList;
        this.waitingNumber = waitingNumber;
        this.totalPrice = totalPrice;
        request = "";
        orderDate = "";
        completeDate = "";
        orderState = false;
    }
    
    // 이미 order list에 존재하는지 확인하는 메서드
    public boolean alreadyExistInOrderList(Product product) {
        boolean exist = false;

        if(orderList.contains(product))
            exist = true;

        return exist;
    }

    // 목록의 수량을 반환하는 메서드
    public int addCount(Product product) {
        return product.getCount()+1;
    }

    // 총 가격을 계산하여 반환하는 메서드
    public double addTotalPrice(Product product) {
        totalPrice += product.getPrice();
        return totalPrice;
    }

    // 주문했을 때 입력받은 값을 저장하는 메서드 (대기자번호id, 요청사항, 주문일시)
    public void saveOrder(int waitingNumber, String request) {
        String currentDate = LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul")).toString();

        this.setRequest(request);
        this.setOrderDate(currentDate);
        this.setWaitingNumber(waitingNumber);
        Store.waitingList.add(this);
        /*
        Order inCartOrder = new Order(orderList, waitingNumber, totalPrice);
        inCartOrder.setRequest(request);
        inCartOrder.setOrderDate(currentDate);
        inCartOrder.setTotalPrice(totalPrice);

        store.waitingList.add(inCartOrder);
         */
    }

    // 주문 상태를 반환하는 메서드 (완료일시가 null이 아니면 True)
    public boolean getOrderState() {
        if(completeDate == null) { // 완료일시가 비어있지 않으면 완료상태
            completeDate = LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul")).toString();
            orderState = true;
        }
        return orderState;
    }

    public List<Product> getOrderList() { return orderList; }
    public String getOrderDate() {
        return orderDate;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public String getRequest() {
        return request;
    }

    public void setOrderState(boolean orderState) {
        this.orderState = orderState;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setWaitingNumber(int waitingNumber) {
        this.waitingNumber = waitingNumber;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

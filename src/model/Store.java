package model;

import java.util.ArrayList;
import java.util.List;

public class Store {

    public static List<Menu> menu = new ArrayList<>();
    public static List<Order> waitingList = new ArrayList<>(); // 대기중인 주문리스트
    public static List<Order> completedList = new ArrayList<>(); // 완료된 주문리스트
}

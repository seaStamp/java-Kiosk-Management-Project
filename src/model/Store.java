package model;

import java.util.ArrayList;

public class Store {
    public static ArrayList<Menu> menu = new ArrayList<>();
    public static ArrayList<Order> waintingList = new ArrayList<>(); // 대기중인 주문리스트
    public static ArrayList<Order> completedList = new ArrayList<>(); // 완료된 주문리스트
}

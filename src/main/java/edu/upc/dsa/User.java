package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User {

    List<Order> orders;
    String name;

    public User (String name){
        orders = new LinkedList<>();
        this.name = name;
    }
    public void addOrder(Order o){

        orders.add(o);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

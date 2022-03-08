package lk.ijse.pos_system.entity;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String orderDate;
    private String custID;
    private ArrayList <OrderDetails>items;

    public Order() {
    }

    public Order(String orderID, String orderDate, String custID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
    }

    public Order(String orderID, String orderDate, String custID, ArrayList<OrderDetails> items) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", custID='" + custID + '\'' +
                ", items=" + items +
                '}';
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public ArrayList<OrderDetails> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderDetails> items) {
        this.items = items;
    }
}

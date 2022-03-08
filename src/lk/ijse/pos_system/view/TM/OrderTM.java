package lk.ijse.pos_system.view.TM;

public class OrderTM{
    private String orderID;
    private String orderDate;
    private String custID;


    public OrderTM(String orderID, String orderDate, String custID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", custID='" + custID + '\'' +

                '}';
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderid) {
        this.orderID = orderid;
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

}

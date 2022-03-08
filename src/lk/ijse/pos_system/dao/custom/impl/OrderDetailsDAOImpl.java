package lk.ijse.pos_system.dao.custom.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import lk.ijse.pos_system.dao.CrudUtil;
import lk.ijse.pos_system.dao.custom.OrderDetailsDAO;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public boolean add(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `Order Details` VALUES(?,?,?,?,?)",orderDetails.getOrderID(),
                orderDetails.getItemCode(),orderDetails.getOrderQTY(),orderDetails.getDiscont(),
                orderDetails.getTotal());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("DELETE FROM `Order Details` WHERE OrderID=?",s);
    }

    @Override
    public boolean update(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `Order Details` SET  Orderqty=?, Discount=?,Price=? WHERE OrderID=?",
                orderDetails.getOrderQTY(),orderDetails.getDiscont(),
                orderDetails.getTotal(),orderDetails.getOrderID());
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM `Order Details` WHERE OrderID=?",s);
        rst.next();
        return  new OrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),rst.getDouble(5));
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
       ResultSet rst=CrudUtil.executeQuery("SELECT * FROM `Order Details`");
       ArrayList<OrderDetails>getAllOrderDetails=new ArrayList<>();
       while (rst.next()){
           getAllOrderDetails.add(new OrderDetails(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getDouble(4),
                   rst.getDouble(5)));
       }
       return getAllOrderDetails;
    }

    @Override
    public ResultSet getOrderIncomeItems() throws SQLException, ClassNotFoundException {
       return CrudUtil.executeQuery("SELECT * FROM `Order Details`");
    }

    @Override
    public ResultSet getOrderItems(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeQuery("SELECT  * FROM `Order Details` WHERE ItemCode=?",id);
    }
}

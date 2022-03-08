package lk.ijse.pos_system.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.pos_system.dao.CrudUtil;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean add(Order order) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO `Order` VALUES (?,?,?)",order.getOrderID(),order.getOrderDate(),
                order.getCustID());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM `Order` WHERE OrderID=?",s);
    }

    @Override
    public boolean update(Order order) throws SQLException, ClassNotFoundException {
       return false;
    }

    @Override
    public Order search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM `Order` WHERE OrderID=?",s);
        rst.next();
        return new Order(rst.getString(1),rst.getString(2),rst.getString(3));
    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM `Order`");
        ArrayList<Order> getAllOrder=new ArrayList<>();

        while (rst.next()){
            getAllOrder.add(new Order(rst.getString(1),rst.getString(2),rst.getString(3)));
        }

        return getAllOrder;
    }

    @Override
    public ResultSet getCustomerOrder(String id) throws ClassNotFoundException, SQLException {
       return CrudUtil.executeQuery("Select * from `Order` WHERE CustID=?",id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT OrderID FROM `Order` ORDER BY OrderID DESC LIMIT 1;");
        return rst.next() ? String.format("O%03d", (Integer.parseInt(rst.getString("OrderID").replace("O", "")) + 1)) : "O001";
    }
}

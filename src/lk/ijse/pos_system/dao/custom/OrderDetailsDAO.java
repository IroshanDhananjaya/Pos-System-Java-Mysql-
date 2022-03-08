package lk.ijse.pos_system.dao.custom;


import lk.ijse.pos_system.dao.CrudDAO;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails,String> {
    ResultSet getOrderIncomeItems() throws SQLException, ClassNotFoundException;
    ResultSet getOrderItems(String id) throws SQLException, ClassNotFoundException;
}

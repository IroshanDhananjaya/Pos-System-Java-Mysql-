package lk.ijse.pos_system.dao.custom;

import lk.ijse.pos_system.dao.CrudDAO;
import lk.ijse.pos_system.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO <Order,String> {
     ResultSet getCustomerOrder(String Id) throws SQLException, ClassNotFoundException;
     String generateNewOrderId() throws SQLException, ClassNotFoundException;
}

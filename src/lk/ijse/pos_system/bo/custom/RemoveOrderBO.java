package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.Order;

import java.sql.SQLException;

public interface RemoveOrderBO extends SuperBO {
    Order searchOrder(String Id) throws SQLException, ClassNotFoundException;
    boolean removeOrder(String id) throws SQLException, ClassNotFoundException;
}

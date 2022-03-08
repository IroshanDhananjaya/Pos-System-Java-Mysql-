package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.dto.OrderDTO;
import lk.ijse.pos_system.dto.OrderDetailsDTO;
import lk.ijse.pos_system.entity.Order;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.SQLException;

public interface ModifyOrderBO extends SuperBO {
    boolean updateOrder(OrderDetailsDTO dto) throws SQLException, ClassNotFoundException;
    OrderDetails searchOrder(String id) throws SQLException, ClassNotFoundException;
}

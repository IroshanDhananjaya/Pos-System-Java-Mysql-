package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.dto.OrderDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface MakeOrderBO extends SuperBO {
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
    boolean placeOrder(OrderDTO dto);
    List<String> loadItemIds() throws SQLException, ClassNotFoundException;
    Item setItemData(String itemId) throws SQLException, ClassNotFoundException;
    void updateItemQTY(String id,int qrt) throws SQLException, ClassNotFoundException;
    Customer setCustomerData(String customerId) throws SQLException, ClassNotFoundException;
    List<String> loadCustomerIds() throws SQLException, ClassNotFoundException;
}

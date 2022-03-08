package lk.ijse.pos_system.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.CustomerOrderDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CashierDashboardBO extends SuperBO {
    ResultSet getCustomerOrder(String Id) throws SQLException, ClassNotFoundException;
    List<String> loadCustomerIds() throws SQLException, ClassNotFoundException;
    ObservableList<CustomerOrderDTO> setCustomeOrderItem(String id) throws SQLException, ClassNotFoundException;
    Customer setCustomerData(String customerId) throws SQLException, ClassNotFoundException;
}

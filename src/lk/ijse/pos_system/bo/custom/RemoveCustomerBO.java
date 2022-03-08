package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface RemoveCustomerBO extends SuperBO {
    boolean removeCustomer(String id) throws SQLException, ClassNotFoundException;
    Customer setCustomerData(String customerId) throws SQLException, ClassNotFoundException;
    List<String> loadCustomerIds() throws SQLException, ClassNotFoundException;

}

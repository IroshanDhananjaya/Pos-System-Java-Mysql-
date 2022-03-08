package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public interface SearchCustomerBO extends SuperBO {
    Customer searchCustomer(String id) throws SQLException, ClassNotFoundException;
}

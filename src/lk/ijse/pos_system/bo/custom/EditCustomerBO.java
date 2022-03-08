package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public interface EditCustomerBO extends SuperBO {
    boolean editCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    Customer searchCustomer(String id) throws SQLException, ClassNotFoundException;
}

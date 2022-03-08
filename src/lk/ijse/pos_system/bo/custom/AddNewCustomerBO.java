package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;


public interface AddNewCustomerBO extends SuperBO {
    boolean addNewCustomer(CustomerDTO dto)throws SQLException, ClassNotFoundException ;
}

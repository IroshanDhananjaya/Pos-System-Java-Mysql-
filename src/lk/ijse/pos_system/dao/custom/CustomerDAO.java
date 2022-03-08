package lk.ijse.pos_system.dao.custom;

import lk.ijse.pos_system.dao.CrudDAO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO <Customer,String> {
    List<String> getCustomerIds() throws SQLException, ClassNotFoundException;
}

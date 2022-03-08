package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.SearchCustomerBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class SearchCustomerBOImpl implements SearchCustomerBO {
    private final CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }
}

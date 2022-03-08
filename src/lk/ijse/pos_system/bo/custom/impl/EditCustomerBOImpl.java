package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.EditCustomerBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class EditCustomerBOImpl implements EditCustomerBO {
    private final CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean editCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getCustID(),dto.getCustTitle(),dto.getCustName(),
                dto.getCustAddress(),dto.getCity(),dto.getProvince(),dto.getPostCode()));
    }

    @Override
    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }
}

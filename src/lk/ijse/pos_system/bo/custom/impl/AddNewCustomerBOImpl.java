package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.AddNewCustomerBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class AddNewCustomerBOImpl implements AddNewCustomerBO {

    private final CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addNewCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(new Customer(dto.getCustID(),dto.getCustTitle(),dto.getCustName(),dto.getCustAddress()
                ,dto.getCity(),dto.getProvince(),dto.getPostCode()));
    }
}

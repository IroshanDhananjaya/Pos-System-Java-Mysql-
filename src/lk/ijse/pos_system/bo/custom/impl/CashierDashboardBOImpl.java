package lk.ijse.pos_system.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.pos_system.bo.custom.CashierDashboardBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.dto.CustomerOrderDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Order;
import lk.ijse.pos_system.view.TM.CustomerTM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CashierDashboardBOImpl implements CashierDashboardBO {
    private final OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final CustomerDAO customerDAO=
            (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public ResultSet getCustomerOrder(String Id) throws SQLException, ClassNotFoundException {
       return orderDAO.getCustomerOrder(Id);
    }

    @Override
    public List<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerIds();
    }

    @Override
    public ObservableList<CustomerOrderDTO> setCustomeOrderItem(String id) throws SQLException, ClassNotFoundException {
        double b=0;
        ResultSet rst=itemDAO.getCustomerOrderItem(id);
        ArrayList<CustomerOrderDTO>orderDTOS=new ArrayList<>();
        while (rst.next()){
            b+=rst.getDouble(5);
            orderDTOS.add(new CustomerOrderDTO(rst.getString(1),rst.getInt(3),b));
        }

        ObservableList<CustomerOrderDTO> obList = FXCollections.observableArrayList();

        orderDTOS.forEach(e->obList.addAll(new CustomerOrderDTO(e.getItemCode(),e.getQty(),e.getPrice())));
        return obList;
    }

    @Override
    public Customer setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.search(customerId);
    }
}

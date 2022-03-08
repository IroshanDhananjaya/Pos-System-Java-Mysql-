package lk.ijse.pos_system.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.pos_system.bo.custom.TableControllBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.dao.custom.OrderDetailsDAO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.Order;
import lk.ijse.pos_system.entity.OrderDetails;
import lk.ijse.pos_system.view.TM.CustomerTM;
import lk.ijse.pos_system.view.TM.ItemTM;
import lk.ijse.pos_system.view.TM.OrderDetailsTM;
import lk.ijse.pos_system.view.TM.OrderTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class TableControllerBOImpl implements TableControllBO {
    private final CustomerDAO customerDAO= (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDetailsDAO orderDetailsDAO= (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public ObservableList<CustomerTM> loadAllCustomerforTable() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customerTMS=customerDAO.getAll();
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();

        customerTMS.forEach(e->obList.addAll(new CustomerTM(e.getCustID(),e.getCustTitle(),e.getCustName(),
                e.getCustAddress(),e.getCity(),e.getProvince(),e.getPostCode())));
        return obList;
    }

    @Override
    public ObservableList<ItemTM> loadAllItemforTable() throws SQLException, ClassNotFoundException {
        ArrayList<Item> customerTMS=itemDAO.getAll();
        ObservableList<ItemTM> obList = FXCollections.observableArrayList();

        customerTMS.forEach(e->obList.addAll(new ItemTM(e.getItemID(),e.getItenDescription(),e.getPackSize(),
                e.getUnitPrice(),e.getQtyOnHand())));
        return obList;
    }

    @Override
    public ObservableList<OrderTM> loadAllOrderforTable() throws SQLException, ClassNotFoundException {
        ArrayList<Order> orderTMS=orderDAO.getAll();
        ObservableList<OrderTM> obList = FXCollections.observableArrayList();
        orderTMS.forEach(e->obList.addAll(new OrderTM(e.getOrderID(),e.getOrderDate(),e.getCustID())));
        return obList;
    }

    @Override
    public ObservableList<OrderDetailsTM> loadAllOrderDetailsforTable() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetails> orderDetailsTMS=orderDetailsDAO.getAll();
        ObservableList<OrderDetailsTM> obList = FXCollections.observableArrayList();
        orderDetailsTMS.forEach(e->obList.addAll(new OrderDetailsTM(e.getOrderID(),e.getItemCode(),e.getOrderQTY(),
                e.getDiscont(),e.getTotal())));
        return obList;
    }
}

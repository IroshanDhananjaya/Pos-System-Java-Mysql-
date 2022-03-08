package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.DB.DbConnection;
import lk.ijse.pos_system.bo.custom.MakeOrderBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.dao.custom.OrderDetailsDAO;
import lk.ijse.pos_system.dto.OrderDTO;
import lk.ijse.pos_system.dto.OrderDetailsDTO;
import lk.ijse.pos_system.entity.Customer;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.entity.Order;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MakeOrderBOImpl implements MakeOrderBO {
    private final OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    private final CustomerDAO customerDAO=
            (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    private final OrderDetailsDAO orderDetailsDAO= (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewOrderId();
    }

    @Override
    public boolean placeOrder(OrderDTO dto) {
        Connection con=null;
        try {
            con=DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);
            if(orderDAO.add(new Order(dto.getOrderID(),dto.getOrderDate(),dto.getCustID()))){
                for (OrderDetailsDTO temp:dto.getItems()) {
                    OrderDetails orderDetails=new OrderDetails(dto.getOrderID(),temp.getItemCode(),
                            temp.getOrderQTY(),temp.getDiscont(),temp.getTotal());
                    if(orderDetailsDAO.add(orderDetails)){
                        con.commit();
                        return true;
                    }else {
                        con.rollback();
                        return false;
                    }
                }
            }else{
                con.rollback();
                return false;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<String> loadItemIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getItemIds();
    }

    @Override
    public Item setItemData(String itemId) throws SQLException, ClassNotFoundException {
        return itemDAO.search(itemId);
    }

    @Override
    public void updateItemQTY(String id, int qty) throws SQLException, ClassNotFoundException {
        itemDAO.updateQty(id,qty);
    }
    @Override
    public Customer setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        return customerDAO.search(customerId);
    }
    @Override
    public List<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDAO.getCustomerIds();
    }
}

package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.RemoveOrderBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.entity.Order;

import java.sql.SQLException;

public class RemoveOrderImpl implements RemoveOrderBO {
    private final OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    @Override
    public Order searchOrder(String Id) throws SQLException, ClassNotFoundException {
        return orderDAO.search(Id);
    }

    @Override
    public boolean removeOrder(String id) throws SQLException, ClassNotFoundException {
        return orderDAO.delete(id);
    }
}

package lk.ijse.pos_system.bo.custom.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import lk.ijse.pos_system.bo.custom.ModifyOrderBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.OrderDAO;
import lk.ijse.pos_system.dao.custom.OrderDetailsDAO;
import lk.ijse.pos_system.dto.OrderDTO;
import lk.ijse.pos_system.dto.OrderDetailsDTO;
import lk.ijse.pos_system.entity.Order;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.SQLException;

public class ModifyOrderBOImpl implements ModifyOrderBO {
    private final OrderDetailsDAO orderDetailsDAO =
            (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    @Override
    public boolean updateOrder(OrderDetailsDTO dto) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.update(new OrderDetails(dto.getOrderID(),dto.getItemCode(),dto.getOrderQTY(),
                dto.getDiscont(),dto.getTotal()));
    }

    @Override
    public OrderDetails searchOrder(String id) throws SQLException, ClassNotFoundException {
       return orderDetailsDAO.search(id);
    }
}

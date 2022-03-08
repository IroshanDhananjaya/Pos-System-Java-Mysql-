package lk.ijse.pos_system.dao.custom;

import lk.ijse.pos_system.dao.CrudDAO;
import lk.ijse.pos_system.dto.CustomerOrderDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDAO extends CrudDAO <Item,String> {
    ResultSet getCustomerOrderItem(String id) throws SQLException, ClassNotFoundException;
    List<String> getItemIds() throws SQLException, ClassNotFoundException;
    void updateQty(String id,int qty) throws SQLException, ClassNotFoundException;
}

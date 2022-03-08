package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;

public interface RemoveItemBO extends SuperBO {
    Item searchItem(String Id) throws SQLException, ClassNotFoundException;
    boolean removeItem(String id) throws SQLException, ClassNotFoundException;
}

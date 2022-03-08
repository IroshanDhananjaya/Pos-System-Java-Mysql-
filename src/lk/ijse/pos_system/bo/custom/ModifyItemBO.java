package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dao.SuperDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ModifyItemBO extends SuperBO {
    boolean addNewItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    Item getItem(String id) throws SQLException, ClassNotFoundException;
    List<String> loadItemIds() throws SQLException, ClassNotFoundException;
}

package lk.ijse.pos_system.bo.custom;

import javafx.event.ActionEvent;
import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.dto.ItemDTO;

import java.sql.SQLException;


public interface AddNewItemBO extends SuperBO {
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
}

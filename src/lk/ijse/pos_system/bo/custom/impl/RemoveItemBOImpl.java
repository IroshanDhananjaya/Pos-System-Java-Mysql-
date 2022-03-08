package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.RemoveItemBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;

public class RemoveItemBOImpl implements RemoveItemBO {

    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public Item searchItem(String Id) throws SQLException, ClassNotFoundException {
      return itemDAO.search(Id);
    }

    @Override
    public boolean removeItem(String id) throws SQLException, ClassNotFoundException {
       return itemDAO.delete(id);
    }
}

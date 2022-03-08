package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.AddNewItemBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;

public class AddNewItemBOImpl implements AddNewItemBO {

    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
      return itemDAO.add(new Item(dto.getItemID(),dto.getItenDescription(),dto.getPackSize(),dto.getUnitPrice(),
               dto.getQtyOnHand()));
    }
}

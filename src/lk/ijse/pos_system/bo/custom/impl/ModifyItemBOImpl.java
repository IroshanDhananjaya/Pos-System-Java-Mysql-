package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.ModifyItemBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ModifyItemBOImpl implements ModifyItemBO {
    private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean addNewItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(new Item(dto.getItemID(),dto.getItenDescription(),dto.getPackSize(),dto.getUnitPrice(),
                dto.getQtyOnHand()));
    }

    @Override
    public Item getItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.search(id);
    }

    @Override
    public List<String> loadItemIds() throws SQLException, ClassNotFoundException {
        return itemDAO.getItemIds();
    }
}

package lk.ijse.pos_system.bo.custom.impl;

import lk.ijse.pos_system.bo.custom.IncomeControllerBO;
import lk.ijse.pos_system.dao.DAOFactory;
import lk.ijse.pos_system.dao.custom.ItemDAO;
import lk.ijse.pos_system.dao.custom.OrderDetailsDAO;
import lk.ijse.pos_system.entity.ItemQtyRates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeControllerBOImpl implements IncomeControllerBO {
    int qty;
   private final OrderDetailsDAO orderDetailsDAO=
           (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
   private final ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ResultSet setIncomeData() throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.getOrderIncomeItems();
    }

    @Override
    public List<ItemQtyRates> getItemCode() throws SQLException, ClassNotFoundException {
        List<String> itemIds=new ArrayList<>();
        itemIds=itemDAO.getItemIds();

        List<String>itemCodes=new ArrayList<>();
        itemCodes=getAllItemCode();
        List <ItemQtyRates> itemQtyRates=new ArrayList<>();
        for(int i=0;i<itemIds.size();i++){
            for (int j=0;j<itemCodes.size();j++){
                if(itemIds.get(i).equals(itemCodes.get(j))){
                    qty=0;
                    getItemqty(itemCodes.get(j));
                    itemQtyRates.add(new ItemQtyRates(itemCodes.get(j),qty));
                    break;
                }
            }
        }
        return itemQtyRates;
    }

    @Override
    public int getItemqty(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst=orderDetailsDAO.getOrderItems(s);
        while (rst.next()){
            qty+=rst.getInt(3);
        }
        return qty;
    }

    @Override
    public List<String> getAllItemCode() throws SQLException, ClassNotFoundException {
       List<String>itemIds=itemDAO.getItemIds();
       return itemIds;
    }
}

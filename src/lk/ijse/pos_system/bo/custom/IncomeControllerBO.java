package lk.ijse.pos_system.bo.custom;

import lk.ijse.pos_system.bo.SuperBO;
import lk.ijse.pos_system.entity.ItemQtyRates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IncomeControllerBO extends SuperBO {
    ResultSet setIncomeData() throws SQLException, ClassNotFoundException;
    List<ItemQtyRates> getItemCode() throws SQLException, ClassNotFoundException;
    int getItemqty(String s) throws SQLException, ClassNotFoundException;
    List<String> getAllItemCode() throws SQLException, ClassNotFoundException;
}

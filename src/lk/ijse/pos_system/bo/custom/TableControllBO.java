package lk.ijse.pos_system.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.pos_system.bo.SuperBO;

import lk.ijse.pos_system.view.TM.CustomerTM;
import lk.ijse.pos_system.view.TM.ItemTM;
import lk.ijse.pos_system.view.TM.OrderDetailsTM;
import lk.ijse.pos_system.view.TM.OrderTM;

import java.sql.SQLException;

public interface TableControllBO extends SuperBO {
    ObservableList<CustomerTM>loadAllCustomerforTable() throws SQLException, ClassNotFoundException;
    ObservableList<ItemTM> loadAllItemforTable() throws SQLException, ClassNotFoundException;
    ObservableList<OrderTM> loadAllOrderforTable() throws SQLException, ClassNotFoundException;
    ObservableList<OrderDetailsTM> loadAllOrderDetailsforTable() throws SQLException, ClassNotFoundException;
}

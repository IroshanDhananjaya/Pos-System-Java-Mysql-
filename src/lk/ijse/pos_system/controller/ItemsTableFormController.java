package lk.ijse.pos_system.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.TableControllBO;
import lk.ijse.pos_system.entity.Item;
import lk.ijse.pos_system.view.TM.ItemTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsTableFormController {
    public TableView<ItemTM> tblItem;
    public TableColumn colCode;
    public TableColumn colDiscription;
    public TableColumn colPackSize;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;

    private final TableControllBO tableControllBO =
            (TableControllBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CUSTOMERCONTROLLER);


    public void initialize() {
        try {

            colCode.setCellValueFactory(new PropertyValueFactory<>("itemID"));
            colDiscription.setCellValueFactory(new PropertyValueFactory<>("itenDescription"));
            colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
            colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));


            setCustomersToTable();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCustomersToTable() throws SQLException, ClassNotFoundException {
       ObservableList<ItemTM> obList = tableControllBO.loadAllItemforTable();
        tblItem.setItems(obList);
    }
}

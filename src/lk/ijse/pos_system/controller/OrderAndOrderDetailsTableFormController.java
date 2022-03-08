package lk.ijse.pos_system.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos_system.DB.DbConnection;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.TableControllBO;
import lk.ijse.pos_system.view.TM.OrderDetailsTM;
import lk.ijse.pos_system.view.TM.OrderTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderAndOrderDetailsTableFormController {
    public TableView tblOrder;
    public TableColumn colOrderDate;
    public TableColumn colCustId;
    public ComboBox cmbSelectTable;
    public TableView tblOrderDetails;
    public TableColumn colOrderID2;
    public TableColumn colItemCode2;
    public TableColumn colQTY;
    public TableColumn colDisCount;
    public TableColumn colPrice;
    public TableColumn colOrderCode;
    public TableColumn colOrderTemp;
    private final TableControllBO tableControllBO =
            (TableControllBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CUSTOMERCONTROLLER);

    public void initialize(){
        cmbSelectTable.getItems().addAll("Order","Order Details");
        cmbSelectTable.setValue("Order");


        try {
            colOrderTemp.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            colOrderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
            colCustId.setCellValueFactory(new PropertyValueFactory<>("custID"));

            colOrderID2.setCellValueFactory(new PropertyValueFactory<>("orderid"));
            colItemCode2.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
            colQTY.setCellValueFactory(new PropertyValueFactory<>("orderQTY"));
            colDisCount.setCellValueFactory(new PropertyValueFactory<>("discont"));
            colPrice.setCellValueFactory(new PropertyValueFactory<>("total"));
            loadAllOrderDetails();
            loadAllOrder();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void selectTabelOnAction(ActionEvent actionEvent) {
        if(cmbSelectTable.getValue().equals("Order Details")){
            tblOrder.setVisible(false);
            tblOrderDetails.setVisible(true);
        }else{
            tblOrder.setVisible(true);
            tblOrderDetails.setVisible(false);
        }
    }
    private void loadAllOrder() throws ClassNotFoundException, SQLException {

        tblOrder.setItems(tableControllBO.loadAllOrderforTable());
    }
    private void loadAllOrderDetails() throws ClassNotFoundException, SQLException {

        tblOrderDetails.setItems(tableControllBO.loadAllOrderDetailsforTable());
    }
}

package lk.ijse.pos_system.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.TableControllBO;
import lk.ijse.pos_system.view.TM.CustomerTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class CustomerControllFormController {
    public  AnchorPane CustomerContext;
    public TableView <CustomerTM>tblCustomer;
    public TableColumn colID;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostCode;

    private final TableControllBO tableControllBO =
            (TableControllBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CUSTOMERCONTROLLER);

    public void initialize() {


            colID.setCellValueFactory(new PropertyValueFactory<>("custID"));
            colTitle.setCellValueFactory(new PropertyValueFactory<>("custTitle"));
            colName.setCellValueFactory(new PropertyValueFactory<>("custName"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
            colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
            colProvince.setCellValueFactory(new PropertyValueFactory<>("Province"));
            colPostCode.setCellValueFactory(new PropertyValueFactory<>("postCode"));

        try {
            setCustomersToTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    private void setCustomersToTable() throws SQLException, ClassNotFoundException {

        tblCustomer.setItems(tableControllBO.loadAllCustomerforTable());
    }
    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewCustomerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CustomerContext.getChildren().clear();
        CustomerContext.getChildren().add(load);
    }

    public void editCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/EditCustomerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CustomerContext.getChildren().clear();
        CustomerContext.getChildren().add(load);
    }

    public void searchCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SearchCustomerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CustomerContext.getChildren().clear();
        CustomerContext.getChildren().add(load);
    }

    public void removeCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RemoveCustomerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CustomerContext.getChildren().clear();
        CustomerContext.getChildren().add(load);
    }

}

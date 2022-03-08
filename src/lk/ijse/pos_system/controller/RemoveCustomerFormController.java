package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.CashierDashboardBO;
import lk.ijse.pos_system.bo.custom.MakeOrderBO;
import lk.ijse.pos_system.bo.custom.RemoveCustomerBO;
import lk.ijse.pos_system.bo.custom.impl.CashierDashboardBOImpl;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class RemoveCustomerFormController {
    public JFXComboBox <String>cmdCustomerID;
    public JFXTextField txtName;
    public JFXTextField txtTitle;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtProvince;
    public JFXTextField txtPostCode;
    private final RemoveCustomerBO removeCustomerBO= (RemoveCustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REMOVECUSTOMER);

    public void initialize(){

        try {
            loadCustomerIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmdCustomerID.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setCustomerData(newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
    }



    private void setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        Customer c1 = removeCustomerBO.setCustomerData(customerId);
        if (c1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
           txtTitle.setText(c1.getCustTitle());
           txtName.setText(c1.getCustName());
           txtAddress.setText(c1.getCustAddress());
           txtCity.setText(c1.getCity());
           txtProvince.setText(c1.getProvince());
           txtPostCode.setText(c1.getPostCode());
        }
    }
    private void loadCustomerIds() throws SQLException, ClassNotFoundException {
        cmdCustomerID.getItems().addAll(removeCustomerBO.loadCustomerIds());
    }

    public void removeCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtCity.clear();
        txtPostCode.clear();
        txtProvince.clear();
        txtAddress.clear();
        txtName.clear();
        txtTitle.clear();


        if (removeCustomerBO.removeCustomer(cmdCustomerID.getValue())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();

        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }


    }

}

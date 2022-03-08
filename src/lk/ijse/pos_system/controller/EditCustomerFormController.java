package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.EditCustomerBO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class EditCustomerFormController {

    public TextField txtCustomerID;
    public JFXTextField txtTitle;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtProvince;
    public JFXTextField txtPostCode;

    private final EditCustomerBO editCustomerBO=
            (EditCustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.EDITCUSTOMER);

    public void comfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerDTO dto= new CustomerDTO(txtCustomerID.getText(),txtTitle.getText(),txtName.getText(),
                txtAddress.getText(),txtCity.getText(),txtProvince.getText(),txtPostCode.getText());
        if (editCustomerBO.editCustomer(dto))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();

    }

    public void SelectCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String customerId = txtCustomerID.getText();

        Customer c1= editCustomerBO.searchCustomer(customerId);
        if (c1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(c1);
        }
    }

    void setData(Customer c){
        txtCustomerID.setText(c.getCustID());
        txtTitle.setText(c.getCustTitle());
        txtName.setText(c.getCustName());
        txtAddress.setText(c.getCustAddress());
        txtCity.setText(c.getCity());
        txtProvince.setText(c.getProvince());
        txtPostCode.setText(c.getPostCode());

    }
}

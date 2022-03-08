package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.AddNewCustomerBO;
import lk.ijse.pos_system.dto.CustomerDTO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class AddNewCustomerFormController {
    public JFXTextField txtID;
    public JFXTextField txtTitle;
    public JFXTextField txtName;
    public JFXTextField txtPostCode;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtProvince;

    private final AddNewCustomerBO addNewCustomerBO= (AddNewCustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ADDCUSTOMER);

    public void addNewCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        CustomerDTO dto=new CustomerDTO(txtID.getText(),txtTitle.getText(),txtName.getText(),txtAddress.getText(),
                txtCity.getText(),txtProvince.getText(),txtPostCode.getText());
        if(addNewCustomerBO.addNewCustomer(dto))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }
}

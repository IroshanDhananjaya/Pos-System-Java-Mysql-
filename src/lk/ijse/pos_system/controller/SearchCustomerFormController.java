package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.SearchCustomerBO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.SQLException;

public class SearchCustomerFormController {
    public JFXTextField txtID;
    public JFXTextField txtTitle;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtCity;
    public JFXTextField txtProvince;
    public JFXTextField txtPostCode;
    private final SearchCustomerBO searchCustomerBO=
            (SearchCustomerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.SEARCHCUSTOMER);

    public void searchCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        Customer c= searchCustomerBO.searchCustomer(txtID.getText());
        if (c==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            txtTitle.setVisible(true);
            txtName.setVisible(true);
            txtAddress.setVisible(true);
            txtPostCode.setVisible(true);
            txtProvince.setVisible(true);
            txtCity.setVisible(true);

            txtID.setText(c.getCustID());
            txtTitle.setText(c.getCustTitle());
            txtName.setText(c.getCustName());
            txtAddress.setText(c.getCustAddress());
            txtCity.setText(c.getCity());
            txtProvince.setText(c.getProvince());
            txtPostCode.setText(c.getPostCode());
        }
    }

}

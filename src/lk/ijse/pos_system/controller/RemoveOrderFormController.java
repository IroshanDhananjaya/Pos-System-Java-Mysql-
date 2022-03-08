package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pos_system.DB.DbConnection;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.RemoveOrderBO;
import lk.ijse.pos_system.entity.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RemoveOrderFormController {
    public TextField txtOrderId;
    public JFXTextField txtDate;
    public JFXTextField txtCustID;
    String ItemCode;
    int qty;

    private final RemoveOrderBO removeOrderBO=
            (RemoveOrderBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REMOVEORDER);

    public void searchOrder(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Order o=removeOrderBO.searchOrder(txtOrderId.getText());

        if (o!=null){
            txtDate.setText(o.getOrderDate());
            txtCustID.setText(o.getCustID());
        }else{
            new Alert(Alert.AlertType.WARNING, "Empty Set").show();
        }

    }


    public void removeOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (removeOrderBO.removeOrder(txtOrderId.getText())){
            //updateQtyITEM(txtOrderId.getText());
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }


}

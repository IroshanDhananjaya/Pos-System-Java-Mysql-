package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pos_system.DB.DbConnection;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.ModifyOrderBO;
import lk.ijse.pos_system.dto.OrderDetailsDTO;
import lk.ijse.pos_system.entity.OrderDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifiOrderFormController{
    public AnchorPane modifiOrderContext;
    public TextField txtOrderID;
    public JFXTextField txtItemCode;
    public JFXTextField txtOrderQty;
    public JFXTextField txtDiscount;
    double newTotal;
    Double fullTotal;

    private final ModifyOrderBO modifyOrderBO= (ModifyOrderBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.MODIFYORDER);

  public void searchOrderDetaisOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String OrderID= txtOrderID.getText();

        OrderDetails o=modifyOrderBO.searchOrder(OrderID);
        if (o==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            txtItemCode.setText(o.getItemCode());
            txtOrderQty.setText(String.valueOf(o.getOrderQTY()));
            txtDiscount.setText(String.valueOf(o.getDiscont()));
            fullTotal=(o.getTotal()*100)/(100-Double.parseDouble(txtDiscount.getText()));
        }

    }
    public void comfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
      OrderDetailsDTO i1= new OrderDetailsDTO(txtItemCode.getText(),Integer.parseInt(txtOrderQty.getText()),
                Double.parseDouble(txtDiscount.getText()),newTotal);


        if (modifyOrderBO.updateOrder(i1))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
    }

    void setData(OrderDetails o) {
        txtItemCode.setText(o.getItemCode());
        txtOrderQty.setText(String.valueOf(o.getOrderQTY()));
        txtDiscount.setText(String.valueOf(o.getDiscont()));

        fullTotal=(o.getTotal()*100)/(100-Double.parseDouble(txtDiscount.getText()));
    }


}

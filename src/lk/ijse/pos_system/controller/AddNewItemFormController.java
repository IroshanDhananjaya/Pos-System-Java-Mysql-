package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.AddNewItemBO;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;

public class AddNewItemFormController {
    public JFXTextField txtCode;
    public JFXTextField txtDescription;
    public JFXTextField txtPackSize;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQtyOnHand;

    private final AddNewItemBO addNewItemBO= (AddNewItemBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ADDITEM);


    public void addOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ItemDTO dto = new ItemDTO(
                txtCode.getText(),txtDescription.getText(),txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQtyOnHand.getText())
        );

        if(addNewItemBO.addItem(dto))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();

    }
}

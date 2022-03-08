package lk.ijse.pos_system.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.RemoveItemBO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;

public class RemoveItemFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQTYonhand;

    private final
    RemoveItemBO removeItemBO= (RemoveItemBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.REMOVEITEM);

    public void removeOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (removeItemBO.removeItem(txtCode.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Item i1= removeItemBO.searchItem(txtCode.getText());
        if (i1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            txtDescription.setText(i1.getItenDescription());
            txtPackSize.setText(i1.getPackSize());
            txtUnitPrice.setText(String.valueOf(i1.getUnitPrice()));
            txtQTYonhand.setText(String.valueOf(i1.getQtyOnHand()));
        }
    }

}

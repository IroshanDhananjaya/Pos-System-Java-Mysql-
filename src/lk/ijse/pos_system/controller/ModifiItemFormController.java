package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.MakeOrderBO;
import lk.ijse.pos_system.bo.custom.ModifyItemBO;
import lk.ijse.pos_system.bo.custom.impl.ModifyItemBOImpl;
import lk.ijse.pos_system.dto.ItemDTO;
import lk.ijse.pos_system.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ModifiItemFormController {
    public TextField txtDiscription;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQTYOnhand;
    public JFXComboBox cmdItcomCode;


    private final ModifyItemBO modifyItemBO= (ModifyItemBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.MODIFYITEM);
    public void initialize(){
        try {
            loadItemIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmdItcomCode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setItemData((String) newValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    public void comfirmOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ItemDTO i1= new ItemDTO((String) cmdItcomCode.getValue(),txtDiscription.getText(),txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),Integer.parseInt(txtQTYOnhand.getText())
        );
        if (modifyItemBO.addNewItem(i1))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();

    }

    private void loadItemIds() throws SQLException, ClassNotFoundException {
        cmdItcomCode.getItems().addAll(modifyItemBO.loadItemIds()); }

    private void setItemData(String itemCode) throws SQLException, ClassNotFoundException {
        Item i1 =modifyItemBO.getItem(itemCode) ;
        if (i1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
           txtDiscription.setText(i1.getItenDescription());
           txtPackSize.setText(i1.getPackSize());
           txtUnitPrice.setText(String.valueOf(i1.getUnitPrice()));
           txtQTYOnhand.setText(String.valueOf(i1.getQtyOnHand()));

        }
    }

}

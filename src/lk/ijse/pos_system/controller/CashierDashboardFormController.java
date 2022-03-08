package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.CashierDashboardBO;
import lk.ijse.pos_system.dto.CustomerOrderDTO;
import lk.ijse.pos_system.entity.Customer;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class CashierDashboardFormController{
    public AnchorPane CashierDashboardContext;
    public AnchorPane CashierContext;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox cmbCustomerID;
    public JFXTextField txtCustName;
    public JFXTextField txtCustAddress;
    public JFXTextField TxtDate;
    public JFXTextField txtOrderID;
    public TableView <CustomerOrderDTO>tblItemDetails;
    public TableColumn colItems;
    public TableColumn colQTY;
    public Label lblTotalprice;
    public TableColumn colPrice;

    private static CashierDashboardBO cashierDashboardBO=
            (CashierDashboardBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CASHIERDASHBOARD);



    public void initialize(){
        colItems.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        loadDateAndTime();
        try {
            loadCustomerIds();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        cmbCustomerID.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setCustomerData((String) newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });

    }

    public void loadorder() throws SQLException, ClassNotFoundException {
       ResultSet rst=cashierDashboardBO.getCustomerOrder((String) cmbCustomerID.getValue());
       if(rst.next()){
           txtOrderID.setText(rst.getString(1));
           TxtDate.setText(rst.getString(2));
       }else {
           new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
       }
    }


    private void loadCustomerIds() throws SQLException, ClassNotFoundException {
        List<String> customerIds = cashierDashboardBO.loadCustomerIds();
        cmbCustomerID.getItems().addAll(customerIds);

    }
    private void setItems() throws SQLException, ClassNotFoundException{ double price=0;
        ObservableList<CustomerOrderDTO> obList=cashierDashboardBO.setCustomeOrderItem(txtOrderID.getText());
        for (CustomerOrderDTO temp:obList) {
            price+=temp.getPrice();
        }
        lblTotalprice.setText(String.valueOf(price));
        tblItemDetails.setItems(obList);
    }

    private void setCustomerData(String customerId) throws SQLException, ClassNotFoundException {
        Customer c1 = cashierDashboardBO.setCustomerData((String) cmbCustomerID.getValue());
        if (c1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set");
        } else {
            txtCustName.setText(c1.getCustName());
            txtCustAddress.setText(c1.getCustAddress());
        }
        loadorder();
        setItems();
    }

    private void loadDateAndTime() {
        // load Date
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        // load Time
        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }


    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierDashboardContext.getChildren().clear();
        CashierDashboardContext.getChildren().add(load);
    }

    public void modifiOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ModifiOrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void removeOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RemoveOrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void CustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CustomerTableForCashierForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);


    }

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewCustomerForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void makeOrderOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MakeOrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void showOrderTabels(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderAndOrderDetailsTableForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void orderTabels(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OrderAndOrderDetailsTableForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void MakeOrder(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MakeOrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierContext.getChildren().clear();
        CashierContext.getChildren().add(load);
    }

    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CashierDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        CashierDashboardContext.getChildren().clear();
        CashierDashboardContext.getChildren().add(load);

    }
}

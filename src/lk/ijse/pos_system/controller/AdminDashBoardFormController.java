package lk.ijse.pos_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pos_system.bo.BOFactory;
import lk.ijse.pos_system.bo.custom.IncomeControllerBO;
import lk.ijse.pos_system.entity.ItemQtyRates;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminDashBoardFormController {
    public AnchorPane AdminDashboardContext;
    public AnchorPane contextOne;
    public Label lblMostMovebleItem;
    public Label lblLeastMovebleItem1;
    public Label lblMostMovebleItemQty;
    public Label lblLeastMovebleItemQty;
    public BarChart barChartItem;
    public CategoryAxis x;
    public NumberAxis y;
    private final IncomeControllerBO incomeControllerBO=
            (IncomeControllerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.INCOME);

    public void initialize(){
        XYChart.Series set = new XYChart.Series();
        List <ItemQtyRates>itemQtyRates1=new ArrayList<>();
        try {
            itemQtyRates1=incomeControllerBO.getItemCode();
            for (ItemQtyRates temp:itemQtyRates1
                 ) {
               set.getData().add(new XYChart.Data(temp.getItemCode(),temp.getQty()));
            }
            barChartItem.getData().addAll(set);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        AdminDashboardContext.getChildren().clear();
        AdminDashboardContext.getChildren().add(load);

    }

    public void addNewItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddNewItemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);
    }

    public void modifiItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ModifiItemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);
    }

    public void removeItemOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/RemoveItemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);

    }

    public void CustomerControllOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/CustomerControllForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);
    }

    public void ItemTableOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ItemsTableForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);
    }

    public void incomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/IncomeForm.fxml");
        Parent load = FXMLLoader.load(resource);
        contextOne.getChildren().clear();
        contextOne.getChildren().add(load);
    }



    public void homeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdminDashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        AdminDashboardContext.getChildren().clear();
        AdminDashboardContext.getChildren().add(load);
    }



}

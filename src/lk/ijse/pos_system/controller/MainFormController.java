package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class MainFormController {
    public AnchorPane AdminLoginSlider;
    public Label LblloginClose;

    public AnchorPane DasgboardContext;
    public AnchorPane CashierSlider1;
    public JFXTextField txxCashierUserName;
    public JFXPasswordField txtCashierPassword;
    public Label lblInvalidPassword;
    public JFXTextField txtadminUserName;
    public JFXPasswordField txtAdminPassword;


    public void initialize(){
        AdminLoginSlider.setTranslateX(-1000);
        CashierSlider1.setTranslateX(-1000);



        LblloginClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(CashierSlider1);



            slide.setToX(-1000);
            slide.play();


            CashierSlider1.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                LblloginClose.setVisible(false);
            });
            TranslateTransition slide1 = new TranslateTransition();
            slide1.setDuration(Duration.seconds(0.4));
            slide1.setNode(AdminLoginSlider);



            slide1.setToX(-1000);
            slide1.play();


            AdminLoginSlider.setTranslateX(0);
            slide1.setOnFinished((ActionEvent e)-> {
                LblloginClose.setVisible(false);
            });


        });


    }

    public void adminLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtadminUserName.getText().equals("admin")&txtAdminPassword.getText().equals("admin")){
            URL resource = getClass().getResource("../view/AdminDashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            DasgboardContext.getChildren().clear();
            DasgboardContext.getChildren().add(load);
        }else{
            new Alert(Alert.AlertType.WARNING,"User Name or Password Invalid").show();
        }
    }

    public void CasgierLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txxCashierUserName.getText().equals("cashier")&txtCashierPassword.getText().equals("cashier")) {
            URL resource = getClass().getResource("../view/CashierDashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            DasgboardContext.getChildren().clear();
            DasgboardContext.getChildren().add(load);
        }else{
            new Alert(Alert.AlertType.WARNING,"User Name or Password Invalid").show();
        }

    }

    public void adminLogInOnAction(ActionEvent actionEvent) {
        AdminLoginSlider.setVisible(true);
        LblloginClose.setVisible(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(AdminLoginSlider);

        slide.setToX(0);
        slide.play();

        AdminLoginSlider.setTranslateX(-176);
        slide.setOnFinished((ActionEvent e)-> {
        });
    }

    public void cashierLoginOnAction(ActionEvent actionEvent) {
        CashierSlider1.setVisible(true);
        LblloginClose.setVisible(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(CashierSlider1);

        slide.setToX(0);
        slide.play();

        CashierSlider1.setTranslateX(-176);
        slide.setOnFinished((ActionEvent e)-> {
        });
    }
}

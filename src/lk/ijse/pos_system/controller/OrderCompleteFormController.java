package lk.ijse.pos_system.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class OrderCompleteFormController {
    public AnchorPane cardPaymentContext;
    public JFXButton btnCancel;
    public AnchorPane orderCompleteSlider;
    public AnchorPane paymentContext;
    public Label lblTotal;
    public ComboBox cmbmonth;
    public ComboBox cmbtear;

    public void initialize(){

        cmbmonth.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        cmbtear.getItems().addAll("2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030");

        cardPaymentContext.setTranslateX(-1000);
        orderCompleteSlider.setTranslateX(-1000);



        btnCancel.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(cardPaymentContext);



            slide.setToX(-1000);
            slide.play();


            cardPaymentContext.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                cardPaymentContext.setVisible(false);
            });


        });


    }

    public void CardPaymentOnAction(ActionEvent actionEvent) {
        cardPaymentContext.setVisible(true);
        //LblloginClose.setVisible(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.2));
        slide.setNode(cardPaymentContext);

        slide.setToX(0);
        slide.play();

       cardPaymentContext.setTranslateX(-176);
        slide.setOnFinished((ActionEvent e)-> {
        });
    }

    public void payOnAction(ActionEvent actionEvent) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(cardPaymentContext);



        slide.setToX(-1000);
        slide.play();


        cardPaymentContext.setTranslateX(0);
    }

    public void doneOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DoneOrderForm.fxml");
        Parent load = FXMLLoader.load(resource);
        paymentContext.getChildren().clear();
        paymentContext.getChildren().add(load);

    }

}

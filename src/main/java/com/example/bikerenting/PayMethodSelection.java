package com.example.bikerenting;

import com.example.bikerenting.screen_controller.ScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PayMethodSelection extends ScreenController implements Initializable {

    @FXML
    private RadioButton btnEWallet;
    @FXML
    private RadioButton btnCreditCard;
    @FXML
    private Button btnPaymentMethodSelection;

    public PayMethodSelection() {
    }

    public PayMethodSelection(Stage stage, String screenPath) throws Exception {
        super(stage, screenPath);
    }

    public void show() {
        super.show();
    }

    public void select(ActionEvent actionEvent) {

        ToggleGroup group = new ToggleGroup();
        btnEWallet.setToggleGroup(group);
        btnCreditCard.setToggleGroup(group);
        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {

            // Có lựa chọn
            if (group.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) group.getSelectedToggle();

                System.out.println("Button: " + button.getText());
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        btnEWallet.setToggleGroup(group);
        btnCreditCard.setToggleGroup(group);
        btnCreditCard.setSelected(true);
    }

    public void submit(ActionEvent actionEvent) throws Exception {
        if (btnEWallet.isSelected()) {
            System.out.println("Going in e wallet payment");
//            PayOrderController payOrder = new PayOrderController(this.stage,);
//            payOrder.show();
        } else if (btnCreditCard.isSelected()) {
            PayOrderController payOrder = new PayOrderController(this.stage, "/payOrderCreditCard.fxml");
            payOrder.setStageTitle("Pay via Credit Card");
            Stage prev = (Stage) btnPaymentMethodSelection.getScene().getWindow();
            prev.close();
            payOrder.show();
            System.out.println("Going in credit card payment");
        }
    }
}

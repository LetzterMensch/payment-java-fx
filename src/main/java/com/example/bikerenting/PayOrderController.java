package com.example.bikerenting;

import com.almasb.fxgl.scene.Scene;
import com.example.bikerenting.model.CreditCard;
import com.example.bikerenting.model.EWallet;
import com.example.bikerenting.model.Transaction;
import com.example.bikerenting.screen_controller.ScreenController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.bikerenting.DB.JdbcDao;
import javafx.stage.Window;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Optional;
import java.util.ResourceBundle;

public class PayOrderController extends ScreenController implements Initializable {
    private CreditCard creditCard;
    private EWallet eWallet;
    private Transaction transaction;
    private Boolean method;
    private Scene scene;
    protected Hashtable<String, String> messages;
    @FXML
    private RadioButton btnEWallet;
    @FXML
    private RadioButton btnCreditCard;
    @FXML
    private Button btnConfirmPayment;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField cardHolderName;
    @FXML
    private TextField Amount;
    @FXML
    private TextField cardCVV;
    public PayOrderController() {
    }
    public PayOrderController(Stage stage, String screenPath) throws Exception {
        super(stage, screenPath);
    }
    public PayOrderController(Stage stage, String screenPath, CreditCard creditCard) throws Exception {
        super(stage, screenPath);
        this.creditCard = creditCard;
    }
    public void setPayOrderInfo(){
        Integer amount = 100_000;
        Amount.setText(amount.toString());
        Amount.setDisable(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        btnEWallet.setToggleGroup(group);
        btnCreditCard.setToggleGroup(group);
        btnEWallet.setSelected(false);
        btnCreditCard.setSelected(true);
        btnCreditCard.setDisable(true);
        btnEWallet.setDisable(true);
        setPayOrderInfo();
    }

    public void confirmPayment(Event e) throws Exception {
        Window owner = btnConfirmPayment.getScene().getWindow();
        Stage prev = (Stage)owner;
        String cardNumber = this.cardNumber.getText();
        String cardHolderName = this.cardHolderName.getText();
        String cardCVV = this.cardCVV.getText();
        String amount = this.Amount.getText();
        if(cardNumber.isEmpty() || cardHolderName.isEmpty() || cardCVV.isEmpty() || amount.isEmpty()) {
            this.messages = new Hashtable<>();
            this.messages.put("error", "Please fill all the fields");
            this.messages.put("cardNumber", "Please fill all the fields");
            this.messages.put("cardHolderName", "Please fill all the fields");
            this.messages.put("cardCVV", "Please fill all the fields");
            showAlert(Alert.AlertType.ERROR, owner, "Please fill all the fields", this.messages.get("error"));
        }
        else {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Time createTime = new Time(timestamp.getTime());
            JdbcDao jdbcDao = new JdbcDao();
//            jdbcDao.insertCardRecord(cardNumber, cardHolderName, Date.valueOf("2023-02-08"), cardCVV);
//            String cardID = jdbcDao.getCardID(cardNumber);
//            jdbcDao.insertTransactionRecord(Integer.parseInt(amount),"Credit Card",createTime,"Renting a bike","1");
//            showAlert(Alert.AlertType.INFORMATION, owner,"Payment Successful", "Payment Successful");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Payment Result");
            alert.setHeaderText("Payment Result.");
            alert.setResizable(false);
            alert.setContentText("Payment was Successful !");

            Optional<ButtonType> result = alert.showAndWait();
            ButtonType button = result.orElse(ButtonType.CANCEL);

            if (button != null) {
                System.out.println("close alert");
                prev.close();
            }
        }
    }
    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}

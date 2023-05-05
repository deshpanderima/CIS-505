import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DeshpandeEnhancedFutureValueApp extends Application {
    private TextField monthlyPayment = new TextField();
    private TextField interestRate = new TextField();
    private TextArea result = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblFutureValueDate = new Label();
    private ComboBox<Integer> cmbYears = new ComboBox<>();
    private Button btnClear = new Button("Clear");
    private Button btnCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);

        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        lblInterestRateFormat.setTextFill(Color.RED);

        gridPane.add(lblMonthlyPayment, 0, 0);
        gridPane.add(monthlyPayment, 1, 0);
        gridPane.add(lblInterestRate, 0, 1);
        gridPane.add(interestRate, 1, 1);
        gridPane.add(lblInterestRateFormat, 1, 2);
        gridPane.add(lblYears, 0, 3);
        gridPane.add(cmbYears, 1, 3);
        gridPane.add(lblFutureValueDate, 1, 5);
        gridPane.add(result, 1, 6);

        cmbYears.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(btnClear);
        actionBtnContainer.getChildren().add(btnCalculate);
        gridPane.add(actionBtnContainer, 1, 4);

        primaryStage.setTitle("Deshpande Future Value App.");
        primaryStage.setScene(new Scene(gridPane, 400, 300));
        primaryStage.show();

        // set the event handlers
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void clearFormFields() {
        monthlyPayment.setText("");
        interestRate.setText("");
        result.setText("");
        lblFutureValueDate.setText("");
        cmbYears.setValue(0);
    }

    private void calculateResults() {
        double monthlyPaymentValue = Double.parseDouble(monthlyPayment.getText());
        double interestRateValue = Double.parseDouble(interestRate.getText());
        int yearsValue = cmbYears.getValue();

        FinanceCalculator calculator = new FinanceCalculator();
        double futureValue = calculator.calculateFutureValue(monthlyPaymentValue, interestRateValue, yearsValue);

        lblFutureValueDate.setText("Calculation as of " + getTodayDate());
        result.setText("The future value is $" + futureValue);
    }

    private String getTodayDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        return formatter.format(new Date());
    }

}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeshpandeGradeBookApp extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GradeBookApp");

        // Create form fields
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameTextField = new TextField();

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameTextField = new TextField();

        Label courseLabel = new Label("Course:");
        TextField courseTextField = new TextField();

        Label gradeLabel = new Label("Grade:");
        ComboBox<String> gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "E", "F");

        // Create buttons
        Button clearButton = new Button("Clear");
        Button viewButton = new Button("View Grades");
        Button saveButton = new Button("Save Grade");

        // Create layout
        GridPane formLayout = new GridPane();
        formLayout.setPadding(new Insets(10));
        formLayout.setVgap(10);
        formLayout.setHgap(10);
        formLayout.addRow(0, firstNameLabel, firstNameTextField);
        formLayout.addRow(1, lastNameLabel, lastNameTextField);
        formLayout.addRow(2, courseLabel, courseTextField);
        formLayout.addRow(3, gradeLabel, gradeComboBox);

        VBox buttonsLayout = new VBox(10);
        buttonsLayout.setPadding(new Insets(10));
        buttonsLayout.getChildren().addAll(clearButton, viewButton, saveButton);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(formLayout, buttonsLayout);

        // Create scene
        Scene scene = new Scene(layout, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

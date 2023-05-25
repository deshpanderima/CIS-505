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

import java.io.*;

public class DeshpandeGradeBookApp extends Application {
    private static final String FILE_NAME = "grades.csv";

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

        // Create result label
        Label resultLabel = new Label();

        // Create scene
        Scene scene = new Scene(new VBox(layout, resultLabel), 400, 350);

        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle Save Grade button action
        saveButton.setOnAction(event -> {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String course = courseTextField.getText();
            String grade = gradeComboBox.getValue();

            Student student = new Student(firstName, lastName, course, grade);
            saveStudentToCSV(student);
        });

        // Handle View Grades button action
        viewButton.setOnAction(event -> {
            String grades = readGradesFromCSV();
            resultLabel.setText(grades);
        });
    }

    private void saveStudentToCSV(Student student) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter pw = new PrintWriter(bw)) {
            // Check if the file is empty, then add the header row
            File file = new File(FILE_NAME);
            if (file.length() == 0) {
                pw.println("firstName,lastName,course,grade");
            }
            pw.println(student.getFirstName() + "," +
                    student.getLastName() + "," +
                    student.getCourse() + "," +
                    student.getGrade());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readGradesFromCSV() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private String course;
        private String grade;

        public Student() {
            // Default constructor
        }

        public Student(String firstName, String lastName, String course, String grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.course = course;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", course='" + course + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }
}

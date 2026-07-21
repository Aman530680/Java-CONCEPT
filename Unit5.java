// ------------------ UNIT 5 : JavaFX + JDBC -----------------------
// Student Management System (JavaFX UI + JDBC Database)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.*;
import java.util.ArrayList;

// ---------------------- DATABASE CLASS ----------------------------
class DBConnect {

    static Connection getConnection() throws Exception {
        // Load driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to database
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "password");
    }
}

// ---------------------- MAIN JAVAFX APP ---------------------------
public class Unit5 extends Application {

    ListView<String> list; // To display student names
    TextField nameField, deptField;

    @Override
    public void start(Stage stage) {

        // Title
        Label title = new Label("STUDENT MANAGEMENT SYSTEM");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Input fields
        nameField = new TextField();
        nameField.setPromptText("Enter Student Name");

        deptField = new TextField();
        deptField.setPromptText("Enter Department");

        // Buttons
        Button addBtn = new Button("Add Student");
        Button viewBtn = new Button("View Students");
        Button deleteBtn = new Button("Delete Student");

        // ListView
        list = new ListView<>();

        // Layout using VBox
        VBox box = new VBox(10);
        box.setPadding(new Insets(20));
        box.getChildren().addAll(title, nameField, deptField, addBtn, viewBtn, deleteBtn, list);

        // Button Events
        addBtn.setOnAction(e -> addStudent());
        viewBtn.setOnAction(e -> viewStudents());
        deleteBtn.setOnAction(e -> deleteStudent());

        // Scene
        Scene scene = new Scene(box, 400, 500);
        stage.setTitle("Unit 5 - JavaFX + JDBC");
        stage.setScene(scene);
        stage.show();
    }

    // ---------------- ADD STUDENT -------------------
    void addStudent() {
        String name = nameField.getText();
        String dept = deptField.getText();

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO student(name,dept) VALUES(?,?)");
            pst.setString(1, name);
            pst.setString(2, dept);

            pst.executeUpdate();
            con.close();

            Alert a = new Alert(Alert.AlertType.INFORMATION, "Student Added!");
            a.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ---------------- VIEW STUDENTS -------------------
    void viewStudents() {
        list.getItems().clear();

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM student");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.getItems().add(rs.getInt("id") + " - " + rs.getString("name"));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ---------------- DELETE STUDENT -------------------
    void deleteStudent() {
        String selected = list.getSelectionModel().getSelectedItem();

        if (selected == null)
            return;

        int id = Integer.parseInt(selected.split(" - ")[0]);

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM student WHERE id=?");
            pst.setInt(1, id);

            pst.executeUpdate();
            con.close();

            viewStudents();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

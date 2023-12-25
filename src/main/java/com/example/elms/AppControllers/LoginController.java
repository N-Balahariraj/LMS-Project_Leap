package com.example.elms.AppControllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.elms.E_LMS;
import com.example.elms.Helpers.JavaSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    public void switchToRegister(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void LogOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("Register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToInstructorHome(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("InstructorHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();}

    @FXML
    public void switchToStudentHome(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();}


    public void switchToAdminHome(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private TextField UserIdField;

    @FXML
    private TextField PasswordField;

    @FXML
    public void loginValidation(ActionEvent event){

        String InputName = UserIdField.getText();
        String InputPassword = PasswordField.getText();

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();

        String S_Query = "SELECT student_id, Email_id FROM Student";
        String I_Query = "SELECT instructor_id, Email_id FROM Instructor";
        String A_Query = "SELECT admin_id, name FROM Admin";

        try{
            Statement S_Stmt = newCon.createStatement();
            ResultSet SQueryOutput = S_Stmt.executeQuery(S_Query);

            while (SQueryOutput.next()){
                if ((SQueryOutput.getString("student_id") + SQueryOutput.getString("Email_id")).equals(InputPassword + InputName)) {
                    System.out.println("Switched to User Page Successfully");
                    switchToStudentHome(event);
                    return;
                }
//                else {
//                    System.out.println("User is Not a Student");
//                }
            }


            Statement I_Stmt = newCon.createStatement();
            ResultSet IQueryOutput = I_Stmt.executeQuery(I_Query);

            while (IQueryOutput.next()) {
                if ((IQueryOutput.getString("instructor_id") + IQueryOutput.getString("Email_id")).equals(InputPassword + InputName)) {
                    System.out.println("Switched to User Page Successfully");
                    switchToInstructorHome(event);
                    return;
                }
//                else {
//                    System.out.println("User is Not an Instructor");
//                }
            }


            Statement A_Stmt = newCon.createStatement();
            ResultSet AQueryOutput = A_Stmt.executeQuery(A_Query);

            while (AQueryOutput.next()) {
                if ((AQueryOutput.getString("admin_id") + AQueryOutput.getString("name")).equals(InputPassword + InputName)) {
                    System.out.println("Switched to Admin Page Successfully");
                    switchToAdminHome(event);
                    return;
                }
//                else {
//                    System.out.println("User is Not an Admin");
//                }
            }

        }
        catch (Exception e){
            System.out.println("Some error occurred : "+e);
        }
    }
}

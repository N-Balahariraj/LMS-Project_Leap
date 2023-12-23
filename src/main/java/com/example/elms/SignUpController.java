package com.example.elms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class SignUpController {

    @FXML
    public TextField InsName;

    @FXML
    public TextField InsPassword;

    @FXML
    public TextField StuName;

    @FXML
    public TextField StuPassword;


    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToInstructorHome(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudentHome(ActionEvent event) throws IOException {
        System.out.println(event);
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void SignUp(ActionEvent event){

        JavaSQL DBConnect = new JavaSQL();
        Connection con = DBConnect.ConnectDB();

        String S_Name = StuName.getText();
        String S_Pass = StuPassword.getText();

        String I_Name = InsName.getText();
        String I_Pass = InsPassword.getText();

        String S_Query = "INSERT INTO student (Student_ID, Email_ID) VALUES ("+S_Pass+","+"'"+S_Name+"'"+")";
        String I_Query = "INSERT INTO instructor (Instructor_ID, Email_ID) VALUES ("+I_Pass+","+"'"+I_Name+"'"+")";

        try{

            if(Objects.equals(S_Name, "") && Objects.equals(S_Pass, "") && Objects.equals(I_Pass, "") && Objects.equals(I_Name, "")){
                System.out.println("Enter your Details to SignUp");
            }
            else if (!Objects.equals(S_Name, "") && !Objects.equals(S_Pass, "")) {
                Statement S_stmt = con.createStatement();
                S_stmt.executeUpdate(S_Query);
                System.out.println("Student Successfully registered");
                switchToStudentHome(event);
            }
            else if (!Objects.equals(I_Name, "") && !Objects.equals(I_Pass, "")) {
                Statement I_stmt = con.createStatement();
                I_stmt.executeUpdate(I_Query);
                System.out.println("Instructor successfully registered");
                switchToInstructorHome(event);
            }
            else{
                System.out.println("Fill all of your respective fields");
            }

        }catch(Exception e){
            System.out.println("Some Error Occurred : "+e);
            System.out.println(I_Query);
            System.out.println(S_Query);
        }


    }
}


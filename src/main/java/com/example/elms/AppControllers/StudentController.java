package com.example.elms.AppControllers;

import com.example.elms.E_LMS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentController {

    @FXML
    private Button LogOutButton;

    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToDashBoard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentDashBoard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToCourses(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentCourses.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToProfile(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("StudentProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void AboutUs(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("AboutUs.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ContactUs(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("ContactUs.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


}

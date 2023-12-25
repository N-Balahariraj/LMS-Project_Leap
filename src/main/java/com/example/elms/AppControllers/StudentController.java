package com.example.elms.AppControllers;

import com.example.elms.E_LMS;
import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.CourseCard;
import com.example.elms.TableControllers.CourseCardController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

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

    ObservableList<CourseCard> CourseList = FXCollections.observableArrayList();

    @FXML
    private HBox CourseBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCourses();
        try {

            for(int i = 0;i < CourseList.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/resources/StudentHome.fxml"));
                HBox Box = fxmlLoader.load();
                CourseCardController CCC = fxmlLoader.getController();
                CCC.setCourses(CourseList.get(i));
                CourseBox.getChildren().add(Box);
            }

        }catch (Exception e){
            System.out.println("Error : "+e);
        }
    }

    public void addCourses() {

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Select Image,Course_Name,Duration,Rating from Course";

        try {
            Statement stmt = newCon.createStatement();
            ResultSet rs = stmt.executeQuery(C_Query);
            while (rs.next()) {
                CourseList.add(new CourseCard(
                        rs.getString("Image"),
                        rs.getString("Course_Name"),
                        rs.getString("Duration"),
                        rs.getString("Rating")
                ));
            }
        } catch (Exception e) {
            System.out.println("Some Error occurred in CourseCardController : " + e);
        }
//        finally {
//            System.out.println(CourseList);
//        }
    }

}

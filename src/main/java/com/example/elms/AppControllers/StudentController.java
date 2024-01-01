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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
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
    public void LogOut(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("Login.fxml"));
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

    // Rendering the course cards in HomePage
    @FXML
    private HBox CourseBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addCourses();

        try {

            for(int i = 0;i < 5;i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Paths.get("C:\\Users\\balah\\IdeaProjects\\Leap_Project\\src\\main\\resources\\com\\example\\elms\\StudentHomeCourseCard.fxml").toUri().toURL());
                HBox Box = fxmlLoader.load();
                CourseCardController CCC = fxmlLoader.getController();
                CCC.setCourses(CourseList.get(i));
                CourseBox.getChildren().add(Box);
            }

        }catch (Exception e){
            System.out.println("Some Error occurred in StudentController 'initialize' : ");
            e.printStackTrace();
        }
    }

    // Rendering the Course Cards in CoursesPage
    @FXML
    private GridPane CoursesGrid;

    @FXML
    public void Refresh(){

        System.out.println("Refresh Invoked");

        try{

            int Column = 0;
            int Row = 1;
            for(int i = 0;i < CourseList.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(Paths.get("C:\\Users\\balah\\IdeaProjects\\Leap_Project\\src\\main\\resources\\com\\example\\elms\\StudentCoursesCourseCard.fxml").toUri().toURL());
                VBox Box = fxmlLoader.load();
                CourseCardController CCC = fxmlLoader.getController();
                CCC.setCourses(CourseList.get(i));

                if(Column == 5){
                    Column = 0;
                    Row++;
                }
                CoursesGrid.add(Box,Column++,Row);
                GridPane.setMargin(Box,new Insets(10));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Course Cards in DashBoard Page

    @FXML
    private ImageView CourseImg;

    @FXML
    private Label CourseLb;

    @FXML
    private Label DurationLb;

    @FXML
    private Label RateLb;




    // Updation of user from Profile Page

    @FXML
    private TextField ContactTxt;

    @FXML
    private TextField IdTxt;

    @FXML
    private TextField MailTxt;

    @FXML
    private TextField NameTxt;
    @FXML
    public void Update(){
        String Contact = ContactTxt.getText();
        String Id = IdTxt.getText();
        String Name = NameTxt.getText();
        String Mail = MailTxt.getText();

        String UpdateProfile = "Update Student Set Name = '"+Name+"',Mobile_No = '"+Contact+"',Email_ID = '"+Mail+"' Where Student_ID = "+Id;

        try{
            Statement stmt = newCon.createStatement();
            int Update = stmt.executeUpdate(UpdateProfile);
            System.out.println(Update+" : Update Successful");
            if(Update == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Your Information Updated Successfully !!!");
                alert.setContentText("Click OK to continue.");
                alert.showAndWait();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Check Your Credentials Again :( ");
            alert.setContentText("Click OK to continue.");
            alert.showAndWait();
        }
    }

    // Fetching Courses Data from Database
    JavaSQL connectNow = new JavaSQL();
    Connection newCon = connectNow.ConnectDB();
    public void addCourses() {

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
            System.out.println("Some Error occurred in StudentController 'AddCourses' : " + e);
        }

    }

}


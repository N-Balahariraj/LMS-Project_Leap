package com.example.elms.TableControllers;

import com.example.elms.E_LMS;
import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.CourseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CourseController {

    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<CourseTable> CourseTable;

    @FXML
    private TableColumn<CourseTable, String> DomainCol;

    @FXML
    private TableColumn<CourseTable, String> DurationCol;

    @FXML
    private TableColumn<CourseTable, Integer> IdCol;

    @FXML
    private TableColumn<CourseTable, String> NameCol;

    @FXML
    private TableColumn<CourseTable, Float> RateCol;

    ObservableList<CourseTable> CourseList = FXCollections.observableArrayList();

    public void loadData() {
        refreshTable();
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DomainCol.setCellValueFactory(new PropertyValueFactory<>("domain"));
        DurationCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        RateCol.setCellValueFactory(new PropertyValueFactory<>("ratings"));
    }

    public void refreshTable() {

        CourseList.clear();

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Select course_id,course_name as Name,course_domain as Domain,Duration,Rating as Ratings from Course";

        try {

            Statement stmt = newCon.createStatement();
            ResultSet rs = stmt.executeQuery(C_Query);
            while (rs.next()) {
                CourseList.add(new CourseTable(
                        rs.getInt("Course_Id"),
                        rs.getString("Name"),
                        rs.getString("Domain"),
                        rs.getString("Duration"),
                        rs.getFloat("Ratings")
                ));
                CourseTable.setItems(CourseList);
            }

        } catch (Exception e) {
            System.out.println("Some Error occurred in CourseController : " + e);
        }
    }

    @FXML
    private TextField IdTxt;

    @FXML
    private TextField NameTxt;

    @FXML
    private TextField DomainTxt;

    @FXML
    private TextField DurationTxt;

    @FXML
    private TextField RateTxt;

    Integer Index;

    @FXML
    void getCourseDetails(MouseEvent event){
        Index = CourseTable.getSelectionModel().getSelectedIndex();
        if(Index <= -1)
            return;
        IdTxt.setText(IdCol.getCellData(Index).toString());
        NameTxt.setText(NameCol.getCellData(Index));
        DomainTxt.setText(DomainCol.getCellData(Index));
        DurationTxt.setText(DurationCol.getCellData(Index));
        RateTxt.setText(RateCol.getCellData(Index).toString());
    }

    PreparedStatement stmt;

    @FXML
    void Update(ActionEvent event){

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Update Course Set Course_Name = ?, Course_Domain = ?, Duration = ?, Rating = ? Where Course_ID = ?";
        try {
             stmt = newCon.prepareStatement(C_Query);
             stmt.setString(1,NameTxt.getText());
             stmt.setString(2,DomainTxt.getText());
             stmt.setString(3,DurationTxt.getText());
             stmt.setFloat(4,Float.parseFloat(RateTxt.getText()));
             stmt.setInt(5,Integer.parseInt(IdTxt.getText()));
             stmt.executeUpdate();
             System.out.println("Record Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Delete(ActionEvent event){
        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Delete from Course Where Course_ID = ?";
        try {
            stmt = newCon.prepareStatement(C_Query);
            stmt.setInt(1,Integer.parseInt(IdTxt.getText()));
            stmt.executeUpdate();
            System.out.println("Record Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}



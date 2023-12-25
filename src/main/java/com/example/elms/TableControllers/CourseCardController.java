package com.example.elms.TableControllers;

import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.CourseCard;
import com.example.elms.Schema.CourseTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseCardController {

    @FXML
    private AnchorPane CourseCard;

    @FXML
    private ImageView CourseImg;

    @FXML
    private Label CourseLb;

    @FXML
    private Label DurationLb;

    @FXML
    private ImageView RateLb;

    ObservableList<CourseCard> CourseList = FXCollections.observableArrayList();
    public void refreshTable() {

        CourseList.clear();

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Select Image,Course_Name,Duration,Rating from Course";

        try {

            Statement stmt = newCon.createStatement();
            ResultSet rs = stmt.executeQuery(C_Query);
            while (rs.next()) {
                CourseList.add(new CourseCard(
                        rs.getString("Name"),
                        rs.getString("Domain"),
                        rs.getString("Duration"),
                        rs.getString("Rating")
                ));
            }

        } catch (Exception e) {
            System.out.println("Some Error occurred in CourseController : " + e);
        }
    }
}

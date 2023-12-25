package com.example.elms.TableControllers;

import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.CourseCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Label RateLb;

    public void setCourses(CourseCard course){
        Image image = new Image(getClass().getResourceAsStream(course.getImgUrl()));
//        Image image = new Image("src/main/resources/com/example/elms/images/Artificial inteligence.jpg");
        CourseImg.setImage(image);
        CourseLb.setText(course.getName());
        DurationLb.setText(course.getDuration());
        RateLb.setText(course.getRate());
    }

}

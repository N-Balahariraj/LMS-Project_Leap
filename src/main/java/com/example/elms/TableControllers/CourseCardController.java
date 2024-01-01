package com.example.elms.TableControllers;

import com.example.elms.Schema.CourseCard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CourseCardController {

    @FXML
    private ImageView CourseImg;

    @FXML
    private Label CourseLb;

    @FXML
    private Label DurationLb;

    @FXML
    private Label RateLb;


    public void setCourses(CourseCard course) throws FileNotFoundException {
        InputStream imageStream = getImageStreamFromPath("C:\\Users\\balah\\IdeaProjects\\Leap_Project\\src\\main\\resources\\com\\example\\elms\\"+course.getImgUrl());
        Image image = new Image(imageStream);
        CourseImg.setImage(image);
        CourseLb.setText(course.getName());
        DurationLb.setText(course.getDuration());
        RateLb.setText(course.getRate());
    }

    public InputStream getImageStreamFromPath(String imagePath) throws FileNotFoundException {
        File imageFile = new File(imagePath);
        return new FileInputStream(imageFile);
    }

}

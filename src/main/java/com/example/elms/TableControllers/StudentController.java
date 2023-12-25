package com.example.elms.TableControllers;


import com.example.elms.E_LMS;
import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.StudentTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.*;

public class StudentController {

    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<StudentTable> StudentTable;

    @FXML
    private TableColumn<StudentTable,Integer> IdCol;

    @FXML
    private TableColumn<StudentTable, String> MailCol;

    @FXML
    private TableColumn<StudentTable, String> MobileCol;

    @FXML
    private TableColumn<StudentTable, String> NameCol;

    ObservableList<StudentTable> StudentList = FXCollections.observableArrayList();

    @FXML
    void loadData(ActionEvent event) {
        refreshTable();
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        MobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        MailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
    }

    public void refreshTable(){

        StudentList.clear();

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Select Student_ID, Name, Mobile_No, Email_ID from Student";

        try{

            Statement stmt = newCon.createStatement();
            ResultSet rs = stmt.executeQuery(C_Query);
            while (rs.next()){
                StudentList.add(new StudentTable(
                        rs.getInt("Student_Id"),
                        rs.getString("Name"),
                        rs.getString("Mobile_No"),
                        rs.getString("Email_ID")
                ));
                StudentTable.setItems(StudentList);
            }

        }catch(Exception e){
            System.out.println("Some Error occurred in StudentController : "+e);
        }
    }

    @FXML
    private TextField IdTxt;

    @FXML
    private TextField NameTxt;

    @FXML
    private TextField MobileTxt;

    @FXML
    private TextField MailTxt;

    Integer Index;

    @FXML
    void getStudentDetails(MouseEvent event){
        Index = StudentTable.getSelectionModel().getSelectedIndex();
        if(Index <= -1)
            return;
        IdTxt.setText(IdCol.getCellData(Index).toString());
        NameTxt.setText(NameCol.getCellData(Index));
        MobileTxt.setText(MobileCol.getCellData(Index));
        MailTxt.setText(MailCol.getCellData(Index));
    }


    PreparedStatement stmt;

    @FXML
    void Delete(ActionEvent event) {
        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String S_Query = "Delete from Student Where Student_ID = ?";
        try {
            stmt = newCon.prepareStatement(S_Query);
            stmt.setInt(1,Integer.parseInt(IdTxt.getText()));
            stmt.executeUpdate();
            System.out.println("Record Deleted Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Update(ActionEvent event) {
        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String I_Query = "Update Student Set Name = ?, Mobile_No = ?, Email_ID = ? Where Student_ID = ?";
        try {
            stmt = newCon.prepareStatement(I_Query);
            stmt.setString(1,NameTxt.getText());
            stmt.setString(2,MobileTxt.getText());
            stmt.setString(3,MailTxt.getText());
            stmt.setInt(4,Integer.parseInt(IdTxt.getText()));
            stmt.executeUpdate();
            System.out.println("Record Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

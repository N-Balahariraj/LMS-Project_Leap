package com.example.elms.TableControllers;

import com.example.elms.E_LMS;
import com.example.elms.Helpers.JavaSQL;
import com.example.elms.Schema.CourseTable;
import com.example.elms.Schema.InstructorTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class InstructorController {

    @FXML
    public void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(E_LMS.class.getResource("AdminHome.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    ObservableList<InstructorTable> InstructorList = FXCollections.observableArrayList();

    @FXML
    private TableView<InstructorTable> InstructorTable;

    @FXML
    private TableColumn<InstructorTable, String> DomainCol;

    @FXML
    private TableColumn<InstructorTable, Integer> IdCol;

    @FXML
    private TableColumn<InstructorTable, String> MailCol;

    @FXML
    private TableColumn<InstructorTable, String> MobileCol;

    @FXML
    private TableColumn<InstructorTable, String> NameCol;

    public void loadData() {
        refreshTable();
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        DomainCol.setCellValueFactory(new PropertyValueFactory<>("domain"));
        MobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        MailCol.setCellValueFactory(new PropertyValueFactory<>("mail"));
    }

    public void refreshTable(){

        InstructorList.clear();

        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String C_Query = "Select Instructor_id, Name,Domain,Mobile_No,Email_ID from Instructor";

        try{

            Statement stmt = newCon.createStatement();
            ResultSet rs = stmt.executeQuery(C_Query);
            while (rs.next()){
                InstructorList.add(new InstructorTable(
                        rs.getInt("Instructor_Id"),
                        rs.getString("Name"),
                        rs.getString("Domain"),
                        rs.getString("Mobile_No"),
                        rs.getString("Email_ID")
                ));
                InstructorTable.setItems(InstructorList);
            }

        }catch(Exception e){
            System.out.println("Some Error occurred in CourseController : "+e);
        }

}


    @FXML
    private TextField IdTxt;

    @FXML
    private TextField NameTxt;

    @FXML
    private TextField DomainTxt;

    @FXML
    private TextField MobileTxt;

    @FXML
    private TextField MailTxt;

    Integer Index;

    @FXML
    void getInstructorDetails(MouseEvent event){
        Index = InstructorTable.getSelectionModel().getSelectedIndex();
        if(Index <= -1)
            return;
        IdTxt.setText(IdCol.getCellData(Index).toString());
        NameTxt.setText(NameCol.getCellData(Index));
        DomainTxt.setText(DomainCol.getCellData(Index));
        MobileTxt.setText(MobileCol.getCellData(Index));
        MailTxt.setText(MailCol.getCellData(Index));
    }


    PreparedStatement stmt;

    @FXML
    void Delete(ActionEvent event) {
        JavaSQL connectNow = new JavaSQL();
        Connection newCon = connectNow.ConnectDB();
        String I_Query = "Delete from Instructor Where Instructor_ID = ?";
        try {
            stmt = newCon.prepareStatement(I_Query);
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
        String I_Query = "Update Instructor Set Name = ?, Domain = ?, Mobile_No = ?, Email_ID = ? Where Instructor_ID = ?";
        try {
            stmt = newCon.prepareStatement(I_Query);
            stmt.setString(1,NameTxt.getText());
            stmt.setString(2,DomainTxt.getText());
            stmt.setString(3,MobileTxt.getText());
            stmt.setString(4,MailTxt.getText());
            stmt.setInt(5,Integer.parseInt(IdTxt.getText()));
            stmt.executeUpdate();
            System.out.println("Record Updated Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

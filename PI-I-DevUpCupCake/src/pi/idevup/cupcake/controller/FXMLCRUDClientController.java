/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;
import pi.idevup.cupcake.connectionBD.Session;
import pi.idevup.cupcake.entities.Client;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.UserService;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Amine Sboui
 */
public class FXMLCRUDClientController implements Initializable {

    @FXML
    private Label userID;
    @FXML
    private Label labelhome;
    @FXML
    private Separator sep;
    @FXML
    private TextField searchfield;
    @FXML
    private TableView<User> userTable;
    @FXML
    private MenuItem deleteUsers;
    @FXML
    private TableColumn<User, Integer> colUserId;
    @FXML
    private TableColumn<User, String> colFirstName;
    @FXML
    private TableColumn<User, String> colLastName;
    @FXML
    private TableColumn<User, String> colusername;
    @FXML
    private TableColumn<User, String> colEmail;
    @FXML
    private TableColumn<User, String> colMp;
    @FXML
    private TableColumn<User, Integer> colActive;
    @FXML
    private PieChart PieChart;
    @FXML
    private TableColumn<User, Boolean> coldetail;
    ObservableList<User> Liste_Users = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    @FXML
    private ImageView imageCli;
    @FXML
    private Label username;
    @FXML
    private Label telT;
    @FXML
    private Label townT;
    @FXML
    private Label addressT;
    @FXML
    private Label facebookT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminList();
        // TODO
    }

    public void AdminList() {
        Liste_Users = FXCollections.observableArrayList(Session.iuserService.getClientAll());
        userTable.setItems(Liste_Users);
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserId.cellFactoryProperty();
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        colFirstName.cellFactoryProperty();
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colLastName.cellFactoryProperty();
        colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colusername.cellFactoryProperty();
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colEmail.cellFactoryProperty();
        colMp.setCellValueFactory(new PropertyValueFactory<>("password"));
        colMp.cellFactoryProperty();
        colActive.setCellValueFactory(new PropertyValueFactory<>("enabled"));
        colActive.cellFactoryProperty();
        //colEdit.setCellValueFactory(new PropertyValueFactory<>("Edit"));
        coldetail.setCellFactory(cellFactory);

        /**
         * *****************Recherche******************************
         */
        ObservableList data = userTable.getItems();
        searchfield.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                userTable.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<User> subentries = FXCollections.observableArrayList();

            long count = userTable.getColumns().stream().count();
            for (int i = 0; i < userTable.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + userTable.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(userTable.getItems().get(i));
                        break;
                    }
                }
            }
            userTable.setItems(subentries);
        });
    }
    Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>> cellFactory
            = new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>() {
        @Override
        public TableCell<User, Boolean> call(final TableColumn<User, Boolean> param) {
            final TableCell<User, Boolean> cell = new TableCell<User, Boolean>() {
                Image imgEdit = new Image(getClass().getResourceAsStream("/pi/idevup/cupcake/ressources/img/loop.png"));
                final Button btnEdit = new Button();

                @Override
                public void updateItem(Boolean check, boolean empty) {
                    super.updateItem(check, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btnEdit.setOnAction(e -> {
                            User user = getTableView().getItems().get(getIndex());
                            detailUser(user);
                        });

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv = new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        iv.setFitWidth(20);
                        iv.setFitHeight(20);
                        btnEdit.setGraphic(iv);
                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }

                private void detailUser(User user) {
                    userID.setText(String.valueOf(user.getId()));
                    username.setText(user.getUsername());
                    telT.setText(user.getPhone());
                    townT.setText(user.getTown());
                    addressT.setText(user.getAddress());
                    facebookT.setText(user.getFacebook());
                }
            };
            return cell;
        }
    };

    @FXML
    private void deleteUsers(ActionEvent event) {
        List<User> users = userTable.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            new UserService().remove(users.get(0).getId());
            System.out.println(users.get(0).getId());
        }
        AdminList();
    }

}

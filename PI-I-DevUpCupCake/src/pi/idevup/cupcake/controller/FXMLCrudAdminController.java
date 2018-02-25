/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.controller;

import pi.idevup.cupcake.connectionBD.Session;
import pi.idevup.cupcake.entities.User;
import pi.idevup.cupcake.services.BCrypt;
import pi.idevup.cupcake.services.UserService;
import com.jfoenix.controls.JFXCheckBox;
import static java.awt.Color.green;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Popup;
import javafx.util.Callback;
import pi.idevup.cupcake.services.serviceCryptage;

/**
 * FXML Controller class
 *
 * @author Amine Sboui
 */
public class FXMLCrudAdminController implements Initializable {

    @FXML
    private Button reset;
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
    private TableColumn<User, String> colEmail;
    @FXML
    private TableColumn<User, Boolean> colEdit;
    @FXML
    private TextField nomT;
    @FXML
    private TextField prenomT;
    @FXML
    private TextField unT;
    @FXML
    private TextField emailT;
    @FXML
    private PasswordField mpT;
    @FXML
    private PasswordField rmpT;
    @FXML
    private Button saveAdmin;
    @FXML
    private Label labelhome;
    @FXML
    private Separator sep;
    @FXML
    private JFXCheckBox activeCB;
    @FXML
    private TableColumn<User, String> colusername;
    @FXML
    private TableColumn<User, String> colMp;
    @FXML
    private TableColumn<User, Integer> colActive;
    ObservableList<User> Liste_Users = FXCollections.observableArrayList();
    @FXML
    private Label userID;
    @FXML
    private TextField searchfield;
    @FXML
    private PieChart PieChart;
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

    public Button getReset() {
        return reset;
    }

    public void setReset(Button reset) {
        this.reset = reset;
    }

    public TableView<?> getUserTable() {
        return userTable;
    }

    public void setUserTable(TableView<User> userTable) {
        this.userTable = userTable;
    }

    public MenuItem getDeleteUsers() {
        return deleteUsers;
    }

    public void setDeleteUsers(MenuItem deleteUsers) {
        this.deleteUsers = deleteUsers;
    }

    public TableColumn<?, ?> getColUserId() {
        return colUserId;
    }

    public void setColUserId(TableColumn<User, Integer> colUserId) {
        this.colUserId = colUserId;
    }

    public TableColumn<?, ?> getColFirstName() {
        return colFirstName;
    }

    public void setColFirstName(TableColumn<User, String> colFirstName) {
        this.colFirstName = colFirstName;
    }

    public TableColumn<?, ?> getColLastName() {
        return colLastName;
    }

    public void setColLastName(TableColumn<User, String> colLastName) {
        this.colLastName = colLastName;
    }

    public TableColumn<?, ?> getColEmail() {
        return colEmail;
    }

    public void setColEmail(TableColumn<User, String> colEmail) {
        this.colEmail = colEmail;
    }

    public TableColumn<?, ?> getColEdit() {
        return colEdit;
    }

    public void setColEdit(TableColumn<User, Boolean> colEdit) {
        this.colEdit = colEdit;
    }

    public TextField getNomT() {
        return nomT;
    }

    public void setNomT(TextField nomT) {
        this.nomT = nomT;
    }

    public TextField getPrenomT() {
        return prenomT;
    }

    public void setPrenomT(TextField prenomT) {
        this.prenomT = prenomT;
    }

    public TextField getUnT() {
        return unT;
    }

    public void setUnT(TextField unT) {
        this.unT = unT;
    }

    public TextField getEmailT() {
        return emailT;
    }

    public void setEmailT(TextField emailT) {
        this.emailT = emailT;
    }

    public PasswordField getMpT() {
        return mpT;
    }

    public void setMpT(PasswordField mpT) {
        this.mpT = mpT;
    }

    public PasswordField getRmpT() {
        return rmpT;
    }

    public void setRmpT(PasswordField rmpT) {
        this.rmpT = rmpT;
    }

    public Button getSaveAdmin() {
        return saveAdmin;
    }

    public void setSaveAdmin(Button saveAdmin) {
        this.saveAdmin = saveAdmin;
    }

    public Label getLabelhome() {
        return labelhome;
    }

    public void setLabelhome(Label labelhome) {
        this.labelhome = labelhome;
    }

    public Separator getSep() {
        return sep;
    }

    public void setSep(Separator sep) {
        this.sep = sep;
    }

    public JFXCheckBox getActiveCB() {
        return activeCB;
    }

    public void setActiveCB(JFXCheckBox activeCB) {
        this.activeCB = activeCB;
    }

    public TableColumn<?, ?> getColusername() {
        return colusername;
    }

    public void setColusername(TableColumn<User, String> colusername) {
        this.colusername = colusername;
    }

    public TableColumn<?, ?> getColMp() {
        return colMp;
    }

    public void setColMp(TableColumn<User, String> colMp) {
        this.colMp = colMp;
    }

    public TableColumn<?, ?> getColActive() {
        return colActive;
    }

    public void setColActive(TableColumn<User, Integer> colActive) {
        this.colActive = colActive;
    }

    public void stat() throws Exception {
        UserService srvr = new UserService();
        ResultSet rs = srvr.buildData();
        while (rs.next()) {
            data.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AdminList();
        try {
            stat();
        } catch (Exception e) {
            System.out.println(e);

        }
        PieChart.getData().addAll(data);

    }

    public void AdminList() {
        Liste_Users = FXCollections.observableArrayList(Session.iuserService.getAllAdmin());
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
        colEdit.setCellFactory(cellFactory);

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
                Image imgEdit = new Image(getClass().getResourceAsStream("/pi/idevup/cupcake/ressources/img/mod.png"));
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
                            updateUser(user);
                        });

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv = new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        btnEdit.setGraphic(iv);

                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }

                private void updateUser(User user) {
                    userID.setText(String.valueOf(user.getId()));
                    nomT.setText(user.getFirstname());
                    prenomT.setText(user.getLastname());
                    unT.setText(user.getUsername());
                    emailT.setText(user.getEmail());
                    mpT.setText("");
                    if (user.getEnabled() == 0) {
                        activeCB.setSelected(false);
                        getActiveCB().setText("Desactivé");
                        getActiveCB().setTextFill(Paint.valueOf("#ff0000"));
                    } else {
                        activeCB.setSelected(true);
                        getActiveCB().setText("Activé");
                        getActiveCB().setTextFill(Paint.valueOf("#437C17"));
                    }
                }
            };
            return cell;
        }
    };

    public void Clearfields() {
        userID.setText(null);
        nomT.setText("");
        prenomT.setText("");
        unT.setText("");
        emailT.setText("");
        mpT.setText("");
        rmpT.setText("");
        rmpT.setStyle("-fx-background-color:white");
        activeCB.setSelected(false);
    }

    @FXML
    private void reset(ActionEvent event) {
        Clearfields();
    }

    @FXML
    private void saveUser(ActionEvent event) {
        if (userID.getText().equals("") || userID.getText() == null) {
            User u = new User();
            u.setUsername(unT.getText());
            u.setUsername_canonical(unT.getText());
            u.setEmail(emailT.getText());
            u.setEmail_canonical(emailT.getText());
            if (activeCB.isSelected() == false) {
                u.setEnabled(0);
            }
            if (activeCB.isSelected() == true) {
                u.setEnabled(1);
            }
            String password = mpT.getText();
            //String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            String hashedmd5 = serviceCryptage.cryptWithMD5(password);
            //hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
            u.setPassword(hashedmd5);
            u.setFirstname(nomT.getText());
            u.setLastname(prenomT.getText());
            u.setRoles("a:1{i:0;s:10:\"ROLE_ADMIN\";}");
            UserService US = new UserService();
            US.addAdmin(u);

        } else {
            System.out.println("upsate");
            User u = new User();
            u.setId(Integer.parseInt(userID.getText()));
            u.setUsername(unT.getText());
            u.setUsername_canonical(unT.getText());
            u.setEmail(emailT.getText());
            u.setEmail_canonical(emailT.getText());
            String password = mpT.getText();
            //String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
            //hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
            String hashedmd5 = serviceCryptage.cryptWithMD5(password);
            u.setPassword(hashedmd5);
            if (activeCB.isSelected() == false) {
                u.setEnabled(0);
            }
            if (activeCB.isSelected() == true) {
                u.setEnabled(1);
            }
            u.setFirstname(nomT.getText());
            u.setLastname(prenomT.getText());
            UserService US = new UserService();
            US.updateAdmin(u);

        }
        Clearfields();
        AdminList();
    }

    @FXML
    private void deleteUsers(ActionEvent event) {
        List<User> users = userTable.getSelectionModel().getSelectedItems();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            new UserService().removeAdmin(users.get(0).getId());
            System.out.println(users.get(0).getId());
        }
        AdminList();
    }

    @FXML
    private void changeCB(ActionEvent event) {
        if (activeCB.isSelected()) {
            getActiveCB().setText("Activé");
            getActiveCB().setTextFill(Paint.valueOf("#437C17"));
        } else {
            getActiveCB().setText("Desactivé");
            getActiveCB().setTextFill(Paint.valueOf("#ff0000"));
        }
    }

    @FXML
    private void verifpasswordd(KeyEvent event) {
        if (mpT.getText().equals(rmpT.getText())) {
            rmpT.setStyle("-fx-background-color:#3cbc53");
        } else {
            rmpT.setStyle("-fx-background-color:#ff0000");
        }
    }

}

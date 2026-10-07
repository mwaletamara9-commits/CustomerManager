package org.example.customermanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML private TextField nameField;
    @FXML private ComboBox<String> provinceComboBox;
    @FXML private TextField phoneField;
    @FXML private TableView<Customer> customerTable;
    @FXML private TableColumn<Customer, String> nameColumn;
    @FXML private TableColumn<Customer, String> provinceColumn;
    @FXML private TableColumn<Customer, String> phoneColumn;

    private ObservableList<Customer> customers = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Requirement 2 & 3: ObservableList and TableView
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<>("province"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerTable.setItems(customers);

        // Requirement 1: Province List - All Zambian provinces
        provinceComboBox.setItems(FXCollections.observableArrayList(
                "Central", "Copperbelt", "Eastern", "Luapula", "Lusaka",
                "Muchinga", "Northern", "North-Western", "Southern", "Western"
        ));

        // Requirement 6: Keyboard access - Press Enter to add, Delete key to delete
        nameField.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER) onAddButtonClick(); });
        phoneField.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.ENTER) onAddButtonClick(); });
        customerTable.setOnKeyPressed(e -> { if (e.getCode() == KeyCode.DELETE) onDeleteButtonClick(); });
    }

    @FXML
    protected void onAddButtonClick() {
        // Requirement 4: Validate input
        String name = nameField.getText().trim();
        String province = provinceComboBox.getValue();
        String phone = phoneField.getText().trim();

        if (name.isEmpty()) {
            showError("Name is required!");
            nameField.requestFocus();
            return;
        }
        if (province == null || province.isEmpty()) {
            showError("Please select a Province!");
            provinceComboBox.requestFocus();
            return;
        }
        if (phone.isEmpty() || !phone.matches("\\d{10,12}")) {
            showError("Phone must be 10-12 digits!");
            phoneField.requestFocus();
            return;
        }

        customers.add(new Customer(name, province, phone));
        clearFields();
    }

    @FXML
    protected void onDeleteButtonClick() {
        // Requirement 5: Confirm deletion of selected customer
        Customer selected = customerTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showError("Please select a customer to delete!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Deletion");
        confirm.setHeaderText("Delete Customer?");
        confirm.setContentText("Are you sure you want to delete: " + selected.getName() + " from " + selected.getProvince() + "?");

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                customers.remove(selected);
            }
        });
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        nameField.clear();
        provinceComboBox.setValue(null);
        phoneField.clear();
        nameField.requestFocus();
    }
}
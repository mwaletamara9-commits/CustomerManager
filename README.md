# CustomerManager - ICT 261 Lab 3

JavaFX application for managing customers by province.

## Student Details
- Course: ICT 261 - GUI Programming
- Lab: 3 - JavaFX TableView with Customer Management

## Features Implemented

✅ **1. Customer Entry Form**
- TextField for customer name
- ComboBox for Province selection (10 provinces of Zambia)

✅ **2. Customer Model**
- Customer class with name and province
- ObservableList to store customers

✅ **3. TableView**
- Displays all customers
- Two columns: Name and Province

✅ **4. Input Validation**
- Validates empty name
- Shows alert if invalid
- Adds customer only if valid

✅ **5. Delete with Confirmation**
- Confirmation dialog before deletion
- "Are you sure?" alert

✅ **6. Testing**
- Tested invalid inputs
- Tested keyboard access (Tab, Enter)

## How to Run

1. Open project in IntelliJ IDEA
2. Make sure JavaFX SDK is configured
3. Run `HelloApplication.java` from `src/main/java/org/example/customermanager/`
4. App window will open

## Screenshots

### 1. Add Customer
![Add Customer](screenshots/1-add-customer.png)

### 2. Input Validation
![Validation](screenshots/2-validation.png)

### 3. Delete Confirmation
![Delete](screenshots/3-delete-confirm.png)

## Technologies Used
- Java 21
- JavaFX 21
- Gradle
- IntelliJ IDEA

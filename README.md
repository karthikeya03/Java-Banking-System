# 🏦 Banking Management System (JavaFX + MySQL + JDBC)

A modern desktop Banking Management System built using JavaFX, MySQL, and JDBC. This application provides a graphical interface to perform core banking operations such as account creation, deposits, withdrawals, fund transfers, and customer management.

---

## 🚀 Features

- Create new customer accounts
- Deposit money into accounts
- Withdraw money with balance validation
- Transfer funds between customers
- View all customers and balances in a TableView
- Persistent storage using MySQL database
- Modern GUI built with JavaFX
- Modular architecture using DAO and Service layers
- Exception handling and input validation

---

## 🖥️ Technologies Used

- Java 21
- JavaFX 21
- MySQL 8+
- JDBC (MySQL Connector/J)
- JavaFX TableView
- OOP Principles (Encapsulation, Abstraction, Modularity)
- DAO Design Pattern
- Service Layer Architecture

---

## 📂 Project Structure

```

BankingSystem/
│
├── lib/
│   ├── javafx-sdk-21/
│   └── mysql-connector-j.jar
│
├── src/
│   ├── Main.java
│   │
│   ├── util/
│   │   └── DBConnection.java
│   │
│   ├── model/
│   │   ├── Customer.java
│   │   └── Transaction.java
│   │
│   ├── dao/
│   │   ├── CustomerDAO.java
│   │   └── TransactionDAO.java
│   │
│   ├── service/
│   │   └── BankingService.java
│   │
│   └── ui/
│       ├── Dashboard.java
│       ├── CreateAccountUI.java
│       ├── DepositUI.java
│       ├── WithdrawUI.java
│       ├── TransferUI.java
│       └── ViewCustomersUI.java

````

---

## 🗄️ Database Setup

Create database:

```sql
CREATE DATABASE banking_system;
USE banking_system;
````

Create customers table:

```sql
CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(15),
    balance DOUBLE DEFAULT 0
);
```

---

## ⚙️ How to Run

### 1. Clone repository

```bash
git clone https://github.com/yourusername/BankingSystem.git
cd BankingSystem
```

### 2. Compile

```bash
javac --module-path "lib/javafx-sdk-21/lib" --add-modules javafx.controls -cp "lib/mysql-connector-j.jar" src/Main.java src/util/*.java src/model/*.java src/dao/*.java src/service/*.java src/ui/*.java
```

### 3. Run

```bash
java --module-path "lib/javafx-sdk-21/lib" --add-modules javafx.controls -cp "src;lib/mysql-connector-j.jar" Main
```

---

## 🧠 Architecture

This project follows a layered architecture:

* UI Layer → JavaFX screens
* Service Layer → Business logic
* DAO Layer → Database access
* Model Layer → Entity classes
* Database Layer → MySQL

This separation improves maintainability and scalability.

---

## Features include:

* Dashboard with banking operations
* Account creation form
* Deposit and withdraw interface
* Transfer money interface
* Customer TableView display

---

## 🎯 Resume Value

This project demonstrates:

* Desktop application development
* Database integration with JDBC
* JavaFX GUI development
* Object-Oriented Design
* Clean architecture and modular coding
* Real-world banking logic implementation


---

## 📜 License

This project is for educational and portfolio purposes.


